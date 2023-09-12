package com.projectmanagement.kanban.repository;

import com.projectmanagement.kanban.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

//The repository's single responsibility is to query the database.
@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    @Query("SELECT u FROM User u WHERE u.designation = :designation")
    List<User> findUserWithDesignation(String designation);
}
