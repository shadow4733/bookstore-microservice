package com.books.review_service.repository

import com.books.review_service.model.Review
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface ReviewRepository : JpaRepository<Review,UUID> {
    fun findByBookId(bookId: UUID): MutableList<Review>
    fun findByAccountId(userId: UUID): MutableList<Review>
    fun deleteAllByBookId(bookId: UUID)
    fun deleteAllByAccountId(userId: UUID)
}