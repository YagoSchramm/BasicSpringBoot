package com.example.springfirst.infra.repository;

import com.example.springfirst.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface AuthRepository extends JpaRepository<User,String> {
    UserDetails findByName(String name);

}
