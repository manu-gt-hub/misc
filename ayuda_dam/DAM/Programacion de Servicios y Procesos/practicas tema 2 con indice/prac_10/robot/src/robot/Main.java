
package robot;

import java.util.logging.Level;
import java.util.logging.Logger;


public class Main {

    public static class hilo implements Runnable
    {
        Ventana v;
        public hilo(Ventana v) {
            this.v=v;
        }

        
        @Override
        public void run() {
            while(!v.Margen())
            {
                v.mover(8);
                v.repaint();
                try {
                    Thread.sleep(100);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            v.dispose();
            

            
            
        }
                
    }
    
    public static class movimiento implements Runnable
    {
        Ventana v;
        public movimiento(Ventana v) {
            this.v=v;
        }

        
        @Override
        public void run() {
            int n=50;
            while(!v.Margen())
            {
                while(n>5)
                {
                    v.movimiento(n);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    n-=10;
                }
                while(n<45)
                {
                    v.movimiento(n);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    n+=10;
                }
            }
        }
                
    }
   
    public static void main(String[] args) throws InterruptedException {
        Ventana v=new Ventana();
        v.setVisible(true);
        Thread hilo=new Thread(new hilo(v));
        hilo.start();
        Thread hilo2=new Thread(new movimiento(v));
        hilo2.start();
    }
}
