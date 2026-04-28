package com.example.springfirst.infra.repository;

import com.example.springfirst.domain.task.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TaskRepository extends JpaRepository<Task,String> {
    Task findById(UUID id);
    Task createTask(Task task) throws Exception;
    Task deleteTaskById(UUID id) throws Exception;
    Task updateTaskById(UUID id,Task task) throws Exception;

}
