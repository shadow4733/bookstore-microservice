package com.books.book_service.serviceImpl;

import com.books.book_service.client.AuthorServiceClient;
import com.books.book_service.dto.BookRequest;
import com.books.book_service.dto.BookResponse;
import com.books.book_service.dto.ReviewResponse;
import com.books.book_service.model.Book;
import com.books.book_service.repository.BookRepository;
import com.books.book_service.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class BookServiceImpl implements BookService {

    private BookRepository bookRepository;
    private AuthorServiceClient authorServiceClient;


    @Override
    public BookResponse addNewBook(BookRequest book) {
        return null;
    }

    @Override
    public BookResponse getBookById(UUID id) {
        return null;
    }

    @Override
    public List<BookResponse> getAllBooks() {
        return null;
    }

    @Override
    public List<BookResponse> getBooksByAuthorId(UUID authorId) {
        return null;
    }

    @Override
    public BookResponse updateBookById(UUID id, BookRequest book) {
        return null;
    }

    @Override
    public void deleteBookById(UUID id) {

    }

    @Override
    public void deleteBooksByAuthorId(UUID authorId) {

    }

    @Override
    public Book findBookById(UUID id) {
        return null;
    }

    @Override
    public List<ReviewResponse> getReviewsByBookId(UUID bookId) {
        return null;
    }
}
