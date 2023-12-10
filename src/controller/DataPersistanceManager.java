package controller;

import model.Exercise;
import view.ErrorPrompt;

import java.io.*;
import java.util.List;

public class DataPersistanceManager {
    static File exercisesFile;
    public static void saveData(){
        try
        {
            FileOutputStream fileOut = new FileOutputStream("exercises.ser");
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

    public static void readData(){
        exercisesFile = new File("exercises.ser");
        if (!exercisesFile.exists()) return;

        try
        {
            FileInputStream fileIn = new FileInputStream("exercises.ser");
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
}
