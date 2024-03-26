package com.example.taskmanager.controller;

import com.example.taskmanager.model.TaskEntity;
import com.example.taskmanager.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping
    public List<TaskEntity> getAllTasks() {
        return taskService.getAllTasks();
    }

    @GetMapping("/{id}")
    public TaskEntity getTaskEntityById(@PathVariable Long id) {
        return taskService.getTaskEntityById(id)
                .orElseThrow(() -> new RuntimeException("Task not found with id: " + id));
    }

    @PostMapping
    public TaskEntity createTaskEntity(@RequestBody TaskEntity taskEntity) {
        return taskService.createTaskEntity(taskEntity);
    }

    @PutMapping("/{id}")
    public TaskEntity updateTaskEntity(@PathVariable Long id, @RequestBody TaskEntity taskDetails) {
        return taskService.updateTaskEntity(id, taskDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteTaskEntity(@PathVariable Long id) {
        taskService.deleteTaskEntity(id);
    }
}




