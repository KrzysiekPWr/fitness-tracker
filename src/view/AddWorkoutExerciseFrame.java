package view;

import controller.CreationController;
import model.Exercise;

import javax.swing.*;
import java.awt.*;

public class AddWorkoutExerciseFrame extends JFrame{
    private JPanel panel1 = new JPanel();
    public JButton addExerciseToWorkoutButton = new JButton("Add Excercise to Workout");
    JFrame frame = new JFrame();

    public AddWorkoutExerciseFrame(String[] resultRow) {
        boolean isWeighted = resultRow[2].equals("true");
        boolean areRepsCounted = resultRow[3].equals("true");

        panel1.setLayout(new BoxLayout(panel1, BoxLayout.PAGE_AXIS));
        panel1.setSize(new Dimension(500, 350));
        panel1.setBackground(Color.GRAY);

        JLabel excerciseDescriptionLabel = new JLabel(resultRow[0]);
        JLabel excerciseNameLabel = new JLabel(resultRow[1]);
//        JLabel TimeLabel = new JLabel("Time:");
//        JLabel RepsLabel = new JLabel("Reps:");
//        JLabel WeightLabel = new JLabel("Weight(kg):");

        //frame basic configuration
        frame.setTitle("Add Excercise to Workout");
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(1000, 700);

        JTextField timeTextField = new JTextField("Time");
        timeTextField.setPreferredSize(new Dimension(200, 30));
        JTextField repsTextField = new JTextField("Reps");
        repsTextField.setPreferredSize(new Dimension(200, 30));
        JTextField weightTextField = new JTextField("Weight");
        weightTextField.setPreferredSize(new Dimension(200, 30));


        addExerciseToWorkoutButton.setPreferredSize(new Dimension(200, 30));

        //add the text fields to the panel
        panel1.add(excerciseNameLabel, BorderLayout.CENTER);
        panel1.add(excerciseDescriptionLabel, BorderLayout.CENTER);

        if (isWeighted) panel1.add(weightTextField, BorderLayout.CENTER);

        if (!areRepsCounted) panel1.add(timeTextField, BorderLayout.CENTER);
        else panel1.add(repsTextField, BorderLayout.CENTER);

        panel1.add(addExerciseToWorkoutButton, BorderLayout.SOUTH);

            frame.add(panel1, BorderLayout.CENTER);
            frame.pack();

            addExerciseToWorkoutButton.addActionListener(e -> {
                String time = timeTextField.getText();
                String reps = repsTextField.getText();
                String weight = weightTextField.getText();
                if (time.equals("Time")) time = "-";
                if (reps.equals("Reps")) reps = "-";
                if (weight.equals("Weight")) weight = "-";
                String[] rowToAdd = {resultRow[0], resultRow[1], reps, time, weight};
                new CreateWorkoutFrame(rowToAdd);
                frame.dispose();
            });
    }
}