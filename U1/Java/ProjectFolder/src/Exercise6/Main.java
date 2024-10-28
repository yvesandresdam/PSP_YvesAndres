package Exercise6;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Exercise 6");

        Log l = new Log();
        List<Thread> threads = new ArrayList<Thread>();

        for(int i = 1; i <= 5; i++){
            Thread t = new Thread(new Escritor(i, l));
            t.start();
            threads.add(t);
        }

        for(Thread t : threads){
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Hilos finalizados");
        l.cerrar();
    }
}

/*
    DOCUMENTATION
    -------------

    En este ejercicio se pide modificar el proyecto que encontraréis en el paquete ejercicio6, para
    que el log se escriba correctamente. Se pide realizar los mínimos cambios posibles y deberás
    utilizar alguno de los mecanismos de sincronización vistos hasta el momento.

 */
