package com.books.review_service.service

import com.books.review_service.dto.ReviewRequest
import com.books.review_service.dto.ReviewResponse
import com.books.review_service.model.Review
import java.util.UUID

interface ReviewService {
    fun getAllReviews(id: UUID): MutableList<ReviewResponse>
    fun getReviewById(id: UUID): ReviewResponse
    fun getReviewsByBookId(bookId: UUID): MutableList<ReviewResponse>
    fun getReviewsByAccountId(userId: UUID): MutableList<ReviewResponse>
    fun saveReview(review: Review): ReviewResponse
    fun updateReview(id: UUID, review: ReviewRequest): ReviewResponse
    fun deleteReview(id: UUID)
    fun deleteReviewsByBookId(bookId: UUID)
    fun deleteReviewsByAccountId(accountId: UUID)
    fun findById(id: UUID): Review
}