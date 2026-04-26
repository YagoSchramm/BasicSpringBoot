package com.example.springfirst.domain;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.UUID;
@Table(name="users")
@Entity(name="users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private  String name;
    private String email;
    private String password;
    private UserRole role;
    public User(String email,String name,String password,UserRole role) {
    super();
    this.name=name;
    this.email=email;
    this.password=password;
    this.role=role;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if(this.role==UserRole.ADMIN){
            return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"),new SimpleGrantedAuthority("ROLE_USER"));
        }
        return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getUsername() {
        return this.name;
    }
}

