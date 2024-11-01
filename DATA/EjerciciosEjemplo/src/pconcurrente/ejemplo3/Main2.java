package pconcurrente.ejemplo3;

public class Main2 {
    public static void main(String[] args) {

        // Preparamos las tostadas
        try{
            PrepararTostadas();
        } catch(InterruptedException ie){
            System.out.println("Hilo interrumpido");
        }

        // Preparamos el café, la ejecución se realizará en un nuevo hilo pero no comenzará hasta que las tostadas no hayan finalizado
        Cafetera c = new Cafetera();
        c.start();

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

Debido a que la primera función del hilo principal es PrepararTostadas, que presenta unos
Thread.sleep de 2 segundos, la función preparar cafe no comienza hasta que termina la tarea anterior.


 */
