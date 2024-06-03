package com.books.auth_service.service;

import com.books.auth_service.dto.UserResponse;
import com.books.auth_service.dto.RegisterRequest;
import com.books.auth_service.dto.LoginRequest;
import com.books.auth_service.dto.TokenResponse;
import com.books.auth_service.exception.UserAlreadyExistException;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    Logger logger = LoggerFactory.getLogger(AuthService.class);

    @Autowired
    private UserService userService;
    @Autowired
    private TokenService tokenService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private PasswordEncoder passwordEncoder;
    public UserResponse register(RegisterRequest request) {
        logger.info("Registering user: {}", request.getUsername());
        if (userService.existsByUsername(request.getUsername())) {
            throw new UserAlreadyExistException("Username already exists");
        }
        request.setPassword(passwordEncoder.encode(request.getPassword()));
        logger.info("Saving user: {}", request);
        return userService.saveUser(request);
    }

    public TokenResponse login(LoginRequest request) {
        logger.info("Logging in user: {}", request);
        UserResponse userResponse = userService.findByUsername(request.username());
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.username(), request.password()));
            return TokenResponse.builder()
                    .user(userResponse)
                    .token(tokenService.generateToken(request.username()))
                    .build();
        } catch (BadCredentialsException e) {
            throw new BadCredentialsException("Incorrect username or password");
        }
    }
}