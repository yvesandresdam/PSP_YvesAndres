import java.util.ArrayList;
import java.util.List;

public class Task {
    private int maxPrime;
    private List<Integer> primeNumbersList;

    private final static int MINPRIMENUMBER = 2;
    private final static int MAXPRIMENUMBER = 100;

    public void startThread(int index) {
        Thread hilo = new Thread() {
            @Override
            public void run() {

                Thread.currentThread().setName("Hilo " + index);
                getMaxPrime();
                System.out.println("Este es el " + Thread.currentThread().getName() + ". Muestra los primos hasta el numero: " + maxPrime);

                getListPrimes();
                displayPrimeNumbers();

                int lastPrime = primeNumbersList.size() - 1;
                System.out.println("Fin del proceso. Ultimo numero primo: " + primeNumbersList.get(lastPrime));
            }
        };
        hilo.start();
    }

    public void startThreadLambda(int index) {
        Thread hilo = new Thread(() -> {

            Thread.currentThread().setName("Hilo " + index);
            getMaxPrime();
            System.out.println("Este es el " + Thread.currentThread().getName() + ". Muestra los primos hasta el numero: " + maxPrime);

            getListPrimes();
            displayPrimeNumbers();

            int lastPrime = primeNumbersList.size() - 1;
            System.out.println("Fin del proceso. Ultimo numero primo: " + primeNumbersList.get(lastPrime));
        });
        hilo.start();
    }

    private void getMaxPrime() {
        maxPrime = Utils.getRandomIntNumber(MINPRIMENUMBER, MAXPRIMENUMBER);
    }

    private void getListPrimes() {
        primeNumbersList = Utils.getListPrimes(maxPrime);
    }

    private void displayPrimeNumbers() {
        Thread hiloSecundario = new Thread() {
            @Override
            public void run() {
                while (Thread.currentThread().getState() != State.TERMINATED)
                    displayThreadInformation();
            }
        };
        hiloSecundario.start();

        for (int prime : primeNumbersList) {
            System.out.println(Thread.currentThread().getName() + ": " + prime);
            sleepThread();
        }
    }

    private void sleepThread() {
        int sleepRandomTime = Utils.getRandomIntNumber(500, 1000);

        try {
            Thread.sleep(sleepRandomTime);
        } catch (InterruptedException ie) {
            System.out.println("El hilo se ha interrumpido");
        }
    }

    private void displayThreadInformation() {
        Long ID = Thread.currentThread().getId();
        String name = Thread.currentThread().getName();
        Thread.State state = Thread.currentThread().getState();

        System.out.println("El Hilo con ID " + ID + "de nombre " + name + "se encuentra en el siguiente estado: " + state);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException ie) {
            System.out.println("El hilo se ha detenido");
        }
    }
}
