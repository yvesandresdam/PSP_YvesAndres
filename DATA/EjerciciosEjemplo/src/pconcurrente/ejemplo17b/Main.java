package pconcurrente.ejemplo17b;

public class Main {
    public static void main(String[] args) {
        int contador = 0;
        // Lanzamos 5 hilos contador
        for(int i = 1; i <= 5; i++){
            Thread t = new Thread(() ->{
                for(int j = 0; j < 100; j++){
                // contador++;
                // La modificación de la variable local desde el interior de la expresión lambda produce un error
                }
                System.out.println(
                "Finalizado el hilo " + Thread.currentThread().getName() +
                ". El valor del contador es " + contador);
            });
            t.start();
        }
    }
}

/*
DOCUMENTACIÓN
----------------------

En estos ejemplos se muestra que desde el interior de las funciones lambda o clases anónimas no podemos acceder a las variables locales. La solución es extraerla como atributo de clase o fuera del bucle de creación de hilos.

 */

