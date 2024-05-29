package com.books.book_service.dto;

import com.books.book_service.model.Book;
import com.books.book_service.model.enums.BookGenres;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.NonNull;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public record BookResponse(
    UUID id,
    UUID authorId,
    String title,
    String description,
    List<String> genres,
    LocalDateTime publishDate
) implements Serializable {
    public static BookResponse toDto(Book book) {
        return new BookResponse(
                book.getId(),
                book.getAuthorId(),
                book.getTitle(),
                book.getDescription(),
                List.of(book.getGenres().toString()),
                book.getPublishDate()
        );
    }
}