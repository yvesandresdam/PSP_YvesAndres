package Exercise1_Solution1;

import java.util.Random;
import java.util.Scanner;

public class Main {

    // EJERCICIO 1
    // SOLUCION 1

    private static int number1;
    private static int number2;

    public static void main(String[] args) {

        // Creamos un objeto de tipo Scanner que reconozca
        // los enteros introducidos por el usuario en la linea
        // de comandos.
        Scanner scanner = new Scanner(System.in);

        System.out.printf("Introduce el primer numero: ");
        number1 = scanner.nextInt();
        System.out.printf("Introduce el segundo numero: ");
        number2 = scanner.nextInt();

        System.out.println("El primer numero es: " + number1 + " y el segundo numero es: " + number2);

        // Creamos un Hilo de manera paralela al hilo principal
        // La función start() inicia su proceso de forma autonoma
        SecondaryThread secondThread = new SecondaryThread();
        secondThread.start();

        // Cerramos el objeto scanner
        scanner.close();
    }


    static class SecondaryThread extends Thread {

        // La clase SecondaryThread contiene las instrucciones
        // de funcionamiento del hilo secundario

        // La funcion run() solo contiene la funcion countingNumbers
        // Esta funcion cuenta numeros
        @Override
        public void run() {
            countingNumbers();
        }


        // La funcion counting Numbers contiene toda la información
        // que procesa el hilo secundario
        private static void countingNumbers() {
            System.out.println("El hilo se ha lanzado");

            while (number1 != number2) {
                try {
                    int randomNumber = getRandom(1000);

                    if (number1 < number2) {
                        number1++;
                        System.out.println(number1);

                        // La funcion Thread.sleep requiere obligatoriamente
                        // el control de las excepciones que se puedan producir
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

        // La funcion getRandom es una funcion auxiliar.
        // Devuelve un entero random entre 1 y el numero 'maxNumber'
        private static int getRandom(int maxNumber) {
            Random randomNumber = new Random();
            return randomNumber.nextInt(maxNumber) + 1;
        }
    }
}

