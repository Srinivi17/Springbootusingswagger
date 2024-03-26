package com.example.taskmanager.service;

import com.example.taskmanager.model.TaskEntity;
import com.example.taskmanager.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public List<TaskEntity> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public Optional<TaskEntity> getTaskEntityById(Long id) {
        return taskRepository.findById(id);
    }

    @Override
    public TaskEntity createTaskEntity(TaskEntity task) {
        return taskRepository.save(task);
    }

    @Override
    public TaskEntity updateTaskEntity(Long id, TaskEntity taskDetails) {
        TaskEntity taskEntity = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found with id: " + id));

        // Update task details
        taskEntity.setName(taskDetails.getName());
        taskEntity.setDescription(taskDetails.getDescription());
        taskEntity.setStatus(taskDetails.getStatus());

        return taskRepository.save(taskEntity);
    }

    @Override
    public void deleteTaskEntity(Long id) {
        TaskEntity taskEntity = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found with id: " + id));
        taskRepository.delete(taskEntity);
    }
}
