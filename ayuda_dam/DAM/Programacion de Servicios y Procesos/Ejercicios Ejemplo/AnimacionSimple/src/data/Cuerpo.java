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
public class Cuerpo extends Rectangle{

    public Cuerpo(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    void actualizar() {
        this.x+=2;
    }

    public void pintar(Graphics g) {
        g.fillRect(x, y, width, height);
    }
    
    
    
}
