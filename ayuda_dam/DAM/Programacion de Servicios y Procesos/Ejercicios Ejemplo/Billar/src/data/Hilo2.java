package data;

import GUI.MiPanel;
import GUI.Ventana;
import java.util.logging.Level;
import java.util.logging.Logger;

    public class Hilo2 implements Runnable {
        Bola b2;
        Ventana v;
        MiPanel p;
        Animacion a;
        int dist=1;

    public Hilo2(Bola b2, Ventana v, MiPanel p,Animacion a) {
        this.b2 = b2;
        this.v = v;
        this.a=a;
        this.p = p;
    }

        @Override
        public void run() {   
            while( dist>0)
            {
                try {
                    a.mover();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Animacion.class.getName()).log(Level.SEVERE, null, ex);
                }
                dist=a.energia;

                b2.x+=dist;
                p.repaint();
                try {
                    Thread.sleep(60);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Animacion.class.getName()).log(Level.SEVERE, null, ex);
                }
                dist--;
                a.energia=dist;   
            }  
        }
    }
