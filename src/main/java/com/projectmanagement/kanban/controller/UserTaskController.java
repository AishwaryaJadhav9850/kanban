package com.projectmanagement.kanban.controller;

import com.projectmanagement.kanban.model.TeamMilestone;
import com.projectmanagement.kanban.model.UserTask;
import com.projectmanagement.kanban.service.UserTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/userTask")
public class UserTaskController {

    @Autowired
    private final UserTaskService userTaskService;

    public UserTaskController(UserTaskService userTaskService) {
        this.userTaskService = userTaskService;
    }

    @PostMapping("/")
    public String add(@RequestBody UserTask userTask) {
        userTaskService.saveUserTask(userTask);
        return "New User - Task is added";
    }

    @GetMapping("/all")
    public List<UserTask> getAllUserTasks(){
        return userTaskService.getAllUserTasks();
    }

    @GetMapping("/{id}")
    public UserTask getUserTaskById(@PathVariable Long id){
        return userTaskService.getUserTaskByID(id);
    }

    @PutMapping("/{id}")
    public UserTask UpdateUserTaskById(@PathVariable Long id,@RequestBody UserTask userTask){
        return userTaskService.updateUserTaskById(id,userTask);
    }

    @DeleteMapping("/{id}")
    public String deleteUserTaskById(@PathVariable Long id) {
        userTaskService.deleteUserTaskById(id);
        return "UserTask with id "+ id +" has been deleted successfully!";
    }
}
