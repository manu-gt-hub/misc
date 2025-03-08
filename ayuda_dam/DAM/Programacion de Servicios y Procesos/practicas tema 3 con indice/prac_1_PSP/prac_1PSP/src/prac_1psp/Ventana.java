
package prac_1psp;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.net.InetAddress;
import java.net.UnknownHostException;


public class Ventana extends javax.swing.JFrame {


    public Ventana() throws UnknownHostException {
        initComponents();
        this.setSize(600,700);
        jTextArea1.setBackground(Color.black);
        Font fuente = new Font("Verdana", Font.BOLD, 12);
        jTextArea1.setForeground(Color.WHITE);
        jTextArea1.setFont(fuente);

        this.setTitle("Monitor del servidor     IP: "+Main.getIp()+"  Puerto: "+Main.getPuerto());
        this.setLocationRelativeTo(null);
        this.jTextArea1.setEditable(false);
        
        jScrollPane1.getVerticalScrollBar().addAdjustmentListener(new AdjustmentListener() {  
        public void adjustmentValueChanged(AdjustmentEvent e) {  
            e.getAdjustable().setValue(e.getAdjustable().getMaximum());  
        }
    });

    }
    public void escribir(String txt)
    {
        this.jTextArea1.append(txt+"\n");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        getContentPane().add(jScrollPane1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
