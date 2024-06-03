package com.books.book_service.serviceImpl;

import com.books.book_service.client.AuthorServiceClient;
import com.books.book_service.client.ReviewServiceClient;
import com.books.book_service.dto.BookRequest;
import com.books.book_service.dto.BookResponse;
import com.books.book_service.dto.ReviewResponse;
import com.books.book_service.exception.BookNotFoundException;
import com.books.book_service.model.Book;
import com.books.book_service.repository.BookRepository;
import com.books.book_service.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class BookServiceImpl implements BookService {

    Logger log = LoggerFactory.getLogger(BookServiceImpl.class);

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private AuthorServiceClient authorServiceClient;
    @Autowired
    private ReviewServiceClient reviewServiceClient;


    @Override
    public BookResponse addNewBook(BookRequest book) {
        authorServiceClient.getAuthorById(book.authorId()); // check if author exists (throws exception if not found)
        Book newBook = new Book(
                book.title(),
                book.authorId(),
                book.description(),
                book.genres(),
                book.publishDate()
        );

        bookRepository.save(newBook);
        log.info("New book added with name: {}", newBook.getTitle());
        return BookResponse.toDto(newBook);
    }

    @Override
    public BookResponse getBookById(UUID id) {
        log.info("Fetching book with id: {}", id);
        return BookResponse.toDto(findBookById(id));
    }

    @Override
    public List<BookResponse> getAllBooks() {
        log.info("Fetching all books");
        return bookRepository.findAll()
                .stream()
                .map(BookResponse::toDto)
                .toList();
    }

    @Override
    public List<BookResponse> getBooksByAuthorId(UUID authorId) {
        log.info("Fetching books by author with id: {}", authorId);
        authorServiceClient.getAuthorById(authorId);
        return bookRepository.findByAuthorId(authorId)
                .stream()
                .map(BookResponse::toDto)
                .toList();
    }

    @Override
    public BookResponse updateBookById(UUID id, BookRequest book) {
        log.info("Updating book with id: {}", id);
        Book existingBook = findBookById(id);
        authorServiceClient.getAuthorById(book.authorId());
        existingBook.setAuthorId(book.authorId());
        existingBook.setTitle(book.title());
        existingBook.setDescription(book.description());
        existingBook.setGenres(book.genres());
        existingBook.setPublishDate(book.publishDate());
        bookRepository.save(existingBook);
        return BookResponse.toDto(existingBook);
    }

    @Override
    public void deleteBookById(UUID id) {
        log.info("Deleting book with id: {}", id);
        findBookById(id);
        reviewServiceClient.deleteReviewsByBookId(id);
        bookRepository.deleteById(id);
    }

    @Override
    public void deleteBooksByAuthorId(UUID authorId) {
        log.info("Deleting books by author with id: {}", authorId);
        authorServiceClient.getAuthorById(authorId);
        bookRepository.deleteByAuthorId(authorId);
    }

    @Override
    public Book findBookById(UUID id) {
        return bookRepository.findById(id).orElseThrow(
                () -> new BookNotFoundException("Book not found with id: " + id)
        );
    }

    @Override
    public List<ReviewResponse> getReviewsByBookId(UUID bookId) {
        log.info("Fetching reviews by book with id: {}", bookId);
        return reviewServiceClient.getReviewsByBookId(bookId).getBody();
    }
}
