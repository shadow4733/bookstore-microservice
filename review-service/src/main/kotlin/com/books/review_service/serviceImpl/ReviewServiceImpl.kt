package com.books.review_service.serviceImpl


import com.books.review_service.client.AccountServiceClient
import com.books.review_service.client.BookServiceClient
import com.books.review_service.dto.ReviewRequest
import com.books.review_service.dto.ReviewResponse
import com.books.review_service.exception.ReviewNotFoundException
import com.books.review_service.model.Review
import com.books.review_service.repository.ReviewRepository
import com.books.review_service.service.ReviewService
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import java.util.*

@Service
class ReviewServiceImpl(
    val reviewRepository: ReviewRepository,
    val bookServiceClient: BookServiceClient,
    val accountServiceClient: AccountServiceClient) : ReviewService {

    private val logger = LoggerFactory.getLogger(ReviewService::class.java)

    override fun getAllReviews(): MutableList<ReviewResponse> {
        logger.info("Fetching all reviews")
        return reviewRepository.findAll()
            .map { ReviewResponse.toReviewResponse(it) }
            .toMutableList()
    }

    override fun getReviewById(id: UUID): ReviewResponse {
        logger.info("Fetching review with id: $id")
        return findById(id)
            .let { ReviewResponse.toReviewResponse(it) }
    }

    override fun getReviewsByBookId(bookId: UUID): MutableList<ReviewResponse> {
        logger.info("Fetching reviews for book with id: $bookId")
        bookServiceClient.getBookById(bookId) // Check if book exists
        return reviewRepository.findByBookId(bookId)
            .map { ReviewResponse.toReviewResponse(it) }
            .toMutableList()
    }

    override fun getReviewsByAccountId(userId: UUID): MutableList<ReviewResponse> {
        logger.info("Fetching reviews for account with id: $userId")
        accountServiceClient.getAccountById(userId) // Check if account exists
        return reviewRepository.findByAccountId(userId)
            .map { ReviewResponse.toReviewResponse(it) }
            .toMutableList()
    }

    override fun updateReview(id: UUID, review: ReviewRequest): ReviewResponse {
        logger.info("Updating review with id: $id")
        val existingReview = findById(id)
        existingReview.rating = review.rating
        existingReview.review = review.review
        reviewRepository.save(existingReview)
        return ReviewResponse.toReviewResponse(existingReview)
    }

    override fun deleteReview(id: UUID) {
        logger.info("Deleting review with id: $id")
        val existingReview = findById(id)
        reviewRepository.delete(existingReview)
    }

    override fun deleteReviewsByBookId(bookId: UUID) {
        logger.info("Deleting reviews for book with id: $bookId")
        bookServiceClient.getBookById(bookId) // Check if book exists
        reviewRepository.deleteAllByBookId(bookId)
    }

    override fun deleteReviewsByAccountId(accountId: UUID) {
        logger.info("Deleting reviews for account with id: $accountId")
        accountServiceClient.getAccountById(accountId) // Check if account exists
        reviewRepository.deleteAllByAccountId(accountId)
    }

    override fun findById(id: UUID): Review {
        return reviewRepository.findById(id).orElseThrow { throw ReviewNotFoundException("Review not found with id: $id") }
    }
}