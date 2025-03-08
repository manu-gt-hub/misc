
package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.util.calendar.Gregorian;


public class Ventana extends javax.swing.JFrame {
        
   
    
    public class Hilo1 implements Runnable
     {
        VenSal v;
        int time;
        public Hilo1(int t,VenSal v) {
            this.v=v;
            this.time=t;
        }
        
        @Override
        public void run() {
            
            //Thread crono=new Thread(new Cronometro(v));
            //crono.start();
            for (int i = 1; i < 10; i++) {
                for (int j = 0; j <=10; j++) {
                    
                    v.jTextArea1.setText(v.jTextArea1.getText()+i+" x "+j+" = "+(i*j)+"\n");
                    try {
                        Thread.sleep(time);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                }
                
                
            }

            
        }
       
     }
     public class Hilo2 implements Runnable
     {
        VenSal v;
        int time;
        int min=0;
        int seg=0;
        int mil=0;
        String smin="";
        String sseg="";
        String smil="";
        String titulo;
        public Hilo2(int t,VenSal v) {
            this.time=t;
            this.v=v;
            this.titulo=v.getTitle();
        }
         
        @Override
        public void run() {
            //Thread crono=new Thread(new Cronometro(v));
            //crono.start();
            
            String texto=v.jTextArea1.getText();
            int fib1=0,fib2=1;

            v.jTextArea1.setText(texto+=0+"\n");

            for (int n = 0; fib2<500; n++) {
                fib2 = fib1 + fib2;
                fib1 = fib2 - fib1;
                v.jTextArea1.setText(v.jTextArea1.getText()+fib1+"\n");
                try {
                    Thread.sleep(300);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

        }
       
     }
    public Ventana() {
        miinitComponents();
        this.setTitle("prac_3");
        this.setSize(300,200);
        this.setLocationRelativeTo(null);
    }


    private void miinitComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridLayout(1, 2));

        jButton1.setText("Tabla multiplicar");
        jButton1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
               VenSal ventana=new VenSal();
               ventana.setVisible(true);
               Thread h=new Thread(new Hilo1(400,ventana));
               h.start();
               
               Cronometro crono = new Cronometro(ventana); 

               Timer timer = new Timer(); 
     
               timer.scheduleAtFixedRate(crono, 0,1);
            }
        });
        
    
        getContentPane().add(jButton1);

        jButton2.setText("Fibonacci");
        jButton2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
               VenSal ventana=new VenSal();
                ventana.setVisible(true);
               Thread h=new Thread(new Hilo2(400,ventana));
               h.start();
               Cronometro crono = new Cronometro(ventana); 

               Timer timer = new Timer(); 
     
               timer.scheduleAtFixedRate(crono, 0,1);
            }
        });
        getContentPane().add(jButton2);

       
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridLayout(1, 2));

        jButton1.setText("Tabla multiplicar");
        getContentPane().add(jButton1);

        jButton2.setText("Fibonacci");
        getContentPane().add(jButton2);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    // End of variables declaration//GEN-END:variables
}
