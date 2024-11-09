package pconcurrente.ejemplo19;

public class Cuenta {

	private double saldo = 0;

	public double getSaldo() {
		return saldo;
	}

	// Método para realizar ingresos
	public synchronized void ingresar(double cantidad) {
		saldo += cantidad;
	}

	// Método para realizar reintegros
	public synchronized void reintegrar (double cantidad) {
		saldo -= cantidad;
	}
}

/*
DOCUMENTACIÓN
-------------

METODO DE EXCLUSION MUTUA:
Hy que detectar cuales son las partes del código que forman las secciones críticas. En este caso, el metodo ingresar() y el metodo reintegrar() acceden
y modifican la misma variable saldo. Pero se ejecutan desde distintos procesos concurrentes, y por eso pueden dar condiciones de carrera, y por eso
se tratan de secciones criticas. Para resolver problemas de concurrencia en secciones críticas tenemos los monitores.

MONITORES
En este ejemplo, es la misma clase cuenta la que actua de monitor, impidiendo la posesion de la llave de los metodos
marcados como 'synchronized'. Mientras se este ejecutando uno de estos metodos, NO SE PERMITE LA EJECUCION DE OTRO METODO 'SYNCHRONIZED'.

De esta forma se controlan los acesos a las secciones criticas y asi no se producen problemas de concurrencia.
*/

