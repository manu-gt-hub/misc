package GUI;

import data.Bola;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MiPanel extends JPanel{
    Bola bola;
    Bola bola2;
    Image imagen;

    public MiPanel(Bola bola, String img, Bola bola2) {
        this.bola = bola;
        this.imagen = new ImageIcon(img).getImage();
        this.bola2 = bola2;
    }

    @Override
    public void paint(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.drawImage(imagen,0,0,getWidth(),getHeight(), null);
        bola.dibujar(g2);
        bola2.dibujar(g2);
    }
}
