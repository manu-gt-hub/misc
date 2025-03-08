package GUI;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JPanel;


public class Semaforo extends javax.swing.JFrame {


    private javax.swing.JPanel jPanel1;
    private PanelFondo jPanel2;
     public class MiHilo implements Runnable
     {

         int time;

        public MiHilo(int t) {
            this.time=t;
        }
         
        @Override
        public void run() {
            while(true)
            {
                jPanel2.repintar("rojo");
                try {
                    Thread.sleep(time);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Semaforo.class.getName()).log(Level.SEVERE, null, ex);
                }
                jPanel2.repintar("ambar");
                try {
                    Thread.sleep(time);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Semaforo.class.getName()).log(Level.SEVERE, null, ex);
                }
                jPanel2.repintar("verde");
                try {
                    Thread.sleep(time);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Semaforo.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        }
       
     }
    public Semaforo() {
        miinitComponents();

        this.setSize(250,400);
        this.setTitle("Semaforo");
        this.setLocationRelativeTo(null);
        MiHilo hilo=new MiHilo(500);
        Thread h=new Thread(hilo);
        h.start();
        
    }

 
    private void miinitComponents() {

        jPanel1 =new JPanel();
        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.LINE_AXIS));
        jPanel2 =new PanelFondo("rojo");

        jPanel1.add(jPanel2);
        getContentPane().add(jPanel1);
        
       
        pack();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridLayout(1, 1, 1, 0));

        pack();
    }// </editor-fold>//GEN-END:initComponents

 /*
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
*/
}

