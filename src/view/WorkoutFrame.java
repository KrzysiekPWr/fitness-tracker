package view;

import model.Workout;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.util.List;

public class WorkoutFrame extends JFrame {

    private JButton cancelWorkout = new JButton("Cancel Workout");
    private JLabel currentExerciseName;
    private JLabel currentExerciseDescription;
    private JLabel currentExerciseNumber;
    private JLabel currentExerciseReps = new JLabel();
    private JLabel currentExerciseTime = new JLabel();
    private JLabel currentExerciseWeight = new JLabel();
    private JButton nextExerciseButton = new JButton("Next Exercise");
    private static List<List<String>> exercisesList;
    private  String workoutName;

    private int currentExerciseIndex;

    public WorkoutFrame(String workoutName, List<List<String>> exercisesList) {
        WorkoutFrame.exercisesList = exercisesList;
        this.workoutName = workoutName;
        currentExerciseIndex = 0;

        initializeFrame();

        // Display the first exercise
        displayExercise(currentExerciseIndex);
    }

    private void initializeFrame() {
        setTitle("Workout");
        setSize(750, 500);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setVisible(true);

        // configure Label components
        currentExerciseName = new JLabel();
        currentExerciseDescription = new JLabel();
        currentExerciseNumber = new JLabel();

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));

        mainPanel.add(currentExerciseNumber);
        mainPanel.add(currentExerciseName);
        mainPanel.add(currentExerciseDescription);
        mainPanel.add(currentExerciseWeight);
        mainPanel.add(currentExerciseReps);
        mainPanel.add(currentExerciseTime);

        add(cancelWorkout, BorderLayout.NORTH);
        add(mainPanel, BorderLayout.CENTER);
        mainPanel.add(nextExerciseButton);

        cancelWorkout.addActionListener(e -> {
            if (JOptionPane.showConfirmDialog(this,
                    "Are you sure you want to cancel this workout?", "Cancel workout?",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
                MainFrame mainFrame = new MainFrame();
                mainFrame.frame.setVisible(true);
                dispose();
            }
        });

        nextExerciseButton.addActionListener(e -> {
            // Display the next exercise when the button is clicked
            currentExerciseIndex++;
            if (currentExerciseIndex < exercisesList.size()) {
                displayExercise(currentExerciseIndex);
            }
            if (currentExerciseIndex == exercisesList.size()-1) {
                nextExerciseButton.setText("Finish Workout");
            }
            else {
                // No more exercises, workout completed
                JOptionPane.showMessageDialog(this, "Workout completed!");
                Workout.addCompleteDate(LocalDate.now(), workoutName);
                new MainFrame();
                dispose();
            }
        });
    }

    private void displayExercise(int index) {
        List<String> exercise = exercisesList.get(index);
        String name = exercise.get(0);
        String description = exercise.get(1);
        String reps = exercise.get(2);
        String time = exercise.get(3);
        String weight = exercise.get(4);

        currentExerciseNumber.setText("Exercise " + (index + 1) + " out of " + exercisesList.size());
        currentExerciseName.setText(name);
        currentExerciseDescription.setText(description);
        currentExerciseWeight.setText("Weight: " + weight);
        currentExerciseReps.setText("Number of repetitions: " + reps);
        currentExerciseTime.setText("Time: " + time);

        revalidate();
        repaint();
    }
}
