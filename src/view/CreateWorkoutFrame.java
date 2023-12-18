package view;

import controller.CreationController;
import model.Exercise;
import model.Workout;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class CreateWorkoutFrame{
    JFrame frame = new JFrame();
    JPanel mainPanel = new JPanel();
    JTable exercisesTable;
    static DefaultTableModel tableModel = new DefaultTableModel(0, 0);
    static JTable newExerciseTable = new JTable(tableModel);
    JButton addExerciseButton = new JButton("Add Excercise To Workout");
    JButton removeExerciseButton = new JButton("Remove Selected Exercise");
    JButton createWorkoutButton = new JButton("Create Workout");
    JButton backButton = new JButton("Back");
    JPanel leftExercisesPanel = new JPanel();
    JPanel middleExercisesPanel = new JPanel();

    public CreateWorkoutFrame(){
        frame.setTitle("Create Workout");
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.setSize(1000, 700);

//        SET ALL PANELS LAYOUTS
        mainPanel.setLayout(new BorderLayout());
        leftExercisesPanel.setLayout(new BoxLayout(leftExercisesPanel, BoxLayout.PAGE_AXIS));
        middleExercisesPanel.setLayout(new BoxLayout(middleExercisesPanel, BoxLayout.PAGE_AXIS));
//        rightButtonsPanel.setLayout(new BoxLayout(rightButtonsPanel, BoxLayout.PAGE_AXIS));
//        rightButtonsPanel.setBackground(Color.GRAY);
//        rightButtonsPanel.setSize(new Dimension(500, 350));

//        LEFT TABLE INITIALIZATION
        exercisesTable = ComponentBuilder.createExerciseTable();
        JScrollPane excerciseScrollPane = new JScrollPane(exercisesTable);

//        MIDDLE TABLE INITIALIZATION
        String header[] = new String[] { "Name", "Description", "Reps", "Time", "Weight"};

        tableModel.setColumnIdentifiers(header);
        JScrollPane newExcerciseScrollPane = new JScrollPane(newExerciseTable);


//        PANELS CONFIGURATION
        leftExercisesPanel.add(excerciseScrollPane);
        leftExercisesPanel.add(addExerciseButton);

        middleExercisesPanel.add(newExcerciseScrollPane);

//-------------------ADD EVERYTHING TO THE FRAME ---------------------------------------------
//        rightButtonsPanel.add(addExerciseButton);
//        rightButtonsPanel.add(deleteExerciseButton);
        middleExercisesPanel.add(createWorkoutButton);
        middleExercisesPanel.add(removeExerciseButton);
        mainPanel.add(backButton, BorderLayout.NORTH);
//        mainPanel.add(rightButtonsPanel, BorderLayout.EAST);
        mainPanel.add(middleExercisesPanel, BorderLayout.CENTER);
        mainPanel.add(leftExercisesPanel, BorderLayout.WEST);
        frame.add(mainPanel);
        frame.setVisible(true);

        //if the user clicks the back button, open the main frame
        backButton.addActionListener(e -> {
            MainFrame mainFrame = new MainFrame();
            mainFrame.frame.setVisible(true);
            frame.dispose();
        });


        //if the user clicks the add excercise button, open the addWorkoutExcercise popup
        addExerciseButton.addActionListener(e -> {
            int selectedExercise = exercisesTable.getSelectedRow();
            if(selectedExercise != -1){
                String[] resultRow = CreationController.getRowAt(selectedExercise, exercisesTable);
                AddWorkoutExerciseFrame addExcerciseFrame = new AddWorkoutExerciseFrame(resultRow);
                addExcerciseFrame.frame.setVisible(true);
                frame.dispose();
            }
        });

        //if the user clicks the delete excercise button, delete the selected excercise
        removeExerciseButton.addActionListener(e -> {
            int selectedExercise = newExerciseTable.getSelectedRow();
            if(selectedExercise != -1){
                tableModel.removeRow(selectedExercise);
            }
        });

        createWorkoutButton.addActionListener(e -> {
            String workoutName = JOptionPane.showInputDialog("Enter workout name");
            String workoutDescription = JOptionPane.showInputDialog("Enter workout description");
            String[][] exercises = new String[newExerciseTable.getRowCount()][5];
            for(int i = 0; i < newExerciseTable.getRowCount(); i++){
                for(int j = 0; j < 5; j++){
                    exercises[i][j] = (String) newExerciseTable.getValueAt(i, j);
                }
            }
            Workout newWorkout = CreationController.createWorkout(workoutName, workoutDescription, exercises);
            Workout.getWorkoutList().add(newWorkout);

            //reset the table
//            newExerciseTable = new JTable(0, 0);
//            newExerciseTable.set
            tableModel.setRowCount(0);
//            MainFrame mainFrame = new MainFrame();
//            mainFrame.frame.setVisible(true);
//            frame.dispose();
        });
    }
    public CreateWorkoutFrame(String[] row){
        this();
        tableModel.addRow(row);
    }
}
