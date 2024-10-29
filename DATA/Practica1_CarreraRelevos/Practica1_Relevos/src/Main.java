import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Programacion Servicios y Procesos");
        System.out.println("Practica 1 - Carrera de relevos");
        System.out.println();

        // Creacion de cada carril / Creacion de runners
        Thread tLane = new Thread(() -> {
            int numberLanes = 4;
            for (int i = 1; i <= numberLanes; i++) {
                Lane lane = new Lane(i);
                lane.startLane();
            }
        });
        tLane.start();

        // Fin del programa
        try {
            tLane.join();
        } catch (InterruptedException e) {
            tLane.getStackTrace();
        } finally {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Press any key to exit...");
            scanner.nextLine();
        }
    }
}
