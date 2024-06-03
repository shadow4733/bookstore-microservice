package com.books.account_service.dto;

import com.books.account_service.model.Account;

import java.util.UUID;

public record AccountClientResponse(
        UUID id,
        String username,
        String password,
        String email,
        String role
) {
    public static AccountClientResponse from(Account account) {
        return new AccountClientResponse(
                account.getId(),
                account.getUsername(),
                account.getPassword(),
                account.getEmail(),
                account.getRole().toString()
        );
    }
}