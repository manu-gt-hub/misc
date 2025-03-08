
package prac_2psp2ev;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.naming.Context;
import javax.swing.JFileChooser;


public class MiCanvas extends Canvas {

    Point p=null;
    Point p2;
   
    ImgCanvas imagen_Act;
    Graphics2D g2;
    Color c;
    private boolean acc_img=true;
    public MiCanvas() 
    {
        
        this.setBackground(new Color(220,220,185));
      
        imagen_Act = new ImgCanvas();
        
        
    }

    public void paint (Graphics g)
    {
        g.clearRect(0,0,this.getWidth(),this.getHeight());

        
        g.drawImage(imagen_Act.img,0,0,this.getWidth(),this.getHeight(), this);

        
    } 

    public void cambioColor(Color c) {
        this.c=c;

    }

    public void pintar(Point point) 
    {
    
        if(c==null)
        {
            c=new Color(0,0,0);
        }
        if(p==null)
        {
            
            p=new Point(point.x,point.y);
        }
        if(g2==null)
        {


           
            imagen_Act.img = new BufferedImage(this.getWidth(),this.getHeight(), BufferedImage.TRANSLUCENT);
            g2=(Graphics2D)imagen_Act.img.getGraphics();
            
            

        }
        else
        {
                
                g2.setColor(c);
                //g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_IN,1));
                g2.drawLine(p.x,p.y,point.x,point.y);
                this.getGraphics().drawImage(imagen_Act.img,0,0,this.getWidth(),this.getHeight(), this);
                
                
                
               
                
                p=point;
  
        }
        
        
        
        
    }

    void cambioTrazo(int n) {
        if(g2==null)
        {
            if(imagen_Act.img==null)
            {
               
                imagen_Act.img = new BufferedImage(this.getWidth(),this.getHeight(), BufferedImage.TRANSLUCENT);
            }
            g2=(Graphics2D)imagen_Act.img.getGraphics();
            g2.setStroke(new BasicStroke(n));
            

        }
        else
        {
            g2.setStroke(new BasicStroke(n));
  
        }
       
        
    }

    void libPunto() {
        p=null;
    }

    void nuevoLienzo()
    {
        if(g2==null)
        {
            if(imagen_Act.img==null)
            {
                imagen_Act.img = new BufferedImage(this.getWidth(),this.getHeight(), BufferedImage.TRANSLUCENT);
            }
            g2=(Graphics2D)imagen_Act.img.getGraphics();
        }
        g2.setColor(new Color(220,220,185));
        g2.fillRect(0,0,this.getWidth(),this.getHeight());
        
        this.repaint();
       
    }

    void borrar() {
        c=new Color(220,220,185);
    }
    
    void cargarImagen() throws IOException
    {
        
        JFileChooser chooser = new JFileChooser();

        chooser.setCurrentDirectory(new java.io.File("."));

        chooser.setDialogTitle("Seleccione imagen");


        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) 
        {
        
            this.nuevoLienzo();

            /*
            Image img=ImageIO.read(chooser.getSelectedFile()).getScaledInstance(this.getWidth(),this.getHeight(),Image.SCALE_SMOOTH);
            imagen = (BufferedImage) img;
            */
            imagen_Act.img=ImageIO.read(chooser.getSelectedFile());

            g2=(Graphics2D)imagen_Act.img.getGraphics();

            //g2.drawImage(imagen,0,0,this.getWidth(),this.getHeight(), this);
            this.repaint();
     

        } 
        else 
        {

            System.out.println("No seleccion ");

        }

        
    }
    void guardarImagen() throws IOException
    {
        JFileChooser chooser = new JFileChooser();

        chooser.setCurrentDirectory(new java.io.File("."));

        chooser.setDialogTitle("Seleccione imagen");


        if (chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {

           ImageIO.write(imagen_Act.img, "JPG", new File(chooser.getSelectedFile().getName()));
     

        } else {

            System.out.println("No seleccion ");

        }
       
    }
    public void setImagen(BufferedImage i) throws InterruptedException
    {
        while(!acc_img)
        {
            this.wait();
        }
        acc_img=false;
     
        this.imagen_Act.img=i;
        acc_img=true;
        notifyAll();

    }
    void cambiarFondo(Color color) {
        this.setBackground(color);
    }
    public ImgCanvas getImagen()
    {
        return this.imagen_Act;
    }

}
