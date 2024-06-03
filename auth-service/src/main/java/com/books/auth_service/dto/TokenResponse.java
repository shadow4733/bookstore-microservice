package com.books.auth_service.dto;

import lombok.Builder;

@Builder
public record TokenResponse(
        UserResponse user,
        String token
) {
}
