package com.books.author_service.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Author not found")
class AuthorNotFoundException(message: String) : RuntimeException(message) {
}