package com.projectmanagement.kanban.service;

import com.projectmanagement.kanban.model.Milestone;

import java.util.List;

public interface MilestoneService {
    public Milestone saveMilestone(Milestone milestone);
    public List<Milestone> getAllMilestones();
    public Milestone getMilestoneByID(Long id);
    public Milestone updateMilestoneById(Long id,Milestone updatedMilestone);
    public void deleteMilestoneById(Long id);
}
