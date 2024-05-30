package com.books.author_service.repository

import com.books.author_service.model.Author
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface AuthorRepository : JpaRepository<Author, UUID> {
}