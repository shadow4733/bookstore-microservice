package com.books.auth_service;

import com.books.auth_service.service.AuthService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class AuthServiceApplicationTests {

	@Autowired
	private AuthService authService;

	@Test
	void contextLoads() {
		assertNotNull(authService);
	}

}