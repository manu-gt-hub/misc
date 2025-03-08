package GUI;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class PanelFondo extends JPanel
{
    Image fondo;
    private Graphics g;

    public PanelFondo(String ruta)
    {
        this.setOpaque(false);
        fondo = new ImageIcon((System.getProperty("user.dir")+"\\res\\imgs\\"+ruta+".JPG")).getImage();
    }

    
    public void repintar(String ruta)
    {
        fondo = new ImageIcon((System.getProperty("user.dir")+"\\res\\imgs\\"+ruta+".JPG")).getImage();
        repaint();
    }
    @Override
    public void paint(Graphics g)
    {
        g.drawImage(fondo,0,0,this.getWidth(),this.getHeight(),this);
        super.paint(g);
    }
    
}
