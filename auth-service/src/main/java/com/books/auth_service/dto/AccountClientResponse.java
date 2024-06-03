package com.books.auth_service.dto;

import java.util.UUID;

public record AccountClientResponse(
        UUID id,
        String username,
        String password,
        String email,
        String role
) {
}
