package com.example.springfirst.infra.err;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(FilterNotFoundException.class)
    private ResponseEntity<String> filterNotFoundHandler(FilterNotFoundException ex ){
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Filter not found.");
    }
}
