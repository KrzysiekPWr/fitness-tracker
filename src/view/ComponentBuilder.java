package view;

import controller.CreationController;
import model.Exercise;
import model.Workout;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ComponentBuilder {
    public static JTable createExerciseTable(){
        //configure the table
        JTable exerciseTable;
        String[] columnNames = {"Name", "Description", "Can be weighted?", "Reps counted", "Reps timed"};

        String[][] data = CreationController.toExerciseArray(Exercise.exerciseList);

//-------------------TABLE CREATION ---------------------------------------------
        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        exerciseTable = new JTable(model);
        exerciseTable.setPreferredScrollableViewportSize(new Dimension(500, 70));
        exerciseTable.setBounds(100, 100, 300, 500);
        exerciseTable.setFillsViewportHeight(true);
        exerciseTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        return exerciseTable;
    }

    public static JTable createWorkoutTable(){
        //configure the table
        JTable workoutTable;
        String[] columnNames = {"Name", "Description", "Exercises"};

        Object[][] data = CreationController.toWorkoutArray();
        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        workoutTable = new JTable(model);
        workoutTable.setPreferredScrollableViewportSize(new Dimension(500, 70));
        workoutTable.setBounds(100, 100, 300, 500);
        workoutTable.setFillsViewportHeight(true);
        workoutTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        return workoutTable;
    }

    public static JTable createWorkoutSessionTable() {
        JTable workoutTable;
        String[] columnNames = {"Name", "Description", "Exercises", "Date"};

        Object[][] data = CreationController.toWorkoutSessionArray();

        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        workoutTable = new JTable(model);
        workoutTable.setPreferredScrollableViewportSize(new Dimension(500, 70));
        workoutTable.setBounds(100, 100, 300, 500);
        workoutTable.setFillsViewportHeight(true);
        workoutTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        return workoutTable;
    }
}
