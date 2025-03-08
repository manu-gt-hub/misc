
package prac_12psp;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Ventana extends javax.swing.JFrame {

 
    Panel panel;
    public Ventana() {
        miinitComponents();
        this.setSize(500,500);
        this.setLocationRelativeTo(null);
        this.setTitle("practica_12");
    }
    
    private void miinitComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        panel=new Panel();
        setContentPane(panel);
        //getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));
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
                if(e.getKeyChar()=='w' || e.getKeyChar()=='W')
                {
                    Thread salto=new Thread(new Saltar(panel));
                    salto.start();
                    
                }
                if(e.getKeyChar()=='s' || e.getKeyChar()=='S')
                {
                    Thread saludo=new Thread(new Saludar(panel));
                    saludo.start();
                    
                }
            }


        });
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
}
