package ejemplo17;

public class Main {
    // Extramos la variable contador
    // Asi se convierte en un recurso compartido
    public static int contador = 0;

    public static void main(String[] args) {
        // Lanzamos 5 hilos contador
        // Todos usan la misma variable contador
        for(int i = 1; i <= 5; i++){
            Thread t = new Thread(() ->{
                for(int j = 0; j < 100; j++){
                    contador++;
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
DOCUMENTACION
-------------

Y aqui como comprobar que si sacamos la variable contador, en forma de atributo estatico de clase,
podemos compartir el recurso dentro de la funcion LAMBDA que crea los 5 hilos distintos, usando la misma variable.
Aqui tenemos un ejemplo de RECURSO COMPARTIDO O MEMORIA COMPARTIDA.

*/

