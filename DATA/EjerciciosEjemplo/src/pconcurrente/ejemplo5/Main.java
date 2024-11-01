package pconcurrente.ejemplo5;

public class Main {
    public static void main(String[] args) {

        // Preparamos el café, la ejecución se realizará en un nuevo hilo
        Runnable r = new Runnable(){
            @Override
            public void run() {
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
            }
        };
        Thread t = new Thread(r);
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

Podemos crear un hilo secundario mediante el uso de CLASES ANONIMAS.

Estas son clases que no necesitan de un fichero adjunto para funcionar, se crean desde el mismo código.

LAS CLASES ANONIMAS solo se pueden crear de Clases que HEREDAN DE OTRA o que IMPLEMENTAN UNA INTERFAZ.
La sintaxis es la siguiente: Runnable r = new Runnable(){ // CODIGO A EJECUTAR }

Desde una clase anónima puedo acceder pero no modificar VARIABLES LOCALES.

 */
