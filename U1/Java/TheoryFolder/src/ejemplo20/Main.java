package ejemplo20;

public class Main {

    public static void main(String[] args) {

        // Creamos una única cuenta cuyo saldo inicial será de €.
        // Este objeto c de Cuenta será utilizado como MONITOR.
        // ES IMPORTANTE PASAR EL MISMO OBJETO A TRAVES DE LOS CONSTRUCTORES
        // DE LOS HILOS.
        Cuenta c = new Cuenta();

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

MÉTODOS DE EXCLUSIÓN MUTUA
En caso que necesitemos dar solucion a condiciones de carrera y, por el motivo que sea, no podamos acceder a las secciones críticas
podemos usar otro tipo de Mecanismos de Exclusion Mutua.

MONITORES - BLOQUES SINCRONIZADOS
Son bloques de código que quedan protegidos por un objeto MONITOR. Este MONITOR posee la llave que PERMITE O NO PERMITE la ejecución
del bloque en cuestión sincronizado.

ES REALMENTE IMPORTANTE TENER EN CUENTA, QUE PARA QUE DOS BLOQUES SINCRONIZADOS SEAN PROTEGIDOS POR EL MISMO MONITOR, DEBEN ESTAR
SINCRONIZADOS CON EL MISMO MONITOR. Monitores distintos permiten acceso a distintas funciones.

Podemos ver en el Main, que se crea un UNICO OBJETO DE TIPO CUENTA, que se le pasa al constructor de los HILOS. ESTE OBJETO ES EL MONITOR
DE LOS METODOS SINCRONIZADOS reintegro() y ingreso().

ESTO SIGNIFICA QUE 'CUENTA' ES EL MONITOR DE LOS BLOQUES SINCRONIZADOS.

 */


