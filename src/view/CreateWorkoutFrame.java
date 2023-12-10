package view;

import model.Workout;

import javax.swing.*;

public class CreateWorkoutFrame extends Workout {
    JFrame frame = new JFrame();

    public CreateWorkoutFrame(){
        frame.setTitle("Create Workout");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(1000, 700);
        frame.setVisible(true);
    }
}
