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


    @PostMapping("/update")
    public String updateGoal(Task task){
        taskService.createNewTask(task, task.getGoal());
        return "redirect:" + task.getTaskId();
    }

    @GetMapping("/update/{id}")
    public String showUpdateForm(@PathVariable int id, Model model){
        model.addAttribute("task", taskService.getTaskById(id));
        return "task-update";
    }


    @GetMapping("/delete/{id}")
    public String deleteTask(@PathVariable int id){
        int goalId = taskService.getTaskById(id).getGoal().getGoalId();
        taskService.deleteTaskById(id);
        return "redirect:/goals/" + goalId;
    }

    @GetMapping("/{id}")
    public Object getTask(@PathVariable int id, Model model){
        model.addAttribute("task", taskService.getTaskById(id));
        return "task-detail";
    }
}
