package pconcurrente.ejemplo10;

public class Main {
    public static void main(String[] args) {

        // Obtenemos el objeto Thread del hilo en el que nos encontramos.
        Thread t = Thread.currentThread();

        // Informacion que podemos recuperar de los hilos.
        System.out.println("ID: " + t.getId());
        System.out.println("Nombre: " + t.getName());
        System.out.println("Prioridad: " + t.getPriority());
        System.out.println("Estado: " + t.getState());
        System.out.println("Está vivo: " + t.isAlive());
    }
}

/*
DOCUMENTACION
-------------

Ejemplo que explica la manera para recuperar la información del hilo en el que nos encontramos.
Thread.currentThread() devuelve el propio hilo desde el que ejecutamos la orden.

*/

