package pconcurrente.ejemplo20b;

public class HiloReintegro implements Runnable {

	private Cuenta cuenta;
	private Perro perro;
	private Object object;

	public HiloReintegro(Cuenta cuenta, Object object, Perro perro) {
		this.cuenta = cuenta;
		this.object = object;
		this.perro = perro;
	}
	
	@Override
	public void run() {
		for(int i = 0; i < 1000; i++) {
			// En este caso el objeto MONITOR es 'perro'
			synchronized (perro){
				cuenta.reintegrar(100);
			}
		}
	}
}
