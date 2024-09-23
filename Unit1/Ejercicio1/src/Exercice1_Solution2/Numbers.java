package Exercice1_Solution2;

import java.util.Random;
import java.util.Scanner;

public class Numbers implements Runnable {

    private int number1;
    private int number2;
    @Override
    public void run() {

        while (number1 != number2) {
            try {
                int randomNumber = getRandom(1000);
                if (number1 < number2) {
                    number1++;
                    System.out.println(number1);
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

    public void setNumber1(int value){
        number1 = value;
    }
    public void setNumber2(int value){
        number2 = value;
    }

    public void UINumberSelector(){
        Scanner scanner = new Scanner(System.in);

        System.out.printf("Introduce el primer numero: ");
        number1 = scanner.nextInt();

        System.out.printf("Introduce el segundo numero: ");
        number2 = scanner.nextInt();

        System.out.println("El primer numero es: " + number1 + " y el segundo numero es: " + number2);

        scanner.close();
    }
    private static int getRandom(int maxNumber) {
        Random randomNumber = new Random();
        return randomNumber.nextInt(maxNumber) + 1;
    }
}
