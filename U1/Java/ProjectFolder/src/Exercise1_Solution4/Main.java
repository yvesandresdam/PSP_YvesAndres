package Exercise1_Solution4;

import java.util.Random;
import java.util.Scanner;

public class Main {

    private static int number1;
    private static int number2;
    private static final int MAXVALUE = 1000;

    public static void main(String[] args) {
        //EJERCICIO 1
        //USANDO FUNCIONES LAMBDA

        //SINTAXIS
        //Thread hilo1 = new Thread(() -> {});

        Thread hilo1 = new Thread(() -> {
            setNumbers();
            countingNumbers();
            endingProcess();
        });
        hilo1.start();
    }

    private static void setNumbers() {
        Scanner scanner = new Scanner(System.in);

        System.out.printf("Introduce el primer numero: ");
        number1 = scanner.nextInt();

        System.out.printf("Introduce el segundo numero: ");
        number2 = scanner.nextInt();

        scanner.close();
    }

    private static void countingNumbers() {

        try {
            while (number1 != number2) {
                int randomNumber = getRandom(MAXVALUE);
                if (number1 < number2) {
                    number1++;
                    System.out.println(number1);
                    Thread.sleep(randomNumber);
                } else {
                    number1--;
                    System.out.println(number1);
                    Thread.sleep(randomNumber);
                }
            }
        } catch (InterruptedException ie) {
            System.out.println("El Hilo se ha interrumpido");
        }
    }

    private static int getRandom(int maxValue) {
        Random randomNumber = new Random();
        return randomNumber.nextInt(maxValue) + 1;
    }

    private static void endingProcess() {
        System.out.println("El proceso ha concluido");
    }
}
