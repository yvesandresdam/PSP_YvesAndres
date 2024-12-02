package ejemplo13;

import java.util.Scanner;

public class Main3 {

    public static void main(String[] args) {

        // Lanzamos el hilo
        Cafetera3 c = new Cafetera3();
        Thread t = new Thread(c);
        t.start();

        // Cuando el usuario pulse enter detenemos el hilo
        System.out.println("Presiona intro para detener la cafetera");
        Scanner sc = new Scanner(System.in);
        sc.nextLine();

        // Metodo de Thread que realiza la interrupcion del hilo
        t.interrupt();

        // La finalización no es instantánea, así que esperamos a que realmente finalice
        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.printf("Total: %d cafés", c.getContador());
    }
}

class Cafetera3 implements Runnable {

    private int contador = 0;
    public int getContador() {
        return contador;
    }

    @Override
    public void run() {
        try{
            while(!Thread.currentThread().isInterrupted()){
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

Para detener un hilo podemos utilizar el metodo de la clase Thread t.interrupt();
Este metodo interrumpe el hilo en ese momento, pero espera para salir del bloque try, cuando una funcion lanza
la excepcion 'interruptedException', que es entonces cuando ejecuta el codigo del bloque catch y finaliza el hilo.
Como siempre debemos hacer un join() para esperar a que el hilo finalice.

Hasta que no encuentra un metodo que lanza la excepcion no finaliza su proceso, es decir, sin metodo que llame al catch se encontraria ejecutandose constantemente.

Podemos sustituir la condicion booleana de flag, por otra condición mas adecuada,
Thread.currentThread.IsInterrupted() que devuelve un booleano indicando si el hilo se ha interrumpido o no. Al igual que en ejercicios anteriores, hasta que
no se evalua la condicion del bucle o no lanza la excepcion, el funcionamiento del hilo no finaliza.

Podemos simplificar la condicion flag a la siguiente expresion
while(!Thread.currentThread.IsInterrupted())
{
// Codigo
}

Es importante que la condicion flag interrupted sea cierta para que se cumpla el bucle, esto se consigue con una puerta logica NOT,
mientras el hilo NO SE INTERRUMPA

Tambien es importante darse cuenta que el bucle WHILE, DEBE ESTAR DENTRO DEL BLOQUE TRY. Por ejemplo, si tenemos una condicion flag interrupted, y esta en modo true, es decir, interrumpida,
y un bloque catch realiza su gestion de la interrupcion, lanzando una excepcion, entonces dicha condicion flag pasa inmediatamente a estar a true, porque el hilo
YA NO ESTA INTERRUMPIDO, sino que ha sido gestionado. Asi el codigo del bloque catch si que se ejecuta, pero la condicion del bucle WHILE volveria a ser true,
haciendo que sea imposible detener el hilo.
Lo correcto es que el bucle WHILE este dentro del TRY

try{
    WHILE(Thread.currentThread.isInterrupted())
    {
        // codigo
    }
catch (InterruptedException e){
// codigo
}

 */


