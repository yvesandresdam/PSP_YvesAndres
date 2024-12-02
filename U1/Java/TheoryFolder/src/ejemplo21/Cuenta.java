package ejemplo21;

public class Cuenta {

    private double saldo = 0;

    public double getSaldo() {
        return saldo;
    }

    // Funcion para realizar ingresos
    public void ingresar(double cantidad) {
        saldo += cantidad;
    }

    // Funcion para realizar reintegros
    public void reintegrar (double cantidad) {
        saldo -= cantidad;
    }

}
