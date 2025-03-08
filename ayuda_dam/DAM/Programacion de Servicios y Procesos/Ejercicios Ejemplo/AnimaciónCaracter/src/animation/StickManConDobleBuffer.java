package animation;

import java.awt.*;
import java.awt.event.*;
import javax.swing.JFrame;

public class StickManConDobleBuffer extends JFrame implements Runnable {

    final int SCREEN_WIDTH = 400;
    final int SCREEN_HEIGHT = 400;

    private long tiempoTotalAnim=5000;
    private Thread animation;
    private int frameDelay = 100;
    private Image frames[];
    private int currentFrame = 0;   
    
    private Image dbImage;
    private Graphics2D dbg=null;
    

 public static void main(String args[]) throws InterruptedException {
    StickManConDobleBuffer app = new StickManConDobleBuffer();
    app.setVisible(true);
    app.setLocationRelativeTo(null);
    Thread.sleep(1000);
    app.iniciarAnimación();    
 }

 public StickManConDobleBuffer() {
      super("Graphic Animation");
      setSize(SCREEN_WIDTH,SCREEN_HEIGHT);
      addWindowListener(new WindowEventHandler());

      //Cargo las imágenes
      Toolkit toolkit = getToolkit();
      frames = new Image[4];
      frames[0] = toolkit.getImage("img/stickman1.gif");
      frames[1] = toolkit.getImage("img/stickman2.gif");
      frames[2] = toolkit.getImage("img/stickman3.gif");
      frames[3] = toolkit.getImage("img/stickman4.gif");
 }

    @Override
     public void paint(Graphics g) {
        gameRender();
        if(dbImage!=null)
            g.drawImage(dbImage, 0,0, this);
     }
    
    //Dibujo sobre una imagen (Doble buffer)
    private void gameRender(){// draw the current frame to an image buffer
       
        if (dbImage == null){ // create the buffer
            dbImage = this.createImage(this.getWidth(),this.getHeight()  );//Método heredado de java.awt.Component
            if (dbImage == null) {
                System.out.println("dbImage is null");
                return;
            }else{
                dbg = (Graphics2D) dbImage.getGraphics();
                System.out.println("iiiii");
            }
        }        
       
        //dbg.clearRect(0,0,this.SCREEN_WIDTH,this.SCREEN_HEIGHT);
        dbg.setColor(Color.red);
        dbg.fillRect(0,0,this.getWidth(),this.getHeight());
        dbg.drawImage(frames[currentFrame],125,80,this);
        

    } // end of gameRender()
    
     
    

 //Hilo q repre la animación
    @Override
     public void run() {
      long inicio;
      inicio=System.currentTimeMillis();
      boolean sw=true;
      do {       
            repaint();
            try {
             Thread.sleep(frameDelay);
            }catch(InterruptedException ex){
            }
            if(sw)
                ++currentFrame;
            else
                --currentFrame;
            
            if(currentFrame>=(frames.length-1)||currentFrame<=0)
                sw=!sw;            
            
      } while (System.currentTimeMillis()<inicio+this.tiempoTotalAnim);
     }

    private void iniciarAnimación() {
      animation = new Thread(this);
      animation.start();
    }
 
 class WindowEventHandler extends WindowAdapter {
  @Override
  public void windowClosing(WindowEvent e){
   System.exit(0);
  }
 }
}
