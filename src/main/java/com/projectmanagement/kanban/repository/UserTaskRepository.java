package com.projectmanagement.kanban.repository;

import com.projectmanagement.kanban.model.UserTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserTaskRepository extends JpaRepository<UserTask,Long> {
}