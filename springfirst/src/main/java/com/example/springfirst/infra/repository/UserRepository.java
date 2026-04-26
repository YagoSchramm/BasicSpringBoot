package com.example.springfirst.infra.repository;

import com.example.springfirst.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {
}
