public class Runner {
    private int idRunner;
    private int idLane;
    private boolean stickOn;

    public Runner(int idRunner, int idLane){
        this.idRunner = idRunner;
        this.idLane = idLane;
    }

    private boolean hasStick(){
        return stickOn;
    }

    private void moveRunner(){
        if(stickOn)
            position++;
    }
}
