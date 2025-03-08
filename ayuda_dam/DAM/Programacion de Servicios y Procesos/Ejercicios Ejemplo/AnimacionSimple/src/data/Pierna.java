/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

/**
 *
 * @author Profesor
 */
public class Pierna{
    Point p1,p2;
    boolean turno;

    public Pierna(Point p1, Point p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    public void pintar(Graphics g) {
        Graphics2D gg=(Graphics2D)g;
        gg.setStroke(new BasicStroke(15));
        gg.drawLine(p1.x,p1.y,p2.x,p2.y);
    }

    void actualizar() {
        
        p1.x+=2;
        if(turno)
            p2.x+=5;        
        
        if(p1.x%75==0)
            turno=!turno;
        
        
    }
    
    
    
}
