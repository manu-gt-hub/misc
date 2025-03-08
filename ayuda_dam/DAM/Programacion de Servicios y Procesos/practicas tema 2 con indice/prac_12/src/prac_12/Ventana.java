
package prac_12;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Ventana extends javax.swing.JFrame {

    Robot panel;
    
    public class saltar implements Runnable
    {
        Robot r;

        public saltar(Robot r) {
            this.r = r;
        }
        
        @Override
        public void run() {
            r.impulsando=true;
            r.adelanto=0;
            
            r.repaint();
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            r.saltando=true;
            int origen=r.caby;
            int tope=r.caby-100;

            while(tope<r.caby)
            {
                r.caby-=5;
                r.body-=5;
                r.piernaizqy-=5;
                
                r.piernadery-=5;

                r.brazoizqy-=5;

                r.brazodery-=5;
                
                r.repaint();
                try {
                    Thread.sleep(40);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            while(origen>r.caby)
            {
                r.caby+=5;
                r.body+=5;
                r.piernaizqy+=5;

                r.piernadery+=5;

                r.brazoizqy+=5;

                r.brazodery+=5;
                
                r.repaint();
                try {
                    Thread.sleep(40);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            r.saltando=false;
            r.repaint();
        }

    }
    
    public class saludar implements Runnable
    {
        Robot r;

        public saludar(Robot r) {
            this.r = r;
        }
        
        @Override
        public void run() {
            r.saludando=true;
            r.adelanto=0;



            int x=r.brazoderx;
            int y=r.brazodery;
            r.brazoderx=x-10;
            r.brazodery=y+10;
            r.alt=40;
            for (int i = 0; i < 2; i++) {
                
                while(r.alt<60)
                {
                    r.alt+=2;
                    r.repaint();
                    try {
                        Thread.sleep(40);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                while(r.alt>20)
                {
                    r.alt-=2;
                    r.repaint();
                    try {
                        Thread.sleep(40);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                
                
                
            }
            r.brazoderx=x;
            r.repaint();
            r.saludando=false;
            
            
        }

    }
    
    public Ventana() throws InterruptedException {
        miinitComponents();
        this.setSize(500,500);
        this.setLocationRelativeTo(null);
        this.setTitle("Practica 12");
        
        
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
                if(e.getKeyChar()=='w' || e.getKeyChar()=='W')
                {
                    Thread salto=new Thread(new saltar(panel));
                    salto.start();
                    
                }
                if(e.getKeyChar()=='s' || e.getKeyChar()=='S')
                {
                    Thread saludo=new Thread(new saludar(panel));
                    saludo.start();
                    
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
