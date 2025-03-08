package data;

import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * esta la clase que hace de monitor del recurso compartido
 * @author profesor
 */
public class Bandeja extends Sprite{   
    int tam;
    List<Pan> barras;//lista de barras de pan q hay en la bandeja

    public Bandeja(Image img, int tam,int x, int y) {
        super(img,x,y);
        this.tam = tam;
        barras=new ArrayList(tam);
    }

    synchronized boolean espacioParaBarra() {
        if(barras.size()<tam)
            return true;
        return false;
    }

    /**
     * COloca una barra en la bandeja de pan
     * @param p 
     */
    synchronized void colocarBarra(Pan p) throws InterruptedException {
      //Y las pongo en la bandeja (si caben)
      while(!espacioParaBarra()){
              wait();
      }      
      
      /*
      Aunq lo normal es agregar y notificar aquí, No lo hago xq quiero dar tiempo a q la barra esté en la bandeja
      lo hago entonces en notificaBarraColocada
      if(barras.size()<tam){
            System.out.println("Coloco una barra en la bandeja");
            barras.add(p);
            notifyAll(); 
            
      }
      */
    }
    
    //llego aquí cdo acaba la animación de la barra-->
    //Entonces la barra está fisicamente en la bandeja
    synchronized void notificaBarraColocada(Pan p) {        
        if(barras.size()<tam){
            System.out.println("Coloco una barra en la bandeja");
            barras.add(p);
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(Bandeja.class.getName()).log(Level.SEVERE, null, ex);
            }
            notifyAll(); 
      }
    }

    synchronized boolean hayBarras() {
        if(barras.size()>0)
            return true;
        return false;
    }

    synchronized Pan dameUnaBarra() throws InterruptedException {        
        while(!hayBarras())
        {
                System.out.println("espero xq no hay barras en la bandeja");
                wait();
        }
        Random r=new Random();
        if(barras.size()>0){
            System.out.println("me llevo una barra de la bandeja");
            Pan p= (Pan)barras.remove(r.nextInt(barras.size()));
            notifyAll();
            return p;
        }
        return null;        
    }    

    @Override
    void pintar(Graphics g) {
        super.pintar(g);
        synchronized(this){
            //pongo las barras en su bandeja
            for (Pan pan : this.barras) {
                if(pan!=null)pan.pintar(g);
            }
        }
    }
    
    
    
    

   
}