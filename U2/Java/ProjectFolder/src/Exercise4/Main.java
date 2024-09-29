package Exercise4;

public class Main {
    public static void main(String[] args){
        System.out.println("Ejercicio 4");
        System.out.println("Practica de hilos");

        Application app = new Application();
        app.launch();
    }
}


/*

    DOCUMENTACION
    -------------

    En este ejercicio vamos a desarrollar un pequeño juego en el que trataremos de detener
    un contador en el momento exacto. El programa principal elegirá un número aleatorio
    entre 10 y 20. Luego lanzará un hilo que irá contando números, empezando por el uno, y
    dejando una espera de un segundo entre cada número. El hilo mostrará por pantalla los
    números hasta el 5 inclusive, pero luego dejará de mostrarlos. El programa principal pedirá
    al usuario que pulse la tecla enter cuando quiera detener el contador. El objetivo es que el
    jugador lo detenga cuando llegue al número elegido aleatoriamente.
    Para resolver este ejercicio, crea una clase que implemente la interfaz Runnable. Utiliza un
    flag para detener el hilo.
 */
