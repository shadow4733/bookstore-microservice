package com.books.account_service.serviceImpl;

import com.books.account_service.client.ReviewServiceClient;
import com.books.account_service.dto.AccountClientResponse;
import com.books.account_service.dto.AccountRequest;
import com.books.account_service.dto.AccountResponse;
import com.books.account_service.dto.ReviewResponse;
import com.books.account_service.exception.AccountNotFoundException;
import com.books.account_service.model.Account;
import com.books.account_service.model.enums.Role;
import com.books.account_service.repository.AccountRepository;
import com.books.account_service.service.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AccountServiceImpl implements AccountService {

    Logger logger = LoggerFactory.getLogger(AccountServiceImpl.class);

    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private ReviewServiceClient reviewServiceClient;

    @Override
    public AccountResponse createAccount(AccountRequest accountRequest) {
        logger.info("Creating account : {}", accountRequest);
        Account account = new Account(
                accountRequest.username(),
                accountRequest.email(),
                accountRequest.password(),
                Role.USER
        );
        accountRepository.save(account);
        return AccountResponse.from(account);
    }

    @Override
    public AccountResponse getAccountById(UUID id) {
        logger.info("Getting account by id : {}", id);
        return AccountResponse.from(getAccount(id));
    }

    @Override
    public AccountClientResponse getAccountByUsername(String username) {
        logger.info("Getting account by username : {}", username);
        return AccountClientResponse.from(accountRepository.findByUsername(username)
                .orElseThrow(() -> new AccountNotFoundException("Account not found with username: " + username)));
    }

    @Override
    public List<ReviewResponse> getReviewsByAccountId(UUID accountId) {
        logger.info("Getting reviews by account id : {}", accountId);
        return reviewServiceClient.getReviewsByAccountId(accountId).getBody();
    }

    @Override
    public AccountResponse updateAccount(UUID id, AccountRequest accountRequest) {
        logger.info("Updating account with id : {} and request : {}", id, accountRequest);
        Account account = getAccount(id);
        account.setUsername(accountRequest.username());
        account.setEmail(accountRequest.email());
        accountRepository.save(account);
        return AccountResponse.from(account);
    }

    @Override
    public void deleteAccount(UUID id) {
        logger.info("Deleting account with id : {}", id);
        reviewServiceClient.deleteReviewsByAccountId(id);
        accountRepository.delete(getAccount(id));
    }

    @Override
    public boolean existsByUsername(String username) {
        return accountRepository.existsByUsername(username);
    }

    @Override
    public Account getAccount(UUID id) {
        return accountRepository.findById(id)
                .orElseThrow(() -> new AccountNotFoundException("Account not found with id: " + id));
    }
}
