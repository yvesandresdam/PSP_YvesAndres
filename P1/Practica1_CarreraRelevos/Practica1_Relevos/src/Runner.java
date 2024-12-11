public class Runner implements Runnable {

    // Atributos
    private int idRunner;
    private int idLane;
    private StateType runnerState;
    private Object testigo;

    // Constructores
    public Runner(int idRunner, int idLane, Object testigo) {
        this.idRunner = idRunner;
        this.idLane = idLane;
        this.testigo = testigo;
        if (idRunner == 1)
            runnerState = StateType.RUNNING;
        else
            runnerState = StateType.WAITING;
    }
    public void run(){
        synchronized (testigo) {
            while (getRunnerState() == StateType.WAITING) {
                try {
                    testigo.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    // Getters / Setters de la clase Runner
    public int getIDRunner() {
        return idRunner;
    }
    public void setIDRunner(int IDRunner) {
        idRunner = IDRunner;
    }
    public int getIDLane() {
        return idLane;
    }
    public void setIDLane(int IDLane) {
        idLane = IDLane;
    }
    public void setRunnerState(StateType runnerState) {
        this.runnerState = runnerState;
    }
    public StateType getRunnerState() {
        return runnerState;
    }
}
