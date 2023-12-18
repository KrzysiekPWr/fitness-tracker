package view;
import model.Goal;



public class ShowGoalFrame {
    public ShowGoalFrame(int selectedRowIndex) {
        Goal goal = Goal.getGoalList().get(selectedRowIndex);


    }
}
