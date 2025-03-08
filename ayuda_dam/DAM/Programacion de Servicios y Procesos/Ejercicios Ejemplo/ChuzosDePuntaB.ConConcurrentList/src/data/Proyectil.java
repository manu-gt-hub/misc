package data;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;

/**
 *
 * @author Profesor
 */
public class Proyectil {
    private Point pos;//posición de la imagen dentro de la pantalla
    private Dimension tam;
    private Image img;
    private static String IMG="bullet.png";
    private float vy=1f;//Velocidad en y
    private boolean vUniforme;

    public Proyectil(int x, int y,boolean vUniforme) {
        this(x,y,-1,-1,vUniforme);
    }
    
    public Proyectil(int x, int y, int ancho, int alto,boolean vUniforme) {        
        img = Main.cargarImagen(IMG);        
        if(ancho<0 || alto<0) {
            tam=new Dimension(img.getWidth(null),img.getHeight(null));
        }
        else {
            tam=new Dimension(ancho, alto);
        }
        this.pos=new Point(x,y);       
        this.vUniforme=vUniforme;
        
    }
    
    Rectangle getBounds() {        
        return new Rectangle(pos.x,pos.y,tam.width, tam.height);
    }
    
    /**
     * Mueve el proyectil 1 px hacia abajo
     */
    public void moverHaciaAbajo()
    {
        float avance=1;
        if(vUniforme) {
            avance=vy;
        }
        else {
            if(this.pos.y<=0)
               this.pos.y=1;             
            avance=(this.pos.y*vy)/100;                
        }
        if(avance<1) avance=1;
        
        this.pos.y+=avance;       
    }
    
    public void pintar(Graphics g){    
        g.drawImage(img, pos.x, pos.y, tam.width, tam.height, null);        
    }

    public void setVy(float vy) {
        this.vy = vy;
    }

    public float getVy() {
        return vy;
    }
    
    
    
    
}
