package Example01;

public class Counting implements Runnable{
    @Override
    public void run() {
        countingNumbers(5);
    }

    private void countingNumbers(int number){
        int count = 0;
        try {
            for (int i = 1; i <= number; i++) {
                count++;
                System.out.printf("segundo: %d\n", count);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e)
        {
            System.out.println("Error");
        }
    }
}
