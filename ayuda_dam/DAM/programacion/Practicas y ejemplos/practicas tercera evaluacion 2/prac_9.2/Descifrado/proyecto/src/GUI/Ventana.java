
package GUI;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import prac_descifrados.Main;


public class Ventana extends javax.swing.JFrame {

    JFileChooser sel;
    Main ap;
    File origen;
    File destino;
    String texto="";
    public Ventana(Main ref) throws IOException {
        initComponents();
        ap=ref;
        sel=new JFileChooser();
        this.setLocationRelativeTo(null);
        this.jTextArea1.setEditable(false);
        this.setTitle("Descifrador");
        
    }
    @SuppressWarnings("unchecked")
    public void descifrar(File o,File d) throws IOException
    {
        String outpath=d.getPath();
        String inpath=o.getPath();
        FileInputStream in= null;
        FileOutputStream out= null;
        LinkedList<Character> cars=new LinkedList();
            out = new FileOutputStream(outpath);
            int c=0,caracteres=0,cont=0;
            char car;
                texto+="\n --- SUMA CARACTERES--- \n";
                this.jTextArea1.setText(texto);
                //System.out.println("\n --- SUMA CARACTERES--- ");
                for (int i=1; i < 128; i++) {
                    in = new FileInputStream(inpath);
                    //in = new FileInputStream("prueba1.txt");
                    //in = new FileInputStream("prueba2.txt");
                    while ((c=in.read())!=-1)
                    {
                          car=(char)(c+i);
                          if((car>='a' && car<='z' ) || (car>='A' && car<='Z') || car==' ' || (car>='0' && car<='9'))
                          {
                              cars.add(car);
                              cont++; 
                              
                          }
                          caracteres++;
                    }
                    if(cont==caracteres) 
                    {
                        texto+="car+"+i+" -> ";
                        this.jTextArea1.setText(texto);
                        //System.out.print("car+"+i+" -> ");
                        for (Character caract: cars) {
                            texto+=caract;
                            this.jTextArea1.setText(texto);
                            //System.out.print(caract);
                            out.write(caract);
                        }
                        texto+="\n";
                        this.jTextArea1.setText(texto);
                        //System.out.println("");
                    }
                    
                    cars.clear();
                    caracteres=0;
                    cont=0;
                    
                }
                texto+="\n --- RESTA CARACTERES--- \n";
                this.jTextArea1.setText(texto);
                //System.out.println("\n --- RESTA CARACTERES--- ");
                for (int i = 127; i >0; i--) {
                    in = new FileInputStream(inpath);
                    //in = new FileInputStream("prueba1.txt");
                    //in = new FileInputStream("prueba2.txt");
                    while ((c=in.read())!=-1)
                    {

                          car=(char)(c-i);
                          if((car>='a' && car<='z' ) || (car>='A' && car<='Z') || car==' ' || (car>='0' && car<='9'))
                          {
                              cars.add(car);
                              cont++;
                              
                          }
                          caracteres++;
                    }
                    if(cont==caracteres) 
                    {
                        texto+="car-"+i+" -> ";
                        this.jTextArea1.setText(texto);
                        //System.out.print("car-"+i+" -> ");
                        for (Character caract: cars) {
                            texto+=caract;
                            this.jTextArea1.setText(texto);
                            //System.out.print(caract);
                            out.write(caract);
                        
                        }
                        texto+="\n";
                        this.jTextArea1.setText(texto);
                        //System.out.println("");
                    }
                    cars.clear();
                    caracteres=0;
                    cont=0;
                    
                }
                texto+="\n --- SUMA VOCALES Y RESTA CONSONANTES --- \n";
                this.jTextArea1.setText(texto);
                //System.out.println("\n --- SUMA VOCALES Y RESTA CONSONANTES --- ");
                for (int i = 1; i <128; i++) {
                    in = new FileInputStream(inpath);
                    //in = new FileInputStream("prueba1.txt");
                    //in = new FileInputStream("prueba2.txt");
                    while ((c=in.read())!=-1)
                    {
                        
                      car=(char)(c+i);
                      if(car=='a' || car=='e' || car=='i' || car=='o' || car=='u'
                      || car=='A' || car=='E' || car=='I' || car=='O' || car=='U')
                      {
                          cars.add(car);
                          cont++;
                      }    
                      else
                      {
                          car=(char)(c-i);
                          if(((car>='a' && car<='z' ) || (car>='A' && car<='Z')) && 
                              (car!='a' && car!='e' && car!='i' && car!='o' && car!='u'
                            && car!='A' && car!='E' && car!='I' && car!='O' && car!='U'))
                          {
                              cars.add(car);
                              cont++;
                          } 
                          else
                          {
                              if((car>='0' && car<='9')||(car+(i*2)>='0' && car+(i*2)<='9')||car==' '||car+(i*2)==' ')
                              {
                                  cars.add(car);
                                  cont++;
                              }
                          }
                      }
                      caracteres++;
                        
                    }
                    if(cont==caracteres) 
                    {
                        texto+="voc +"+i+", const. -"+i+" -> ";
                        this.jTextArea1.setText(texto);
                        //System.out.print("voc +"+i+", const. -"+i+" -> ");
                        for (Character caract: cars) {
                            texto+=caract;
                            this.jTextArea1.setText(texto);
                            //System.out.print(caract);
                            out.write(caract);
                        
                        }
                        texto+="\n";
                        this.jTextArea1.setText(texto);
                        //System.out.println("");
                    }
                    cars.clear();
                    caracteres=0;
                    cont=0;
                }
                texto+="\n --- RESTA VOCALES Y SUMA CONSONANTES --- \n";
                this.jTextArea1.setText(texto);
                //System.out.println("\n --- RESTA VOCALES Y SUMA CONSONANTES --- ");
                for (int i = 1; i <128; i++) {
                    in = new FileInputStream(inpath);
                    //in = new FileInputStream("prueba1.txt");
                    //in = new FileInputStream("prueba2.txt");
                    while ((c=in.read())!=-1)
                    {
                        
                      car=(char)(c-i);
                      
                      if(car=='a' || car=='e' || car=='i' || car=='o' || car=='u'
                      || car=='A' || car=='E' || car=='I' || car=='O' || car=='U')
                      {
                          cars.add(car);
                          cont++;
                      }    
                      else
                      {
                          car=(char)(c+i);
                          if(((car>='a' && car<='z' ) || (car>='A' && car<='Z')) && 
                              (car!='a' && car!='e' && car!='i' && car!='o' && car!='u'
                            && car!='A' && car!='E' && car!='I' && car!='O' && car!='U'))
                          {
                              cars.add(car);
                              cont++;
                          } 
                          else
                          {
                              if((car>='0' && car<='9')||(car-(i*2)>='0' && car-(i*2)<='9')||car==' '||car-(i*2)==' ')
                              {
                                  cars.add(car);
                                  cont++;
                              }
                          }
                      }
                      caracteres++;
                        
                    }
                    
                    if(cont==caracteres) 
                    {
                        texto+="voc -"+i+", const. +"+i+" -> ";
                        this.jTextArea1.setText(texto);
                        //System.out.print("voc -"+i+", const. +"+i+" -> ");
                        for (Character caract: cars) {
                            texto+=caract;
                            this.jTextArea1.setText(texto);
                            //System.out.print(caract);
                            out.write(caract);
                        
                        }
                        texto+="\n";
                        this.jTextArea1.setText(texto);
                        //System.out.println("");
                    }
                    cars.clear();
                    caracteres=0;
                    cont=0;
                }
            
            if(in!=null)
            {
                in.close();
            }
            if(out!=null)
            {
                out.close();
            }
            
        
    }
        
 

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jTextField1 = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Seleccione el archivo de origen");
        jLabel1.setToolTipText("");

        jButton3.setText("Descifrar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton2.setText("Buscar");
        jButton2.setActionCommand("Buscar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setText("Seleccione el archivo de destino");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton3)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(23, 23, 23)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3)
                .addGap(43, 43, 43))
        );

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jLabel3.setText("Resultados");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        sel.showOpenDialog(sel);
        origen=sel.getSelectedFile();
        this.jTextField1.setText(origen.getPath());
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        sel.showOpenDialog(sel);
        destino=sel.getSelectedFile();
        this.jTextField2.setText(destino.getPath());
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if(destino!=null && origen!=null)
        {
            try {
                descifrar(origen, destino);
            } catch (IOException ex) {
                Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null,"Seleccione un fichero de origen\ny otro de destino");
        }
        
        
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * @param args the command line arguments
     */
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
