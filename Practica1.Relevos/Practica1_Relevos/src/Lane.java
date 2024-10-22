import java.util.List;
import java.util.ArrayList;

public class Lane {
    // Atributos de la clase carril

    // Posicion que tiene el carril
    private Position positionTest;


    // Identificador del carril
    private int idCarril;

    // Constructor de carril, recibe el numero de carril
    public Lane(int IDCarril) {
        idCarril = IDCarril;
    }

    // region Getters / Setters
    public int getIDCarril() {
        return idCarril;
    }

    public void setRunnerAtPosition(int position) {
        this.position = position;
    }

    public int getPosition() {
        return position;
    }
    // endregion

    public void startHiloCorredor() {

        // Runner1
        Runnable hiloCorredor1 = new Runnable() {
            @Override
            public void run() {
                addRunner(1);
            }
        };
        Thread t1 = new Thread(hiloCorredor1);
        t1.start();

        // Runner2
        Runnable hiloCorredor2 = new Runnable() {
            @Override
            public void run() {
                addRunner(2);
            }
        };
        Thread t2 = new Thread(hiloCorredor2);
        t2.start();

        // Runner3
        Runnable hiloCorredor3 = new Runnable() {
            @Override
            public void run() {
                addRunner(3);
            }
        };
        Thread t3 = new Thread(hiloCorredor3);
        t3.start();

        // Runner4
        Runnable hiloCorredor4 = new Runnable() {
            @Override
            public void run() {
                addRunner(4);
            }
        };
        Thread t4 = new Thread(hiloCorredor4);
        t4.start();
    }

    private void addRunner(int idRunner) {
        Runner runner = new Runner(idRunner,1);
        if (idRunner == 1)
            runner.setPosition(0);
        else if (idRunner == 2)
            runner.setPosition(100000);
        else if (idRunner == 3)
            runner.setPosition(200000);
        else if (idRunner == 4)
            runner.setPosition(300000);
    }
    private boolean moveRunner(int idRunner) {
        for (Runner runner : runnersList) {
            if(runner.getID() == (idRunner)) {
                int actualPosition = runner.getPosition();
                runner.setPosition(actualPosition++);
            }
        }
        return true;
    }

    private int getPosition(int idRunner) {
        for (Runner runner : runnersList) {
            if(runner.getID() == (idRunner))
                return runner.getPosition();
        }
        return 0;
    }
}
