package com.books.book_service.dto;

import java.util.UUID;

public record ReviewResponse(
        UUID id,
        UUID bookId,
        UUID accountId,
        float rating,
        String review
) {
}
