package com.projectmanagement.kanban.controller;
import com.projectmanagement.kanban.model.TeamMilestone;
import com.projectmanagement.kanban.service.TeamMilestoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teamMilestone")
public class TeamMilestoneController {
    @Autowired
    private final TeamMilestoneService teamMilestoneService;

    public TeamMilestoneController(TeamMilestoneService teamMilestoneService) {
        this.teamMilestoneService = teamMilestoneService;
    }

    @PostMapping("/")
    public String add(@RequestBody TeamMilestone teamMilestone) {
        teamMilestoneService.saveTeamMilestone(teamMilestone);
        return "New Team - Milestone is added";
    }

    @GetMapping("/all")
    public List<TeamMilestone> getAllTeamMilestones(){
        return teamMilestoneService.getAllTeamMilestones();
    }

    @GetMapping("/{id}")
    public TeamMilestone getTeamMilestoneById(@PathVariable Long id){
        return teamMilestoneService.getTeamMilestoneByID(id);
    }

    @PutMapping("/{id}")
    public TeamMilestone UpdateTeamMilestoneById(@PathVariable Long id,@RequestBody TeamMilestone teamMilestone){
        return teamMilestoneService.updateTeamMilestoneById(id,teamMilestone);
    }

    @DeleteMapping("/{id}")
    public String deleteTeamMilestoneById(@PathVariable Long id) {
        teamMilestoneService.deleteTeamMilestoneById(id);
        return "TeamMilestone with id "+ id +" has been deleted successfully!";
    }
}
