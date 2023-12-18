package view;

import controller.InputValidator;
import model.Goal;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Map;

public class LogGoalProgressFrame extends JFrame {
    private JButton backButton = new JButton("Back");
    private JButton logButton = new JButton("Log Progress");
    private JPanel mainPanel = new JPanel();
    private JTextField goalProgressEntryTextField = new JTextField();
    public LogGoalProgressFrame(String name, String description, String deadline, String value, String exerc){
        setTitle("Log Goal Progress");
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setSize(1000, 700);
        setVisible(true);
        setLayout(new BorderLayout());

        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));


        mainPanel.add(new JLabel("Name: " + name));
        mainPanel.add(new JLabel("Description: " + description));
        mainPanel.add(new JLabel("Deadline: " + deadline));
        mainPanel.add(new JLabel("Exercise: " + exerc));
        mainPanel.add(new JLabel("Your goal: " + value));
        mainPanel.add(new JLabel("Your current progress:"));
        mainPanel.add(goalProgressEntryTextField);


        add(backButton, BorderLayout.NORTH);
        add(mainPanel, BorderLayout.CENTER);
        add(logButton, BorderLayout.SOUTH);
        pack();

        backButton.addActionListener(e -> {
            BrowseGoalsFrame browseGoalFrame = new BrowseGoalsFrame();
            browseGoalFrame.setVisible(true);
            dispose();
        });

        logButton.addActionListener(e -> {

            ArrayList<Goal> goalList = Goal.getGoalList();
            int index = -1;
            //Find the proper id of a goal in Goal.getGoalList()
            for (index = 0; index < goalList.size() && !goalList.get(index).getName().equals(name); index++){}
            Goal goal = Goal.getGoalList().get(index);


            String finalValue = InputValidator.returnJustDigits(goalProgressEntryTextField.getText());
            if(finalValue.isBlank()) {
                JOptionPane.showMessageDialog(this, "Please enter a valid value");
            }
            else{
                goal.addToProgressList(Integer.parseInt(finalValue));
                System.out.println(goal.getProgressList());
                new BrowseGoalsFrame();
                dispose();
            }
        });

    }
}
