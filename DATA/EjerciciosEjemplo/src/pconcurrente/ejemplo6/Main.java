package pconcurrente.ejemplo6;

public class Main {
    public static int contador = 1;
    public static void main(String[] args) {
        String texto = "elefante(s) se balanceaban ...";
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                while(contador <= 5){
                    System.out.println(contador + " " + texto);
                    IncrementaContador();
                }
            }
        });
        t.start();
    }
    public static void IncrementaContador(){
        contador++;
    }
}

/*
DOCUMENTACION
-------------
Desde una clase anónima puedo acceder y recuperar el valor de UNA VARIABLE LOCAL, pero no puedo MODIFICAR SU VALOR.

La variable 'texto' se puede leer pero no modificar desde dentro de la funcion run();


 */
