package com.example.springfirst.domain.task;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.UUID;
@Table(name="tasks")
@Entity(name="tasks")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private Long id1;
    private UUID id;
    private String name;
    private String description;
    private String username;
    private boolean done;
    private Date createdAt;
}
