package com.example.streamable.service;


import com.example.streamable.model.Task;
import com.example.streamable.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;

    public List<Task> findByTaskName(String taskName) {
        return taskRepository.findByTaskName(taskName);
    }

    public List<Task> findByPerson(String firstName, String lastName) {
        return taskRepository.findByPerson(firstName, lastName);
    }

    public List<Task> findTasksStartWith(String name) {
        return taskRepository.findTasksStartWith(name);
    }


}
