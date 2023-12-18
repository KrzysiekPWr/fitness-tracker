package view;

import controller.CreationController;
import model.Goal;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class BrowseGoalsFrame extends JFrame {
JPanel mainPanel = new JPanel();
JPanel buttonPanel = new JPanel();
JButton backButton = new JButton("Back");
JButton deleteGoalButton = new JButton("Delete Goal");
JButton editGoalButton = new JButton("Edit Goal");
JButton showGoalButton = new JButton("Show Goal");
JButton logGoalProgress = new JButton("Log Your Progress");
public BrowseGoalsFrame(){
        setTitle("Browse Goals");
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setSize(1000, 700);
        setVisible(true);
        setLayout(new BorderLayout());

        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));

        //set up the table for the goals
        String[] columnNames = {"Name", "Description", "Deadline", "Value", "Type", "Exercise"};
        String[][] data = CreationController.toGoalArray(model.Goal.getGoalList());
        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        //add the table to the panel
        mainPanel.add(scrollPane);

        //add buttons to the south button panel
        buttonPanel.add(editGoalButton);
        buttonPanel.add(deleteGoalButton);
        buttonPanel.add(showGoalButton);
        buttonPanel.add(logGoalProgress);

        //add the buttons to the panel
        add(backButton, BorderLayout.NORTH);
        add(mainPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);


        backButton.addActionListener(e -> {
                MainFrame mainFrame = new MainFrame();
                mainFrame.frame.setVisible(true);
                dispose();
        });

        deleteGoalButton.addActionListener(e -> {
                int selectedRow = table.getSelectedRow();
                if(selectedRow != -1){
                        Goal.getGoalList().remove(selectedRow);
                        ((DefaultTableModel)table.getModel()).removeRow(selectedRow);
                }
        });

        showGoalButton.addActionListener(e -> {
                int selectedRowIndex = table.getSelectedRow();
                if(selectedRowIndex != -1){
                        new ShowGoalFrame(selectedRowIndex);
                        dispose();
                }
        });

        logGoalProgress.addActionListener(e -> {
                int selectedRowIndex = table.getSelectedRow();
                if(selectedRowIndex != -1){
                        String[] selectedRow = data[selectedRowIndex];
                        new LogGoalProgressFrame(selectedRow[0], selectedRow[1], selectedRow[2], selectedRow[3],
                                selectedRow[5]);
                        dispose();
                }
        });

        editGoalButton.addActionListener(e -> {
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                        new CreateGoalFrame(data[selectedRow][0], data[selectedRow][1], data[selectedRow][2], data[selectedRow][3],
                                data[selectedRow][4], data[selectedRow][5], selectedRow);
                        dispose();
                }
        });
}
}
