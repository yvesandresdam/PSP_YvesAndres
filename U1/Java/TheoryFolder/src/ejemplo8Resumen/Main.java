package ejemplo8Resumen;

public class Main {
    public static void main(String[] args) {

        // Creacion de hilos
        // Clase que HEREDA
        System.out.println("Ejemplo de clase que hereda");
        CafeteraHereda cafeteraHereda = new CafeteraHereda();
        cafeteraHereda.start();
        try {
            cafeteraHereda.join();
        } catch (InterruptedException e) {
            System.out.println("Error");
        }


        // Clase que implementa INTERFAZ
        System.out.println("Ejemplo de clase que implementa");
        CafeteraInterfaz cafeteraInterfaz = new CafeteraInterfaz();
        Thread interfaz = new Thread(cafeteraInterfaz);
        interfaz.start();
        try {
            interfaz.join();
        } catch (InterruptedException e) {
            System.out.println("Error");
        }

        // Clase Anonima
        System.out.println("Ejemplo de clase anonima");
        Runnable anonimaRunnable = new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < 6; i++) {
                        Thread.sleep(1000);
                        System.out.println("Ha pasado " + i + " segundos");
                    }
                    System.out.println("Han pasado 5 segundos en total");
                } catch (InterruptedException e) {
                    System.out.println("Hilo interrumpido");
                }
            }
        };
        Thread anonima = new Thread(anonimaRunnable);
        anonima.start();
        try {
            anonima.join();
        } catch (InterruptedException e) {
            System.out.println("Error");
        }

        System.out.println("Ejemplo de clase anonima alternativa");
        Thread anonimaAlt = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < 6; i++) {
                        Thread.sleep(1000);
                        System.out.println("Ha pasado " + i + " segundos");
                    }
                    System.out.println("Han pasado 5 segundos en total");
                } catch (InterruptedException e) {
                    System.out.println("Hilo interrumpido");
                }
            }
        });
        anonimaAlt.start();
        try {
            anonimaAlt.join();
        } catch (InterruptedException e) {
            System.out.println("Error");
        }

        // Ejemplo de funcion Lambda
        System.out.println("Ejemplo de funcion Lambda");
        Thread lambda = new Thread(() -> {
            try {
                for (int i = 0; i < 6; i++) {
                    Thread.sleep(1000);
                    System.out.println("Ha pasado " + i + " segundos");
                }
                System.out.println("Han pasado 5 segundos en total");
            } catch (InterruptedException e) {
                System.out.println("Hilo interrumpido");
            }
        });
        lambda.start();
        try {
            lambda.join();
        } catch (InterruptedException e) {
            System.out.println("Error");
        }
    }
}

class CafeteraHereda extends Thread {
    @Override
    public void run() {
        try {
            for (int i = 0; i < 6; i++) {
                Thread.sleep(1000);
                System.out.println("Ha pasado " + i + " segundos");
            }
            System.out.println("Han pasado 5 segundos en total");
        } catch (InterruptedException e) {
            System.out.println("Hilo interrumpido");
        }
    }
}

class CafeteraInterfaz implements Runnable {
    @Override
    public void run() {
        try {
            for (int i = 0; i < 6; i++) {
                Thread.sleep(1000);
                System.out.println("Ha pasado " + i + " segundos");
            }
            System.out.println("Han pasado 5 segundos en total");
        } catch (InterruptedException e) {
            System.out.println("Hilo interrumpido");
        }
    }
}
