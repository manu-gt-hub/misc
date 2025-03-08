
package GUI;

import data.ClientHandler;
import data.TimerSender;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/*clase dnd se visualiza toda la actividad del servidor
y sus controles
*/
public class Ventana extends javax.swing.JFrame {

    public static ClientHandler client;
    float TIME_INI=2.0f;
    int WIDTH=400;
    int HEIGHT=400;
    TimerSender sender;
    public Ventana() {
        
    }

    public int getTime()
    {
        return Integer.parseInt(this.jComboBox1.getSelectedItem().toString());
    }
    public Ventana(String host, int port) {
        minitComponents();
        this.setSize(WIDTH,HEIGHT);
        this.setTitle("LOG del server IP: "+host+" Puerto: "+port);
        this.setLocationRelativeTo(null);
        sender=new TimerSender(2.0f,this,WIDTH,HEIGHT); 
        sender.start();
   }
    public void escribir(String txt)
    {
        this.jTextArea1.append(txt);
    }

    
    private void minitComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTextArea1.setBackground(new java.awt.Color(51, 51, 51));
        jTextArea1.setColumns(20);
        jTextArea1.setForeground(new java.awt.Color(255, 255, 255));
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel1.setLayout(new java.awt.GridLayout(1, 2));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Tiempo de envio items: (seg) ");
        jPanel1.add(jLabel1);

        
        for (float i = 0.5f; i <= 5.0f; i+=0.25) {
            jComboBox1.addItem(i);
            
        }
        jComboBox1.setSelectedIndex(6);
        jComboBox1.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent ie) {
                sender.setTime((int)(Float.parseFloat(ie.getItem().toString())*1000));
            }
        });
        //jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(jComboBox1);

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_START);

        pack();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTextArea1.setBackground(new java.awt.Color(51, 51, 51));
        jTextArea1.setColumns(20);
        jTextArea1.setForeground(new java.awt.Color(255, 255, 255));
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel1.setLayout(new java.awt.GridLayout(1, 2));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Tiempo de envio items:");
        jPanel1.add(jLabel1);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(jComboBox1);

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_START);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables

    public void setClientHandler(ClientHandler c) {
        client=c;
    }
    public ClientHandler getClientHandler() {
        return this.client;
    }
}
