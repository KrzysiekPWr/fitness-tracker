package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Exercise implements Serializable {
    private String name;
    private String description;

    public static List<Exercise> exerciseList = new ArrayList<>();

    public Exercise(String name, String description){
        this.name = name;
        this.description = description;
    }

    public static List<Exercise> getExerciseList() {
        return exerciseList;
    }
    public static void setExerciseList(List<Exercise> exerciseList) {
        Exercise.exerciseList = exerciseList;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }
}
