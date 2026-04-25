package com.example.springfirst.service;

import org.springframework.stereotype.Service;


@Service
public class HelloWorldService {

    public String helloWorld(String name) {
        return "HELLO WORLD!"+name;
    }
}
