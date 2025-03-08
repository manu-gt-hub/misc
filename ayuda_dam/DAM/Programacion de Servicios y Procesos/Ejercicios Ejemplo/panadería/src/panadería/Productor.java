package panadería;

/**
 *
 * @author profesor
 * 
 */
class Productor extends Thread{
	
	private bandejaPan bandeja;
	
	public Productor(bandejaPan h){
		bandeja = h;
	}

        @Override
	public void run(){
	    for (int i=0;!Main.FIN;i++){
		bandeja.producir(i);            
                
                //Dejo a los demás q too entren a ejecutarse
                yield();
                /*
                 O too podría dormir un rato al productor
                 try{
                        Thread.sleep(100);
                }catch(InterruptedException e){}
                 *
                 */
                
            }
	}


	
}//Productor

