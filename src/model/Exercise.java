package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Exercise implements Serializable {
    private String name;
    private String description;
    private boolean canBeWeighted;
    private boolean areRepsCounted;
    private boolean areRepsTimed;

    public boolean getCanBeWeighted() {
        return canBeWeighted;
    }
    public boolean getAreRepsCounted() {
        return areRepsCounted;
    }
    public boolean getAreRepsTimed() {
        return areRepsTimed;
    }
    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }


    public static List<Exercise> exerciseList = new ArrayList<>();

    public Exercise(String name, String description, boolean canBeWeighted, boolean areRepsCounted,
                    boolean areRepsTimed) {
        this.name = name;
        this.description = description;
        this.canBeWeighted = canBeWeighted;
        this.areRepsCounted = areRepsCounted;
        this.areRepsTimed = areRepsTimed;
    }

    public static List<Exercise> getExerciseList() {
        return exerciseList;
    }
//    public static int get
    public static void setExerciseList(List<Exercise> exerciseList) {
        Exercise.exerciseList = exerciseList;
    }

}
