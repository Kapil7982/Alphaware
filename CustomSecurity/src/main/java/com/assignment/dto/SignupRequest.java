package com.assignment.dto;

import java.util.Set;

import lombok.Data;

@Data
public class SignupRequest {
    private String username;
    private String password;
    private Set<String> roles;
}

