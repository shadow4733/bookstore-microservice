package com.books.author_service.dto

import com.fasterxml.jackson.databind.BeanDescription
import java.time.LocalDate
import java.util.UUID

data class BookResponse(
    val id: UUID?,
    val title: String,
    val authorId: String,
    val description: String,
    val genres: List<String>,
    val publishedDate: LocalDate?
)
