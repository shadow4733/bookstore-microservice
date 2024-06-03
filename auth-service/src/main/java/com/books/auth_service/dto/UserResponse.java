package com.books.auth_service.dto;

import com.fasterxml.jackson.core.JsonToken;
import lombok.Builder;

import java.util.UUID;

@Builder
public record UserResponse(
        UUID id,
        String username,
        String email,
        String role
) {
}
