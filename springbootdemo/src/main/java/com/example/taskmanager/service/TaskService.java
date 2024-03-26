
package com.example.taskmanager.service;

import com.example.taskmanager.model.TaskEntity;

import java.util.List;
import java.util.Optional;

public interface TaskService {
    List<TaskEntity> getAllTasks();
    Optional<TaskEntity> getTaskEntityById(Long id);
    TaskEntity createTaskEntity(TaskEntity taskEntity);
    TaskEntity updateTaskEntity(Long id, TaskEntity taskDetails);
    void deleteTaskEntity(Long id);
}
