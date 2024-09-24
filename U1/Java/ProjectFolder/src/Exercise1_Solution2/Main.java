package Exercise1_Solution2;

public class Main {

    // EJERCICIO 1
    // SOLUCION 2
    // USANDO UNA CLASE QUE IMPLEMENTE LA INTERFAZ RUNNABLE

    //SINTAXIS
    //public class Numbers implements Runnable{}

    public static void main(String[] args){

        // La clase 'Numbers' implementa la interfaz Runnable
        Numbers countingApp = new Numbers();
        countingApp.StartApp();

        // La clase Thread, requiere por parametros de una instancia 'Runnable'
        Thread hiloAlternative = new Thread(countingApp);
        hiloAlternative.start();
    }
}
