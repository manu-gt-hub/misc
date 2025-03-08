/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sincronización1;

/**
 *
 * @author profesor
 */
class Consumidor extends Thread{
	
	private EnteroCompartido datoCompartido;
	
	public Consumidor(EnteroCompartido h){
		datoCompartido = h;
	}

        public void run(){
		
		int val=0;

                //Consumo 9 números de forma sincronizada, ya q el método leer me bloquea
		while (val != 9){
			val = datoCompartido.leer();
			try{
				sleep(1000);
			}catch (InterruptedException e){}
		}
	}
}//Consumidor

