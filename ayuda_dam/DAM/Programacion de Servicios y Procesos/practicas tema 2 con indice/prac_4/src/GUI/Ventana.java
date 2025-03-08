
package GUI;

import java.awt.Graphics;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Ventana extends javax.swing.JFrame {
   int x1=175;
   int y1=70;
   
   int x2=175;
   int y2=130;
   
   int x3=175;
   int y3=190;
    
    public class Hilo1 implements Runnable
    {
        Ventana v;

        public Hilo1(Ventana v) {
            this.v = v;
        }
        

        @Override
        public void run() {
            Random r=new Random(); 
            while(true)
            {
                if(r.nextInt(10)>5)  v.x1+=r.nextInt(8);
                else  v.x1-=r.nextInt(8);
                
                if(r.nextInt(10)>5) v.y1+=r.nextInt(8);
                else  v.y1-=r.nextInt(8);
                
                if(r.nextInt(10)>5)  v.x2+=r.nextInt(8);
                else  v.x2-=r.nextInt(8);
                
                if(r.nextInt(10)>5) v.y2+=r.nextInt(8);
                else  v.y2-=r.nextInt(8);
                
                if(r.nextInt(10)>5)  v.x3+=r.nextInt(8);
                else  v.x3-=r.nextInt(5);
                
                if(r.nextInt(10)>5) v.y3+=r.nextInt(8);
                else  v.y3-=r.nextInt(8);

                v.repaint();
                try {
                    Thread.sleep(30);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
    }
    public Ventana() {
        initComponents();
        this.setTitle("prac_4");
        this.setLocationRelativeTo(null);
        Thread h=new Thread(new Hilo1(this));
        h.start();
    }

    
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillOval(x1, y1, 30, 30);
        g.fillOval(x2, y2, 30, 30);
        g.fillOval(x3, y3, 30, 30);
    }
    
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
