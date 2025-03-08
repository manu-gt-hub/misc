

package sincronización2;


//***********************************************************
//***********************************************************
//Clase q escribe en el fichero compartido
//En este ej escribe 5000 cars de una tacada
class Productor extends Thread{
	
private FicheroCompartido fichero;


	public Productor(FicheroCompartido f){
		fichero = f;
	}//Ctor
	
	public void run(){
		
			while (true){
				fichero.escribir();
				try{
					sleep(500);
				}catch(InterruptedException e){}
			}//while
	}//run
	
	
}//Productor