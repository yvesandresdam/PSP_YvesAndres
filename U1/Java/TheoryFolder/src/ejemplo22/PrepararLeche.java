package ejemplo22;

// Esta es la clase DEPENDIENTE
// Funciona solo en caso que se cumpla una condicion con respecto a la clase PrepararCafe
public class PrepararLeche implements Runnable {

    private Taza taza;

    public PrepararLeche(Taza t) { taza = t;}

    @Override
    public void run() {
        try {
            System.out.println("Leche: Vertemos la leche en un cazo.");
            Thread.sleep((long)(Math.random()*3000));
            System.out.println("Leche: Ponemos el cazo al fuego.");
            Thread.sleep((long)(Math.random()*3000));
            System.out.println("Leche: Esperamos a que se caliente.");
            Thread.sleep((long)(Math.random()*3000));

            synchronized (taza){
                while(!taza.getHayCafe()){
                    System.out.println("Leche: Esperando el café ");
                    taza.wait();
                }
            }
            // En este bloque sincronizado, el objeto taza realiza una funcion de espera, en caso que
            // no se cumpla la condicion de que hay cafe en la taza.

            System.out.println("Leche: Servimos la leche en la taza.");
            taza.añadirIngrediente("con leche");

        } catch (InterruptedException e) {
            System.out.println("Error de interrupcion");
        }
    }
}

