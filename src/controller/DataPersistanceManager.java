package controller;

import model.Exercise;
import model.Goal;
import view.ErrorPrompt;
import model.Workout;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DataPersistanceManager {
    static File exercisesFile;
    static File workoutsFile;
    static File goalsFile;
    public static void saveExercisesData(String fileName){
        try
        {
            FileOutputStream fileOut = new FileOutputStream(fileName);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(Exercise.getExerciseList());
            out.close();
            fileOut.close();
        }
        catch (IOException ioe)
        {
            new ErrorPrompt();
        }
    }

    public static void readExercisesData(String fileName){
        exercisesFile = new File(fileName);
        if (!exercisesFile.exists()){
            try {
                exercisesFile.createNewFile();
            } catch (IOException e) {
                new ErrorPrompt();
            }
            return;
        }

        try
        {
            FileInputStream fileIn = new FileInputStream(fileName);
            ObjectInputStream in = new ObjectInputStream(fileIn);

            Exercise.setExerciseList((List<Exercise>)in.readObject());

            in.close();
            fileIn.close();
        }
        catch (IOException ioe)
        {
            new ErrorPrompt();
        }
        catch (ClassNotFoundException cnfe)
        {
            //this is normal behaviour. Can't go out of loop in other way
        }
    }


    public static void saveWorkoutsData(String fileName){
        try
        {
            FileOutputStream fileOut = new FileOutputStream(fileName);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(Workout.getWorkoutList());
            out.close();
            fileOut.close();
        }
        catch (IOException ioe)
        {
            new ErrorPrompt();
        }
    }
    public static void readWorkoutsData(String fileName){
        workoutsFile = new File(fileName);
        if (!workoutsFile.exists()){
            try {
                workoutsFile.createNewFile();
            } catch (IOException e) {
                new ErrorPrompt();
            }
            return;
        }

        try
        {
            FileInputStream fileIn = new FileInputStream(fileName);
            ObjectInputStream in = new ObjectInputStream(fileIn);

            Workout.setWorkoutList((List<Workout>)in.readObject());

            in.close();
            fileIn.close();
        }
        catch (IOException ioe)
        {
            new ErrorPrompt();
        }
        catch (ClassNotFoundException cnfe)
        {
            //this is normal behaviour. Can't go out of loop in other way
        }
    }

    public static void readGoalsData(String fileName) {
        goalsFile = new File(fileName);
        if (!goalsFile.exists()){
            try {
                goalsFile.createNewFile();
            } catch (IOException e) {
                new ErrorPrompt();
            }
            return;
        }

        try
        {
            FileInputStream fileIn = new FileInputStream(fileName);
            ObjectInputStream in = new ObjectInputStream(fileIn);

            Goal.setGoalList((ArrayList<Goal>)in.readObject());

            in.close();
            fileIn.close();
        }
        catch (IOException ioe)
        {
            new ErrorPrompt();
        }
        catch (ClassNotFoundException cnfe)
        {
            //this is normal behaviour. Can't go out of loop in other way
        }
    }

    public static void saveGoalsData(String fileName){
        try
        {
            FileOutputStream fileOut = new FileOutputStream(fileName);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(Goal.getGoalList());
            out.close();
            fileOut.close();
        }
        catch (IOException ioe)
        {
            new ErrorPrompt();
        }
    }
}
