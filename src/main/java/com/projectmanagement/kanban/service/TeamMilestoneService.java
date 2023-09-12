package com.projectmanagement.kanban.service;

import com.projectmanagement.kanban.model.TeamMilestone;

import java.util.List;

public interface TeamMilestoneService {
    public TeamMilestone saveTeamMilestone(TeamMilestone teamMilestone);
    public List<TeamMilestone> getAllTeamMilestones();
    public TeamMilestone getTeamMilestoneByID(Long id);
    public TeamMilestone updateTeamMilestoneById(Long id,TeamMilestone updatedTeamMilestone);
    public void deleteTeamMilestoneById(Long id);
}
