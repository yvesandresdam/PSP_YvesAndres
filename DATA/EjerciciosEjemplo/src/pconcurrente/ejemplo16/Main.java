package pconcurrente.ejemplo16;

public class Main {
    public static void main(String[] args) {
        // Lanzamos 5 hilos contador
        for(int i = 1; i <= 5; i++){
            Thread t = new Thread(() ->{
                int contador = 0;
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

Vamos a crear el ejercicio identico al anterior, mediante el uso de FUNCIONES LAMBDA.
Igual estamos creando 5 hilos distintos con un bucle for y en cada uno de ellos incrementamos en uno su variable contador.
Como los recursos NO ESTAN COMPARTIDOS, la variable llegara a 100 y dispondra un mensaje en cada uno de los hilos.
 */
