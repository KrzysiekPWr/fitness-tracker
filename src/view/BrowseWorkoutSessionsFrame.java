package view;

import javax.swing.*;
import java.awt.*;

public class BrowseWorkoutSessionsFrame extends JFrame {

    public BrowseWorkoutSessionsFrame(){
        super("Browse Workout Sessions");
        setSize(1000, 700);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setVisible(true);
        setLayout(new BorderLayout());

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.PAGE_AXIS));

        JTable workoutTable = ComponentBuilder.createWorkoutSessionTable();
        JScrollPane workoutScrollPane = new JScrollPane(workoutTable);

        centerPanel.add(workoutScrollPane);

        add(centerPanel, BorderLayout.CENTER);

        JButton backButton = new JButton("Back");
        add(backButton, BorderLayout.NORTH);

        backButton.addActionListener(e -> {
            MainFrame mainFrame = new MainFrame();
            mainFrame.frame.setVisible(true);
            dispose();
        });
    }
}
