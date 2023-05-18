package com.example.simple.service;

import com.example.demo.simple.model.Person;
import com.example.demo.simple.model.Task;
import com.example.simple.repository.TaskRepository;
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
