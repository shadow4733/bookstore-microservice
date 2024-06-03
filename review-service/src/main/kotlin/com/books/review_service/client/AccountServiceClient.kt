package com.books.review_service.client

import com.books.review_service.dto.AccountResponse
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import java.util.UUID

@FeignClient(name = "account-service", path ="/api/v1/accounts")
interface AccountServiceClient {
    @GetMapping("/{accountId}")
    fun getAccountById(@PathVariable accountId: UUID): ResponseEntity<AccountResponse>
}