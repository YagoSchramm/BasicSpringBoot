package com.example.springfirst.infra.repository;

import com.example.springfirst.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface AuthRepository extends JpaRepository<User,String> {
    UserDetails findByName(String name);

}
