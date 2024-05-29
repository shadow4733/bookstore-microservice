package com.books.author_service.dto

import com.books.author_service.model.Author
import org.jetbrains.annotations.NotNull
import java.time.LocalDate
import java.util.UUID

data class AuthorResponse (
    val id: UUID,
    val name: String,
    val biography: String,
    val birthDate: LocalDate
){
    companion object{
        fun toAuthorResponse(author: Author): AuthorResponse{
            return AuthorResponse(
                author.id!!,
                author.name,
                author.biography,
                author.birthDate
            )
        }
    }
}

