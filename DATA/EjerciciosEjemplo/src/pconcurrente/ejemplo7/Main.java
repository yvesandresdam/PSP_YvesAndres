package pconcurrente.ejemplo7;

public class Main {
    public static void main(String[] args) {
        Thread t = new Thread(()->{
            try{
                System.out.println("Café: Comenzamos a preparar el café");
                System.out.println("Café: Ponemos la cafetera");
                Thread.sleep(2000);
                System.out.println("Café: Servimos el café en la taza");
                Thread.sleep(2000);
                System.out.println("Café: Echamos la leche");
                Thread.sleep(2000);
                System.out.println("Café: Café finalizado");
            }catch (InterruptedException ie){
                System.out.println("Hilo interrumpido");
            }
        });
        t.start();

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

Creamos Hilos utilizando expresiones Lambda.

En el caso concreto de Thread, es posible pasarle por parámetros una interfaz 'runnable' y es por ello
que podemos utilizar una expresion lambda.

La sintaxis es:

Thread hilo = new Thread (() -> { // Código }

No se añaden parametros en los parentesis porque la única funcion de runnable es 'run()', asi los parentesis estan vacios.
Luego viene flecha y luego entre llaves { } el codigo que hace funcionar run();

SOLO PODEMOS UTILIZAR LA EXPRESION LAMBDA, SI LA INTERFAZ SOLO TIENE UN METODO PARA IMPLEMENTAR.
EN EL CASO DE RUNNABLE, SOLO CONTIENE LA FUNCION RUN().

PODEMOS CREAR NUESTRA PROPIA EXPRESION LAMBDA, PERO SOLO DESDE UNA INTERFAZ DE UN UNICO CODIGO

Desde dentro de la expresion lambda PODEMOS LEER UNA VARIABLE LOCAL, PERO NO PODEMOS MODIFICARLA.

 */
