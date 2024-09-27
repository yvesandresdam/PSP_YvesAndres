package Exercise1_Solution2;

import java.util.Random;
import java.util.Scanner;

public class Numbers implements Runnable {

    // CLASE NUMBERS
    // implementa la interfaz 'Runnable'

    private static int number1;
    private static int number2;

    // Funcion que recoje los valores de los numeros que introduce
    // el usuario por consola
    public void startApp() {
        Scanner scanner = new Scanner(System.in);

        System.out.printf("Introduce el primer numero: ");
        number1 = scanner.nextInt();

        System.out.printf("Introduce el segundo numero: ");
        number2 = scanner.nextInt();

        System.out.println("El primer numero es: " + number1 + " y el segundo numero es: " + number2);

        scanner.close();
    }


    // Metodo run que contiene las instrucciones para contar numeros
    // Es invocado desde la llamada hilo.start();
    @Override
    public void run() {
        countingNumbers();
    }

    // Funcion que cuenta numeros mientras los valores sean distintos
    private void countingNumbers() {
        while (number1 != number2) {
            try {
                int randomNumber = getRandom(1000);
                if (number1 < number2) {
                    number1++;
                    System.out.println(number1);

                    // Funcion que duerme el hilo
                    // Necesita de un bloque try/catch
                    Thread.sleep(randomNumber);
                } else {
                    number1--;
                    System.out.println(number1);
                    Thread.sleep((randomNumber));
                }
            } catch (InterruptedException ie) {
                System.out.println("El hilo se ha interrumpido");
            }
        }
        System.out.println("El proceso ha concluido.");
    }

    // <editor-fold desc="FUNCIONES PRIVADAS">
    // Funcion que devuelve un numero entero aleatorio
    private static int getRandom(int maxNumber) {
        Random randomNumber = new Random();
        return randomNumber.nextInt(maxNumber) + 1;
    }
    // </editor-fold>
}
