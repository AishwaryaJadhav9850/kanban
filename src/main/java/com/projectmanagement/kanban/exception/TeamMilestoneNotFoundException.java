package com.projectmanagement.kanban.exception;

public class TeamMilestoneNotFoundException extends RuntimeException{
    public TeamMilestoneNotFoundException(Long id) {
        super("Team Milestone not found with ID: "+id);
    }
}