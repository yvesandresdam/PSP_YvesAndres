package pconcurrente.ejemplo11;

import java.util.Random;

public class Main {
    public static void main(String[] args) throws InterruptedException{
        // Lanzamos un hilo que cuenta de 0 a 9
        Thread t = new Thread(() ->{
            try{
                Random r = new Random();
                for(int i = 0; i < 10; i++){
                    Thread.sleep((long)r.nextInt(1500));
                    System.out.println("Número " + i);
                }
            } catch(InterruptedException ie){
                System.out.println("El hilo ha sido interrumpido");
            }
        });
        t.start();

        // Esperamos a que finalice
        while(t.isAlive()){
            Thread.sleep(1000);
        }
        System.out.println("El hilo ha finalizado");
    }
}

/*
DOCUMENTACION
-------------

Esta es una manera de ejecutar codigo cuando el proceso del hilo ha terminado.
con un bucle While comprobamos que el hilo sigue vivo para esperar durante 1 segundo.
En el momento que el hilo ha finalizado, entonces mostramos por pantalla un mensaje.
El problema es que no podemos estar seguros de cada cuanto tiempo tenemos que evaluar la condicion
While, 1 segundo puede ser poco y 10 segundo puede ser mucho.

*/
