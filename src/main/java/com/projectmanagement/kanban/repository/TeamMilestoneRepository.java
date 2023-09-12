package com.projectmanagement.kanban.repository;

import com.projectmanagement.kanban.model.TeamMilestone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamMilestoneRepository extends JpaRepository<TeamMilestone,Long> {
}
