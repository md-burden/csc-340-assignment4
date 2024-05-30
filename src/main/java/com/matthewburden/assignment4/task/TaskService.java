package com.matthewburden.assignment4.task;

import com.matthewburden.assignment4.goal.Goal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<Task> getAllTasksByGoalId(int id){
        return taskRepository.getTasksByGoalId(id);
    }

    public Task getTaskById(int id){
        return taskRepository.findById(id).orElse(null);
    }

    public void deleteTaskById(int id){
        taskRepository.deleteById(id);
    }
}
