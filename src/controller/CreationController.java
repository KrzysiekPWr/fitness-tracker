package controller;
import model.*;

import javax.swing.*;
import javax.swing.text.DateFormatter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CreationController{
    public static Workout createWorkout(String name, String description, String[][] exercises) {
        Workout workout = new Workout(name, description, exercises);
        return workout;
    }
    public static void createExcercise(String name, String description, boolean canBeWeighted, boolean areRepsCounted,
                                       boolean areRepsTimed) {
        Exercise exercise = new Exercise(name, description, canBeWeighted, areRepsCounted, areRepsTimed);
        Exercise.exerciseList.add(exercise);

    }
    public static void createGoal(String name, String description, String stringDeadline, Exercise relatedExercise,
                                  Goal.GoalType goalType, int value) {
        String[] dateList = stringDeadline.split("/");
        int day = Integer.parseInt(dateList[0]);
        int month = Integer.parseInt(dateList[1]);
        int year = Integer.parseInt(dateList[2]);
        LocalDate deadline = LocalDate.of(year, month, day);
        ArrayList<Goal> goalList = Goal.getGoalList();
        goalList.add(new Goal(name, description, deadline, relatedExercise, goalType, value));
        Goal.setGoalList(goalList);
    }

    public static String[][] toArray(List<Exercise> exercise){
        String[][] excercisesArray = new String[exercise.size()][2];
        for(int i = 0; i < exercise.size(); i++){
            excercisesArray[i][0] = exercise.get(i).getName();
        }
        return excercisesArray;
    }

    public static String[][] toGoalArray(List<Goal> goalList){
        String[][] goalArray = new String[goalList.size()][6];
        for(int i = 0; i < goalList.size(); i++){
//          {"Name", "Description", "Deadline", "Value", "Type", "Exercise"};
            Goal currentGoal = goalList.get(i);
            goalArray[i][0] = currentGoal.getName();
            goalArray[i][1] = currentGoal.getDescription();
            goalArray[i][2] = currentGoal.getDeadline().toString();
            goalArray[i][3] = String.valueOf(currentGoal.getValue());
            goalArray[i][4] = currentGoal.getGoalType().toString();
            goalArray[i][5] = currentGoal.getRelatedExercise().getName();
        }
        return goalArray;
    }

    public static String[][] toExerciseArray(List<Exercise> exercise){
        String[][] excercisesArray = new String[exercise.size()][5];
        for(int i = 0; i < exercise.size(); i++){
            excercisesArray[i][0] = exercise.get(i).getName();
            excercisesArray[i][1] = exercise.get(i).getDescription();
            excercisesArray[i][2] = String.valueOf(exercise.get(i).getCanBeWeighted());
            excercisesArray[i][3] = String.valueOf(exercise.get(i).getAreRepsCounted());
            excercisesArray[i][4] = String.valueOf(exercise.get(i).getAreRepsTimed());
        }
        return excercisesArray;
    }
//TODO why this method gets no arg, but the method above requires one
    public static String[][] toWorkoutArray(){
        List<Workout> workout = Workout.getWorkoutList();
        String[][] workoutArray = new String[workout.size()][3];
        for(int i = 0; i < workout.size(); i++){
            workoutArray[i][0] = workout.get(i).getName();
            workoutArray[i][1] = workout.get(i).getDescription();
            workoutArray[i][2] = Arrays.deepToString(workout.get(i).getExercises());
        }
        return workoutArray;
    }

    public static String[][] toWorkoutSessionArray(){
        List<Workout> workouts = Workout.getWorkoutList();
//        System.out.println(workouts.size());
        ArrayList<String[]> workoutArray = new ArrayList<>();
        int id = 0;
        for(Workout workout: workouts) {
            System.out.println(workout.getDateList().size());
            for (int dateID = 0; dateID < workout.getDateList().size(); dateID++) {
                String[] session = new String[4];
                session[0] = workout.getName();
                session[1] = workout.getDescription();
                session[2] = Arrays.deepToString(workout.getExercises());
                session[3] = workout.getDate(dateID).toString();
                id += 1;
                workoutArray.add(session);
            }
        }
        String[][] workoutArrayFinal = new String[workoutArray.size()][4];

        for (int i = 0; i < workoutArray.size(); i++)
        {
            workoutArrayFinal[i] = workoutArray.get(i);
        }

        System.out.println(id);

        return workoutArrayFinal;
    }

    public static String[] getRowAt(int row, JTable table) {
        int colNumber = table.getColumnCount();
        String[] result = new String[colNumber];

        for(int i = 0; i < colNumber; i++){
            result[i] = String.valueOf(table.getValueAt(row, i));
        }

        return result;
    }

    public static List<List<String>> parseExerciseString(String exerciseString) {
        List<List<String>> exerciseList = new ArrayList<>();

        // Removing "[" and "]" from the beginning and end of the string
        exerciseString = exerciseString.substring(2, exerciseString.length() - 1);

        // Splitting the string into individual exercises
        String[] exerciseArray = exerciseString.split("\\], \\[");

        for (String exercise : exerciseArray) {
            /// Splitting each exercise into its elements
            String[] exerciseElements = exercise.split(", ");

            // Adding elements to the list of exercises
            exerciseList.add(Arrays.asList(exerciseElements));
        }

        return exerciseList;
    }
}
