package com.books.account_service.dto;

public record AccountRequest(
        String username,
        String password,
        String email,
        String role
) {
}
