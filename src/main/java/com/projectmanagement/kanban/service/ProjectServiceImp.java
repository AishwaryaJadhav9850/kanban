package com.projectmanagement.kanban.service;
import com.projectmanagement.kanban.exception.ProjectNotFoundException;
import com.projectmanagement.kanban.model.Project;
import com.projectmanagement.kanban.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImp implements ProjectService{
    @Autowired
    private final ProjectRepository projectRepository;
    @Autowired
    public ProjectServiceImp(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public Project saveProject(Project project) {
        return projectRepository.save(project);
    }

    @Override
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    @Override
    public Project getProjectByID(Long id) {
        return projectRepository.findById(id)
                .orElseThrow(() -> new ProjectNotFoundException(id));
    }

    @Override
    public Project updateProjectById(Long id, Project updatedProject) {
        return projectRepository.findById(id)
                .map(project -> {
                    project.setName(updatedProject.getName());
                    project.setDescription(updatedProject.getDescription());
                    project.setStart_date(updatedProject.getStart_date());
                    project.setDue_date(updatedProject.getDue_date());
                    project.setEffort(updatedProject.getEffort());
                    project.setStatus(updatedProject.getStatus());
                    project.setMilestone_id(updatedProject.getMilestone_id());
                    project.setTeam_id(updatedProject.getTeam_id());
                    return projectRepository.save(project);
                }).orElseThrow(() -> new ProjectNotFoundException(id));
    }

    @Override
    public void deleteProjectById(Long id) {
        if(!projectRepository.existsById(id)){
            throw new ProjectNotFoundException(id);
        }
        projectRepository.deleteById(id);
    }
}
