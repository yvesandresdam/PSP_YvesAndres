public class Lane {

    // Posicion del carril
    private int position;

    // Id del carril
    private int idLane;

    // CONSTRUCTOR de la clase carril
    public Lane(int IDLane) {
        idLane = IDLane;
        position = 0;
    }

    public void startLane() {
        Thread runnerThread = new Thread(() -> {
            int idRunner = 4;
            for (int i = 1; i <= idRunner; i++) {
                Runner runner = new Runner(i, idLane, new Lane(idLane));
                runner.run();
            }
        });
        runnerThread.start();
    }

    // Añade un corredor al carril
    private boolean addRunner(Runner runner, int position) {
//        for (Integer runnerPosition : runnersList.values()) {
//            if (runnerPosition == position)
//                return false;
//        }
//        runnersList.put(runner, position);
        return true;
    }

    // Avance del corredor
    public boolean advanceRunner(int idRunner) {
        while (position <= 400000) {
            position++;
            if (position == 100000) {
                System.out.printf("Carril %s Corredor %s: Pierdo el testigo\n", idLane, idRunner);
                idRunner = 2;
                System.out.printf("Carril %s Corredor %s: Recojo el testigo\n", idLane, idRunner);
                System.out.printf("Carril %s Corredor %s: Tengo el testigo y empiezo a correr\n", idLane, idRunner);
            } else if (position == 200000) {
                System.out.printf("Carril %s Corredor %s: Pierdo el testigo\n", idLane, idRunner);
                idRunner = 3;
                System.out.printf("Carril %s Corredor %s: Recojo el testigo\n", idLane, idRunner);
                System.out.printf("Carril %s Corredor %s: Tengo el testigo y empiezo a correr\n", idLane, idRunner);
            } else if (position == 300000) {
                System.out.printf("Carril %s Corredor %s: Pierdo el testigo\n", idLane, idRunner);
                idRunner = 4;
                System.out.printf("Carril %s Corredor %s: Recojo el testigo\n", idLane, idRunner);
                System.out.printf("Carril %s Corredor %s: Tengo el testigo y empiezo a correr\n", idLane, idRunner);
            }
        }
        return true;
    }


    // Getters / Setters
    public int getIDLane() {
        return idLane;
    }
    public void setIDLane(int IDLane) {
        idLane = IDLane;
    }

    public int getRunnerPositionWithID(int idRunner) {
        if (idRunner == 1)
            return 0;
        else if (idRunner == 2)
            return 100000;
        else if (idRunner == 3)
            return 200000;
        else
            return 300000;
    }
}
