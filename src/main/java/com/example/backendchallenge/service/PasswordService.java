package com.example.backendchallenge.service;

import com.example.backendchallenge.domain.Password;
import com.example.backendchallenge.dto.PasswordResponseDTO;
import com.example.backendchallenge.validator.PasswordValidator;
import org.springframework.stereotype.Service;

@Service
public class PasswordService {
    public PasswordResponseDTO validate(Password password) {
        boolean isValid = PasswordValidator.isValid(password.getValue());
        return new PasswordResponseDTO(isValid);
    }
}