package com.projectmanagement.kanban.service;

import com.projectmanagement.kanban.exception.MilestoneNotFoundException;
import com.projectmanagement.kanban.model.Milestone;
import com.projectmanagement.kanban.repository.MilestoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MilestoneServiceImp implements MilestoneService{

    @Autowired
    private final MilestoneRepository milestoneRepository;
    @Autowired
    public MilestoneServiceImp(MilestoneRepository milestoneRepository) {
        this.milestoneRepository = milestoneRepository;
    }

    @Override
    public Milestone saveMilestone(Milestone milestone) {
        return milestoneRepository.save(milestone);
    }

    @Override
    public List<Milestone> getAllMilestones() {
        return milestoneRepository.findAll();
    }

    @Override
    public Milestone getMilestoneByID(Long id) {
        return milestoneRepository.findById(id)
                .orElseThrow(() -> new MilestoneNotFoundException(id));
    }

    @Override
    public Milestone updateMilestoneById(Long id, Milestone updatedMilestone) {
        return milestoneRepository.findById(id)
                .map(milestone -> {
                    milestone.setName(updatedMilestone.getName());
                    milestone.setDescription(updatedMilestone.getDescription());
                    milestone.setStart_date(updatedMilestone.getStart_date());
                    milestone.setDue_date(updatedMilestone.getDue_date());
                    milestone.setEffort(updatedMilestone.getEffort());
                    milestone.setStatus(updatedMilestone.getStatus());
                    return milestoneRepository.save(milestone);
                }).orElseThrow(() -> new MilestoneNotFoundException(id));
    }

    @Override
    public void deleteMilestoneById(Long id) {
        if(!milestoneRepository.existsById(id)){
            throw new MilestoneNotFoundException(id);
        }
        milestoneRepository.deleteById(id);
    }
}
