package com.example.springfirst.controller;

import com.example.springfirst.domain.User;
import com.example.springfirst.infra.err.FilterNotFoundException;
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
        if(!isValidFilter(filter)){
            throw new FilterNotFoundException();
        }
        return helloWorldService.helloWorldPost(filter,id,body);
    }
    public boolean isValidFilter(String filter){
    if(filter.equals("no")){
        return true;
    }
    if(filter.equals("onlyname")){
        return true;
    }
    if(filter.equals("")){
        return true;
    }
    return false;
    }

}
