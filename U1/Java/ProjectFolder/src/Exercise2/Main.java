package Exercise2;

public class Main {
    public static void main(String[] args) {

        System.out.println("Ejercicio 2 - PSP");
        System.out.println("DAM - Yves Andres Elianor");

        App application = new App();
        application.launch();
    }
}

/*
    ENUNCIADO
    -----------

    Realiza un programa que pida al usuario un número n. El programa lanzará n hilos, el primero se
    llamará “Hilo 1”, el siguiente “Hilo 2” y así sucesivamente. Cada hilo generará un número
    aleatorio entre 1 y 100 y mostrará los números primos que existan entre 1 y el número elegido
    aleatoriamente. Junto con el número primo,se debe mostrar el nombre del hilo. Se realizará una
    pausa aleatoria entre 500 y 1000 milisegundos tras mostrar cada número. Para crear los hilos
    utiliza una clase que implemente la interfaz Runnable.
    Ejemplo de ejecución:
    Introduce el número de hilos a crear: 2
    Hilo 1: Mostrando primos hasta el 45
    Hilo 2: Mostrando primos hasta el 72
    Hilo 1: 2
    Hilo 2: 2
    Hilo 2: 3
    Hilo 1: 3
    Hilo 2: 5
    Hilo 1: 5
    Hilo 2: 7
 */