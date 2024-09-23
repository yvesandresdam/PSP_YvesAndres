import java.util.Scanner;

public class UI {

    public static int getUserInputText(){
        System.out.println("Introduce el numero de hilos: ");
        Scanner textInput = new Scanner(System.in);
        return textInput.nextInt();
    }
}
