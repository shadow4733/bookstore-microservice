package com.books.author_service.service

import com.books.author_service.dto.AuthorRequest
import com.books.author_service.dto.AuthorResponse
import com.books.author_service.dto.BookResponse
import com.books.author_service.model.Author
import org.springframework.http.ResponseEntity
import java.util.*


interface AuthorService {
    fun getAll(): MutableList<AuthorResponse>
    fun getById(id: UUID) : AuthorResponse
    fun getBooksByAuthor(id: UUID) : ResponseEntity<List<BookResponse>>
    fun saveAuthor(request: AuthorRequest) : AuthorResponse
    fun updateAuthor(id: UUID, request: AuthorRequest) : AuthorResponse
    fun deleteAuthor(id: UUID)
    fun findById(id: UUID): Author
}