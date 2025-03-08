
package prac_12psp;

import java.util.logging.Level;
import java.util.logging.Logger;


public class Saludar implements Runnable
{
    Panel r;

    public Saludar(Panel r) {
        this.r = r;
    }

    @Override
    public void run() {
        r.saludando=true;
        r.adelanto=0;



        int x=r.brazoderx;
        int y=r.brazodery;
        r.brazoderx=x-10;
        r.brazodery=y+10;
        r.alt=40;
        for (int i = 0; i < 2; i++) {

            while(r.alt<60)
            {
                r.alt+=2;
                r.repaint();
                try {
                    Thread.sleep(40);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            while(r.alt>20)
            {
                r.alt-=2;
                r.repaint();
                try {
                    Thread.sleep(40);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
                }
            }



        }
        r.brazoderx=x;
        r.repaint();
        r.saludando=false;


    }

}
