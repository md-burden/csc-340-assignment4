package com.matthewburden.assignment4.goal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoalService {

    @Autowired
    GoalRepository goalRepository;

    public void createNewGoal(Goal goal) {
        goal = new Goal(goal.getTitle(), goal.getDetails(), goal.getTargetDate());
        goalRepository.save(goal);
    }

    // TODO: Create update method
    public void updateExisitingGoal(Goal goal) {}

    public void deleteGoal(Goal goal) {
        goalRepository.delete(goal);
    }

    public Object getAllUserGoals(){
        return goalRepository.findAll();
    }

    public Goal getGoalById(int id) {
        return goalRepository.findById(id).orElse(null);
    }
}
