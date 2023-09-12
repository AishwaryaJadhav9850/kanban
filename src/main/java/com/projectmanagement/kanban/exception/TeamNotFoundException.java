package com.projectmanagement.kanban.exception;

public class TeamNotFoundException extends RuntimeException{
    public TeamNotFoundException(Long id) {
        super("Team not found with ID: "+id);
    }
}
