package com.projectmanagement.kanban.model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private Long owner_id;


    private Long created_by;


    private Long changed_by;


    private Long project_id;


    @Enumerated(EnumType.STRING)
    private Stage stage;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Enumerated(EnumType.STRING)
    private Priority priority;

    @Column(name="tags")
    @ElementCollection(targetClass=String.class)
    private List<String> tags;

    private String name;
    private String description;
    private String git_link;
    private String teams_link;
    private Date created_at;
    private Date changed_at;
    private Date due_date;
    private int effort;

    public Task() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOwner_id() {
        return owner_id;
    }

    public void setOwner_id(Long owner_id) {
        this.owner_id = owner_id;
    }

    public Long getCreated_by() {
        return created_by;
    }

    public void setCreated_by(Long created_by) {
        this.created_by = created_by;
    }

    public Long getChanged_by() {
        return changed_by;
    }

    public void setChanged_by(Long changed_by) {
        this.changed_by = changed_by;
    }

    public Long getProject_id() {
        return project_id;
    }

    public void setProject_id(Long project_id) {
        this.project_id = project_id;
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGit_link() {
        return git_link;
    }

    public void setGit_link(String git_link) {
        this.git_link = git_link;
    }

    public String getTeams_link() {
        return teams_link;
    }

    public void setTeams_link(String teams_link) {
        this.teams_link = teams_link;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getChanged_at() {
        return changed_at;
    }

    public void setChanged_at(Date changed_at) {
        this.changed_at = changed_at;
    }

    public Date getDue_date() {
        return due_date;
    }

    public void setDue_date(Date due_date) {
        this.due_date = due_date;
    }

    public int getEffort() {
        return effort;
    }

    public void setEffort(int effort) {
        this.effort = effort;
    }
}
