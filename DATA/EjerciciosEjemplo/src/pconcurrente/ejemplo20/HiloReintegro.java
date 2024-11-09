package pconcurrente.ejemplo20;

public class HiloReintegro implements Runnable {

	private Cuenta cuenta;
	
	public HiloReintegro(Cuenta cuenta) {
		this.cuenta = cuenta;
	}
	
	@Override
	public void run() {
		for(int i = 0; i < 1000; i++) {
			// Este hilo retira 1000 veces 100€
			// Este método reintegrar esta definido como 'synchronized'
			// y su monitor es este objeto en particular 'cuenta'
			synchronized (cuenta){
				cuenta.reintegrar(100);
			}
		}
	}
}
