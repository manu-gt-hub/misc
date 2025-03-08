package data;

import GUI.MiPanel;
import java.util.logging.Level;
import java.util.logging.Logger;

    public class Hilo1 implements Runnable {
        Bola b1;
        Bola b2;
        MiPanel p;
        Animacion a;
    
    public Hilo1(Bola b1, Bola b2,MiPanel p,Animacion a) {
        this.b1 = b1;
        this.b2 = b2;
        this.p=p;
        this.a=a;
    }
        int dist=30;
        
        @Override
        public void run() {
            //while(b1.x<b2.x-50)
            while(dist>0)
            {
                b1.x+=dist;
                p.repaint();
                try   {
                    Thread.sleep(60);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Animacion.class.getName()).log(Level.SEVERE, null, ex);
                }
                dist--;
                if(b1.x>b2.x-50)
                {
                    a.chocar(dist);
                    dist-=4;
                }
            }  
        }
    }
