package sincronización1;

/**
 * Este es el recurso compartido. Creo un monitor para acceder a él
 * @author profesor
 */
class EnteroCompartido{
	
	private int enteroCompartido;
	private boolean disponible=false;//Variable de condición
	
	public synchronized void escribir(int valor){
		while (disponible == true){  //me quedo a la espera de que el dato lo coja un "consumidor"
			try{
				wait();
			}catch (InterruptedException e){}
		}//si no hay un dato "producido",lo produzco y pongo como el dato como disponible
		enteroCompartido=valor;
		System.out.println("El productor puso "+enteroCompartido+" en memoria");
                
                disponible=true;
		notifyAll(); //Notifico a los demas que ya he dejado de usar el dato
                             //Haciéndo el dato disponible para otro hilo q lo necesite                
		
	}
	
	public synchronized int leer (){
		while (disponible == false){ //Mientras el "productor" no haya escrito un dato 
                                             //(=dato no disponible )no lo puedo leer.                                             
			try{
				wait();
			}catch (InterruptedException e){}
		} //Si ya tengo un dato lo leo. Notifico que ya lo he leido y que ya no hay dato disponible
                
                System.out.println("El consumidor recupero "+enteroCompartido+" de memoria");                
		
                disponible = false;
		notifyAll();		
		return enteroCompartido;
	}
	
}//EnteroCompartido
