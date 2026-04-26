package com.example.springfirst.controller;

import com.example.springfirst.domain.AuthDTO;
import com.example.springfirst.domain.SignUpDTO;
import com.example.springfirst.domain.User;
import com.example.springfirst.domain.UserRole;
import com.example.springfirst.infra.repository.AuthRepository;
import com.example.springfirst.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private AuthRepository authRepo;
    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Validated AuthDTO data){
    var usernamePassword=new UsernamePasswordAuthenticationToken(data.username(),data.password());
    var auth =authenticationManager.authenticate(usernamePassword);
    return ResponseEntity.ok().build();
    }
    @PostMapping("/signup")
    public ResponseEntity signup(@RequestBody @Validated SignUpDTO data){
       if(this.authRepo.findByName(data.username())!=null) return ResponseEntity.badRequest().build();
       String encryptedPassword=new BCryptPasswordEncoder().encode(data.password());
        User newUser=new User(data.email(),data.username(),encryptedPassword,data.role());
        this.authRepo.save(newUser);
        return ResponseEntity.ok().build();
    }
}
