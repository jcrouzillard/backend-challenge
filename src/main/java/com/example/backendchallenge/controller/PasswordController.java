package com.example.backendchallenge.controller;

import com.example.backendchallenge.domain.Password;
import com.example.backendchallenge.dto.PasswordRequestDTO;
import com.example.backendchallenge.dto.PasswordResponseDTO;
import com.example.backendchallenge.service.PasswordService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/validate-password")
public class PasswordController {

    private final PasswordService passwordService;

    public PasswordController(PasswordService passwordService) {
        this.passwordService = passwordService;
    }

    @PostMapping
    public ResponseEntity<PasswordResponseDTO> validate(@RequestBody PasswordRequestDTO dto) {
        Password password = new Password(dto.password);
        return ResponseEntity.ok(passwordService.validate(password));
    }
}