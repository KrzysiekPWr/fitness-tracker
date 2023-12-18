package model;

import controller.GoalController;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;

public class Goal implements Serializable {
    private final GoalType goalType;
    // TODO possibility of Progress Visualisation
    private LocalDate deadline;
    private String name;
    private String description;
    private boolean isCompleted;
    private boolean isFailed;
    private LocalDate creationDate;
    private Exercise relatedExercise;
    private int value;
    private List<Integer> progressList = new ArrayList<>();
    static private ArrayList<Goal> goalList = new ArrayList<>();



    public GoalType getGoalType() {
        return goalType;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Exercise getRelatedExercise() {
        return relatedExercise;
    }
    public int getValue() {
        return value;
    }



    public enum GoalType {
        WEIGHT(1),
        REPETITIONS(2),
        TIME(3);
        private final int goalType;
        GoalType(int goalType) {
            this.goalType = goalType;
        }
    }
    public static ArrayList<Goal> getGoalList() {
        return goalList;
    }
    public static void setGoalList(ArrayList<Goal> goalList) {
        Goal.goalList = goalList;
    }
    public List<Integer> getProgressList() {
        return progressList;
    }
    public void setProgressList(List<Integer> progressList) {
        this.progressList = progressList;
    }


    public Goal(String name, String description, LocalDate deadline, Exercise relatedExercise, GoalType goalType, int value) {
        this.deadline = deadline;
        this.name = name;
        this.description = description;
        this.creationDate = LocalDate.now();
        this.relatedExercise = relatedExercise;
        this.isCompleted = false;
        this.isFailed = false;
        this.goalType = goalType;
        this.value = value;
    }

    public void  addToProgressList(int progress)
    {
        progressList.add(progress);
    }


}
