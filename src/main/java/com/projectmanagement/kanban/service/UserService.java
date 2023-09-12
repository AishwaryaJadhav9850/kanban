package com.projectmanagement.kanban.service;
import com.projectmanagement.kanban.model.User;
import java.util.List;

//The Service layer's single responsibility is to do any logic required with the data received by the Controller
public interface UserService {
    public User saveUser(User user);
    public List<User> getAllUsers();
    public User getUserByID(Long id);
    public User updateUserById(Long id,User newUser);
    public void deleteUserById(Long id);
    public List<User> getAllUsersWithDesignation(String designation);

}
