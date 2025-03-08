
package GUI;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Ventana extends javax.swing.JFrame {

    int x=5,y=5;
    
    public static class Hilo implements Runnable
    {
        Ventana v;
        int x=6,y=6;
        boolean xneg=false,yneg=false;
        public Hilo(Ventana v) {
            this.v = v;
        }
        

        @Override
        public void run() {
            this.x=v.getX();
            this.y=v.getY();
            while(true)
            {
                
            
                if(x>=560) xneg=!xneg;
                if(x<=0) xneg=!xneg;
                
                if(y>=340) yneg=!yneg;
                if(y<=0) yneg=!yneg;
                
                if(!xneg) x+=5;
                else x-=5;
                
                if(!yneg) y+=5;
                else y-=5;

                  v.repintar(this.x,this.y);
                  try {
                    Thread.sleep(30);
                  } catch (InterruptedException ex) {
                    Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
                  }
               }

          
       }
        
    }

    
    public Ventana() {

        miinitComponents();
        this.setSize(600,400);
        this.setLocationRelativeTo(null);
        this.setTitle("prac_9");
        Thread h=new Thread(new Hilo(this));
        h.start();
    }

    private void miinitComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        PanelFondo panel=new PanelFondo(this);
        getContentPane().add(panel);
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

    public  int getx() {
        return this.x;
    }

    public  int gety() {
        return this.y;
    }

    public  void repintar(int xx, int yy) {
        this.x=xx;
        this.y=yy;
        repaint();
    }
}
