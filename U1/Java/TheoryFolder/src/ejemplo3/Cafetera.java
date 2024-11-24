package ejemplo3;

public class Cafetera extends Thread {
    @Override
    public void run() {
        try {
            System.out.println("El cafe esta en el bote");
            Thread.sleep(2000);
            System.out.println("El cafe esta en la cafetera");
            Thread.sleep(2000);
            System.out.println("El cafe esta en la taza");
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println("El hilo se ha interumpido");
        }
    }
}
