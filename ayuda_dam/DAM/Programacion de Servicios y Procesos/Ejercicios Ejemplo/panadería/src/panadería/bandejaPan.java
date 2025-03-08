package panadería;


import java.util.LinkedList;


/**
 *
 * @author profesor
 */
class bandejaPan{
	
    private LinkedList bandeja;	
    public final int MAX;//nº max de barras de pan q caben en la bandeja

    public bandejaPan(int tam) {
        MAX=tam;
        this.bandeja = new LinkedList();
    }


    /**
     * Dice si la bandeja está vacía
     */
    public synchronized boolean vacía(){
        if (bandeja.size()<=0)
            return true;
        return false;
    }


    /**
     * Dice si la bandeja está llena
     */
    public synchronized boolean llena(){
        if (bandeja.size()>=MAX)
            return true;
        return false;
    }

    /**
     * Añade una barra de pan a la bandeja
     * @param valor
     */
    public synchronized void producir(int valor){
            while (llena()&&!Main.FIN){  //me quedo a la espera de que el dato lo coja un "consumidor"
                    try{
                            this.wait();//La bandeja es el recurso compartido, y es por tanto la q debe esperar a q le pongan pan
                    }catch (InterruptedException e){}
            }
            if(!llena()){
                bandeja.add(valor);
                System.out.println("El productor puso la barra "+valor+" en la bandeja (tot. barras:"+bandeja.size()+")");
                notifyAll(); //Notifico a los demas que ya he añadido una nueva barra
            }
    }
	

    public synchronized int consumir (){
        int x;
        while (vacía()&&!Main.FIN){ //Mientras el "productor" no haya puesto una barra no la puedo consumir.
                try{
                        wait();//La bandeja es el recurso compartido, y es por tanto la q debe esperar a q le pongan pan
                }catch (InterruptedException e){}
        }
        if(!vacía()){
            x=(Integer)bandeja.getLast();
            bandeja.removeLast();
            notifyAll();//Notifico q he consumido
            return x;
        }
        return -1;
    }
	
}//bandejaPan
