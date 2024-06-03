package com.books.auth_service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class UsernameNotFoundException extends RuntimeException{
    public UsernameNotFoundException(String message) {
        super("Username not found: " + message);
    }
}
