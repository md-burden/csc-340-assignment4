package com.matthewburden.assignment4.goal;

import com.matthewburden.assignment4.task.TaskRepository;
import com.matthewburden.assignment4.task.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoalService {

    @Autowired
    GoalRepository goalRepository;

    @Autowired
    TaskService taskService;

    public void createNewGoal(Goal goal) {
        if (goalRepository.existsById(goal.getGoalId())) {
            goal = new Goal(goal);
            goalRepository.save(goal);
            return;
        }
        goal = new Goal(goal.getTitle(), goal.getDetails(), goal.getTargetDate());
        goalRepository.save(goal);
    }

    public void deleteGoal(int id) {
        taskService.deleteTasksByGoalId(id);
        goalRepository.deleteById(id);
    }

    public Object getAllUserGoals() {
        // Using a static userId since we are the only user
        return goalRepository.getUserGoals(1);
    }

    public Goal getGoalById(int id) {
        return goalRepository.findById(id).orElse(null);
    }
}
