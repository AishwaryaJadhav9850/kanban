package com.projectmanagement.kanban.service;

import com.projectmanagement.kanban.exception.TeamNotFoundException;
import com.projectmanagement.kanban.model.Team;
import com.projectmanagement.kanban.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TeamServiceImp implements TeamService{

    @Autowired
    private final TeamRepository teamRepository;
    @Autowired
    public TeamServiceImp(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    @Override
    public Team saveTeam(Team team) {
        return teamRepository.save(team);
    }
    @Override
    public List<Team> getAllTeams() {
        return teamRepository.findAll();
    }
    @Override
    public Team getTeamByID(Long id) {
        return teamRepository.findById(id)
                .orElseThrow(() -> new TeamNotFoundException(id));
    }
    @Override
    public Team updateTeamById(Long id, Team updatedTeam) {
        return teamRepository.findById(id)
                .map(team -> {
                    team.setName(updatedTeam.getName());
                    team.setDescription(updatedTeam.getDescription());
                    team.setManager_id(updatedTeam.getManager_id());
                    return teamRepository.save(team);
                }).orElseThrow(() -> new TeamNotFoundException(id));
    }
    @Override
    public void deleteTeamById(Long id) {
        if(!teamRepository.existsById(id)){
            throw new TeamNotFoundException(id);
        }
        teamRepository.deleteById(id);
    }
}
