package ejemplo20b;

public class Main {

    public static void main(String[] args) {

        //
        Cuenta c = new Cuenta();
        Perro p = new Perro();
        Object o = new Object();


        HiloIngreso hi = new HiloIngreso(c, o, p);
        HiloReintegro hr = new HiloReintegro(c, o, p);

        Thread ti = new Thread(hi);
        Thread tr = new Thread(hr);

        // Lanzamos los hilos
        ti.start();
        tr.start();

        try {
            // Esperamos a que los dos hilos finalicen
            ti.join();
            tr.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Saldo final: " + c.getSaldo());
    }
}

class Perro {

}

