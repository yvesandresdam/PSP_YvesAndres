package ejemplo9;

public class Main {
    public static void main(String[] args) {

        // Lanzamos un hilo con una expresion Lambda
        Thread t = new Thread(()->{
            try{
                for(int i = 0; i < 5; i++){
                    Thread.sleep(1000);
                    System.out.println("¡Hola! ¡Soy un hilo!");
                }
            }catch (InterruptedException ie){
                System.out.println("Hilo interrumpido");
            }
        });
        t.start();


        // Mostramos la información del hilo
        // getId devuelve el identificador del hilo. No podemos cambiarlo
        System.out.println("ID: " + t.getId());

        // getName devuelve un String con el nombre del hilo
        // podemos cambiarlo con setName();
        System.out.println("Nombre: " + t.getName());
        t.setName("nuevo nombre");

        // getPriority() devuelve la prioridad del hilo.
        // 1 es la prioridad menor y 10 es la mayor.
        // Existen constantes que cambian esta prioridad.
        System.out.println("Prioridad: " + t.getPriority());
        t.setPriority(Thread.MAX_PRIORITY);
        t.setPriority(Thread.NORM_PRIORITY);
        t.setPriority(Thread.MIN_PRIORITY);

        // Devuelve un enumerado con el estado actual del hilo.
        System.out.println("Estado: " + t.getState());

        // Devuelve un booleano si el hilo se está ejecutando o por el contrario ha finalizado.
        System.out.println("Está vivo: " + t.isAlive());
    }
}


/*
DOCUMENTACION
-------------

Metodos de la clase Thread que muestran información sobre el hilo.

getId:
Identificador o numero positivo que se genera en el momento de crear un hilo.
No podemos cambiar el identificador.

getName:
El nombre que recibe un hilo.
Podemos cambiarlo con la funcion setName();

getPriority:
Devuelve la prioridad del hilo. Es un numero que va de 1 a 10, siendo 1 la prioridad mínima.
Tambien existe setPriority(integer);
Por defecto la prioridad es 5. Podemos utilizar valores CONSTANTES para modificar este valor al MAXIMO o MINIMO.

getState:
Devuelve un tipo enumerado, con distintos estado posibles del hilo
NEW: El hilo aun no ha sido iniciado. El hilo esta creado, pero no se ha ejecutado t.start().
RUNNABLE: Su estado es ejecutandose.
BLOCKED: El hilo esta tratando de acceder a un recurso ocupado.
WAITING: El hilo está en una espera indefinida, hasta que se ejecuta un evento. Por ejemplo, cuando el hilo llama a un t.join().
TIME_WAITING: El hilo permanece en espera, durante un tiempo DETERMINADO. Cuando termine el tiempo, continua su ejecucion. Por ejemplo t.sleep(2000).
TERMINATED: El hilo ha terminado todas sus instrucciones.

isAlive:
Devuelve un booleano si el hilo ha terminado su ejecución o no.

 */
