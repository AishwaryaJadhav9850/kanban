package com.projectmanagement.kanban.model;

import jakarta.persistence.*;

@Entity
public class TeamMilestone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private Long team_id;


    private Long milestone_id;

    public TeamMilestone() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTeam_id() {
        return team_id;
    }

    public void setTeam_id(Long team_id) {
        this.team_id = team_id;
    }

    public Long getMilestone_id() {
        return milestone_id;
    }

    public void setMilestone_id(Long milestone_id) {
        this.milestone_id = milestone_id;
    }
}
