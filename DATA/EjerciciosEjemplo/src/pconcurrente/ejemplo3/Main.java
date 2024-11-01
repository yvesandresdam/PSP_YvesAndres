package pconcurrente.ejemplo3;

public class Main {

    public static void main(String[] args) {

        // Preparamos el café, la ejecución se realizará en un nuevo hilo
        Cafetera c = new Cafetera();
        c.start();

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

Aquí tenemos un ejemplo de programación concurrente. En la linea c.start() se comienza la ejecución
de un nuevo hilo de compilación, que ejecuta órdenes de manera alterna con el 'main Thread'. Es la función
start() la que inicia un nuevo hilo.

Este nuevo hilo se puede crear de diferentes maneras, como se aprecia en la clase Cafetera. En este caso se utiliza
el metodo de HEREDAR DE LA CLASE THREAD.

La clase Cafetera hereda de la clase Thread con 'extends'. Entonces tenemos que sobreescribir su metodo 'run()'
con el código que queremos que se ejecute en otro hilo. Tambien hay que añadir la anotacion '@Override'.
Hay que añadir una secuencia try/catch dentro del código. No podemos realizarlo desde la firma, porque estamos
heredando.

 */
