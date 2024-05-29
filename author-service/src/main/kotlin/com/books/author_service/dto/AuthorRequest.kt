package com.books.author_service.dto

import com.books.author_service.model.Author
import org.jetbrains.annotations.NotNull
import java.time.LocalDate
import java.util.*

data class AuthorRequest(
    @NotNull
    val id: UUID,
    @NotNull
    val name: String,
    @NotNull
    val biography: String,
    @NotNull
    val birthDate: LocalDate
)