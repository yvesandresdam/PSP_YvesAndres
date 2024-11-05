package pconcurrente.ejemplo12;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException{
        // Lanzamos un hilo que cuenta de 0 a 9
        Thread t = new Thread(() ->{
            try{
                Random r = new Random();
                for(int i = 0; i < 10; i++){
                    Thread.sleep(r.nextInt(1500));
                    System.out.println("Número " + i);
                }
            } catch(InterruptedException ie){
                System.out.println("El hilo ha sido interrumpido");
            }
        });
        t.start();

        // Nos suspendemos hasta que el hilo t finalice
        // Con TimeUnit
        TimeUnit.SECONDS.sleep(2000);

        // Con el metodo yield
        t.yield();

        // Con una llamada bloqueante
        t.join();


        System.out.println("El hilo ha finalizado");
    }
}

/*
DOCUMENTACION
-------------

Existen distintas maneras de suspender un hilo. Podemos hacer esto porque estamos esperando a que otro proceso finalice
o porque estamos esperando una respuesta.

Existen distintas maneras de hacerlo.

1. TimeUnit.SECONDS.sleep();
Con una llamada a la funcion estatica sleep, desde la clase TimeUnit.CONSTANTE, donde la CONSTANTE es la unidad de tiempo.
TimeUnit.SECONDS.sleep(2000); esperara durante 2 segundos. Con este metodo podemos darle flexibilidad a la cantidad de tiempo
que espera el sleep, incluso dando horas o dias de unidad.

2. Thread.yield();
Metodo que sirve para indicar a la CPU que este hilo es SUSCEPTIBLE de dar paso a otro hilo. No implica necesariamente
que el hilo se va a suspender, pero si es una orden del programador de permitir la posibilidad de que trabaje otro hilo.

3. t.join();
Es el metodo preferido, es una llamada bloqueante, porque detiene el funcionamiento del hilo principal hasta que el hilo de objeto t
finalice su ejecución. Trabaja contra la 'espera activa' de un while() que consume muchos recursos.

4. Metodo Wait
Suspende el hilo hasta que recibe una notificacion para continuar.

*/