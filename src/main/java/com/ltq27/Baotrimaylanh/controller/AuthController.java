package com.ltq27.Baotrimaylanh.controller;

import com.ltq27.Baotrimaylanh.dto.request.LoginRequest;
import com.ltq27.Baotrimaylanh.dto.response.LoginResponse;
import com.ltq27.Baotrimaylanh.entity.Account;
import com.ltq27.Baotrimaylanh.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AuthController {
    @Autowired
    private AccountService accountService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        Account account = accountService.login(loginRequest.getUsername(), loginRequest.getPassword());
        if (account != null) {
            return ResponseEntity.ok(new LoginResponse("Login successful", account.getRole()));
        } else {
            return ResponseEntity.badRequest().body("Invalid credentials or account inactive");
        }
    }
}
