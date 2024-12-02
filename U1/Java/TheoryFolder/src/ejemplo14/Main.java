package ejemplo14;

public class Main {
    public static void main(String[] args) {
        // Lanzamos 5 hilos contador
        for(int i = 1; i <= 5; i++){
            Contador c = new Contador();
            Thread t = new Thread(c);
            t.setName("Hilo " + i);
            t.start();
        }
    }
}

/*
DOCUMENTACION
-------------

En este ejemplo tenemos un programa que lanza 5 objetos de tipo Contador, para hacer funcionar 5 Hilos distintos.
El diagrama es el siguiente:
Hilo 1 --> Contador 0
Hilo 2 --> Contador 0
Hilo 3 --> Contador 0

Contador lo que hace es contar de 0 a 100, luego el resultado por consola son cinco lineas con el numero 100, que es el numero hasta el que finalmente cuenta.


Podemos COMPARTIR MEMORIA, compartir espacios en comun o compartir variables, de tal modo que en lugar de tener
cinco objetos de tipo contador, tengamos un UNICO OBJETO CONTADOR, COMPARTIDO por los 5 hilos. De esta manera la variable 'contador'
cuenta del 0 al 500, ya que cada hilo aumenta el contador en 1 durante 100 iteraciones, con resultado total de 500.

La forma de hacer esto es simplemente disponer la variable compartida fuera del bucle for, en la zona de atributos de Clase. Recuerda que las variables locales no son accesibles desde el interior de las clases anonimas / lambda
 */




