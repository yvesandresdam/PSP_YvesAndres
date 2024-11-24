package pconcurrente.ejemplo13;

public class Main {

    public static void main(String[] args) {

        // Lanzamos el hilo
        Cafetera c = new Cafetera();
        Thread t = new Thread(c);
        t.start();
    }
}
