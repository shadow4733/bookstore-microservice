package com.books.review_service.dto

import org.jetbrains.annotations.NotNull
import java.util.*

data class ReviewRequest(
    @NotNull
    val accountId: UUID,
    @NotNull
    val bookId: UUID,
    @NotNull
    val rating: Float,
    val review: String

)
