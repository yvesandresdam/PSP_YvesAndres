package Exercise1_Solution0;
import java.util.Scanner;

public class Main {

    // EJERCICIO 1
    // Conceptos basicos sobre la clase 'Thread'

    public static int number1;
    public static int number2;

    public static void main(String[] args)
    {
        getNumbers();
        countingNumbers(number1, number2);
    }

    public static void getNumbers(){
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

    public static void countingNumbers(int number1, int number2){
        boolean number1IsMajor = isMajor(number1, number2);
        while(number1 != number2){
            try{
                if(number1IsMajor)
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

    private static boolean isMajor(int number1,int number2){
        return number1 > number2;
    }
}

/*
    Documentacion
    -------------

    ATRIBUTOS
    + number1: int
    una variable de tipo entero llamado 'number1'
    + number2: int
    una variable de tipo entero llamado 'number2'

    FUNCIONES
    + _static_ getNumbers(): void
    La función le pide al usuario que introduzca dos numeros en la linea de consola.

    + _static_ countingNumbers(int,int): void
    La funcion cuenta numeros desde el primer parametro entero hasta el segundo.
    Ademas de esto, realiza una pausa entre cada numero de 1 segundo.

    - _static_ isMajor(int,int): Boolean
    La funcion devuelve verdadero si el primer numero es mayor que el segundo y viceversa.


    Enunciado
    -------------

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