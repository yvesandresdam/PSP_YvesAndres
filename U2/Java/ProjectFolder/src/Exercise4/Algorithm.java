package Exercise4;

public class Algorithm implements Runnable {
    private int numberGoal;
    private int currentNumber;
    private Boolean flag = true;

    @Override
    public void run() {
        try {
            while (flag) {
                for (int i = 1; i <= numberGoal; i++) {
                    currentNumber = i;
                    Thread.sleep(1000);

                    System.out.println("El numero invisible es: " + currentNumber);
                }
            }
        } catch (InterruptedException ie) {
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
