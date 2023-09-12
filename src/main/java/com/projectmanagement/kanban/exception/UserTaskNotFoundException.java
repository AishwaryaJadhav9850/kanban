package com.projectmanagement.kanban.exception;

public class UserTaskNotFoundException extends RuntimeException {
    public UserTaskNotFoundException(Long id) {
        super("UserTask not found with ID: "+id);
    }
}
