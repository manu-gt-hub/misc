package data;

import java.awt.Graphics;
import java.awt.Image;

/**
 *
 * @author profesor
 */
class Sprite extends java.awt.Rectangle{
    protected Image img;            
    
    protected Sprite(Image img, int x, int y){
        this.img=img;
        this.x=x;
        this.y=y;
        if(img!=null){
            this.width=img.getWidth(null);
            this.height=img.getHeight(null);
        }
    }
    
     void pintar(Graphics g) {
        g.drawImage(img, x,y, null);
    }
}
