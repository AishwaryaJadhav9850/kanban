package com.projectmanagement.kanban.repository;

import com.projectmanagement.kanban.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<Project,Long>{
}
