package view;

import controller.CreationController;
import model.Exercise;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
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
        panel1.setLayout(new BorderLayout());

        addExcerciseButton = new JButton("Add Excercise");
        deleteExerciseButton = new JButton("Delete Excercise");

        rightButtonsPanel.setLayout(new BoxLayout(rightButtonsPanel, BoxLayout.PAGE_AXIS));
        rightButtonsPanel.setBackground(Color.GRAY);
        rightButtonsPanel.setSize(new Dimension(500, 350));

        table1 = ComponentBuilder.createExerciseTable();
        excerciseScrollPane = new JScrollPane(table1);


//-------------------ADD EVERYTHING TO THE FRAME ---------------------------------------------
        rightButtonsPanel.add(addExcerciseButton);
        rightButtonsPanel.add(deleteExerciseButton);
        panel1.add(backButton, BorderLayout.NORTH);
        panel1.add(rightButtonsPanel, BorderLayout.EAST);
        panel1.add(excerciseScrollPane, BorderLayout.CENTER);
        frame.add(panel1);
        frame.setVisible(true);

        //if the user clicks the back button, open the main frame
        backButton.addActionListener(e -> {
            MainFrame mainFrame = new MainFrame();
            mainFrame.frame.setVisible(true);
            frame.dispose();
        });

        //if the user clicks the add excercise button, open the addExcercise popup
        addExcerciseButton.addActionListener(e -> {
            AddExcerciseFrame addExcerciseFrame = new AddExcerciseFrame();
            addExcerciseFrame.frame.setVisible(true);
            frame.dispose();
        });

        //if the user clicks the delete excercise button, delete the selected excercise
        deleteExerciseButton.addActionListener(e -> {
            int selectedRow = table1.getSelectedRow();
            if(selectedRow != -1){
                Exercise.exerciseList.remove(selectedRow);
                ((DefaultTableModel)table1.getModel()).removeRow(selectedRow);
            }
        });
    }
    
}
