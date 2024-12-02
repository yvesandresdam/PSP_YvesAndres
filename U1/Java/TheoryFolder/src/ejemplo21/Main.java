package ejemplo21;

public class Main {

    public static void main(String[] args) {

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

METODOS NOTIFY Y WAIT
Estos son mecanismos cuya finalidad es realizar ESPERAS QUE DETIENEN EL FUNCIONAMIENTO DE UN HILO
y NOTIFICAR DE QUE YA ES POSIBLE REANUDAR EL PROCESO DEL HILO EN ESPERA

Esto tambien se explica con las habitaciones y los monitores. Como los metodos NOTIFY y WAIT pertenecen a los monitores,
TODOS LOS OBJETOS PUEDEN USAR ESTOS METODOS. LA UNICA CONDICION PARA USARLOS ES QUE SE ENCUENTREN DENTRO DE UN BLOQUE SINCRONIZADO.
EN CASO QUE ESTEN FUERA, TENDREMOS UN ERROR EN TIEMPO DE EJECUCION.

Un hilo se encuentra en la ENTRY SET hasta que el MONITOR le da permiso para realizar su código de sección crítica. PASA AL OWNER DEL MONITOR. SI POR CUALQUIER
MOTIVO NO PUEDE REALIZAR SU PROCESO, podemos llamar a la función objeto.wait() Y ENTONCES PASA AL WAIT SET. EL HILO QUEDA SUSPENDIDO.

Se libera el MONITOR y otro hilo pasa a ser OWNER. Y entonces realiza su código hasta que se llama a la funcion del MISMO OBJETO objeto.notify().

ESTO LO QUE HACE ES DESPERTAR AL HILO QUE ESTABA EN WAIT() CON EL MISMO OBJETO Y LO DIRIGE AL ENTRY SET, DONDE ESPERA A QUE SE LIBERE EL MONITOR PARA VOLVER A EJECTURA SU CODIGO.
ES EL SO QUIEN DECIDE CUANDO LIBERAR EL MONITOR.

NOTIFY() DESPIERTA A UN HILO CUALQUIERA, LO ELIGE EL SO, SIN EMBARGO NOTIFYALL() DESPIERTA A TODOS LOS HILOS QUE SE HAYAN DETENIDO CON DICHO OBJETO.

La razón para usar un bucle WHILE() en el bloque sincronizado es para evitar los 'Spurious Wake ups' o despertares de los bloques sincronizados en momentos incorrectos, debido a otros hilos.
con un bucle IF podria despertar, pero con un bucle WHILE ESTÁ OBLIGADO A COMPROBAR QUE SE CUMPLE LA CONDICIÓN REQUERIDA.

Lo lógico en estos procesos es que el HILO QUE TIENE UNA DEPENDENCIA DE OTRO HILO, revise en un bucle WHILE una condicion necesaria para ejecutarse,
y en caso contrario realizar un objeto.wait(). EL HILO INDEPENDIENTE, realiza su codigo y cuando quiere mandar aviso realiza la función notify(), entonces se despierta el hilo, se revisa el bucle WHILE y se ejecuta su código.

 */
