
package prac_12psp;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Saltar implements Runnable
{
    Panel r;

    public Saltar(Panel r) {
        this.r = r;
    }

    @Override
    public void run() {
        r.impulsando=true;
        r.adelanto=0;

        r.repaint();
        try {
            Thread.sleep(500);
        } catch (InterruptedException ex) {
            Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
        }

        r.saltando=true;
        int origen=r.caby;
        int tope=r.caby-100;

        while(tope<r.caby)
        {
            r.caby-=10;
            r.body-=10;
            r.piernaizqy-=10;

            r.piernadery-=10;

            r.brazoizqy-=10;

            r.brazodery-=10;

            r.repaint();
            try {
                Thread.sleep(40);
            } catch (InterruptedException ex) {
                Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        while(origen>r.caby)
        {
            r.caby+=10;
            r.body+=10;
            r.piernaizqy+=10;

            r.piernadery+=10;

            r.brazoizqy+=10;

            r.brazodery+=10;

            r.repaint();
            try {
                Thread.sleep(40);
            } catch (InterruptedException ex) {
                Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        r.saltando=false;
        r.repaint();
    }

}
