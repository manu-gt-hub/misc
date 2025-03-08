/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Cronometro extends TimerTask{

        int time;
        int mil=0;
        int seg=0;
        int min=0;
                
        String titulo;
        VenSal v;
        Calendar c;

        public Cronometro(VenSal v) {
            c=new GregorianCalendar();
            
            this.titulo=c.getTime().toString();
            v.setTitle(titulo+"   00:00:00");
            this.v = v;
        }

    @Override
    public void run() {

            time=(int) (System.currentTimeMillis()-c.getTimeInMillis());
            v.setTitle(titulo+"   "+min+":"+seg+":"+mil);
        
            if(mil>=1000)
            {
                seg++;
                mil=0;
            }
            else
            {
                mil++;
            }
            if(seg>=60)
            {
                min++;
            }


    }

    
}
