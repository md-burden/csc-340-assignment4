package com.matthewburden.assignment4.goal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/goals")
public class GoalController {

    @Autowired
    GoalService goalService;

    @GetMapping("/all")
    public String getAllGoals(Model model) {
        model.addAttribute("goalList", goalService.getAllUserGoals());
        return "goal-list";
    }

    @GetMapping("/{id}")
    public String getGoalById(@PathVariable int id, Model model) {
        model.addAttribute("goal", goalService.getGoalById(id));
        return "goal-detail";
    }

    @PostMapping("/create")
    public String createGoal(@ModelAttribute("goal") Goal goal) {
        goalService.createNewGoal(goal);
        return "redirect:/goals/all";
    }
}
