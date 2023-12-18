package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Workout implements Serializable {
    private String name;
    private String description;
    private String[][] exercises;
    private static List<Workout> workoutList = new ArrayList<>();
    private static ArrayList<ArrayList<Integer>> workoutExercises = new ArrayList<>();
    private ArrayList<LocalDate> dateList = new ArrayList<>();

    public Workout(String name, String description, String[][] exercises) {
        this.name = name;
        this.description = description;
        this.exercises = exercises;
    }

    public static void setWorkoutList(List<Workout> workouts) {
        workoutList = workouts;
    }
    public static List<Workout> getWorkoutList() {
        return workoutList;
    }
    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public String[][] getExercises() {
        return exercises;
    }

    public ArrayList<LocalDate> getDateList() {
        return dateList;
    }
}
