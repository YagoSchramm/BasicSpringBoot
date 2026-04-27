package com.example.springfirst.infra.repository;

import com.example.springfirst.domain.task.GetTaskDTO;
import com.example.springfirst.domain.task.GetTaskResponse;
import com.example.springfirst.domain.task.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task,String> {
    GetTaskResponse findById(GetTaskDTO getTaskDTO);

}
