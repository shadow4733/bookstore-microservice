package com.books.account_service.controller;

import com.books.account_service.dto.AccountClientResponse;
import com.books.account_service.dto.AccountRequest;
import com.books.account_service.dto.AccountResponse;
import com.books.account_service.dto.ReviewResponse;
import com.books.account_service.service.AccountService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping
    public ResponseEntity<AccountResponse> createAccount(@Valid @RequestBody AccountRequest accountRequest) {
        return ResponseEntity.ok(accountService.createAccount(accountRequest));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccountResponse> getAccountById(@PathVariable UUID id) {
        return ResponseEntity.ok(accountService.getAccountById(id));
    }

    @GetMapping("/username/{username}")
    public ResponseEntity<AccountClientResponse> getByUsername(@PathVariable String username) {
        return ResponseEntity.ok(accountService.getAccountByUsername(username));
    }

    @GetMapping("/reviews/{accountId}")
    public ResponseEntity<List<ReviewResponse>> getReviewsByAccountId(@PathVariable UUID accountId) {
        return ResponseEntity.ok(accountService.getReviewsByAccountId(accountId));
    }

    @GetMapping("/isExist/{username}")
    public ResponseEntity<Boolean> isExist(@PathVariable String username) {
        return ResponseEntity.ok(accountService.existsByUsername(username));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AccountResponse> updateAccount(@PathVariable UUID id, @RequestBody AccountRequest accountRequest) {
        return ResponseEntity.ok(accountService.updateAccount(id, accountRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAccount(@PathVariable UUID id) {
        accountService.deleteAccount(id);
        return ResponseEntity.noContent().build();
    }

}
