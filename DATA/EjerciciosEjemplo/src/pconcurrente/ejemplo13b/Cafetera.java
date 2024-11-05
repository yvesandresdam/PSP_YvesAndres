package pconcurrente.ejemplo13b;

public class Cafetera implements Runnable {

    // Condiciones bandera o flag
    private int contador = 0;
    private boolean ejecutar = true;

    @Override
    public void run() {
        while(ejecutar){
            try{
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
            }catch (InterruptedException ie){
                System.out.println("Hilo interrumpido");
            }
        }
    }

    // Metodo bandera
    public void Detener(){
        ejecutar = false;
    }

    // Getter contador
    public int getContador() {
        return contador;
    }
}

/*
DOCUMENTACION
-------------

Aqui detenemos el hilo usando flags o condiciones banderas, que no es mas que un booleano dentro
de la expresion while(). Si este booleano es 'true' se realiza el bucle, en cambio si el booleano
se cambia a 'false', mediante el uso de una funcion bandera detener(), el bucle while finaliza su proceso.
Antes de finalizar, realiza todo el contenido de su cuerpo, lo que significa que no termina instantaneamente.
Es por ello que se hace imprescindible utilizar un metodo join(), para esperar a que el bucle while y con ello el proceso
del hilo termine por completo, ya que podriamos adelantar los procesos en una forma desordenada.

*/

