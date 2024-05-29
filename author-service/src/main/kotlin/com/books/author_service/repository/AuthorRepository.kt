package com.books.author_service.repository

import com.books.author_service.model.Author
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface AuthorRepository : JpaRepository<Author, UUID> {
}