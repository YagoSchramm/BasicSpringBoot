package com.example.springfirst.controller;

import com.example.springfirst.domain.User;
import com.example.springfirst.infra.err.FilterNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    @PostMapping
public String createUser(@RequestBody CreateUserDTO user){
    if(!isValidUser(user.toUser())){
        throw new FilterNotFoundException("Usuario invalido");
    }

    return "";
}
    public boolean isValidUser(User user) {
        if(user.getName().isEmpty()) {
            return false;
        }
        if (user.getEmail().isEmpty()){
            return false;
        }
        if (user.getPassword().isEmpty()){
            return false;
        }
        return true;
    }
}
