import java.util.List;

public class Lane {

    // ATRIBUTOS de la clase carril
    private List<Position> positionList;
    private List<Runner> runnersList;

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


    public void setRunnerAtPosition(Position position, Runner runner) {
        for(Position p : positionList)
            if(p.equals(position))
                p.setRunner(runner,getIDCarril());
    }
    public void setRunnerAtPositionWithNumber(int positionMilimeter, Runner runner){
        Position p = positionList.get(positionMilimeter);
        p.setRunner(runner);
    }
    public void quitRunnerAtPositionWithNumber(int positionMilimeter, Runner runner){
        Position p = positionList.get(positionMilimeter);
        p.quitRunner(runner);
    }
    // endregion

    public void startHiloCorredor() {

        // Runner1
        Runnable hiloCorredor1 = new Runnable() {
            @Override
            public void run() {
                Runner runner = new Runner(1);
                addRunner(runner,0);
            }
        };
        Thread t1 = new Thread(hiloCorredor1);
        t1.start();

        // Runner2
        Runnable hiloCorredor2 = new Runnable() {
            @Override
            public void run() {
                Runner runner = new Runner(2);
                addRunner(runner,100000);
            }
        };
        Thread t2 = new Thread(hiloCorredor2);
        t2.start();

        // Runner3
        Runnable hiloCorredor3 = new Runnable() {
            @Override
            public void run() {
                Runner runner = new Runner(3);
                addRunner(runner,200000);
            }
        };
        Thread t3 = new Thread(hiloCorredor3);
        t3.start();

        // Runner4
        Runnable hiloCorredor4 = new Runnable() {
            @Override
            public void run() {
                Runner runner = new Runner(4);
                addRunner(runner,300000);
            }
        };
        Thread t4 = new Thread(hiloCorredor4);
        t4.start();
    }

    // OBLIGATORIO
    private void addRunner(Runner runner, int positionMilimeter) {
        setRunnerAtPositionWithNumber(positionMilimeter,runner);
    }
}
