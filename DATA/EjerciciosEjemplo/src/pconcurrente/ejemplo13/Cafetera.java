package pconcurrente.ejemplo13;

public class Cafetera implements Runnable {

    private int contador = 0;
    public int getContador() {
        return contador;
    }

    @Override
    public void run() {
        try{
            while(true){
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
        }catch (InterruptedException ie){
            System.out.println("Hilo interrumpido");
        }
    }
}

/*
DOCUMENTACION
-------------

En este ejemplo queremos ejecutar el proceso de preparar un cafe mientras el bucle sea verdadero,
lo cual ocurre siempre, debido a su condicion 'true'

*/
