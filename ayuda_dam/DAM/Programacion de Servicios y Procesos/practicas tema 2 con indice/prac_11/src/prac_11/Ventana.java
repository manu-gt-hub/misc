
package prac_11;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class Ventana extends javax.swing.JFrame {

    Robot panel;
    
    public Ventana() throws InterruptedException {
        miinitComponents();
        this.setSize(500,500);
        this.setLocationRelativeTo(null);
        this.setTitle("Practica 11");
        
        
    }


    
    private void miinitComponents() throws InterruptedException {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));
        panel=new Robot();
        
        getContentPane().add(panel);
        
        this.addFocusListener(new FocusAdapter() {


            @Override
            public void focusLost(FocusEvent e) {
                requestFocus();
            }
        });
        this.addKeyListener(new KeyAdapter() {


            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyChar()=='a' || e.getKeyChar()=='A')
                {
                    panel.izq(4);
                    panel.repaint();
                }
                if(e.getKeyChar()=='d' || e.getKeyChar()=='D')
                {
                    panel.der(4);
                    panel.repaint();
                }
            }


        });

        pack();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
/*
    public void mover(int i) {
        panel.mover(i);
    }*/
    public void movimiento(int n)
    {
        panel.adelanto(n);
    }
    
    public boolean Margen() {

        if(panel.getX()<this.getWidth()/2)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
    public void repintar()
    {
        panel.repaint();
    }
}
