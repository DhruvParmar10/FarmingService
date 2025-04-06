package com.smartfarm.auth.controller;

import com.smartfarm.auth.entity.User;
import com.smartfarm.auth.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody User request) {
        if (authService.registerUser(request.getUsername(), request.getPassword(), request.getRole())) {
            return ResponseEntity.ok("User registered");
        }
        return ResponseEntity.badRequest().body("Username exists");
    }
}