package ejemplo5;

public class Main2 {
    public static void main(String[] args) {

        // En el ejercicio anterior la linea de codigo era la siguiente
        // Runnable runnable = new Runnable(){ // Codigo };
        // Thread t = new Thread(runnable);

        Thread t = new Thread(new Runnable(){
            @Override
            public void run() {
                try{
                    System.out.println("Café: Comenzamos a preparar el café");
                    System.out.println("Café: Ponemos la cafetera");
                    Thread.sleep(2000);
                    System.out.println("Café: Servimos el café en la taza");
                    Thread.sleep(2000);
                    System.out.println("Café: Echamos la leche");
                    Thread.sleep(2000);
                    System.out.println("Café: Café finalizado");
                }catch (InterruptedException ie){
                    System.out.println("Hilo interrumpido");
                }
            }
        });
        t.start();

        try{
            PrepararTostadas();
        } catch(InterruptedException ie){
            System.out.println("Hilo interrumpido");
        }
    }

    public static void PrepararTostadas() throws InterruptedException {
        System.out.println("Tostadas: Comenzamos a preparar las tostadas");
        System.out.println("Tostadas: Ponemos el pan a tostar");
        Thread.sleep(2000);
        System.out.println("Tostadas: Echamos aceite");
        Thread.sleep(2000);
        System.out.println("Tostadas: Echamos sal");
        Thread.sleep(2000);
        System.out.println("Tostadas: Tostadas finalizadas");
    }
}


