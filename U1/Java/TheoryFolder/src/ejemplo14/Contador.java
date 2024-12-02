package ejemplo14;

public class Contador implements Runnable{

    private int contador = 0;

    @Override
    public void run() {
        for(int i = 0; i < 100; i++){
            contador++;
        }
        System.out.println(
                "Finalizado el hilo " + Thread.currentThread().getName() +
                        ". El valor del contador es " + contador);
    }
}

/*
DOCUMENTACION
-------------

La clase contador crea un objeto Contador que lo que hace es incrementar en 1 su valor hasta llegar al 100.

Entonces saca un mensaje por pantalla indicando su valor.

 */

