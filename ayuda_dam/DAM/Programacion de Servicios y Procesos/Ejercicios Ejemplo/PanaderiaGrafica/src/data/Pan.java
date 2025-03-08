/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author profesor
 */
public class Pan extends Sprite{
    
    enum TipoBarra{GALLEGA,HORNO,PICOS};
    TipoBarra tipo;

    public Pan(TipoBarra tipo,int xx, int yy) {
        super(null,xx,yy);
        this.tipo=tipo;        
        
        if(tipo== TipoBarra.GALLEGA) {
            img=new ImageIcon("img/loaf1.png").getImage();//loaf of bread=barra de pan
        }
        else
            if(tipo== TipoBarra.HORNO) {
            img=new ImageIcon("img/loaf2.png").getImage();
        }
            else {
            img=new ImageIcon("img/loaf3.png").getImage();
        }
        
        this.width=img.getWidth(null);
        this.height=img.getHeight(null);
        
    }
    
        
        
    
}