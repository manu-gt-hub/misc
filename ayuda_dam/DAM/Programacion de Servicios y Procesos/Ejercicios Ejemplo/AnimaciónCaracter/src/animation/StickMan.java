package animation;

import java.awt.*;
import java.awt.event.*;
import javax.swing.JFrame;

public class StickMan extends JFrame implements Runnable {

    final int SCREEN_WIDTH = 400;
    final int SCREEN_HEIGHT = 400;

    private long tiempoTotalAnim=3000;
    private Thread animation;
    private int frameDelay = 100;
    private Image frames[];
    private int currentFrame = 0;   
    

 public static void main(String args[]) throws InterruptedException {
    StickMan app = new StickMan();
    app.setVisible(true);
    Thread.sleep(1000);
    app.iniciarAnimación();
 }

 public StickMan() {
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
        g.clearRect(0,0,this.SCREEN_WIDTH,this.SCREEN_HEIGHT);
        g.drawImage(frames[currentFrame],125,80,this);
     }

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
