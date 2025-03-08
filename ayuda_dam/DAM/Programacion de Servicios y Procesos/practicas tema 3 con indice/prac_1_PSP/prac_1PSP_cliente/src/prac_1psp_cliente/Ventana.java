
package prac_1psp_cliente;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import javax.swing.JOptionPane;

public class Ventana extends javax.swing.JFrame {

  
    public Ventana() {
        miinitComponents();
        this.setTitle("app cliente");
        this.setSize(400,500);
        this.setLocationRelativeTo(null);
        jTextArea1.requestFocus();
    }

    private void miinitComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setLayout(new java.awt.GridLayout(2, 1));

        //jPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1,1,1,1);
        jPanel1.setLayout(new java.awt.FlowLayout());

        jLabel1.setText("IP:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 19);
        jPanel1.add(jLabel1, gridBagConstraints);

        jTextField1.setText("192.168.1.193");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.ipadx = 134;
        jPanel1.add(jTextField1, gridBagConstraints);

        jButton1.setText("Enviar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 6);
        jPanel1.add(jButton1, gridBagConstraints);

        jLabel2.setText("Puerto: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 11);
        jPanel1.add(jLabel2, gridBagConstraints);

        jTextField2.setText("8888");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 57;
        jPanel1.add(jTextField2, gridBagConstraints);

        jButton2.setText("Borrar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 0;
        jPanel1.add(jButton2, gridBagConstraints);

        jPanel3.add(jPanel1);

        jPanel4.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        jPanel4.setLayout(new java.awt.GridLayout(7, 1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Sintaxis: ");
        jPanel4.add(jLabel3);

        jLabel4.setText("Suma: 2+2=");
        jPanel4.add(jLabel4);

        jLabel5.setText("Resta: 2-2=");
        jPanel4.add(jLabel5);

        jLabel6.setText("Multiplicacion: 2*2=");
        jPanel4.add(jLabel6);

        jLabel7.setText("Division: 2/2=");
        jPanel4.add(jLabel7);

        jLabel8.setText("Seno: s(90)=");
        jPanel4.add(jLabel8);

        jLabel9.setText("Coseno: c(90)=");
        jPanel4.add(jLabel9);

        jPanel3.add(jPanel4);

        getContentPane().add(jPanel3, java.awt.BorderLayout.NORTH);

        jPanel2.setLayout(new javax.swing.BoxLayout(jPanel2, javax.swing.BoxLayout.LINE_AXIS));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jPanel2.add(jScrollPane1);

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        pack();
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setLayout(new java.awt.GridLayout(2, 1));

        jPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));

        jLabel1.setText("IP:");
        jPanel1.add(jLabel1);

        jTextField1.setText("192.168.1.193");
        jPanel1.add(jTextField1);

        jButton1.setText("Enviar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);

        jLabel2.setText("Puerto: ");
        jPanel1.add(jLabel2);

        jTextField2.setText("8888");
        jPanel1.add(jTextField2);

        jButton2.setText("Borrar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);

        jPanel3.add(jPanel1);

        jPanel4.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        jPanel4.setLayout(new java.awt.GridLayout(7, 1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Sintaxis: ");
        jPanel4.add(jLabel3);

        jLabel4.setText("Suma: 2+2=");
        jPanel4.add(jLabel4);

        jLabel5.setText("Resta: 2-2=");
        jPanel4.add(jLabel5);

        jLabel6.setText("Multiplicacion: 2*2=");
        jPanel4.add(jLabel6);

        jLabel7.setText("Division: 2/2=");
        jPanel4.add(jLabel7);

        jLabel8.setText("Seno: s(90)=");
        jPanel4.add(jLabel8);

        jLabel9.setText("Coseno: c(90)=");
        jPanel4.add(jLabel9);

        jPanel3.add(jPanel4);

        getContentPane().add(jPanel3, java.awt.BorderLayout.PAGE_END);

        jPanel2.setLayout(new javax.swing.BoxLayout(jPanel2, javax.swing.BoxLayout.LINE_AXIS));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jPanel2.add(jScrollPane1);

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
            
        
        try
	 
	{
            
        final String ip = jTextField1.getText();
	 
	final int puerto = Integer.parseInt(jTextField2.getText());
	 
	Socket sc;
	 
	DataOutputStream mensaje;
	 
	BufferedReader entrada;

	 
	
	 
	sc = new Socket( ip,puerto); 

	mensaje = new DataOutputStream(sc.getOutputStream());
        entrada = new BufferedReader(new InputStreamReader(sc.getInputStream()));
        String env=jTextArea1.getText()+"$\n";
        mensaje.writeBytes(env);
        System.out.println("datos enviados");
        String datos=entrada.readLine();
        System.out.println("datos leidos");
        jTextArea1.append(datos);
        
	sc.close();
	 
	}
        catch(Exception e )
	{
	 
	System.out.println("Error: "+e.getMessage());
            JOptionPane.showMessageDialog(null,"Error: "+e.getMessage());
	 
	}


    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        jTextArea1.setText("");       
    }//GEN-LAST:event_jButton2ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
