package view;
import model.Goal;


import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ShowGoalFrame extends JFrame{
    private JButton backButton;
    public ShowGoalFrame(int selectedRowIndex) {
        setLayout(new BorderLayout());
        // Set up the JFrame
        JPanel mainPanel = new JPanel(new BorderLayout());
        backButton = new JButton("Back");
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setSize(1000, 700);
        setTitle("Show Goal");
        setVisible(true);
        add(backButton, BorderLayout.NORTH);
        add(mainPanel, BorderLayout.CENTER);

        Goal goal = Goal.getGoalList().get(selectedRowIndex);
        DefaultCategoryDataset dataset = createDataset(goal);

        // Create chart
        JFreeChart chart = ChartFactory.createLineChart(
                "Exercise Goal Chart",   // Chart title
                "Date",                 // X-axis label
                "Exercise Value",       // Y-axis label
                dataset                // Dataset
        );

        ChartPanel chartPanel = new ChartPanel(chart);
        mainPanel.add(chartPanel, BorderLayout.CENTER);


        backButton.addActionListener(e -> {
            BrowseGoalsFrame browseGoalFrame = new BrowseGoalsFrame();
            browseGoalFrame.setVisible(true);
            dispose();
        });

    }


    private DefaultCategoryDataset createDataset(Goal goal) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        List<String[]> goalProgressList = goal.getProgressList();
        // Add a data point for the given date and exercise value
        for (int i = 0; i < goal.getProgressList().size(); i++){
            dataset.addValue(Integer.parseInt(goalProgressList.get(i)[1]), "Exercise", goalProgressList.get(i)[0]);
        }
        return dataset;
    }
}
