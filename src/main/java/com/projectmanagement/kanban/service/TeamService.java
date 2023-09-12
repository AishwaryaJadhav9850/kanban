package com.projectmanagement.kanban.service;

import com.projectmanagement.kanban.model.Team;

import java.util.List;

public interface TeamService {
    public Team saveTeam(Team team);
    public List<Team> getAllTeams();
    public Team getTeamByID(Long id);
    public Team updateTeamById(Long id,Team updatedTeam);
    public void deleteTeamById(Long id);
}
