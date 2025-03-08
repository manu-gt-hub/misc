package data;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author profesor
 */
class Animacion extends Thread{

    Ventana v; Panadera p; List<Cliente> lc; Bandeja b;
    public static boolean FIN_ANIMACION=false;

    public Animacion(Ventana v, Panadera p, List<Cliente> lc, Bandeja b) {
        this.v = v;
        this.p = p;
        this.lc = lc;
        this.b = b;
    }

    @Override
    public void run() 
    {
        
        while(!Animacion.FIN_ANIMACION)
        {
            //Actualizo
            actualizar();
            
            //Pinto
            v.repaint();
            try {
                //Espero
                Thread.sleep(200);
            } catch (InterruptedException ex) {
                Logger.getLogger(Animacion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.out.println("FIN de la animación");    
    }
    

    private void actualizar() {
        //-->Cada hilo se actualiza solo
        //Aquí pondría los elementos comunes a actualizar, como datos del escenario, etc.
    }
    
    
}
