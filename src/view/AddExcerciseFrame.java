package view;

import controller.CreationController;

import javax.swing.*;
import java.awt.*;

public class AddExcerciseFrame extends JFrame{
    private JPanel panel1 = new JPanel();
    private JTextField excerciseNameTextField;
    private JTextField excerciseDescriptionTextField;
    public Button addExcerciseButton;
    private JCheckBox canBeWeightedCheckBox;
    private JRadioButton repsTimedRadioButton;
    private JRadioButton repsCountedRadioButton;
    JFrame frame = new JFrame();

    AddExcerciseFrame(){
        panel1.setLayout(new BoxLayout(panel1, BoxLayout.PAGE_AXIS));
        panel1.setSize(new Dimension(500, 350));
        panel1.setBackground(Color.GRAY);
        addExcerciseButton = new Button("Add Excercise");
        canBeWeightedCheckBox = new JCheckBox("Can be weighted", true);
        repsTimedRadioButton = new JRadioButton("Repetitions timed");
        repsCountedRadioButton = new JRadioButton("Repetitions counted", true);

        ButtonGroup repsTypeGroup = new ButtonGroup();
        repsTypeGroup.add(repsTimedRadioButton);
        repsTypeGroup.add(repsCountedRadioButton);

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

        excerciseNameTextField.setAlignmentX(Component.CENTER_ALIGNMENT);
        excerciseDescriptionTextField.setAlignmentX(Component.CENTER_ALIGNMENT);
        canBeWeightedCheckBox.setAlignmentX(Component.CENTER_ALIGNMENT);
        repsTimedRadioButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        repsCountedRadioButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        addExcerciseButton.setPreferredSize(new Dimension(200, 30));

        //add the text fields to the panel
        panel1.add(excerciseNameTextField);
        panel1.add(excerciseDescriptionTextField);
        panel1.add(canBeWeightedCheckBox);
        panel1.add(repsCountedRadioButton);
        panel1.add(repsTimedRadioButton);
        panel1.add(addExcerciseButton);

        frame.add(panel1, BorderLayout.CENTER);
        frame.pack();

        addExcerciseButton.addActionListener(e -> {
            String name = excerciseNameTextField.getText();
            String description = excerciseDescriptionTextField.getText();
            CreationController.createExcercise(name, description, canBeWeightedCheckBox.isSelected(),
                    repsCountedRadioButton.isSelected(), repsTimedRadioButton.isSelected());
            frame.dispose();
            new ExcerciseFrame();
        });
    }
}
