
package GUI;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Ventana extends javax.swing.JFrame {

    PanelFondo panel1;
    public class Hilo1 implements Runnable
    {
        Ventana v;

        public Hilo1(Ventana v) {
            this.v = v;
        }
        

        @Override
        public void run() {
            while(true)
            {
                
                try {
                    v.panel1.repintar("cara1");
                    Thread.sleep(300);
                    v.panel1.repintar("cara2");
                    Thread.sleep(300);
                    v.panel1.repintar("cara3");
                    Thread.sleep(300);
                    v.panel1.repintar("cara4");
                    Thread.sleep(300);
                    v.panel1.repintar("cara5");
                    Thread.sleep(300);
                    v.panel1.repintar("cara6");
                    Thread.sleep(300);
                    v.panel1.repintar("cara7");
                    Thread.sleep(300);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    public Ventana() {
        miinitComponents();
        this.setTitle("prac_7");
        this.setSize(400,400);
        this.setLocationRelativeTo(null);
        Thread h=new Thread(new Hilo1(this));
        h.start();
    }

 
    
    private void miinitComponents() {

        panel1 = new PanelFondo("cara1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        
        getContentPane().add(panel1);

        pack();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.LINE_AXIS));
        getContentPane().add(jPanel1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
