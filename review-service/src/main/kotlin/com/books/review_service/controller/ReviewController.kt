package com.books.review_service.controller

import com.books.review_service.dto.ReviewResponse
import com.books.review_service.dto.ReviewRequest
import com.books.review_service.service.ReviewService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import java.util.*

@RestController
@RequestMapping("/api/v1/reviews")
class ReviewController(val reviewService: ReviewService) {

    @GetMapping
    fun getAllReviews(): ResponseEntity<MutableList<ReviewResponse>> = ResponseEntity.ok(reviewService.getAllReviews())

    @GetMapping("/{id}")
    fun getReviewById(@PathVariable id: UUID): ResponseEntity<ReviewResponse> = ResponseEntity.ok(reviewService.getReviewById(id))

    @GetMapping("/book/{bookId}")
    fun getReviewsByBookId(@PathVariable bookId: UUID): ResponseEntity<MutableList<ReviewResponse>> = ResponseEntity.ok(reviewService.getReviewsByBookId(bookId))

    @GetMapping("/account/{accountId}")
    fun getReviewsByAccountId(@PathVariable accountId: UUID): ResponseEntity<MutableList<ReviewResponse>> = ResponseEntity.ok(reviewService.getReviewsByAccountId(accountId))

    @PutMapping("/{id}")
    fun updateReview(@PathVariable id: UUID, @RequestBody review: ReviewRequest): ResponseEntity<ReviewResponse> = ResponseEntity.ok(reviewService.updateReview(id, review))

    @DeleteMapping("/{id}")
    fun deleteReview(@PathVariable id: UUID) = ResponseEntity.ok(reviewService.deleteReview(id))

    @DeleteMapping("/book/{bookId}")
    fun deleteReviewsByBookId(@PathVariable bookId: UUID) = ResponseEntity.ok(reviewService.deleteReviewsByBookId(bookId))

    @DeleteMapping("/account/{accountId}")
    fun deleteReviewsByAccountId(@PathVariable accountId: UUID) = ResponseEntity.ok(reviewService.deleteReviewsByAccountId(accountId))
}