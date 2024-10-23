public class Runner {
    private int idRunner;
    private int idLane;
    private boolean hasStickOn;

    // CONSTRUCTORES de Runner
    public Runner(){};
    public Runner (int idRunner){
        this.idRunner = idRunner;
    }
    public Runner(int idRunner, int idLane){
        this.idRunner = idRunner;
        this.idLane = idLane;
    }

    // region Getters / Setters
    public int getID(){
        return idRunner;
    }
    public void setID(int idRunner){
        this.idRunner = idRunner;
    }
    // endregion

    private boolean hasStick(){
        return hasStickOn;
    }
}
