package pconcurrente.ejemplo15;

public class Main {
    public static void main(String[] args) {
        // El objeto Contador se crea FUERA del bucle
        // Este objeto se comparte para todos los hilos
        Contador c = new Contador();

        // Lanzamos 5 hilos contador
        // Todos los hilos comparten recursos
        for(int i = 1; i <= 5; i++){
            Thread t = new Thread(c);
            t.setName("Hilo " + i);
            t.start();
        }
    }
}

/*
DOCUMENTACION
-------------

En este ejemplo estamos compartiendo memoria y compartiendo recursos entre los hilos. El bucle for crea 5 hilos distintos,
pero SOLO SE CREA UN UNICO OBJETO CONTADOR, que se pasa por parametros a los 5 hilos. Asi, se comparte la memoria.

En este caso el objeto Contador cuenta hasta el 500, porque cada hilo aumenta en 1 hasta 100 el valor de la variable.
El diagrama es el siguiente:

Hilo 1
Hilo 2      ---> Contador 0
Hilo 3

Es tan fácil como extraer el objeto Contador fuera del bucle y pasarlo por parametros a todos los hilos.

La parte negativa es que los resultados que obtenemos no son los esperados siempre. Se pueden producir PROBLEMAS DE CONCURRENCIA,
O TAMBIEN LLAMADOS CONDICION DE CARRERA.

CONDICION DE CARRERA significa que LOS RESULTADOS QUE RECOGEMOS DEPENDEN DEL ORDEN EN EL QUE DISPONEMOS SU SECUENCIA DE CODIGO FUENTE.

 */

