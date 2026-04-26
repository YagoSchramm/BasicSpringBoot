package com.example.springfirst.domain;

import org.springframework.security.core.GrantedAuthority;

public enum UserRole {
    ADMIN("admin"),
    USER("user");
    private String role;
     UserRole(String role){
        this.role=role;
    }

    public String getRole() {
        return this.role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
