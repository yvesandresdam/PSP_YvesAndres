public class Runner implements Runnable {

    // Atributos
    private int idRunner;
    private int idLane;
    private boolean runnerHasStick;
    private boolean canAdvance;
    private boolean hasFinished;

    private Lane lane;

    // Constructores
    public Runner(int idRunner, int idLane) {
        this.idRunner = idRunner;
        this.idLane = idLane;
        if (idRunner == 1)
            runnerHasStick = true;
    }
    public Runner(int idRunner, int idLane, Lane lane) {
        this.idRunner = idRunner;
        this.idLane = idLane;
        this.lane = lane;
        if (idRunner == 1)
            runnerHasStick = true;
    }

    // Funcion que inicia el hilo Corredor
    public void run() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                if (hasStick())
                    System.out.printf("Carril %s Corredor %s: Tengo el testigo y empiezo a correr\n",idRunner,idLane);
                lane.advanceRunner(idRunner);
            }
        };
        Thread t = new Thread(runnable);
        t.start();
    }

    // region Getters / Setters
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

    public boolean canAdvance() {
        return canAdvance;
    }

    public boolean hasStick() {
        return runnerHasStick;
    }

    public void setStick(boolean setStick) {
        runnerHasStick = setStick;
    }

    public void hasFinishedRunning(boolean finish) {
        hasFinished = finish;
    }
    // endregion
}
