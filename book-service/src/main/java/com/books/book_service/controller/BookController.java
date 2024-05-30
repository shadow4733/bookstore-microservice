package com.books.book_service.controller;

import com.books.book_service.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1/books")
@RequiredArgsConstructor
@RestController
public class BookController {

    private BookService bookService;



}
