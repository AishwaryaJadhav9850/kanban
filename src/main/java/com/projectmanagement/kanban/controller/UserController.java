package com.projectmanagement.kanban.controller;
import org.slf4j.Logger;

import com.projectmanagement.kanban.model.User;
import com.projectmanagement.kanban.service.UserService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private final UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/")
    public String add(@RequestBody User user) {
        userService.saveUser(user);
        return "New user is added";
    }

    @GetMapping("/all")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id){
        return userService.getUserByID(id);
    }

    @GetMapping("/byDesignation")
    public List<User> getAllUsersWithDesignation(@Param("designation") String designation){
        return userService.getAllUsersWithDesignation(designation);
    }

    @PutMapping("/{id}")
    public User UpdateUserById(@PathVariable Long id,@RequestBody User user){
        return userService.updateUserById(id,user);
    }

    @DeleteMapping("/{id}")
    public String deleteUserById(@PathVariable Long id) {
        userService.deleteUserById(id);
        return "User with id "+ id +" has been deleted successfully!";
    }
}
