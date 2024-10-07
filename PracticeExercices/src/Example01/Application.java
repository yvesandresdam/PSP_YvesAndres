package Example01;

public class Application {
    public void first(){
        System.out.println("The next message will be displayed 10 seconds");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public void second(){
        Counting countingFunctions = new Counting();
        Thread alternativeThread = new Thread(countingFunctions);
        System.out.println("The next message will be count for 5 seconds");
        alternativeThread.start();
    }

    public void third(){
        System.out.println("The next message will be count for 5 seconds");
        Thread lambdaThread = new Thread(()->{
            int count = 0;
            int number = 5;
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
        });
        lambdaThread.start();
    }
}
