package Exercise4;

import java.util.Scanner;

public class Application {
    public void launch() {
        System.out.println("Bienvenido a adivinar hilos temporales");

        // Variable de numero que hay que adivinar
        int numberGoal = Utils.getRandom(10, 15);

        System.out.println("Tienes que adivinar en que momento el programa está contando este numero: " + numberGoal);
        System.out.println("Pulsa una tecla para parar el temporizador");

        // Clase que contiene el conteo de numeros
        Algorithm numbers = new Algorithm();
        numbers.setGoalNumber(numberGoal);
        Thread invisibleCounting = new Thread(numbers);
        invisibleCounting.start();

        // El hilo principal cuenta 5 numeros
        counting5Numbers();

        // Se captura la tecla que pulsa el usuario
        Scanner scannerIn = new Scanner(System.in);
        String stop = scannerIn.nextLine();

        // Se detiene el hilo secundario mediante el uso de un flag
        numbers.stopFlag();
        try {
            invisibleCounting.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // Establece la condicion de victoria
        int playerNumber = numbers.getCurrentNumber();
        System.out.println(playerNumber);
        if (playerNumber == numberGoal)
            System.out.println("Has acertado el momento exacto!");
        else
            System.out.println("No has acertado el momento exacto");
    }

    public void counting5Numbers() {
        try {
            for (int i = 1; i < 6; i++) {
                System.out.println("Numero " + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException ie) {
            System.out.println("El hilo se ha detenido");
        }
    }
}
