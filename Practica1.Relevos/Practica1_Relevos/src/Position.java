public class Position {
<<<<<<< Updated upstream
    public int position;
    public Runner idRunner;
=======
    public int milimeter;
    public int idRunner;
    public Runner runner;

    public Position(){};
    public Position(int milimeter){
        this.milimeter = milimeter;
    }
    public boolean setRunner(Runner runner, int idRunner){
        Runner r = new Runner(idRunner);
        return true;
    }
    public boolean setRunner(Runner runner){
        Runner r = new Runner();
        return true;
    }

    public boolean quitRunner(Runner runner){
        Runner r = null;
        return true;
    }
>>>>>>> Stashed changes
}
