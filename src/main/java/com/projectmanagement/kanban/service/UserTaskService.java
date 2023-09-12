package com.projectmanagement.kanban.service;
import com.projectmanagement.kanban.model.UserTask;
import java.util.List;

public interface UserTaskService {
    public UserTask saveUserTask(UserTask userTask);
    public List<UserTask> getAllUserTasks();
    public UserTask getUserTaskByID(Long id);
    public UserTask updateUserTaskById(Long id,UserTask updatedUserTask);
    public void deleteUserTaskById(Long id);
}
