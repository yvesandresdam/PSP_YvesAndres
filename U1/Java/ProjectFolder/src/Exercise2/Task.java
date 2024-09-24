package Exercise2;

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
}
