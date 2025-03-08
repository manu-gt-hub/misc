
package GUI;

import data.Main;
import data.Producto;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;


    
      
public class VentanaMenu extends javax.swing.JFrame {

    JFileChooser sel;
    //cogemos la ruta relativa del ejecutable
    String ruta=new File ("").getAbsolutePath ();
    File arts=new File(ruta+"/archivos/articulos.txt");
    File vents= new File(ruta+"/archivos/ventas.txt");
    Main ap;
    //lista de productos leidos del fichero
    LinkedList<Producto> listprod;
    int c;
    Producto prod;
    public VentanaMenu(Main ref) {
        initComponents();
        this.jTextField1.setEditable(false);
        this.jTextField2.setEditable(false);
        this.jTextField1.setText(arts.getPath());
        this.jTextField2.setText(vents.getPath());
        ap=ref;
        sel=new JFileChooser();
        listprod=new LinkedList();
        this.setTitle("Tienda de ropa");
        this.setLocationRelativeTo(null);
    }
    void cargarDatos(){
        BufferedReader br = null;
        String linea; 

          try {          
          br = new BufferedReader(new FileReader(arts));
          //mientras halla lineas en el fichero de productos
          while ((linea = br.readLine())!=null) {
             
             c=1;
             //vamos leyendo campos
             Scanner sc=new Scanner(linea);
             sc.useDelimiter("[:\r\n]");
             prod=new Producto();
             boolean ver=false;
             while(sc.hasNext()){
                 //segun campo
                 switch(c)
                 {
                     case 1:
                         int ind=Integer.parseInt(sc.next());
                         //verifico que el producto no exista
                         for (Producto p : listprod) {
                             if(p.getCodigo()==ind)
                             {
                                 ver=true;
                             }
                         }
                         if(ver==false)
                         {
                             prod.setCodigo(ind);
                         }
                         
                     break;
                     case 2:
                         if(ver==false)
                         {
                           prod.setNombre(sc.next());
                         }
                     break;
                     case 3:
                         if(ver==false)
                         {
                            prod.setPrecio(Integer.parseInt(sc.next()));
                         }
                     break;
                 }
                 c++;
             }
             //si el producto no existe lo añado a la lista
             if(ver==false)
             {
                 listprod.add(prod);
             }
             c=1;
          }
          JOptionPane.showMessageDialog(null,"Fichero actualizado con exito");
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error al leer del fichero");
        }
        finally {
          try {
            if (br != null) br.close();            
          }
          catch (IOException e) {
               JOptionPane.showMessageDialog(null,"Error al cerrar del fichero");
          }
        }



    }
    private void cargarVentas() {
          BufferedReader br = null;
          String linea; 

          try {          
          br = new BufferedReader(new FileReader(vents));
          //mientras halla lineas en el fichero de ventas
          while ((linea = br.readLine())!=null) {
             c=1;
             Scanner sc=new Scanner(linea);
             sc.useDelimiter("[:\r\n]");
             prod=new Producto();
             //mientras halla campos que leer
             while(sc.hasNext()){
                 String campo=sc.next();
                     /*si el producto esta en la lista enlazada
                     modificamos sus ventas*/
                         for (Producto p : listprod) {
                             
                             if(p.getCodigo()==Integer.valueOf(campo))
                             {
                                 p.setVentas(Integer.valueOf(sc.next()));
                             }
                         }

                 }

          }
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error al leer del fichero");
        }
        finally {
          try {
            if (br != null) br.close();            
          }
          catch (IOException e) {
            JOptionPane.showMessageDialog(null,"Error al cerrar el fichero");
          }
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jButton3 = new javax.swing.JButton();
        jTextField2 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Aceptar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Menu principal");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Actualizar Lista productos", "Visualizar productos", "Visualizar ventas" }));

        jButton3.setText("Buscar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel2.setText("Fichero articulos");

        jLabel3.setText("Fichero ventas");

        jButton2.setText("Buscar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(14, 14, 14)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField2)
                            .addComponent(jTextField1))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2)
                    .addComponent(jButton3)))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jComboBox1, 0, 246, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       switch(this.jComboBox1.getSelectedIndex())
       {
           case 0:
                
                this.cargarDatos();
                
           break;
           case 1:
                new VentanaSal(this.listprod).setVisible(true);
           break;
           case 2:
                
                this.cargarVentas();
                new VentanaSal(this.listprod).setVisible(true);
           break;
       }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        sel.showOpenDialog(sel);
        arts=sel.getSelectedFile();
        this.jTextField1.setText(arts.getPath());
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        sel.showOpenDialog(sel);
        vents=sel.getSelectedFile();
        this.jTextField2.setText(vents.getPath());
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
    // End of variables declaration//GEN-END:variables

    

    
}
