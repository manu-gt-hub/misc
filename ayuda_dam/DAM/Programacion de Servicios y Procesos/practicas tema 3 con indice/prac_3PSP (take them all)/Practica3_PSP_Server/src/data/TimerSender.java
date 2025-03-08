
package data;

import GUI.Ventana;
import static data.Protocol.*;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;


/*hilo encargado de enviar los "regalos" a traves de la red
a los clientes*/
public class TimerSender extends Thread{

    int time;
    Ventana ven;
    Random rand;
    int alto;
    int ancho;
    ClientHandler handler;
    

    public TimerSender(float ti,Ventana v,int w,int h) {
        alto=h;
        ancho=w;
        rand=new Random();
        this.time = (int)(ti*1000);
        this.ven=v;
    }
    
    @Override
    public void run() {
        
        
        while(true)
        {
            handler=ven.getClientHandler();
            if(handler!=null)
            {

                handler.handleMessage(MSG_SEND_POSITION+"|"+rand.nextInt(7)+"|"+rand.nextInt(alto-30)+"|"+rand.nextInt(ancho-30));
                
            }
            try {
                Thread.sleep(time);

            } catch (Exception ex) {
                Logger.getLogger(TimerSender.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
        }
    }
    public void setTime(int t)
    {
        this.time=t;
    }
    
}
