package GUI;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class PanelFondo extends JPanel
{
    Ventana v;
    Image fondo = new ImageIcon((System.getProperty("user.dir")+"\\res\\imgs\\fondo.jpg")).getImage();
    Image pelota = new ImageIcon((System.getProperty("user.dir")+"\\res\\imgs\\pelota.gif")).getImage();
    public PanelFondo(Ventana v)
    {
        this.v=v;
        this.setOpaque(false);
    }
    
    @Override
    public void paint(Graphics g)
    {
        g.drawImage(fondo,0,0,this.getWidth(),this.getHeight(),this);
        g.drawRect(250,150,70,70);
        g.drawImage(pelota,v.getx(),v.gety(),40,40,this);
        super.paint(g);
    }
}
