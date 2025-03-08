

package prac_2pspserver;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import javax.imageio.ImageIO;


public class ImgCanvas implements Serializable{
    public BufferedImage img;
    boolean acc_canvas=true;

    public ImgCanvas() {
        
    }
    
    private void writeObject(ObjectOutputStream out) throws IOException, InterruptedException
    {

        out.writeObject(this);
      
    }
    
    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException, InterruptedException
    {

        img=((ImgCanvas)in.readObject()).img;
      
    }
    
   
    
    
}
