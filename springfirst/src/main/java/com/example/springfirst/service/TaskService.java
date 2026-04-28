package com.example.springfirst.service;

import com.example.springfirst.domain.task.GetTaskDTO;
import com.example.springfirst.domain.task.GetTaskResponse;
import com.example.springfirst.domain.task.Task;
import com.example.springfirst.infra.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepo;
    GetTaskResponse getTaskById(GetTaskDTO getTaskDTO){
        Task task = taskRepo.findById(getTaskDTO.id());
        return new GetTaskResponse(task);
    }

}
