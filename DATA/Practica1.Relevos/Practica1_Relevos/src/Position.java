public class Position {
    
    // ATRIBUTOS
    public int milimeter;
    public int idRunner;
    public Runner runner;


    // CONSTRUCTORES
    public Position(){};
    public Position(int milimeter){
        this.milimeter = milimeter;
    }

    // FUNCTIONS
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
}
