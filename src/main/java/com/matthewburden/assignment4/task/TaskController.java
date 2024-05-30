package com.matthewburden.assignment4.task;

import com.matthewburden.assignment4.goal.Goal;
import com.matthewburden.assignment4.goal.GoalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    TaskService taskService;

    @Autowired
    GoalService goalService;


    @PostMapping("/create/{id}")
    public String showTaskForm(@ModelAttribute("task") Task task, @PathVariable int id){
        Goal goal = goalService.getGoalById(id);
        taskService.createNewTask(task, goal);
        return "redirect:/goals/" + id;

    }

    // TODO: Upadte

    // TODO: Delete

    // TODO: View 1 task with all details
}
