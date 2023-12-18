package view;

import controller.CreationController;
import controller.InputValidator;
import model.Exercise;
import model.Goal;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;

public class CreateGoalFrame extends JFrame {
    private JPanel mainPanel = new JPanel();
    private JPanel radioButtonsPanel = new JPanel();
    private JButton backButton = new JButton("Back");
    private JTextField goalNameTextField = new JTextField();
    private JTextField goalDescriptionTextField = new JTextField();
    private JFormattedTextField goalDeadLineFormatTextField;
    private JLabel deadlineValueLabel = new JLabel();
    private JTextField goalValue = new JTextField();
    private JLabel goalValueLabel = new JLabel();
    private JButton createGoalButton = new JButton("Create Goal");
    private JComboBox<String> relatedExerciseComboBox = new JComboBox<String>();
    private JRadioButton weightGoalRadioButton;
    private JRadioButton repGoalRadioButton;
    private JRadioButton timeGoalRadioButton;
    private Goal.GoalType goalType;
    private final java.util.List<Exercise> exerciseList = model.Exercise.getExerciseList();

    private boolean doesExerciseSupportWeightGoal(){
        return exerciseList.get(relatedExerciseComboBox.getSelectedIndex()).getCanBeWeighted();
    }
    private boolean doesExerciseSupportTimeGoal(){
        return exerciseList.get(relatedExerciseComboBox.getSelectedIndex()).getAreRepsTimed();
    }

    private boolean doesExerciseSupportRepGoal(){
        return exerciseList.get(relatedExerciseComboBox.getSelectedIndex()).getAreRepsCounted();
    }

    public CreateGoalFrame(){
        this("", "", "", "", "", "", -1);
    }
    public CreateGoalFrame(String name, String description, String deadline, String value, String type, String exerc, int goalID){
        setTitle("FitnessTracker");
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setSize(1000, 700);
        setVisible(true);
        radioButtonsPanel.setLayout(new BoxLayout(radioButtonsPanel, BoxLayout.LINE_AXIS));

        //add the type of goal radio buttons
        ButtonGroup goalTypeButtonGroup = new ButtonGroup();
        weightGoalRadioButton = new JRadioButton("Weight Goal");
        repGoalRadioButton = new JRadioButton("Reps Goal");
        timeGoalRadioButton = new JRadioButton("Time Goal");
        goalTypeButtonGroup.add(weightGoalRadioButton);
        goalTypeButtonGroup.add(repGoalRadioButton);
        goalTypeButtonGroup.add(timeGoalRadioButton);

        // create the related exercise combo box
        for (model.Exercise exercise : model.Exercise.getExerciseList()) {
            relatedExerciseComboBox.addItem(exercise.getName());
        }

        //set up the date input
        try {
            MaskFormatter dateFormatter = new MaskFormatter("##/##/####");
            dateFormatter.setPlaceholderCharacter('_');

            goalDeadLineFormatTextField = new JFormattedTextField(dateFormatter);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }

        if (goalID != -1)
        {
            goalNameTextField.setText(name);
            goalDescriptionTextField.setText(description);

            goalValue.setText(value);

            relatedExerciseComboBox.setSelectedItem(exerc);

            if (type.equals(Goal.GoalType.TIME.toString()))
            {
                timeGoalRadioButton.setSelected(true);
                goalType = Goal.GoalType.TIME;
            }
            else if (type.equals(Goal.GoalType.WEIGHT.toString()))
            {
                weightGoalRadioButton.setSelected(true);
                goalType = Goal.GoalType.WEIGHT;
            }
            else
            {
                repGoalRadioButton.setSelected(true);
                goalType = Goal.GoalType.REPETITIONS;
            }
        }

        radioButtonsPanel.add(weightGoalRadioButton);
        radioButtonsPanel.add(repGoalRadioButton);
        radioButtonsPanel.add(timeGoalRadioButton);

        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));
        mainPanel.add(new JLabel("Goal Name:"));
        mainPanel.add(goalNameTextField);
        mainPanel.add(new JLabel("Goal Description:"));
        mainPanel.add(goalDescriptionTextField);
        if (goalID != -1)
        {
            mainPanel.add(new JLabel("Goal Deadline: [" + deadline + "]"));
        }
        else
        {
            mainPanel.add(new JLabel("Goal Deadline:"));

        }
        mainPanel.add(goalDeadLineFormatTextField);
        mainPanel.add(new JLabel("Related Exercise:"));
        mainPanel.add(relatedExerciseComboBox);
        mainPanel.add(new JLabel("Goal Type:"));
        mainPanel.add(radioButtonsPanel);
        mainPanel.add(goalValueLabel);
        mainPanel.add(goalValue);

        weightGoalRadioButton.addItemListener(e -> {
            if(weightGoalRadioButton.isSelected()){
                goalValueLabel.setText("Weight Goal:");
                goalType = Goal.GoalType.WEIGHT;
                mainPanel.revalidate();
                mainPanel.repaint();
            }
        });

        repGoalRadioButton.addItemListener(e -> {
            if(repGoalRadioButton.isSelected()){
                repGoalRadioButton.setSelected(false);
                goalValueLabel.setText("Reps Goal:");
                goalType = Goal.GoalType.REPETITIONS;
                mainPanel.revalidate();
                mainPanel.repaint();
            }
        });

        timeGoalRadioButton.addItemListener(e -> {
            if(timeGoalRadioButton.isSelected()){
                timeGoalRadioButton.setSelected(false);
                goalValueLabel.setText("Time Goal:");
                goalType = Goal.GoalType.TIME;
                mainPanel.revalidate();
                mainPanel.repaint();
            }
        });

        add(backButton, BorderLayout.NORTH);
        add(mainPanel, BorderLayout.CENTER);
        add(createGoalButton, BorderLayout.SOUTH);

        //if the back button is pressed, go back to the main frame
        backButton.addActionListener(e -> {
            MainFrame mainFrame = new MainFrame();
            mainFrame.frame.setVisible(true);
            dispose();
        });

        //create the goal if the create goal button is pressed and all fields are filled in correctly
        createGoalButton.addActionListener(e -> {

//          TODO create another function for this code

            String result = InputValidator.returnJustDigits(goalValue.getText());
            int finalValue = 0;
            if (!result.isEmpty())
            {
                finalValue = Integer.parseInt(result);
            }

            if (!result.equals(goalValue.getText()))
                JOptionPane.showMessageDialog(this, "Skipped some characters from value field");


//          ----------------------------------------------

            if(goalNameTextField.getText().equals("") || goalDescriptionTextField.getText().equals("") ||
                    goalDeadLineFormatTextField.getText().equals("") || relatedExerciseComboBox.getSelectedIndex()==-1 ||
                    goalValue.getText().equals("")){
                JOptionPane.showMessageDialog(this, "Please fill in all fields");
            }
            else if(!doesExerciseSupportWeightGoal() && weightGoalRadioButton.isSelected()){
                weightGoalRadioButton.setSelected(false);
                JOptionPane.showMessageDialog(this, "This exercise isn't weighted. " +
                        "Please select another exercise or a different goal type");
            }
            else if(!doesExerciseSupportRepGoal() && repGoalRadioButton.isSelected()){
                repGoalRadioButton.setSelected(false);
                JOptionPane.showMessageDialog(this, "This exercise does not support repetitions. " +
                        "Please select another exercise or a different goal type");
            }
            else if(!doesExerciseSupportTimeGoal() && timeGoalRadioButton.isSelected()){
                timeGoalRadioButton.setSelected(false);
                JOptionPane.showMessageDialog(this, "This exercise does not support timed repetitions. " +
                        "Please select another exercise or a different goal type");
            }
            else if (!InputValidator.isValidFutureDate(goalDeadLineFormatTextField.getText())){
                JOptionPane.showMessageDialog(this, "Please enter a valid date");
            }
            else if(result.isBlank())
            {
                JOptionPane.showMessageDialog(this, "Entered value is incorrect");
            }
            else {
                if (goalID != -1)
                {
                    Goal.getGoalList().remove(goalID);
                }
                CreationController.createGoal(goalNameTextField.getText(), goalDescriptionTextField.getText(),
                        goalDeadLineFormatTextField.getText(),
                        model.Exercise.getExerciseList().get(relatedExerciseComboBox.getSelectedIndex()),
                        goalType, finalValue);
                MainFrame mainFrame = new MainFrame();
                mainFrame.frame.setVisible(true);
                dispose();
            }
        });

    }
}
