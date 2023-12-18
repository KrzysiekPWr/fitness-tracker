package view;

import controller.DataPersistanceManager;

import javax.swing.*;

public class MainFrame extends ComponentBuilder {
    private JPanel panel1;
    private JButton createWorkoutButton;
    private JButton excercisesButton;
    private JButton startWorkoutButton;
    private JButton browseWorkoutSessionsButton;
    private JButton createGoalButton;
    private JButton browseGoalsButton;
    private JButton browseWorkoutsButton;
    JFrame frame = new JFrame();
    public MainFrame(){
        frame.setTitle("FitnessTracker");
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.setSize(1000, 700);
        frame.add(panel1);
        frame.setVisible(true);

        //if the user clicks the excercises button, open the excercises frame
        excercisesButton.addActionListener(e -> {
            ExcerciseFrame excerciseFrame = new ExcerciseFrame();
            excerciseFrame.frame.setVisible(true);
            frame.dispose();
        });

        //if the user clicks the create workout button, open the createWorkout frame
        createWorkoutButton.addActionListener(e -> {
            CreateWorkoutFrame createWorkoutFrame = new CreateWorkoutFrame();
            createWorkoutFrame.frame.setVisible(true);
            frame.dispose();
        });

        browseWorkoutsButton.addActionListener(e -> {
            new BrowseWorkoutsFrame();
            frame.dispose();
        });

        //if the user clicks the start workout button, open the startWorkout frame
        startWorkoutButton.addActionListener(e -> {
            ChooseWorkoutFrame startWorkoutFrame = new ChooseWorkoutFrame();
            startWorkoutFrame.setVisible(true);
            frame.dispose();
        });

        createGoalButton.addActionListener(e -> {
            new CreateGoalFrame();
            frame.dispose();
        });

        browseGoalsButton.addActionListener(e -> {
            new BrowseGoalsFrame();
            frame.dispose();
        });

        browseWorkoutSessionsButton.addActionListener(e -> {
            new BrowseWorkoutSessionsFrame();
            frame.dispose();
        });

        frame.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                if (JOptionPane.showConfirmDialog(frame,
                    "Are you sure you want to close this window?", "Close Window?",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
                    DataPersistanceManager.saveExercisesData("exercises.ser");
                    DataPersistanceManager.saveWorkoutsData("workouts.ser");
                    DataPersistanceManager.saveGoalsData("goals.ser");
                    System.exit(0);
                }
            }
        });

    }
}
