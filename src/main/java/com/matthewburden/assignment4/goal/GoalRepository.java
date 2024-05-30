package com.matthewburden.assignment4.goal;

import com.matthewburden.assignment4.task.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GoalRepository extends JpaRepository<Goal,Integer> {
    @Query(value = "select * from goal where user_id = :userId", nativeQuery = true)
    public List<Task> getUserGoals(@Param("userId") int userId);
}
