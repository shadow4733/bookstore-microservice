package com.books.book_service.service;

import com.books.book_service.dto.BookRequest;
import com.books.book_service.dto.BookResponse;
import com.books.book_service.dto.ReviewResponse;
import com.books.book_service.model.Book;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface BookService {
    BookResponse addNewBook(BookRequest book);
    BookResponse getBookById(UUID id);
    List<BookResponse> getAllBooks();
    List<BookResponse> getBooksByAuthorId(UUID authorId);
    BookResponse updateBookById(UUID id, BookRequest book);
    void deleteBookById(UUID id);
    void deleteBooksByAuthorId(UUID authorId);
    Book findBookById(UUID id);
    List<ReviewResponse> getReviewsByBookId(UUID bookId);
}
