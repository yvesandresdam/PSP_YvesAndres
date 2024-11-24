package ejemplo4;

public class Main {

    public static void main(String[] args) {
        // Preparamos el café, la ejecución se realizará en un nuevo hilo
        // El objeto 'cafetera' es de la clase 'Cafetera' que implementa 'Runable'
        Cafetera cafetera = new Cafetera();
        Thread t = new Thread(cafetera);
        t.start();

        // Mientras tanto preparamos las tostadas
        try{
            PrepararTostadas();
        } catch(InterruptedException ie){
            System.out.println("Hilo interrumpido");
        }
    }

    public static void PrepararTostadas() throws InterruptedException {
        System.out.println("Tostadas: Comenzamos a preparar las tostadas");
        System.out.println("Tostadas: Ponemos el pan a tostar");
        Thread.sleep(2000);
        System.out.println("Tostadas: Echamos aceite");
        Thread.sleep(2000);
        System.out.println("Tostadas: Echamos sal");
        Thread.sleep(2000);
        System.out.println("Tostadas: Tostadas finalizadas");
    }
}


    /*

    DOCUMENTACION
    -------------

    En este ejemplo, creamos un hilo secundario mediante la un objeto que implementa la interfaz 'Runnable'

    El objeto que le pasamos por parámetros a la creación de un objeto 'Thread' DEBE SER OBLIGATORIAMENTE un objeto runnable.

    Una interfaz deja la firma de las funciones, pero no las define. Es tarea de las clases que la implementan, las que deben definir dichas funciones.

    La interfaz 'Runnable' SOLO TIENE UN METODO, el metodo 'run()'.

    Para crear un hilo podemos extender la clase Thread, o implementar la interfaz 'Runnable'. Creamos un
    hilo con Thread t = new Thread() o Thread t = new Thread(runnable).

    el funcionamiento de la creacion de hilos, se basa en ejecutar secuencialmente las tareas de cada hilo
    y cuando se produce un hilo.start() se crea otro hilo de forma paralela al primero.

     */
