package com.books.auth_service.service;

import com.books.auth_service.client.AccountServiceClient;
import com.books.auth_service.dto.RegisterRequest;
import com.books.auth_service.dto.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class UserService {

    private final AccountServiceClient accountServiceClient;

    protected UserResponse saveUser(RegisterRequest register) {
        return accountServiceClient.createAccount(register).getBody();
    }

    protected UserResponse findByUsername(String username) {
        return UserResponse.builder()
                .id(Objects.requireNonNull(accountServiceClient.getByUsername(username).getBody()).id())
                .username(username)
                .email(Objects.requireNonNull(accountServiceClient.getByUsername(username).getBody()).email())
                .role(Objects.requireNonNull(accountServiceClient.getByUsername(username).getBody()).role())
                .build();
    }

    public boolean existsByUsername(String username) {
        return Boolean.TRUE.equals(accountServiceClient.isExist(username).getBody());
    }
}