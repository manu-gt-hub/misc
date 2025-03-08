
package prac_2pspserver;

import java.awt.BasicStroke;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;


public class MiCanvas extends Canvas {

    Point p=null;
    Point p2;
    ImgCanvas imagen;
    Graphics2D g2;
    Color c;
    boolean acc_img=true;
    public MiCanvas() 
    {
        
        this.setBackground(new Color(220,220,185));
        imagen = new ImgCanvas();
        
        
    }

    public void paint (Graphics g)
    {
        g.clearRect(0,0,this.getWidth(),this.getHeight());

           g.drawImage(imagen.img,0,0,this.getWidth(),this.getHeight(), this);

        
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


            //g2=(Graphics2D)this.getGraphics();
            imagen.img = new BufferedImage(this.getWidth(),this.getHeight(), BufferedImage.TRANSLUCENT);
            g2=(Graphics2D)imagen.img.getGraphics();
            
            

        }
        else
        {
                
                g2.setColor(c);
                g2.drawLine(p.x,p.y,point.x,point.y);
            
                
                this.getGraphics().drawImage(imagen.img,0,0,this.getWidth(),this.getHeight(), this);
                
                 p=point;
  
        }
        
        
        
        
    }

    void cambioTrazo(int n) {
        if(g2==null)
        {
            if(imagen==null)
            {
                imagen.img = new BufferedImage(this.getWidth(),this.getHeight(), BufferedImage.TRANSLUCENT);
            }
            g2=(Graphics2D)imagen.img.getGraphics();
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
            if(imagen==null)
            {
                imagen.img = new BufferedImage(this.getWidth(),this.getHeight(), BufferedImage.TRANSLUCENT);
            }
            g2=(Graphics2D)imagen.img.getGraphics();
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
            imagen.img=ImageIO.read(chooser.getSelectedFile());

            g2=(Graphics2D)imagen.img.getGraphics();

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

           ImageIO.write(imagen.img, "JPG", new File(chooser.getSelectedFile().getName()));
     

        } else {

            System.out.println("No seleccion ");

        }
       
    }

    void cambiarFondo(Color color) {
        this.setBackground(color);
    }
    public synchronized BufferedImage getImagen() throws InterruptedException
    {
        while(!acc_img)
        {
            this.wait();
        }
        acc_img=false;
        BufferedImage i= this.imagen.img;
        acc_img=true;
        notifyAll();
        return i;
    }
    public synchronized void setImagen(BufferedImage i) throws InterruptedException
    {
        
        while(!acc_img)
        {
            this.wait();
        }
        acc_img=false;
        this.imagen.img=i;
        acc_img=true;
        notifyAll();

    }

}
