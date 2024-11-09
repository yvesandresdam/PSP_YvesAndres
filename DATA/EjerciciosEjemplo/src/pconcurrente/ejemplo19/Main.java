package pconcurrente.ejemplo19;

public class Main {

	public static void main(String[] args) {

		// Creamos una única cuenta cuyo saldo inicial será de €.
		Cuenta c = new Cuenta();
		
		// HiloIngreso realizara tareas de ingreso()
		// HiloReintegro realizara tareas de reintegro()
		// Las dos funciones son secciones criticas de la clase
		HiloIngreso hi = new HiloIngreso(c);
		HiloReintegro hr = new HiloReintegro(c);
		
		Thread ti = new Thread(hi);
		Thread tr = new Thread(hr);
		
		// Lanzamos los hilos
		ti.start();
		tr.start();
		
		try {
			// Esperamos a que los dos hilos finalicen
			ti.join();
			tr.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Saldo final: " + c.getSaldo());
	}
}

/*
DOCUMENTACIÓN
-------------

TEORIA DE MONITORES:
Para solucionar los problemas de concurrencia y las condiciones de carrera, existen los llamados 'MECANISMOS DE EXCLUSION MUTUA' que consisten
en evitar que varios metodos accedan, en el mismo momento, a la misma seccion critica. Los monitores son unos de estos mecanismos de exclusion.

MONITORES, son estructuas propias de JAVA que impiden que se usen varios procesos para un unico bloque de código. El monitor actua de policia
de la seccion critica, no dando la llave del proceso hasta que no se libera.

En JAVA, TODOS LOS OBJETOS PUEDEN SER MONITORES. Esto se debe a que las funcionalidades de los monitores están implementados en la clase Object.

SALAS DE EJECUCION DEL MONITOR:
Existen tres salas a la hora de utilizar un objeto monitor.
ENTRY SET: Es donde los procesos que quieren obtener el monitor hacen cola para entrar.
OWNER: Indica que proceso es el que tiene el monitor de la seccion critica y por tanto puede ejecutar el código
WAIT SET: Zona de espera del monitor.

Cuando HiloReintegro ejecuta el metodo reintegro(), se dice que HiloReintegro POSEE el monitor de objeto cuenta.
Hasta que no se libera el objeto protegido, no se da paso al proceso del entry set. Es en el momento en el que HiloReintegro ha terminado
de ejecutar la seccion critica de reintegrar, cuando libera el monitor. La llave del monitor se le da entonces al proceso que estaba esperando
en la Entry Set, y entonces es HiloIngreso quien tiene el monitor y puede entonces ejectura la funcion ingresar().

En este ejemplo en particular, el monitor se resuelve de la manera mas sencilla que podemos encontrar.

Consiste en añadir la palabra reservada 'synchronized' EN LOS METODOS QUE CONFORMAN LA SECCION CRITICA DE LA CLASE.
EL SIGNIFICADO DE SYNCHRONIZED ES EL SIGUIENTE: CUANDO SE EJECUTE UN METODO QUE TIENE ESTA FIRMA, SERA IMPOSIBLE
EJECUTAR OTRO METODO QUE TAMBIEN SEA SYNCHRONIZED. ESTO SE APLICA A LOS METODOS DE UNA MISMA CLASE.

*/
