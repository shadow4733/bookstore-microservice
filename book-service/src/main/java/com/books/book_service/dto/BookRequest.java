package com.books.book_service.dto;

import com.books.book_service.model.enums.BookGenres;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public record BookRequest(
        UUID authorId,
        String title,
        String isbn,
        String description,
        List<BookGenres> genres,
        LocalDateTime publishDate
) {
}
