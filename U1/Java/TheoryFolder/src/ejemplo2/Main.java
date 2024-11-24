package ejemplo2;

public class Main {
    public static void main(String[] args) {
        try{
            PrepararTostadas();
            PrepararCafe();
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
    public static void PrepararCafe() throws InterruptedException {
        System.out.println("Café: Comenzamos a preparar el café");
        System.out.println("Café: Ponemos la cafetera");
        Thread.sleep(2000);
        System.out.println("Café: Servimos el café en la taza");
        Thread.sleep(2000);
        System.out.println("Café: Echamos la leche");
        Thread.sleep(2000);
        System.out.println("Café: Café finalizado");
    }
}


    /*

    DOCUMENTACION
    -------------

    El Hilo principal es el unico hilo que no podemos eliminar del programa.
    También se llama 'Main Thread'.

    2000 ms = 2 segundos

    Existe una clase que contiene las instruccion sobre hilos y es estática.
    La clase 'Thread'. Al ser estática, los métodos se llaman directamente.

    El metodo Thread.sleep duerme o para el proceso de la ejecución de dicho hilo.

    Las clases que usan hilos lanzan una excepcion InterruptedException.
    Podemos ponerlo dentro del metodo con un bloque try/catch o desde la firma de la función

    En este ejemplo los métodos se ejecutan dentro del mismo hilo, luego se disponen secuencialmente.
    Si un metodo dura 6 segundos, la totalidad del programa es de 12 segundos.

     */
