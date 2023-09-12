package com.projectmanagement.kanban.service;

import com.projectmanagement.kanban.exception.UserNotFoundException;
import com.projectmanagement.kanban.model.User;
import com.projectmanagement.kanban.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImp implements UserService{
    @Autowired
    private UserRepository userRepository;

    @Override
    public User saveUser(User user) { //POST
        return userRepository.save(user);
    }
    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll(); //GET ALL
    }

    @Override
    public User getUserByID(Long id){ //GET ONE
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    @Override
    public User updateUserById(Long id,User newUser) { //Update by ID
        return userRepository.findById(id)
                .map(user -> {
                    user.setName(newUser.getName());
                    user.setDesignation(newUser.getDesignation());
                    user.setCreated_on(newUser.getCreated_on());
                    user.setRole(newUser.getRole());
                    user.setTeam_id(newUser.getTeam_id());
                    user.setWorkload(newUser.getWorkload());
                    user.setPreferred_name(newUser.getPreferred_name());
                    return userRepository.save(user);
                }).orElseThrow(() -> new UserNotFoundException(id));
    }

    @Override
    public void deleteUserById(Long id){ //delete by id
        if(!userRepository.existsById(id)){
            throw new UserNotFoundException(id);
        }
        userRepository.deleteById(id);
    }

    @Override
    public List<User> getAllUsersWithDesignation(String designation) {
        return userRepository.findUserWithDesignation(designation);
    }
}
