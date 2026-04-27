package com.example.springfirst.service;

import com.example.springfirst.domain.user.User;
import org.springframework.stereotype.Service;


@Service
public class HelloWorldService {

    public String helloWorld(String name) {
        return "HELLO WORLD!"+name;
    }
    public String helloWorldPost(String filter,String id, User body) {
        if (filter.equals("no")){
            return "Hello, "+body.getName()+id;
        }
        if (filter.equals("onlyname")){
            return  "Hello, "+body.getName();
        }
        return "Hello";
    }
}
