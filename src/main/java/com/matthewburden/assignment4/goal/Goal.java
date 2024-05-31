package com.matthewburden.assignment4.goal;

import com.matthewburden.assignment4.constants.Status;
import jakarta.persistence.Entity;
import jakarta.persistence.*;
import org.springframework.lang.NonNull;

import java.sql.Date;

@Entity
@Table(name = "goal")
public class Goal {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int goalId;

    @NonNull
    private int userId;

    @NonNull
    private String title;

    private String details;

    @NonNull
    private Date targetDate;

    @NonNull
    private Status status;

    public Goal() {
    }

    public Goal(int goalId, int userId, @NonNull String title, String details, @NonNull Date targetDate, @NonNull Status status) {
        this.goalId = goalId;
        this.userId = userId;
        this.title = title;
        this.details = details;
        this.targetDate = targetDate;
        this.status = status;
    }

    public Goal(@NonNull String title, String details, @NonNull Date targetDate) {
        this.userId = 1;
        this.title = title;
        this.details = details;
        this.targetDate = targetDate;
        this.status = Status.PENDING;
    }

    public Goal(Goal goal) {
        this.goalId = goal.getGoalId();
        this.userId = goal.getUserId();
        this.title = goal.getTitle();
        this.details = goal.getDetails();
        this.targetDate = goal.getTargetDate();
        this.status = goal.getStatus();
    }

    public int getGoalId() {
        return goalId;
    }

    public void setGoalId(int id) {
        this.goalId = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @NonNull
    public String getTitle() {
        return title;
    }

    public void setTitle(@NonNull String title) {
        this.title = title;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    @NonNull
    public Date getTargetDate() {
        return targetDate;
    }

    public void setTargetDate(@NonNull Date targetDate) {
        this.targetDate = targetDate;
    }

    @NonNull
    public Status getStatus() {
        return status;
    }

    public void setStatus(@NonNull Status status) {
        this.status = status;
    }
}
