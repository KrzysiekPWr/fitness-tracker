package controller;
import model.Workout;
import model.Exercise;
import model.TrainingSession;
import model.FitnessGoal;
import view.AddExcerciseFrame;

import java.util.List;

public class CreationController extends AddExcerciseFrame {
    public static void createTraining(int sets, int repetitions) {
        Workout workout = new Workout(sets, repetitions);
    }
    public static void createTraining(int sets, int repetitions, float weight) {
        Workout workout = new Workout(sets, repetitions, weight);
    }
    public static void createExcercise(String name, String description) {
        Exercise exercise = new Exercise(name, description);
        Exercise.exerciseList.add(exercise);

    }
    public static void createTrainingSession() {
        TrainingSession trainingSession = new TrainingSession();
    }
    public void createFitnessGoal() {
        FitnessGoal fitnessGoal = new FitnessGoal();
    }

    public static String[][] toArray(List<Exercise> exercise){
        String[][] excercisesArray = new String[exercise.size()][2];
        for(int i = 0; i < exercise.size(); i++){
            excercisesArray[i][0] = exercise.get(i).getName();
            excercisesArray[i][1] = exercise.get(i).getDescription();
        }
        return excercisesArray;
    }
}
