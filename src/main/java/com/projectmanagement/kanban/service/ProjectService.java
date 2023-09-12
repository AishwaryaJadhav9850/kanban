package com.projectmanagement.kanban.service;

import com.projectmanagement.kanban.model.Project;

import java.util.List;

public interface ProjectService {
    public Project saveProject(Project project);
    public List<Project> getAllProjects();
    public Project getProjectByID(Long id);
    public Project updateProjectById(Long id,Project updatedProject);
    public void deleteProjectById(Long id);
}
