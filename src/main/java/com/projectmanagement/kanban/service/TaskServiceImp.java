package com.projectmanagement.kanban.service;

import com.projectmanagement.kanban.exception.TaskNotFoundException;
import com.projectmanagement.kanban.model.Task;
import com.projectmanagement.kanban.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImp implements TaskService{

    @Autowired
    private TaskRepository taskRepository;


    @Override
    public Task saveTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public Task getTaskByID(Long id) {
        return taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException(id));
    }

    @Override
    public Task updateTaskById(Long id, Task updatedTask) {
        return taskRepository.findById(id)
                .map(task -> {
                    task.setName(updatedTask.getName());
                    task.setChanged_at(updatedTask.getChanged_at());
                    task.setChanged_by(updatedTask.getChanged_by());
                    task.setCreated_at(updatedTask.getCreated_at());
                    task.setDescription(updatedTask.getDescription());
                    task.setCreated_by(updatedTask.getCreated_by());
                    task.setEffort(updatedTask.getEffort());
                    task.setDue_date(updatedTask.getDue_date());
                    task.setGit_link(updatedTask.getGit_link());
                    task.setOwner_id(updatedTask.getOwner_id());
                    task.setPriority(updatedTask.getPriority());
                    task.setProject_id(updatedTask.getProject_id());
                    task.setStage(updatedTask.getStage());
                    task.setStatus(updatedTask.getStatus());
                    task.setTags(updatedTask.getTags());
                    task.setTeams_link(updatedTask.getTeams_link());
                    return taskRepository.save(task);
                }).orElseThrow(() -> new TaskNotFoundException(id));    }

    @Override
    public void deleteTaskById(Long id) {
        if(!taskRepository.existsById(id)){
            throw new TaskNotFoundException(id);
        }
        taskRepository.deleteById(id);
    }
}
