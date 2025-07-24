package com.example.backendchallenge;

import com.example.backendchallenge.dto.PasswordRequestDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class PasswordValidationTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void validPasswordShouldReturnTrue() throws Exception {
        PasswordRequestDTO dto = new PasswordRequestDTO();
        dto.password = "AbTp9!fok";

        mockMvc.perform(post("/validate-password")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.isValid").value(true));
    }

    @Test
    void invalidPasswordWithRepeatShouldReturnFalse() throws Exception {
        PasswordRequestDTO dto = new PasswordRequestDTO();
        dto.password = "AbTp9!foo";

        mockMvc.perform(post("/validate-password")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.isValid").value(false));
    }

    @Test
    void emptyPasswordShouldReturnFalse() throws Exception {
        PasswordRequestDTO dto = new PasswordRequestDTO();
        dto.password = "";

        mockMvc.perform(post("/validate-password")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.isValid").value(false));
    }
}