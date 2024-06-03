package com.books.auth_service.client;


import com.books.auth_service.dto.AccountClientResponse;
import com.books.auth_service.dto.RegisterRequest;
import com.books.auth_service.dto.UserResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "account-service", path = "/api/v1/accounts")
public interface AccountServiceClient {
    @GetMapping("/username/{username}")
    ResponseEntity<AccountClientResponse> getByUsername(@PathVariable String username);

    @PostMapping
    ResponseEntity<UserResponse> createAccount(@RequestBody RegisterRequest registerRequest);

    @GetMapping("/isExist/{username}")
    ResponseEntity<Boolean> isExist(@PathVariable String username);
}