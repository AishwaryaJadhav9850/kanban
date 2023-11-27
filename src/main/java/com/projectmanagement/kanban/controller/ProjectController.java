package com.projectmanagement.kanban.controller;

import com.projectmanagement.kanban.model.Project;
import com.projectmanagement.kanban.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/project")
public class ProjectController {
    @Autowired
    private final ProjectService projectService;

    @Autowired
    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @PostMapping("/")
    public String add(@RequestBody Project project) {
        projectService.saveProject(project);
        return "New Project is added";
    }

    @GetMapping("/all")
    public List<Project> getAllProjects(){
        return projectService.getAllProjects();
    }

    @GetMapping("/{id}")
    public Project getProjectById(@PathVariable Long id){
        return projectService.getProjectByID(id);
    }

    @PutMapping("/{id}")
    public Project UpdateProjectById(@PathVariable Long id,@RequestBody Project project){
        return projectService.updateProjectById(id,project);
    }

    @DeleteMapping("/{id}")
    public String deleteProjectById(@PathVariable Long id) {
        projectService.deleteProjectById(id);
        return "Project with id "+ id +" has been deleted successfully!";
    }
}
