package com.projectmanagement.kanban.exception;

public class MilestoneNotFoundException extends RuntimeException {
    public MilestoneNotFoundException(Long id) {
        super("Milestone not found with ID: "+id);
    }

}