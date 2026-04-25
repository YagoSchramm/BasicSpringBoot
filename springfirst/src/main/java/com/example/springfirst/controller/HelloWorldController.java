package com.example.springfirst.controller;

import com.example.springfirst.domain.User;
import com.example.springfirst.service.HelloWorldService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello")
public class HelloWorldController {
    private HelloWorldService helloWorldService;
    public HelloWorldController(HelloWorldService helloWorldService){
        this.helloWorldService=helloWorldService;
    }
@GetMapping
    public String helloWorld() {
        return helloWorldService.helloWorld("Olá");
    }
    @PostMapping("/{id}")
    public String helloWorldPost(@PathVariable String id,@RequestParam(value = "filter",defaultValue = "no") String filter,@RequestBody User body){
       if (filter.equals("no")){
            return "Hello, "+body.getName()+id;
        }
        if (filter.equals("onlyname")){
            return  "Hello, "+body.getName();
        }
        return "Hello";
    }
}
