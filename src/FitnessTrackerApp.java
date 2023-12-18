import controller.DataPersistanceManager;
import view.MainFrame;

public class FitnessTrackerApp {

    public static void runProgram() {
        DataPersistanceManager.readExercisesData("exercises.ser");
        DataPersistanceManager.readWorkoutsData("workouts.ser");
        DataPersistanceManager.readGoalsData("goals.ser");
        new MainFrame();
    }
}
