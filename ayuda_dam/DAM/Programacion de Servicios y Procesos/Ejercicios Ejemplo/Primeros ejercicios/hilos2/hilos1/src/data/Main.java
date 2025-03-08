package data;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Profesor
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Thread t=new Thread(new TareaVisMarisa());
        System.out.println("Hola");
        t.start();
        System.out.println("Adios");
        Thread t2=new Thread(new TareaVisRuben());
        t2.start();
        
        
    }
}

class TareaVisMarisa implements Runnable
{
    @Override
    public void run() {
        try {
            Thread.sleep(5);
            for (int i = 0; i < 1000; i++) {
                System.out.print("Marisa\t");            
                if((i%100)==0)
                    System.out.println("");
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(TareaVisMarisa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

class TareaVisRuben implements Runnable
{
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.print("Ruben\t");            
            if((i%100)==0)
                System.out.println("");
        }
    }
}
