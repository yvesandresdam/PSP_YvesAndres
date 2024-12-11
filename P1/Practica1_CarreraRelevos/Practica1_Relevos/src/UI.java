public class UI {
    public static void raceStart(int idLane) {
        System.out.println("La pista " + idLane + " ha empezado la carrera");
    }

    public static void raceEnd(int idLane) {
        System.out.println("La pista " + idLane + " ha terminado la carrera");
    }

    public static void runnerStart(int idLane, int idRunner) {
        System.out.println("Pista: " + idLane + " ■ " + "Corredor: " + idRunner + " tengo el testigo y empiezo a correr");
    }

    public static void runnerEnd(int idLane, int idRunner) {
        System.out.println("Pista: " + idLane + " ■ " + "Corredor: " + idRunner + " pierdo el testigo");
    }

    public static void turnOverTestigo(int idLane, int runner) {
        System.out.println("Pista: " + idLane + " ■ > " + "Corredor " + runner + " pasa el testigo");
    }

    public static void lanePodium(int idLane, int podiumPosition) {
        System.out.println("PODIUM: posicion " + podiumPosition + "º" + " para la pista " + idLane);
    }
}
