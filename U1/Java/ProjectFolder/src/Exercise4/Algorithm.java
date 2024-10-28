package Exercise4;

public class Algorithm implements Runnable {
    private int numberGoal;
    private int currentNumber = 1;
    private Boolean flag = true;

    @Override
    public void run() {
        try {
            while (flag) {
                Thread.sleep(1000);

                System.out.println("El numero invisible es: " + currentNumber);
                currentNumber++;
            }
        } catch (
                InterruptedException ie) {
            System.out.println("El hilo se ha detenido");
        }
    }


    public void setGoalNumber(int value) {
        numberGoal = value;
    }

    public int getCurrentNumber() {
        return currentNumber;
    }

    public void stopFlag() {
        flag = false;
        System.out.println("FLAG!");
    }
}
