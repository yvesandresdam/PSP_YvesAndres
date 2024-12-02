package ejemplo13;

import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {

        // Lanzamos el hilo
        Cafetera2 c = new Cafetera2();
        Thread t = new Thread(c);
        t.start();

        // Cuando el usuario pulse enter detenemos el hilo
        System.out.println("Presiona intro para detener la cafetera");
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
        // Si se ejecuta la siguiente línea es porque el usuario ha pulsado la tecla enter
        c.Detener();

        // La finalización no es instantánea, así que esperamos a que realmente finalice
        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.printf("Total: %d cafés", c.getContador());
    }
}

class Cafetera2 implements Runnable {

    // Condiciones bandera o flag
    private int contador = 0;
    private boolean ejecutar = true;

    @Override
    public void run() {
        try {
            int contador = 0;
            while (ejecutar) {
                // Comenzamos a preparar el café
                // Ponemos la cafetera
                Thread.sleep(200);
                // Servimos el café en la taza"
                Thread.sleep(200);
                // Echamos la leche
                Thread.sleep(200);
                // Café finalizado
                contador++;
                System.out.println("Nº de cafés preparados: " + contador);
            }
        } catch (InterruptedException e) {
            System.out.println("Hilo interrumpido");
        }
    }

    // Metodo bandera
    public void Detener() {
        ejecutar = false;
    }

    // Getter contador
    public int getContador() {
        return contador;
    }
}


/*
DOCUMENTACION
-------------

Aqui detenemos el hilo usando flags o condiciones banderas, que no es mas que un booleano dentro
de la expresion while(). Si este booleano es 'true' se realiza el bucle, en cambio si el booleano
se cambia a 'false', mediante el uso de una funcion bandera detener(), el bucle while finaliza su proceso.
Antes de finalizar, realiza todo el contenido de su cuerpo, lo que significa que no termina instantaneamente.
Es por ello que se hace imprescindible utilizar un metodo join(), para esperar a que el bucle while y con ello el proceso
del hilo termine por completo, ya que podriamos adelantar los procesos en una forma desordenada.

*/



