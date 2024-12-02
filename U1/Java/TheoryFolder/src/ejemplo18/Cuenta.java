package ejemplo18;

public class Cuenta {

    private double saldo = 0;

    public double getSaldo() {
        return saldo;
    }

    // Funcion para realizar ingresos
    public void ingresar(double cantidad) {
        saldo += cantidad;
    }

    // Metodo para realizar reintegros
    public void reintegrar (double cantidad) {
        saldo -= cantidad;
    }
}

/*
Los dos metodos modifican la misma variable. La variable compartida es 'cantidad'.
Cada funcion se convierte asi en una seccion critica.
 */
