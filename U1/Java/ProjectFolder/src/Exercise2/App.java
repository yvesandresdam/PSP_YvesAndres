package Exercise2;

public class App {
    public void launch() {

        // Pregunta al usuario el numero de hilos
        int threadNumber = UI.getUserInputText();

        for (int i = 1; i <= threadNumber; i++) {
            Task task = new Task();
            task.startThread(i);
        }
    }
}
