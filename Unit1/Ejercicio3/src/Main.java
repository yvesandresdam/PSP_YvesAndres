public class Main {
    public static void main(String[] args) {

        System.out.println("Ejercicio 2 - PSP");
        System.out.println("DAM - Yves Andres Elianor");

        App application = new App();
        application.launch();
    }
}

/*
    Ejercicio 3
    -----------

    Modifica el programa anterior para que, tras lanzar los hilos, el programa principal muestre cada
    segundo el ID, nombre y estado de cada hilo, hasta que todos los hilos hayan finalizado.
    Ejemplo de ejecución:
    Introduce el número de hilos a crear: 2
    12 Hilo 1 RUNNABLE
    13 Hilo 2 BLOCKED
    Hilo 1: Mostrando primos hasta el 81
    Hilo 2: Mostrando primos hasta el 46
    Hilo 1: 2
    Hilo 2: 2
    Hilo 2: 3
    Hilo 1: 3
    12 Hilo 1 TIMED_WAITING
    13 Hilo 2 TIMED_WAITING
    Hilo 1: 5
    Hilo 2: 5
    12 Hilo 1 TIMED_WAITING
    13 Hilo 2 TIMED_WAITING
…
 */