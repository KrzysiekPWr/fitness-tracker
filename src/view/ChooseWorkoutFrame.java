package view;

import controller.CreationController;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.util.ArrayList;
import java.awt.*;

public class ChooseWorkoutFrame extends JFrame {
    private JButton backButton = new JButton("Back");
    private JPanel centerPanel = new JPanel();
    private JButton startWorkoutButton = new JButton("Start Workout");
    public ChooseWorkoutFrame() {
        super("Choose Workout");
        setLayout(new BorderLayout());
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);


        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.PAGE_AXIS));
        JTable workoutTable = ComponentBuilder.createWorkoutTable();
        JScrollPane workoutScrollPane = new JScrollPane(workoutTable);


        centerPanel.add(workoutScrollPane);
        centerPanel.add(startWorkoutButton);

        setVisible(true);
        add(backButton, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);

        backButton.addActionListener(e -> {
            MainFrame mainFrame = new MainFrame();
            mainFrame.frame.setVisible(true);
            dispose();
        });

        startWorkoutButton.addActionListener(e -> {
            //get the selected row
            int selectedRow = workoutTable.getSelectedRow();
            String exercisesString = (String)workoutTable.getValueAt(selectedRow, 2);

            java.util.List<java.util.List<String>> exercisesList = CreationController.parseExerciseString(exercisesString);

           new WorkoutFrame((String)workoutTable.getValueAt(selectedRow, 0), exercisesList);
            dispose();
        });
    }
}
