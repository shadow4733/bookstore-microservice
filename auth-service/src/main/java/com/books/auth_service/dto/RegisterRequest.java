package com.books.auth_service.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class RegisterRequest {
    private String username;
    private String password;
    private String email;
    private String role;
}
