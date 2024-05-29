package com.books.book_service.dto;

import java.time.LocalDate;
import java.util.UUID;

public record AuthorResponse(
        UUID id,
        String name,
        String biography,
        LocalDate birthDate
) {
}
