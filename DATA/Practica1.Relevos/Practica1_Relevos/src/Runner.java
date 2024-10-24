public class Runner {
    // ATRIBUTOS
    private int idRunner;
    private int idLane;
    private boolean runnerHasStick;

    // CONSTRUCTORES
    public Runner(int idRunner, int idLane) {
        this.idRunner = idRunner;
        this.idLane = idLane;
    }

    // region Getters / Setters
    public int getIDRunner() {
        return idRunner;
    }
    public void setIDRunner(int IDRunner) {
        idRunner = IDRunner;
    }
    public int getIDLane(){
        return idLane;
    }
    public void setIDLane(int IDLane){
        idLane = IDLane;
    }
    // endregion

    private boolean hasStick() {
        return runnerHasStick;
    }
    public void setStick(boolean setStick){
        runnerHasStick = setStick;
    }
}
