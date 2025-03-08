package sincronización2;

//***********************************************************
//***********************************************************
//Clase q lee del fichero compartido
class Consumidor extends Thread{
	
private FicheroCompartido fichero;

    public Consumidor(FicheroCompartido f){
            fichero = f;
    }
	
    @Override
    public void run(){

            while (true){
                    fichero.leer();
                    try{
                            sleep(500);
                    }catch (InterruptedException e){}
            }//while
    }//run
	
}//Consumidor
