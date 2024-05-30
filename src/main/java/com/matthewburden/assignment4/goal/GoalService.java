package com.matthewburden.assignment4.goal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoalService {

    @Autowired
    GoalRepository goalRepository;

    public void createNewGoal(Goal goal) {
        if(goalRepository.existsById(goal.getGoalId())){
            goal = new Goal(goal);
            goalRepository.save(goal);
            return;
        }
        goal = new Goal(goal.getTitle(), goal.getDetails(), goal.getTargetDate());
        goalRepository.save(goal);
    }

    public void deleteGoal(int id) {
        goalRepository.deleteById(id);
    }

    public Object getAllUserGoals(){
        return goalRepository.findAll();
    }

    public Goal getGoalById(int id) {
        return goalRepository.findById(id).orElse(null);
    }
}
