package com.books.book_service.model;

import com.books.book_service.model.enums.BookGenres;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @NonNull
    private String title;
    @NonNull
    private UUID authorId;
    private String description;
    @ElementCollection(targetClass = BookGenres.class)
    @Enumerated(EnumType.STRING)
    private List<BookGenres> genres;
    private LocalDateTime publishDate;
    @CreationTimestamp
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private LocalDateTime updatedAt;
}
