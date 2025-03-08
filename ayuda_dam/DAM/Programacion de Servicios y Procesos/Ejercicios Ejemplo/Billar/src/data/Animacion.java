package data;

import GUI.MiPanel;
import GUI.Ventana;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Animacion {
    Bola b1;
    Bola b2;
    MiPanel p;
    int energia;
    static Boolean choque=false;
    Ventana v;
    
    public synchronized  void mover() throws InterruptedException
    {
        while(choque==false)
        {
            this.wait();
        }
    }
    public synchronized void chocar(int e)
    {
        choque=true;
        energia=e;
        notifyAll();
    }
  
    public Animacion(Bola b1, Bola b2,MiPanel p,Ventana v) {
        this.b1 = b1;
        this.b2 = b2;
        this.p=p;
        this.v=v;
        Thread h=new Thread(new Hilo1(b1,b2,p,this));
        h.start();
        Thread h2=new Thread(new Hilo2(b2,v,p,this));
        h2.start();
    }
}
