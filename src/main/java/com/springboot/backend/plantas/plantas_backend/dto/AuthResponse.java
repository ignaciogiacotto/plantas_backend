package com.springboot.backend.plantas.plantas_backend.dto;

import com.springboot.backend.plantas.plantas_backend.entities.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthResponse {
    private String token;
    private User user;
}