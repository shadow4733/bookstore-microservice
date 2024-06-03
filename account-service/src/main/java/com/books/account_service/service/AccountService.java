package com.books.account_service.service;

import com.books.account_service.dto.AccountClientResponse;
import com.books.account_service.dto.AccountRequest;
import com.books.account_service.dto.AccountResponse;
import com.books.account_service.dto.ReviewResponse;
import com.books.account_service.model.Account;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface AccountService {
    AccountResponse createAccount(AccountRequest accountRequest);
    AccountResponse getAccountById(UUID id);
    AccountClientResponse getAccountByUsername(String username);
    List<ReviewResponse> getReviewsByAccountId(UUID accountId);
    AccountResponse updateAccount(UUID id, AccountRequest accountRequest);
    void deleteAccount(UUID id);
    boolean existsByUsername(String username);
    Account getAccount(UUID id);
}
