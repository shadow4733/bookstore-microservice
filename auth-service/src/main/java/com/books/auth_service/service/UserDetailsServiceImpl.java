package com.books.auth_service.service;

import com.books.auth_service.client.AccountServiceClient;
import com.books.auth_service.dto.AccountClientResponse;
import com.books.auth_service.exception.UsernameNotFoundException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.stream.Stream;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final AccountServiceClient userService;

    public UserDetailsServiceImpl(AccountServiceClient userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AccountClientResponse user = userService.getByUsername(username).getBody();
        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        var roles = Stream.of(user.role())
                .map(SimpleGrantedAuthority::new)
                .toList();
        return new org.springframework.security.core.userdetails.User(
                user.username(),
                user.password(),
                roles
        );
    }
}