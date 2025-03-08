
package prac_2psp2ev;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.IOException;
import java.util.Timer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Ventana extends javax.swing.JFrame {


    MiCanvas canvas=null;
    JTextField camp1;
    JTextField camp2;
    public Ventana() {
        
        miinitComponents();
        this.setTitle("practica 2 PSP");
        this.setSize(800,600);
        this.setLocationRelativeTo(null);
        
        Image im = Toolkit.getDefaultToolkit().createImage("pincel.png"); 
        Cursor cur = Toolkit.getDefaultToolkit().createCustomCursor(im, new Point(10,24),""); 
        setCursor(cur); 


    }

    public synchronized void dibujar(Image img) throws InterruptedException {
       MiCanvas c=this.getCanvas();
       c.getGraphics().drawImage(img,c.getWidth(),c.getHeight(), this);
       this.repaint();
    }
    public MiCanvas getCanvas()
    {
        return this.canvas;
    }
    
    private void miinitComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        canvas = new MiCanvas();
        
        
        canvas.addMouseMotionListener(new MouseMotionListener() {

            @Override
            public void mouseDragged(MouseEvent e) {
                canvas.pintar(e.getPoint());
                
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                
            }

           


        });
        canvas.addMouseListener(new MouseAdapter() {


            @Override
            public void mouseReleased(MouseEvent e) {
                canvas.libPunto();
            }


        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        JPanel cabecera=new JPanel();
        cabecera.setLayout(new GridLayout(2,1));
        
        
        JPanel control=new JPanel();
        control.setLayout(new FlowLayout());
        JLabel label1=new JLabel();
        label1.setText("IP: ");
        control.add(label1);
        camp1= new JTextField();
        camp1.setColumns(12);
        control.add(camp1);
        camp1.setText("192.168.1.193");
        
        JLabel label2=new JLabel();
        label2.setText("Puerto: ");
        control.add(label2);
        
        
        camp2= new JTextField();
        control.add(camp2);
        camp2.setColumns(5);
        camp2.setText("8888");

        cabecera.add(control);
        cabecera.add(jPanel1);
        jPanel1.setLayout(new java.awt.GridLayout(1,6));

        JButton nuevo=new JButton();
        nuevo.setText("nuevo lienzo");
        nuevo.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                 canvas.nuevoLienzo();
            }
        });
        jPanel1.add(nuevo);
        
        
        JButton camb_fondo =new JButton();
        camb_fondo.setText("color fondo");
        camb_fondo.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JColorChooser Selectorcolor=new JColorChooser();
                 Color color=Selectorcolor.showDialog(null, "Seleccione un Color", Color.BLUE);
                 canvas.cambiarFondo(color);
            }
        });
        jPanel1.add(camb_fondo);
        
        
        jButton1.setText("Color");
        jButton1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                 JColorChooser Selectorcolor=new JColorChooser();
                 Color color=Selectorcolor.showDialog(null, "Seleccione un Color", Color.BLUE);
                 canvas.cambioColor(color);
            }
        });
        jPanel1.add(jButton1);

        final JComboBox combo=new JComboBox();
        for (int i = 1; i < 40; i++) {
            combo.addItem(i);
            
        }
     
        combo.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                int n=(int)combo.getSelectedItem();
                canvas.cambioTrazo(n);
            }
        });
        jPanel1.add(combo);

        jButton3.setText("Borrar");
        jButton3.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                canvas.borrar();
            }
        });
        jPanel1.add(jButton3);

        jButton4.setText("Guardar");
        jButton4.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    canvas.guardarImagen();
                } catch (IOException ex) {
                    Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        jPanel1.add(jButton4);

        jButton5.setText("Cargar");
        jButton5.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    canvas.cargarImagen();
                } catch (IOException ex) {
                    Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        jPanel1.add(jButton5);

        getContentPane().add(cabecera, java.awt.BorderLayout.NORTH);

        jPanel2.setLayout(new javax.swing.BoxLayout(jPanel2, javax.swing.BoxLayout.LINE_AXIS));
        jPanel2.add(canvas);
        
        

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        Timer sender = new Timer();
        sender.schedule(new TimerEnvio(camp1.getText(),camp2.getText(),canvas,this),0,100);
        
        pack();
    }
    /*
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        canvas1 = new java.awt.Canvas();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new java.awt.GridLayout(5, 1));

        jButton1.setText("Color");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);

        jButton2.setText("Trazo");
        jPanel1.add(jButton2);

        jButton3.setText("Borrar");
        jPanel1.add(jButton3);

        jButton4.setText("Guardar");
        jPanel1.add(jButton4);

        jButton5.setText("Cargar");
        jPanel1.add(jButton5);

        getContentPane().add(jPanel1, java.awt.BorderLayout.LINE_START);

        jPanel2.setLayout(new javax.swing.BoxLayout(jPanel2, javax.swing.BoxLayout.LINE_AXIS));
        jPanel2.add(canvas1);

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed
*/
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Canvas canvas1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables

    String getPuerto() {
        return camp2.getText();
    }

    String getIp() {
        return camp1.getText();
    }
}
