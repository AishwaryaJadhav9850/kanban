package com.projectmanagement.kanban.service;

import com.projectmanagement.kanban.exception.TeamMilestoneNotFoundException;
import com.projectmanagement.kanban.model.TeamMilestone;
import com.projectmanagement.kanban.repository.TeamMilestoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamMilestoneServiceImp implements TeamMilestoneService{

    @Autowired
    private TeamMilestoneRepository teamMilestoneRepository;

    @Override
    public TeamMilestone saveTeamMilestone(TeamMilestone teamMilestone) {
        return teamMilestoneRepository.save(teamMilestone);
    }

    @Override
    public List<TeamMilestone> getAllTeamMilestones() {
        return teamMilestoneRepository.findAll();    }

    @Override
    public TeamMilestone getTeamMilestoneByID(Long id) {
        return teamMilestoneRepository.findById(id)
                .orElseThrow(() -> new TeamMilestoneNotFoundException(id));
    }

    @Override
    public TeamMilestone updateTeamMilestoneById(Long id, TeamMilestone updatedTeamMilestone) {
        return teamMilestoneRepository.findById(id)
                .map(teamMilestone -> {
                    teamMilestone.setTeam_id(updatedTeamMilestone.getTeam_id());
                    teamMilestone.setMilestone_id(updatedTeamMilestone.getMilestone_id());
                    return teamMilestoneRepository.save(teamMilestone);
                }).orElseThrow(() -> new TeamMilestoneNotFoundException(id));
    }

    @Override
    public void deleteTeamMilestoneById(Long id) {
        if(!teamMilestoneRepository.existsById(id)){
            throw new TeamMilestoneNotFoundException(id);
        }
        teamMilestoneRepository.deleteById(id);
    }
}
