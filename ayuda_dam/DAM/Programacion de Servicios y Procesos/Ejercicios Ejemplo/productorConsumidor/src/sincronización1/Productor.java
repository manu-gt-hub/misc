package sincronización1;

/**
 *
 * @author profesor
 * 
 */
class Productor extends Thread{
	
	private EnteroCompartido datoCompartido;
	
	public Productor(EnteroCompartido h){
		datoCompartido = h;
	}

	public void run(){
		for (int i=0;i<10;i++){
                        //Produzco 9 números de forma sincronizada, ya q el método escribir me bloquea
			datoCompartido.escribir(i);
			try{
				sleep(1000);
			}catch(InterruptedException e){}
		}
	}
	
}//Productor

