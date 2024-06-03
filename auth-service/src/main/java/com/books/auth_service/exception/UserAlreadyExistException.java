package com.books.auth_service.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(reason = "User already exist", code = org.springframework.http.HttpStatus.CONFLICT)
public class UserAlreadyExistException extends RuntimeException{
    public UserAlreadyExistException(String message) {
        super(message);
    }
}
