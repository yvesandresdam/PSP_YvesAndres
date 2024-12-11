public class Main {
    private static int podiumPosition = 0;

    public static void main(String[] args) {

        System.out.println("Programacion Servicios y Procesos");
        System.out.println("Practica Final 1 - Carrera de relevos");
        System.out.println();

        Thread hilosCarrera = new Thread(() -> {
            Object testigo1 = new Object();
            Lane l1 = new Lane(1, testigo1, podiumPosition);
            Thread t1 = new Thread(l1);

            Object testigo2 = new Object();
            Lane l2 = new Lane(2, testigo2, podiumPosition);
            Thread t2 = new Thread(l2);

            Object testigo3 = new Object();
            Lane l3 = new Lane(3, testigo3, podiumPosition);
            Thread t3 = new Thread(l3);

            Object testigo4 = new Object();
            Lane l4 = new Lane(4, testigo4, podiumPosition);
            Thread t4 = new Thread(l4);

            t1.start();
            t2.start();
            t3.start();
            t4.start();

            try {
                t1.join();
                t2.join();
                t3.join();
                t4.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        hilosCarrera.start();
    }
}
