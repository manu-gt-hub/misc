

package prac_2psp2ev;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import javax.imageio.ImageIO;


public class ImgCanvas implements Serializable{
    public BufferedImage img;

    public ImgCanvas() {
        
    }
    
    private void writeObject(ObjectOutputStream out) throws IOException
    {
        
        out.writeObject(this);

    }
    
    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException
    {
        img=((ImgCanvas)in.readObject()).img;
    }
    
   
    
    
}
