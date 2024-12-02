package ejemplo18;

public class Main {

    public static void main(String[] args) {

        // Creamos una única cuenta cuyo saldo inicial será de 0€.
        Cuenta c = new Cuenta();

		/*
		   Creamos dos hilos, uno que se encargará de
		   realizar los ingresos y otro que se encargará
		   de realizar los reintegros.
		 */

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

		/*
		    Una vez finalizan mostramos el saldo final. En este
		    caso no hemos implementado la sincronización entre hilos.
		    El resultado debería ser 0€, sin embargo, debido a las condiciones de carrera
		    con cada ejecución se obtendrá un resultado diferente.
		*/
        System.out.println("Saldo final: " + c.getSaldo());
    }
}


/*
DOCUMENTACIÓN
-------------

En el momento en que se comparten variables, pueden producirse resultados inesperados llamados CONDICIONES DE CARRERA.
CONDICIONES DE CARRERA SE PRODUCEN CUANDO EL RESULTADO DE LA EJECUCIÓN DE UN CÓDIGO FUENTE, DEPENDE DEL ORDEN EN EL QUE DISPONEMOS SUS ELEMENTOS.
ES DECIR QUE LOS RESULTADOS CAMBIAN SEGUN EL ORDEN DEL CODIGO.

Estas se producen cuando desde distintos lugares del código se accede a los RECURSOS COMPARTIDOS.

Una SECCION CRITICA son aquellas partes del código EN EL QUE ACCEDEMOS Y MODIFICAMOS LAS VARIABLES DE LOS RECURSOS COMPARTIDOS.

En este ejemplo, la clase HILOINGRESO e HILO REINTEGRO llaman a funciones distintas de CUENTA, las funciones son distintas
y por tanto no son secciones criticas. Sin embargo, dentro de la clase CUENTA, el metodo REINTEGRAR E INGRESAR MODIFICAN LA MISMA VARIABLE,
LA VARIABLE QUE ESTA COMPARTIDA POR LOS OBJETOS DE DOS CLASES DISTINTAS, ESTA VARIABLE ES SALDO,
LUEGO LOS METODOS REINTEGRAR E INGRESAR DE LA CLASE CUENTA CONFORMAN LA SECCION CRITICA DE LOS RECURSOS COMPARTIDOS.

Es importante localizar las secciones críticas, ya que será sobre estas partes donde tomaremos medidas para evitar las condiciones de carrera.

 */

