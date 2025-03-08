package data;

import GUI.Ventana;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Profesor
 */
public class Animacion extends Thread{
    
    Ventana v;
    Cuerpo cuerpo;
    Cabeza cabeza;
    Pierna pierna1;

    public Animacion(Ventana v,Cuerpo f, Cabeza c, Pierna p1) {
        this.v = v;
        this.cuerpo=f;
        this.cabeza=c;
        pierna1=p1;
    }
    
    

    @Override
    public void run() {
        for (int i = 0; i < 150; i++) {            
            //actualizar
            actualizar();            

            //pintar
            v.repaint();

            //esperar
            try {      
                Thread.sleep(20);
            } catch (InterruptedException ex) {
                Logger.getLogger(Animacion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void actualizar() {
        cabeza.actualizar();
        cuerpo.actualizar();        
        pierna1.actualizar();
    }
    
    
    
    
}
