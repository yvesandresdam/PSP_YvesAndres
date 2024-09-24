package Exercise1_Solution0;
import java.util.Scanner;

public class Main {

    // EJERCICIO 1


    public static int number1;
    public static int number2;

    public static void main(String[] args)
    {
        GetNumbers();
        CountingNumbers(number1, number2);
    }

    public static void GetNumbers(){
        // Crear un objeto Scanner para leer los datos ingresados por el usuario
        Scanner scanner = new Scanner(System.in);

        // Solicitar al usuario que ingrese el primer numero
        System.out.println("Por favor, introduce un número:");

        // Leer el número entero ingresado por el usuario
        int numero = scanner.nextInt();

        // Mostrar el número ingresado
        System.out.println("El número que ingresaste es: " + numero);
        number1 = numero;

        System.out.println("Por favor introduzca el segundo numero:");
        int numero2 = scanner.nextInt();
        System.out.println("El numero introducido es: " + numero2);
        number2 = numero2;

        // Cerrar el Scanner
        scanner.close();
    }

    public static void CountingNumbers(int number1, int number2){
        boolean Number1IsMajor = IsMajor(number1, number2);
        while(number1 != number2){
            try{
                if(number1 > number2)
                {
                    number2++;
                    System.out.println(number2);
                    Thread.sleep(1000);
                }
                else{
                    number1++;
                    System.out.println(number1);
                    Thread.sleep(1000);
                }
            }catch(InterruptedException ie){
                System.out.println("Hilo interrumpido");
            }

        }
    }

    public static boolean IsMajor(int number1,int number2){
        return number1 > number2;
    }
}

/*

    Ejercicio 1
    -----------

    Crea un programa que pida al usuario dos números n1 y n2, posteriormente lanzará un
    hilo que mostrará los números existentes entre n1 y n2. Haz que el hilo se suspenda de
    forma aleatoria entre 1 y 1000 milisegundos cada vez que muestre un número por
    pantalla. Una vez lanzado el hilo el programa principal mostrará el mensaje “El hilo se ha
    lanzado”. Resuelve este ejercicio de las siguientes formas: en primer lugar, creando una
    clase que implemente la interfaz Runnable, luego mediante una clase anónima y
    finalmente mediante el uso de expresiones lambda.

    Ejemplo de ejecución:
    Introduce n1: 2
    Introduce n2: 4
    El hilo se ha lanzado
    2
    3
    4

 */