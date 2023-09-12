package com.projectmanagement.kanban.service;
import com.projectmanagement.kanban.model.Task;
import java.util.List;

public interface TaskService {
    public Task saveTask(Task task);
    public List<Task> getAllTasks();
    public Task getTaskByID(Long id);
    public Task updateTaskById(Long id,Task updatedTask);
    public void deleteTaskById(Long id);
}
