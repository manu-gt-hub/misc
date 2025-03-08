/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import GUI.MiPanel;
import GUI.Ventana;
import java.awt.Point;

/**
 *
 * @author Profesor
 */
public class Main {
        public static void main(String args[]) {
            /* Set the Nimbus look and feel */
            //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
            /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
             * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
             */
            try {
                for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                    if ("Nimbus".equals(info.getName())) {
                        javax.swing.UIManager.setLookAndFeel(info.getClassName());
                        break;
                    }
                }
            } catch (ClassNotFoundException ex) {
                java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (InstantiationException ex) {
                java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (javax.swing.UnsupportedLookAndFeelException ex) {
                java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
            //</editor-fold>

            /* Create and display the form */
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    Ventana v=new Ventana();
                    Cuerpo cuerpo=new Cuerpo(100,100,100,100);
                    Cabeza cabeza=new Cabeza(125,50,50,50);
                    Pierna p1=new Pierna(new Point(120,200),new Point(80,300));
                    
                    
                    v.setContentPane(new MiPanel(cuerpo,cabeza,p1));
                    Animacion a=new Animacion(v,cuerpo,cabeza,p1);                    
                    
                    v.setSize(800,400);
                    v.setLocationRelativeTo(null);
                    v.setVisible(true);
                    a.start();
                }
            });
        }    
}
