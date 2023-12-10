import controller.DataPersistanceManager;
import view.MainFrame;

public class FitnessTrackerApp {

    public static void runProgram() {
        DataPersistanceManager.readData();
        new MainFrame();
    }
}
