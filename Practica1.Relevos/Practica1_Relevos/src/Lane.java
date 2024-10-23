import java.util.List;

public class Lane {
<<<<<<< Updated upstream
    // Atributos de la clase carril

    // Posicion que tiene el carril
    private Position positionTest;
=======
>>>>>>> Stashed changes

    // ATRIBUTOS de la clase carril
    private Position position;
    private List<Position> positionList;

    // Identificador del carril
    private int idCarril;



    // CONSTRUCTOR de la clase carril
    public Lane(int IDCarril) {
        idCarril = IDCarril;
        for(int i = 0; i <= 400000; i++){
            Position p = new Position(i);
            positionList.add(p);
        }
    }


    // region Getters / Setters
    public int getIDCarril() {
        return idCarril;
    }
    public void setIDCarril(int idCarril){
        this.idCarril = idCarril;
    }

    public void setPosition(Position position){
        this.position = position;
    }
    public void setRunnerAtPosition(Position position, Runner runner) {
        for(Position p : positionList)
            if(p.equals(position))
                p.setRunner(runner,getIDCarril());
    }
    public void setRunnerAtPositionNumber(int positionMilimeter, Runner runner){
        Position p = positionList.get(number);
        p.setRunner(runner);
    }
    public void quitRunnerAtPositionWithNumber(int positionMilimeter, Runner runner){
        Position p = positionList.get(number);
        p.quitRunner(runner);
    }
    public void setRunnerAtPositionWithNumber(int positionMilimeter, Runner runner) {
        for(Position p : positionList)
            if(p.milimeter == number)
                p.setRunner(runner,getIDCarril());
    }
    public Position getPosition() {
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

    // OBLIGATORIO
    private void addRunner(Runner runner, int positionMilimeter) {
        setRunnerAtPositionNumber(positionMilimeter,runner);
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
