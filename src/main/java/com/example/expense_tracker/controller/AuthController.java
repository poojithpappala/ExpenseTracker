package com.example.expense_tracker.controller;

import com.example.expense_tracker.dto.RegisterRequest;
import com.example.expense_tracker.services.UserService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController 
@RequestMapping("/api/auth")
public class AuthController {
    private final UserService userService;

    public AuthController(UserService userService){
        this.userService = userService;
    }
    
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterRequest request){
        String result = userService.registerUser(request);
        return ResponseEntity.ok(result);
    }

    
}
