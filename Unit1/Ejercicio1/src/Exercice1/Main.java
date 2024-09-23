package Exercice1;

import java.util.Random;
import java.util.Scanner;

public class Main {

    //EJERCICIO 1
    //PROCESO QUE CUENTA NUMEROS

    private static int number1;
    private static int number2;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.printf("Introduce el primer numero: ");
        number1 = scanner.nextInt();
        System.out.printf("Introduce el segundo numero: ");
        number2 = scanner.nextInt();

        System.out.println("El primer numero es: " + number1 + " y el segundo numero es: " + number2);

        SecondaryThread secondThread = new SecondaryThread();
        secondThread.start();

        scanner.close();
    }


    static class SecondaryThread extends Thread {

        @Override
        public void run() {
            countingNumbers();
        }

        private void countingNumbers() {
            System.out.println("El hilo se ha lanzado");

            while (number1 != number2) {
                try {
                    int randomNumber = getRandom(1000);
                    if (number1 < number2) {
                        number1++;
                        System.out.println(number1);
                        Thread.sleep(randomNumber);
                    } else {
                        number1--;
                        System.out.println(number2);
                        Thread.sleep((randomNumber));
                    }
                } catch (InterruptedException ie) {
                    System.out.println("El hilo se ha interrumpido");
                }
            }
            System.out.println("El proceso ha concluido.");
        }

        private int getRandom(int maxNumber) {
            Random randomNumber = new Random();
            return randomNumber.nextInt(maxNumber) + 1;
        }
    }
}

