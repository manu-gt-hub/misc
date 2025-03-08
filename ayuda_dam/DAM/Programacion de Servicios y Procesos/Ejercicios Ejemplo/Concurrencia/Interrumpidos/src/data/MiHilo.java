/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

/**
 *
 * @author Profesor
 */
public class MiHilo implements Runnable {

    @Override
    public void run() 
    {
        
        //Cdo está dormido uso el try catch + la condición
        //Cdo está despierto uso el Thread.iterrupted()
        System.out.println("Start");
        boolean x=true;
        while(!Thread.interrupted() && x){
            for (int i = 0; i < 10000; i++) {
                System.out.println("Hola "+i);
                //if(Thread.interrupted())
                  //  i=20000;
            }
            //System.out.println("Hola");        
            
            try {
                Thread.sleep(4000);
            } catch (InterruptedException ex) {
                System.out.println("Hilo interrumpido mientras dormía");
                x=false;
            }
        }                
        System.out.println("Stop");
    }
    
    
    
    
}
