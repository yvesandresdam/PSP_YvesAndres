package ejemplo13;

public class Main {

    public static void main(String[] args) {

        // Lanzamos el hilo
        Cafetera c = new Cafetera();
        Thread t = new Thread(c);
        t.start();
    }
}

class Cafetera implements Runnable {
    @Override
    public void run() {
        try {
            int contador = 0;
            while (true) {
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
}

/*
DOCUMENTACION
-------------

En este ejemplo queremos ejecutar el proceso de preparar un cafe mientras el bucle sea verdadero,
lo cual ocurre siempre, debido a su condicion 'true'.

*/
