
package GUI;

import data.Main;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/*
 METODO DE CIFRADO
 * 
 *dependera de la opcion elegida en el combo box
 * entre las que estan sumar un numero a todos los caracteres
 * restar un numero a todos los caracteres
 * sumar un numero a las vocales y restarle el mismo a las consonantes
 * restar un numero a las vocales y sumarselo a las consonantes
 * 
 */
public class Ventana extends javax.swing.JFrame {

    JFileChooser sel;
    Main ap;
    //fichero que contiene los datos sin cifrar
    File origen;
    //fichero que almacenara los caracteres ya cifrados
    File destino;
    String inpath;
    String outpath;
    public Ventana() {
        initComponents();
        sel=new JFileChooser();
        this.setLocationRelativeTo(null);
        this.setTitle("Cifrador");
    }
    void cifrar() throws IOException
    {
        FileInputStream in= null;
        FileOutputStream out= null;
        
        if(origen!=null)
        {
            //si origen es distinto de null extraigo su directorio
            inpath=origen.getPath();
            
            if(destino!=null)
            {
                //si destino es distinto de null extraigo su directorio
                outpath=destino.getPath();
                if(!this.jTextField3.getText().isEmpty())
                {
                    int x=Integer.parseInt(this.jTextField3.getText());
                    //recibo en opc la opcion seleccionada del combobox
                    int opc=this.jComboBox1.getSelectedIndex();
                    try
                    {
                    //flujo de entrada in vinculado a la ruta del fichero origen
                    in = new FileInputStream(inpath);
                    //flujo de salida out vinculado a la ruta del fichero destino
                    out = new FileOutputStream(outpath);
                    int c=0;
                    //segun la opcion del combobox
                    switch(opc)
                    {
                        case 0:
                            while ((c=in.read())!=-1)
                            {
                             out.write(c+x);
                            }
                        break;
                        case 1:
                            while ((c=in.read())!=-1)
                            {
                                out.write(c-x);
                            }
                        break;
                        case 2:
                            while ((c=in.read())!=-1)
                            {
                                //si el caracter leido es una vocal
                                if(c=='a' || c=='e'|| c=='i'|| c=='o'|| c=='u'
                                ||c=='A' || c=='E'|| c=='I'|| c=='O'|| c=='U')
                                    out.write(c+x);
                                else
                                    out.write(c-x);
                            }
                        break;
                        case 3:
                            while ((c=in.read())!=-1)
                            {
                                //si el caracter leido es una vocal
                                if(c=='a' || c=='e'|| c=='i'|| c=='o'|| c=='u'
                                ||c=='A' || c=='E'|| c=='I'|| c=='O'|| c=='U')
                                    out.write(c-x);
                                else
                                    out.write(c+x);
                            }
                        break;
                    }
            
                    }
                    finally
                    {
                        if(in!=null)
                        {
                            in.close();
                        }
                        if(out!=null)
                        {
                            out.close();
                            JOptionPane.showMessageDialog(null,"FICHERO CIFRADO");
                            this.dispose();
                        }
            
                    }
    
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Debe introducir un numero");
                }
            }
            else
            {
               JOptionPane.showMessageDialog(null,"Debe elegir la ruta de destino");
            }
                 
        }
        else
        {
            JOptionPane.showMessageDialog(null,"Debe elegir la ruta de origen");
        }
        
        
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Seleccione archivo de origen");

        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setText("Seleccione archivo de destino");

        jButton2.setText("Buscar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Todos car. +x", "Todos car. -x", "Voc +x cons -x", "Voc -x cons +x" }));

        jLabel3.setText("Elija algoritmo de cifrado");

        jButton3.setText("Cifrar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField3, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE))
                    .addComponent(jTextField1)
                    .addComponent(jTextField2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2)
                    .addComponent(jButton1)
                    .addComponent(jButton3))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //muestro una ventana de seleccion de fichero
        sel.showOpenDialog(sel);
        //guardo en origen el archivo seleccionado
        origen=sel.getSelectedFile();
        //muestro la ruta de dicho archivo en jtextfield
        this.jTextField1.setText(origen.getPath());
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        //muestro una ventana de seleccion de fichero
        sel.showOpenDialog(sel);
        //guardo en destino el archivo seleccionado
        destino=sel.getSelectedFile();
        //muestro la ruta de dicho archivo en jtextfield
        this.jTextField2.setText(destino.getPath());
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
            this.cifrar();
        } catch (IOException ex) {
            Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables
}
