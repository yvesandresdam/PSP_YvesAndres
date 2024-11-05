package pconcurrente.ejemplo13d;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // Lanzamos el hilo
        Cafetera c = new Cafetera();
        Thread t = new Thread(c);
        t.start();

        // Cuando el usuario pulse enter detenemos el hilo
        System.out.println("Presiona intro para detener la cafetera");
        Scanner sc = new Scanner(System.in);
        sc.nextLine();

        // Interrumpimos el hilo
        t.interrupt();

        // Otra manera de esperar a que finalice el hilo
        // El sleep que se hace produce una 'espera activa' que puede resultar negativo en el rendimiento del programa
        while (t.isAlive()) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.printf("Total: %d cafés", c.getContador());
    }
}
