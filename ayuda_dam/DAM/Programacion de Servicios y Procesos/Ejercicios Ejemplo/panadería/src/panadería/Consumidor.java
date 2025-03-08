package panadería;

/**
 *
 * @author profesor
 */
class Consumidor extends Thread{
	
    private bandejaPan agente;
    private int numConsummer;
	
    public Consumidor(bandejaPan h,int i){
        agente = h;
        numConsummer=i;
    }

    @Override
    public void run(){
        int x = agente.consumir();
        if(x!=-1)
            System.out.println("El consumidor "+numConsummer+ " se llevó una barra ("+x+") de la bandeja");
    }
	
}//Consumidor

