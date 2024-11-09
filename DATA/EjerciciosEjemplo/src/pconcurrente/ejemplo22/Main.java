package pconcurrente.ejemplo22;

public class Main {
    public static void main(String[] args) {

        // Creamos dos hilos que realizan procesos distintos sobre la misma seccion critica.
        // Los dos procesos reciben por parametros el mismo objeto taza.
        // Este objeto se convertirá en el monitor de sus procesos compartidos.
        Taza taza = new Taza();
        Thread t1 = new Thread(new PrepararCafe(taza));
        Thread t2 = new Thread(new PrepararLeche(taza));

        // Lanzamos los hilos
        t1.start();
        t2.start();

        // El hilo principal esperará a que finalicen sus procesos
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            System.out.println("Se ha interrumpido el hilo");
        }
        System.out.println("La taza contiene " + taza.getIngredientes());
    }
}
