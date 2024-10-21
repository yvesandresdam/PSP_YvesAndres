public class Main {
    public static void main(String[] args) {
        System.out.println("Programacion Servicios y Procesos");
        System.out.println("Practica 1 - Carrera de relevos");

        // Creacion de cada carril
        Lane lane1 = new Lane(1);
        Lane lane2 = new Lane(2);
        Lane lane3 = new Lane(3);
        Lane lane4 = new Lane(4);

        Thread hiloCarril1 = new Thread (() -> {
            lane1.startHiloCorredor();
        });
        hiloCarril1.start();

//        Thread hiloCarril2 = new Thread (() -> {
//            lane2.startHiloCorredor();
//        });
//        Thread hiloCarril3 = new Thread (() -> {
//            lane3.startHiloCorredor();
//        });
//        Thread hiloCarril4 = new Thread (() -> {
//            lane4.startHiloCorredor();
//        });
    }
}
