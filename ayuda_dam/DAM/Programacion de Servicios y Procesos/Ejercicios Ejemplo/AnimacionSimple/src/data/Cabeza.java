/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author Profesor
 */
public class Cabeza extends Rectangle{

    boolean turno=false;
    
    public Cabeza(int x, int y, int width, int height) {
        super(x, y, width, height);
    }
    
    public void pintar(Graphics g) {
        g.fillOval(x, y, width, height);
    }

    void actualizar() {
        if(turno){
            x-=5;            
        }else
            x+=9;        
        turno=!turno;
    }
    
}
