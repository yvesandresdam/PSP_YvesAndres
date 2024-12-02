package ejemplo13;

import java.util.Scanner;

public class Main4 {

    public static void main(String[] args) {

        // Lanzamos el hilo
        Cafetera4 c = new Cafetera4();
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

class Cafetera4 implements Runnable {

    private int contador = 0;

    public int getContador() {
        return contador;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                // Comenzamos a preparar el café
                // Ponemos la cafetera
                Thread.sleep(200);
                // Servimos el café en la taza"
                Thread.sleep(200);
                // Echamos la leche
                Thread.sleep(200);
                // Café finalizado
                contador++;
            } catch (InterruptedException ie) {
                System.out.println("Hilo interrumpido");
            }
        }
    }
}

/*
DOCUMENTACION
-------------

Esta manera no es la más adecuada,porque el bucle WHILE está fuera del bloque TRY,
de tal manera que cuando se gestiona la interrupción desde el bloque CATCH,
la condición de Thread.currentThread.isInterrumpted() pasa a ser false,
porque no está interrumpido, porque se ha gestionado su proceso
y así la condición de flag interrupted nunca es falsa y el bucle WHILE no nunca termina.

 */


