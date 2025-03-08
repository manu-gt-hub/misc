package data;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author profesor
 */
public class PanelPantalla extends javax.swing.JPanel {    
    

    private Ventana v;
    private Image fondo=new ImageIcon("img/fondo.jpg").getImage();
    
    public PanelPantalla(Ventana v) {
        this.setLayout(null);
        this.v=v;
        this.setSize(v.getSize());
    }
    
    

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(fondo, 0,0,this.getWidth(),this.getHeight(), this);
        
       
        v.horno.pintar(g);
        
        v.bandeja.pintar(g);
        
        for (Cliente c : v.listaClientes) {
            c.pintar(g);
        }
                
        v.panadera.pintar(g);
    }
    
    
    
    


    

}
//:~)