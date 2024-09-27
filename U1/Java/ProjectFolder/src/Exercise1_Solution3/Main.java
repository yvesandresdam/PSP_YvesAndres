package Exercise1_Solution3;

import java.util.Random;
import java.util.Scanner;

public class Main {

    //EJERCICIO 1
    //USANDO FUNCIONES ANONIMAS

    private static int number1;
    private static int number2;
    private static final int MAXVALUE = 1000;

    public static void main(String[] args) {

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                getNumbers();
                countNumbers();
            }
        };

        Thread hilo1 = new Thread(runnable);
        hilo1.start();
    }

    private static int getRandom(int maxValue) {
        Random randomNumber = new Random();
        return randomNumber.nextInt(maxValue) + 1;
    }

    private static void getNumbers() {
        Scanner scanner = new Scanner(System.in);

        System.out.printf("Introduce el primer numero: ");
        number1 = scanner.nextInt();

        System.out.printf("Introduce el segundo numero: ");
        number2 = scanner.nextInt();

        scanner.close();
    }

    private static void countNumbers() {
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
                    Thread.sleep((randomNumber));
                }
            }
        } catch (InterruptedException ie) {
            System.out.println("El hilo se ha interrumpido");
        }
        System.out.println("El proceso ha concluido");
    }
}


/*
    DOCUMENTACION
    -------------
    SINTAXIS
    Runnable runnable = new Runnable(){
    //    Codigo a ejecutar
          @Override
          public void run(){
          Codigo a ejecutar
          }
     };
    Thread Hilo1 = new Thread(runnable);
    Hilo1.start();
 */
