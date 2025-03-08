/*
 EJEMPLO DE ANIMACIÓN TEXTUAL-->un conj de * forman una animación sencilla

 */

package animation;

import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JFrame;




public final class CaracterAnimationApp extends JFrame implements Runnable {    
    private Thread animation;
    private final int FRAME_DELAY = 200;
    private String frames[] = {"*","**","***","****","*****","****","***","**","*"};    
    private int currentFrame = 0;
    
    private final int SCREEN_WIDTH = 400;
    private final int SCREEN_HEIGHT = 200;

    private static long DURACION_ANIMACION=10000;//la animación se verá durante 3 segundos
    static boolean finAnimacion=false;    
    

    public static void main(String args[]) throws InterruptedException {
        CaracterAnimationApp a=new CaracterAnimationApp();
        a.iniciarAnimación();
        Thread.sleep(DURACION_ANIMACION);
        CaracterAnimationApp.finAnimacion=true;
        a.dispose();
    }    


    public CaracterAnimationApp() {
      super("Simple Animation");      
      setSize(SCREEN_WIDTH,SCREEN_HEIGHT);
      setFont(new Font("default",Font.BOLD,50));
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setVisible(true);
    }
    
    public void iniciarAnimación(){
        animation = new Thread(this);
        animation.start();
    }

   



    @Override
    public void paint(Graphics g) {
        //Borro pantalla
        g.clearRect(0,0,400,400);

        //Dibujo
        g.drawString(frames[currentFrame],60,160);
    }


    @Override
    public void run() {
    do {
            //Actualizo
            currentFrame=currentFrame%frames.length;
            /*O:
             if(currentFrame>=frames.length)
                currentFrame=0;
            else
                currentFrame++;*/
            repaint();

            try {
                Thread.sleep(FRAME_DELAY);
            }catch(InterruptedException ex){}
            currentFrame++;
            
       
    } while (!finAnimacion);
 }
 
}
