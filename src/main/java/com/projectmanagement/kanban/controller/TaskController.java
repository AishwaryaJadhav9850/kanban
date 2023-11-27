package com.projectmanagement.kanban.controller;

import com.projectmanagement.kanban.model.Task;
import com.projectmanagement.kanban.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {
    @Autowired
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping("/")
    public String add(@RequestBody Task task) {
        taskService.saveTask(task);
        return "New Task is added";
    }

    @GetMapping("/all")
    public List<Task> getAllTasks(){
        return taskService.getAllTasks();
    }

    @GetMapping("/{id}")
    public Task getTaskById(@PathVariable Long id){
        return taskService.getTaskByID(id);
    }

    @PutMapping("/{id}")
    public Task UpdateTaskById(@PathVariable Long id,@RequestBody Task task){
        return taskService.updateTaskById(id,task);
    }

    @DeleteMapping("/{id}")
    public String deleteTaskById(@PathVariable Long id) {
        taskService.deleteTaskById(id);
        return "Task with id "+ id +" has been deleted successfully!";
    }

}
