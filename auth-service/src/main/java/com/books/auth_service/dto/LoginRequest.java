package com.books.auth_service.dto;


public record LoginRequest (
    String username,
    String password
){
}
