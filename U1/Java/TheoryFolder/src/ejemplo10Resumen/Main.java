package ejemplo10Resumen;

public class Main {
    public static void main(String[] args) {
        System.out.println("Resumen de datos de un hilo");
        Thread hilo = new Thread(() -> {
            try {
                Thread.sleep(10000);
                System.out.println("Han pasado 10 segundos");
            } catch (InterruptedException e) {
                System.out.println("Error");
            }
        });
        hilo.start();

        // ID del hilo
        long ID = hilo.getId();
        System.out.println("Id del Hilo: " + ID);
        System.out.println();

        //NOMBRE del hilo
        String Name = hilo.getName();
        System.out.println("Nombre del Hilo: " + Name);
        hilo.setName("HiloRenombrado");
        Name = hilo.getName();
        System.out.println("Nombre del Hilo: " + Name);
        System.out.println();

        // PRIORIDAD del hilo
        int Priority = hilo.getPriority();
        System.out.println("Prioridad del Hilo: " + Priority);
        hilo.setPriority(Thread.MAX_PRIORITY);
        Priority = hilo.getPriority();
        System.out.println("Prioridad del Hilo: " + Priority);
        System.out.println();

        // ESTADO del hilo
        Thread.State State = hilo.getState();
        System.out.println("Estado del hilo: " + State);
        System.out.println();

        boolean Alive = hilo.isAlive();
        System.out.println("Esta el hilo vivo: " + Alive);
        System.out.println();
    }
}
