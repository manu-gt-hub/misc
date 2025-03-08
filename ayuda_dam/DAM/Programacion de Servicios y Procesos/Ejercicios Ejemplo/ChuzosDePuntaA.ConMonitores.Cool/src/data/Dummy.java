/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

/**
 *
 * @author Profesor
 */
public class Dummy {
    private Rectangle cuerpo;
    private Circle cabeza;

    int getHeight() {
        return cuerpo.height+(cabeza.r *2);
    }
    
    class Circle{
        Point pos;
        int r;
        public Circle(Point pos, int r) {
            this.pos = pos;
            this.r = r;
        }
    }
    
    /**
     * Ctor oficial 
     * @param p pto inicial del objeto
     * @param d tam inicial del obj
     */
    public Dummy(Point p, Dimension d) 
    {
        cuerpo=new Rectangle(p,d);
        cabeza=new Circle(new Point(p.x,p.y-d.height),d.height/2);
    }
    
    
    public Dummy(int x, int y, int ancho, int alto)
    {        
        this(new Point(x,y),new Dimension(ancho, alto));        
    }
    
    void moverHaciaDcha() {
        cuerpo.x++;    
        cabeza.pos.x++;
    }
    
    /**
     * Mueve el objeto 1 px hacia abajo
     */
    public void moverHaciaAbajo()
    {
        cuerpo.y++;    
        cabeza.pos.y++;
    }
    
    /**
     * Mueve el objeto los pixels q le indique (hacia abajo)
     * @param xx 
     */
    public void moverHaciaAbajo(int xx)
    {
        cuerpo.y+=xx;    
        cabeza.pos.y+=xx;
    }
    
    public void pintar(Graphics g){    
        g.fillRect(cuerpo.x, cuerpo.y, cuerpo.width,cuerpo.height);    
        g.fillOval(cabeza.pos.x, cabeza.pos.y, cabeza.r*2,cabeza.r*2);
    }
    
    
    
    public Point getPos(){
        return cabeza.pos;
    
    }
    
    public void setPos(int x, int y){
        cabeza.pos=new Point(x,y);    
        cuerpo.x=x;
        cuerpo.y=cabeza.pos.y+(cabeza.r*2);
    }
    
}
