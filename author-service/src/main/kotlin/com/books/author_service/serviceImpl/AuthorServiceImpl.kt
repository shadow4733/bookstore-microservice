package com.books.author_service.serviceImpl

import com.books.author_service.client.BookServiceClient
import com.books.author_service.dto.AuthorRequest
import com.books.author_service.dto.AuthorResponse
import com.books.author_service.dto.BookResponse
import com.books.author_service.exception.AuthorNotFoundException
import com.books.author_service.model.Author
import com.books.author_service.repository.AuthorRepository
import com.books.author_service.service.AuthorService
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import java.util.*

@Service
class AuthorServiceImpl(
    val authorRepository: AuthorRepository, val bookServiceClient: BookServiceClient) : AuthorService {

    private val log = LoggerFactory.getLogger(AuthorService::class.java)

    override fun getAll(): MutableList<AuthorResponse> {
        log.info("Fetching all authors")
        return  authorRepository.findAll()
            .map { AuthorResponse.toAuthorResponse(it) }
            .toMutableList()
    }

    override fun getById(id: UUID): AuthorResponse {
        log.info("Fetching author by id: $id")
        return AuthorResponse.toAuthorResponse(findById(id))
    }

    override fun getBooksByAuthor(id: UUID): ResponseEntity<List<BookResponse>> {
        log.info("Fetching books by author id: $id")
        return bookServiceClient.getBooksByAuthorId(id)
    }

    override fun saveAuthor(request: AuthorRequest): AuthorResponse {
        log.info("Saving author: $request")
        val savedAuthor = Author(
            name = request.name,
            biography = request.biography,
            birthDate = request.birthDate
        )
        return AuthorResponse.toAuthorResponse(authorRepository.save(savedAuthor))
    }

    override fun updateAuthor(id: UUID, request: AuthorRequest): AuthorResponse {
        log.info("Updating author: $request")
        val existingAuthor = findById(id)
        existingAuthor.name = request.name
        existingAuthor.biography = request.biography
        existingAuthor.birthDate = request.birthDate
        authorRepository.save(existingAuthor)
        return AuthorResponse.toAuthorResponse(existingAuthor)
    }

    override fun deleteAuthor(id: UUID) {
        log.info("Deleting author with id: $id")
        bookServiceClient.deleteBooksByAuthorId(id)
        authorRepository.deleteById(id)
    }

    override fun findById(id: UUID): Author = authorRepository.findById(id)
        .orElseThrow { throw AuthorNotFoundException("Author not found with id: $id") }
}