
package data;

import java.awt.Graphics;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
    Creo un monitor xa todo aquel que quiera acceder a la lista de Misiles 
 */

public class MonitorListaProyectiles {

    List<Proyectil> lp;
    boolean llave; //true= disponible;  false=no disponible

    public MonitorListaProyectiles() {
        lp = new LinkedList();        
        llave=true;
    }
    

    synchronized void moverHaciaAbajo() {
        
            while(!llave){
                try {
                    wait();
                } catch (InterruptedException ex) {
                    Logger.getLogger(MonitorListaProyectiles.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            //Cojo la llave
            llave=false;
            
            Iterator itr=lp.iterator();
            while(itr.hasNext()){
                Proyectil proyectil=(Proyectil)itr.next();
                proyectil.moverHaciaAbajo();
            }        
            
            //Dejo la llave y lo notifico
            llave=true;
            notifyAll();
    }

    synchronized void añadir(Proyectil proyectil) {
            while(!llave){
                try {
                    wait();
                } catch (InterruptedException ex) {
                    Logger.getLogger(MonitorListaProyectiles.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            //Cojo la llave
            llave=false;
            
            lp.add(proyectil);
            
            //Dejo la llave y lo notifico
            llave=true;
            notifyAll();
    }

    
    synchronized void pintar(Graphics g) {        
            while(!llave) {
                try {
                    wait();
                } catch (InterruptedException ex) {
                    Logger.getLogger(MonitorListaProyectiles.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            //Cojo la llave
            llave=false;
            
            Iterator itr=lp.iterator();
            while(itr.hasNext()){
                Proyectil bomba=((Proyectil)itr.next());            
                if(bomba!=null) {
                    bomba.pintar(g);
                }
            }        
            
            //Dejo la llave y lo notifico
            llave=true;
            notifyAll();
    }    

    synchronized boolean hayColsionCon(Dummy dummy) {
            boolean chocar=false;
            while(!llave){
                try {
                    wait();
                } catch (InterruptedException ex) {
                    Logger.getLogger(MonitorListaProyectiles.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            //Cojo la llave
            llave=false;
            
            Iterator itr=lp.iterator();
            while(itr.hasNext()){
                Proyectil proyectil=(Proyectil)itr.next();
                if (proyectil.chocaCon(dummy)){
                        chocar=true;
                        break;
                }
            }
            
            //Dejo la llave y lo notifico
            llave=true;
            notifyAll();
            return chocar;
    }
        
}
