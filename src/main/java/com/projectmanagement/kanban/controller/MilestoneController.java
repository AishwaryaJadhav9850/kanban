package com.projectmanagement.kanban.controller;

import com.projectmanagement.kanban.model.Milestone;
import com.projectmanagement.kanban.service.MilestoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/milestone")
public class MilestoneController {
    @Autowired
    private final MilestoneService milestoneService;

    @Autowired
    public MilestoneController(MilestoneService milestoneService) {
        this.milestoneService = milestoneService;
    }

    @PostMapping("/")
    public String add(@RequestBody Milestone milestone) {
        milestoneService.saveMilestone(milestone);
        return "New Milestone is added";
    }

    @GetMapping("/all")
    public List<Milestone> getAllMilestones(){
        return milestoneService.getAllMilestones();
    }

    @GetMapping("/{id}")
    public Milestone getMilestoneById(@PathVariable Long id){
        return milestoneService.getMilestoneByID(id);
    }

    @PutMapping("/{id}")
    public Milestone UpdateMilestoneById(@PathVariable Long id,@RequestBody Milestone milestone){
        return milestoneService.updateMilestoneById(id,milestone);
    }

    @DeleteMapping("/{id}")
    public String deleteMilestoneById(@PathVariable Long id) {
        milestoneService.deleteMilestoneById(id);
        return "Milestone with id "+ id +" has been deleted successfully!";
    }

}
