package com.books.review_service.dto

import java.time.LocalDate
import java.util.UUID

data class BookResponse(
    val id: UUID,
    val title: String,
    val authorId: String,
    val description: String,
    val genres: List<String>,
    val publishedDate: LocalDate?
)
