package com.matthewburden.assignment4.task;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {
    @Query(value = "select * from task where goal_id = :goalId", nativeQuery = true)
    public List<Task> getTasksByGoalId(@Param("goalId") int goalId);
}
