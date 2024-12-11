import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Lane implements Runnable {

    // Atributos de la clase carril
    private int position;
    private int idLane;
    private PositionTurnOver positionTurnOver;
    private static int podiumPosition;

    Object testigo;
    Runner runner1;
    Runner runner2;
    Runner runner3;
    Runner runner4;

    // Constructor de la clase carril
    public Lane(int iDLane, Object testigo, int podiumPosition) {
        this.idLane = iDLane;
        this.testigo = testigo;
        this.position = 0;
        this.positionTurnOver = PositionTurnOver.START;
        this.podiumPosition = podiumPosition;

        runner1 = new Runner(1, idLane, testigo);
        runner2 = new Runner(2, idLane, testigo);
        runner3 = new Runner(3, idLane, testigo);
        runner4 = new Runner(4, idLane, testigo);
    }

    @Override
    public void run() {
        raceStart();
        while (!raceGoal()) {
            runnersRunning();
        }
        raceEnd();
    }

    private void raceStart() {
        // UI
        UI.raceStart(idLane);
        UI.runnerStart(idLane, 1);

        // Funcion que inicia la carrera para la pista idLane
        startThread();
    }

    private boolean raceGoal() {
        // Condicion para terminar la carrera
        return positionTurnOver == PositionTurnOver.GOAL;
    }

    private void runnersRunning() {
        position++;

        if (position == 99999) {
            positionTurnOver = PositionTurnOver.FIRSTSTOP;
            checkMonitor(positionTurnOver);
        } else if (position == 199999) {
            positionTurnOver = PositionTurnOver.SECONDSTOP;
            checkMonitor(positionTurnOver);
        } else if (position == 299999) {
            positionTurnOver = PositionTurnOver.THIRDSTOP;
            checkMonitor(positionTurnOver);
        } else if (position == 399999) {
            positionTurnOver = PositionTurnOver.GOAL;
        }
    }

    private void raceEnd() {
        // Funcion que termina la carrera
        UI.raceEnd(idLane);
        increasePodiumPosition();
    }

    private synchronized void increasePodiumPosition() {
        podiumPosition++;
        UI.lanePodium(idLane, podiumPosition);
    }

    private void startThread() {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        try {
            executorService.execute(runner1);
            executorService.execute(runner2);
            executorService.execute(runner3);
            executorService.execute(runner4);
        } finally {
            executorService.shutdown();
        }
    }

    private void checkMonitor(PositionTurnOver positionTurn) {
        synchronized (testigo) {
            if (positionTurn == PositionTurnOver.FIRSTSTOP) {
                runner1.setRunnerState(StateType.ENDING);
                runner2.setRunnerState(StateType.RUNNING);

                // UI
                UI.runnerEnd(idLane, 1);
                UI.turnOverTestigo(idLane, 1);
                UI.runnerStart(idLane, 2);
            } else if (positionTurn == PositionTurnOver.SECONDSTOP) {
                runner2.setRunnerState(StateType.ENDING);
                runner3.setRunnerState(StateType.RUNNING);

                // UI
                UI.runnerEnd(idLane, 2);
                UI.turnOverTestigo(idLane, 2);
                UI.runnerStart(idLane, 3);
            } else if (positionTurn == PositionTurnOver.THIRDSTOP) {
                runner3.setRunnerState(StateType.ENDING);
                runner4.setRunnerState(StateType.RUNNING);

                // UI
                UI.runnerEnd(idLane, 3);
                UI.turnOverTestigo(idLane, 3);
                UI.runnerStart(idLane, 4);
            } else if (positionTurn == PositionTurnOver.GOAL) {
                runner4.setRunnerState(StateType.ENDING);

                // UI
                UI.runnerEnd(idLane, 4);
            }

            // notifica al await.room cuando termina el cambio de testigo
            testigo.notify();
        }
    }

    // Getters / Setters de la clase carril
    public int getIDLane() {
        return idLane;
    }

    public void setIDLane(int IDLane) {
        idLane = IDLane;
    }

    /* Una alternativa mas CONCURRENTE a runnersRunning() */

    private void runnersRunningMoreConcurrent() {
        position++;

        synchronized (testigo) {
            if (position == 99999) {
                positionTurnOver = PositionTurnOver.FIRSTSTOP;
                runner1.setRunnerState(StateType.ENDING);
                runner2.setRunnerState(StateType.RUNNING);

                // UI
                UI.runnerEnd(idLane, 1);
                UI.turnOverTestigo(idLane, 1);
                UI.runnerStart(idLane, 2);
            } else if (position == 199999) {
                runner2.setRunnerState(StateType.ENDING);
                runner3.setRunnerState(StateType.RUNNING);

                // UI
                UI.runnerEnd(idLane, 2);
                UI.turnOverTestigo(idLane, 2);
                UI.runnerStart(idLane, 3);
            } else if (position == 299999) {
                runner3.setRunnerState(StateType.ENDING);
                runner4.setRunnerState(StateType.RUNNING);

                // UI
                UI.runnerEnd(idLane, 3);
                UI.turnOverTestigo(idLane, 3);
                UI.runnerStart(idLane, 4);
            } else if (position == 399999) {
                runner4.setRunnerState(StateType.ENDING);

                // UI
                UI.runnerEnd(idLane, 4);
            }

            // notifica al await.room cuando termina el cambio de testigo
            testigo.notify();
        }
    }
}
