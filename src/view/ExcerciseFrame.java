package view;

import controller.CreationController;
import model.Exercise;

import javax.swing.*;
import java.awt.*;

public class ExcerciseFrame {
    private JPanel panel1;
    private JTable table1;
    private JButton backButton;
    private JScrollPane excerciseScrollPane;
    private JButton addExcerciseButton;
    private JPanel rightButtonsPanel;
    private JButton deleteExerciseButton;
    JFrame frame = new JFrame();

    public ExcerciseFrame(){
        frame.setTitle("Excercises");
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.setSize(1000, 700);

        addExcerciseButton = new JButton("Add Excercise");
        deleteExerciseButton = new JButton("Delete Excercise");
        addExcerciseButton.setVisible(true);
        deleteExerciseButton.setVisible(true);

        rightButtonsPanel.setLayout(new BoxLayout(rightButtonsPanel, BoxLayout.PAGE_AXIS));
        rightButtonsPanel.setBackground(Color.GRAY);

        //configure the table
        String[] columnNames = {"Name", "Description"};

        String[][] data = CreationController.toArray(Exercise.exerciseList);

//-------------------TABLE CREATION ---------------------------------------------
        table1 = new JTable(data, columnNames);
        table1.setPreferredScrollableViewportSize(new Dimension(500, 70));
        table1.setBounds(100, 100, 300, 500);
        table1.setFillsViewportHeight(true);

        excerciseScrollPane = new JScrollPane(table1);
        excerciseScrollPane.
        excerciseScrollPane.setVisible(true);

//-------------------ADD EVERYTHING TO THE FRAME ---------------------------------------------
        rightButtonsPanel.add(addExcerciseButton);
        rightButtonsPanel.add(deleteExerciseButton);
        panel1.add(rightButtonsPanel);
        panel1.add(excerciseScrollPane);
        frame.add(panel1);
        frame.setVisible(true);

        //if the user clicks the back button, open the main frame
        backButton.addActionListener(e -> {
            MainFrame mainFrame = new MainFrame();
            Point location = frame.getLocationOnScreen();
            mainFrame.setLocation((int)location.getX(), (int)location.getY()); // this doesn't work
            mainFrame.frame.setVisible(true);
            frame.dispose();
        });

        //if the user clicks the add excercise button, open the addExcercise popup
        addExcerciseButton.addActionListener(e -> {
            AddExcerciseFrame addExcerciseFrame = new AddExcerciseFrame();
            addExcerciseFrame.frame.setVisible(true);
            frame.dispose();
        });
    }
}
