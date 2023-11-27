package com.projectmanagement.kanban.service;

import com.projectmanagement.kanban.exception.UserTaskNotFoundException;
import com.projectmanagement.kanban.model.UserTask;
import com.projectmanagement.kanban.repository.UserTaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserTaskServiceImp implements UserTaskService {

    @Autowired
    private UserTaskRepository userTaskRepository;

    @Override
    public UserTask saveUserTask(UserTask userTask) {
        return userTaskRepository.save(userTask);
    }

    @Override
    public List<UserTask> getAllUserTasks() {
        return userTaskRepository.findAll();
    }

    @Override
    public UserTask getUserTaskByID(Long id) {
        return userTaskRepository.findById(id)
                .orElseThrow(() -> new UserTaskNotFoundException(id));
    }

    @Override
    public UserTask updateUserTaskById(Long id, UserTask updatedUserTask) {
        return userTaskRepository.findById(id)
                .map(userTask -> {
                    userTask.setTask_id(updatedUserTask.getTask_id());
                    userTask.setUser_id(updatedUserTask.getUser_id());
                    return userTaskRepository.save(userTask);
                }).orElseThrow(() -> new UserTaskNotFoundException(id));
    }

    @Override
    public void deleteUserTaskById(Long id) {
        if(!userTaskRepository.existsById(id)){
            throw new UserTaskNotFoundException(id);
        }
        userTaskRepository.deleteById(id);
    }
}
