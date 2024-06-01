package com.books.review_service.serviceImpl

import com.books.review_service.dto.ReviewRequest
import com.books.review_service.dto.ReviewResponse
import com.books.review_service.model.Review
import com.books.review_service.service.ReviewService
import java.util.*

class ReviewServiceImpl : ReviewService {

    override fun getAllReviews(id: UUID): MutableList<ReviewResponse> {
        TODO("Not yet implemented")
    }

    override fun getReviewById(id: UUID): ReviewResponse {
        TODO("Not yet implemented")
    }

    override fun getReviewsByBookId(bookId: UUID): MutableList<ReviewResponse> {
        TODO("Not yet implemented")
    }

    override fun getReviewsByAccountId(userId: UUID): MutableList<ReviewResponse> {
        TODO("Not yet implemented")
    }

    override fun saveReview(review: Review): ReviewResponse {
        TODO("Not yet implemented")
    }

    override fun updateReview(id: UUID, review: ReviewRequest): ReviewResponse {
        TODO("Not yet implemented")
    }

    override fun deleteReview(id: UUID) {
        TODO("Not yet implemented")
    }

    override fun deleteReviewsByBookId(bookId: UUID) {
        TODO("Not yet implemented")
    }

    override fun deleteReviewsByAccountId(accountId: UUID) {
        TODO("Not yet implemented")
    }

    override fun findById(id: UUID): Review {
        TODO("Not yet implemented")
    }
}