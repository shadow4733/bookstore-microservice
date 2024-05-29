package com.books.author_service.client

import com.books.author_service.dto.BookResponse
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import java.util.UUID

@FeignClient(name = "book-service", path = "/api/v1/books")
interface BookServiceClient {
    @GetMapping("/author/{authorId}")
    fun getBooksByAuthorId(@PathVariable authorId: UUID): ResponseEntity<List<BookResponse>>

    @DeleteMapping("/author/{authorId}")
    fun deleteBooksByAuthorId(@PathVariable authorId: UUID): ResponseEntity<Unit>
}