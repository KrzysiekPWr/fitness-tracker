package model;

public class Workout {
    // #TODO creating the training
    // #TODO editing the training
    // #TODO deleting the training
    private int sets;
    private int repetitions;
    private float weight;

    public Workout(int sets, int repetitions) {
        this.sets = sets;
        this.repetitions = repetitions;
    }

    public Workout(int sets, int repetitions, float weight) {
        this.sets = sets;
        this.repetitions = repetitions;
        this.weight = weight;
    }
}
