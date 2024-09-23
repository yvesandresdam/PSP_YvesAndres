package Exercice1_Solution2;

import java.util.Scanner;

public class Main {

    //EJERCICIO 1
    //USANDO UNA CLASE QUE IMPLEMENTE LA INTERFAZ RUNNABLE

    //SINTAXIS
    //public class Numbers implements Runnable{}

    public static void main(String[] args){

        Numbers app = new Numbers();
        app.UINumberSelector();

        Thread hiloAlternative = new Thread(app);
        hiloAlternative.start();
    }
}
