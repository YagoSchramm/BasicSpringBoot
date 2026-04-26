package com.example.springfirst.domain;

import java.util.UUID;

public class CreateUserDTO {
    private  String name;
    private String email;
    private String password;
    public User toUser(){
        UUID uuid = UUID.randomUUID();
        return new User(
                uuid,
                this.email,
                this.name,
                this.password
        );
    }
}
