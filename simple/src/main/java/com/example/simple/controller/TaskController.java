package com.example.simple.controller;

import com.example.demo.simple.model.Task;
import com.example.demo.simple.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/task")
public class TaskController {

    private final TaskService taskService;

    @GetMapping("/tasks")
    List<Task> findByTaskName(@RequestParam("taskName") String taskName) {
        return taskService.findByTaskName(taskName);
    }

    @GetMapping("/tasks/person")
    List<Task> findByPerson(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
        return taskService.findByPerson(firstName, lastName);
    }

    @GetMapping("/tasks/{taskName}")
    List<Task> findTasksStartWith(@PathVariable("taskName") String taskName) {
        return taskService.findTasksStartWith(taskName);
    }
}
