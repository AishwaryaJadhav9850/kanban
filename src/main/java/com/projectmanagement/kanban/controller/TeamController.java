package com.projectmanagement.kanban.controller;

import com.projectmanagement.kanban.model.Team;
import com.projectmanagement.kanban.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/team")
public class TeamController {
    @Autowired
    private final TeamService teamService;

    @Autowired
    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @PostMapping("/")
    public String add(@RequestBody Team team) {
        teamService.saveTeam(team);
        return "New Team is added";
    }

    @GetMapping("/all")
    public List<Team> getAllTeams(){
        return teamService.getAllTeams();
    }

    @GetMapping("/{id}")
    public Team getTeamById(@PathVariable Long id){
        return teamService.getTeamByID(id);
    }

    @PutMapping("/{id}")
    public Team UpdateTeamById(@PathVariable Long id,@RequestBody Team team){
        return teamService.updateTeamById(id,team);
    }

    @DeleteMapping("/{id}")
    public String deleteTeamById(@PathVariable Long id) {
        teamService.deleteTeamById(id);
        return "Team with id "+ id +" has been deleted successfully!";
    }
}
