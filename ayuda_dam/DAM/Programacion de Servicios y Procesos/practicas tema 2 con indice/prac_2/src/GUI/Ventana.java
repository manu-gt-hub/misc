
package GUI;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.management.monitor.Monitor;

public class Ventana extends javax.swing.JFrame {

    Semaforo s;
    Thread h;
    Thread h2;
    public class Semaforo extends Semaphore
    {
        int ping=1;

        public Semaforo(int n) {
            super(n);
            this.ping=n;
            
        }
        public synchronized void down(){
          while(ping <= 0){
            try{
               wait();
            }catch(InterruptedException e){
              ;
            }
          }
          ping--;
        }
        public synchronized void up(){
             ping++;
             notify();
        }
        
        public void ping(Runnable r) throws InterruptedException
        {

            
                    
                    try {
                        s.down();
                        jLabel1.setText("PING");
                        Thread.sleep(300);
                        jLabel1.setText("");
                        Thread.sleep(300);
                        s.up();
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    
                   
                
                
            
        }
        public void pong(Runnable r) throws InterruptedException
        {

                     try {
                        s.down();
                        jLabel2.setText("PONG");
                        Thread.sleep(300);
                        jLabel2.setText("");
                        Thread.sleep(300);
                        s.up();
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
                    }
                 
     
                    

  
        }

        
        
    }
    public class Hilo1 implements Runnable
     {

        public Hilo1() {
        }
         
        @Override
        public void run() {
            while(true)
            {
                try {
                    s.ping(this);
                    Thread.sleep(5);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
            
        }
       
     }
     public class Hilo2 implements Runnable
     {
        public Hilo2() {
        }
         
        @Override
        public void run() {
            while(true)
            {
                try {
                    s.pong(this);
                    Thread.sleep(5);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        }
       
     }
     
    public Ventana() throws InterruptedException {
        initComponents();
        this.setTitle("prac_2");
        this.setLocationRelativeTo(null);
        s=new Semaforo(1);
        h=new Thread(new Hilo1());
        h2=new Thread(new Hilo2());
        
        h.start();
        h2.start();

 
        
    

        
        
        
    }

 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridLayout(1, 2));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("  ");
        getContentPane().add(jLabel1);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("  ");
        getContentPane().add(jLabel2);

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
