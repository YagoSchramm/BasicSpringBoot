package com.example.springfirst.domain.user;

public record SignUpDTO(String email,String username,String password,UserRole role) {
}
