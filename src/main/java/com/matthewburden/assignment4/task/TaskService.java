package com.matthewburden.assignment4.task;

import com.matthewburden.assignment4.goal.Goal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

    @Autowired
    TaskRepository taskRepository;

    public void createNewTask(Task task, Goal goal){
        if(taskRepository.existsById(task.getTaskId())){
            task = new Task();
            taskRepository.save(task);
            return;
        }
        task = new Task(task.getTitle(), task.getDetails(), goal);
    taskRepository.save(task);
    }

    public Object getAllTasksByGoalId(int id){
        return taskRepository.getTasksByGoalId(id);
    }
}
