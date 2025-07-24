package com.example.backendchallenge.dto;

public class PasswordResponseDTO {
    public boolean isValid;

    public PasswordResponseDTO(boolean isValid) {
        this.isValid = isValid;
    }
}