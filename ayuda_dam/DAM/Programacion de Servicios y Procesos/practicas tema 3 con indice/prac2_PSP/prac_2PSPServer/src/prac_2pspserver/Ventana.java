
package prac_2pspserver;

import java.awt.Image;
import java.io.IOException;
import java.net.UnknownHostException;

public class Ventana extends javax.swing.JFrame {

  
    String IP;
    int puerto=8888;
    boolean acc_canvas=true;
    MiCanvas canvas;
    
    public Ventana() throws UnknownHostException, IOException 
    {
        minitComponents();
        
        this.setSize(800,600);
        this.setLocationRelativeTo(null);
        
    }
    
    private void minitComponents() {

        canvas = new MiCanvas();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        canvas.setBackground(new java.awt.Color(204, 204, 255));
        getContentPane().add(canvas);

        pack();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        canvas1 = new java.awt.Canvas();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        canvas1.setBackground(new java.awt.Color(204, 204, 255));
        getContentPane().add(canvas1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Canvas canvas1;
    // End of variables declaration//GEN-END:variables

    public synchronized void dibujar(Image img) throws InterruptedException {
       MiCanvas c=this.getCanvas();
       
       c.getGraphics().drawImage(img,0,0,c.getWidth(),c.getHeight(), this);
       this.repaint();
    }
    public synchronized MiCanvas getCanvas() throws InterruptedException
    {
        while(!acc_canvas)
        {
            this.wait();
        }
        acc_canvas=false;
        MiCanvas c=this.canvas;
        acc_canvas=true;
        notifyAll();
        return c;
        
            
            
    }

}
