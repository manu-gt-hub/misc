
package GUI;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Ventana extends javax.swing.JFrame {

    
     public class Hilo1 implements Runnable
     {
        int time;
        public Hilo1(int t) {
            this.time=t;
        }
         
        @Override
        public void run() {
            for (int i = 0; i < 1000; i++) {
                jTextArea1.setText(jTextArea1.getText()+i+"\n");
                try {
                    Thread.sleep(time);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }

            
        }
       
     }
     public class Hilo2 implements Runnable
     {
        int time;
        public Hilo2(int t) {
            this.time=t;
        }
         
        @Override
        public void run() {
            for (int i = 2; i < 2000; i+=2) {
                jTextArea2.setText(jTextArea2.getText()+i+"\n");
                try {
                    Thread.sleep(time);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        }
       
     }
     public class Hilo3 implements Runnable
     {
        int time;
        public Hilo3(int t) {
            this.time=t;
        }
         
        @Override
        public void run() {
            for (int i = 1000; i > 0; i--) {
                jTextArea3.setText(jTextArea3.getText()+i+"\n");
                try {
                    Thread.sleep(time);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        }
       
     }
    public Ventana() {
        initComponents();
        this.setSize(400,300);
        this.setLocationRelativeTo(null);
        this.setTitle("practica 1");
        Thread h1=new Thread(new Hilo1(400));
        h1.start();
        Thread h2=new Thread(new Hilo2(400));
        h2.start();
        Thread h3=new Thread(new Hilo3(400));
        h3.start();
       
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea3 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridLayout(1, 3));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        getContentPane().add(jScrollPane1);

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane2.setViewportView(jTextArea2);

        getContentPane().add(jScrollPane2);

        jTextArea3.setColumns(20);
        jTextArea3.setRows(5);
        jScrollPane3.setViewportView(jTextArea3);

        getContentPane().add(jScrollPane3);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextArea jTextArea3;
    // End of variables declaration//GEN-END:variables
}
