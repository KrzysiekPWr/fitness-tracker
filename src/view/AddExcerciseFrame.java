package view;

import controller.CreationController;

import javax.swing.*;
import java.awt.*;

public class AddExcerciseFrame {
    private JPanel panel1 = new JPanel();
    private JTextField excerciseNameTextField;
    private JTextField excerciseDescriptionTextField;
    public Button addExcerciseButton;
    JFrame frame = new JFrame();

    AddExcerciseFrame(){
        panel1.setLayout(new BoxLayout(panel1, BoxLayout.PAGE_AXIS));
        panel1.setSize(new Dimension(500, 350));
        panel1.setBackground(Color.GRAY);
        addExcerciseButton = new Button("Add Excercise");

        excerciseDescriptionTextField = new JTextField();
        excerciseNameTextField = new JTextField();

        //frame basic configuration
        frame.setTitle("Add Excercise");
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(1000, 700);

        //configure the text fields
        excerciseNameTextField.setPreferredSize(new Dimension(200, 30));
        excerciseNameTextField.setMaximumSize(new Dimension(200, excerciseDescriptionTextField.getPreferredSize().height));
        excerciseNameTextField.setText("Excercise Name");

        excerciseDescriptionTextField.setPreferredSize(new Dimension(200, 30));
        excerciseDescriptionTextField.setMaximumSize(new Dimension(200, excerciseDescriptionTextField.getPreferredSize().height));
        excerciseDescriptionTextField.setText("Excercise Description");

        //add the text fields to the panel
        panel1.add(excerciseNameTextField);
        panel1.add(excerciseDescriptionTextField);
        panel1.add(addExcerciseButton);

        frame.add(panel1, BorderLayout.CENTER);
        frame.pack();

        addExcerciseButton.addActionListener(e -> {
            String name = excerciseNameTextField.getText();
            String description = excerciseDescriptionTextField.getText();
            CreationController.createExcercise(name, description);
            frame.dispose();
            new ExcerciseFrame();
        });
    }
}
