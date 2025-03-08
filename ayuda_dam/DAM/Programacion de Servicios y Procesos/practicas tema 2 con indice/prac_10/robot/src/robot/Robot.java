
package robot;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.geom.Line2D;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;





     

public class Robot extends JPanel
{        
    int adelanto=50;
    int cabx=10;
    int caby=200;
    int bodx=10;
    int body=250;
    int piernaizqx=30;
    int piernaizqy=350;
    int piernaderx=30;
    int piernadery=350;
    int brazoizqx=30;
    int brazoizqy=250;
    int brazoderx=30;
    int brazodery=250;
    Image fondo= new ImageIcon((System.getProperty("user.dir")+"\\fondo.jpg")).getImage();

    Timer timer;

    
    
        
        public Robot() throws InterruptedException
        {
            this.setOpaque(false);
  
        }

        @Override
        public void paint(Graphics g)
        {
            super.paint(g);
            
            //g.drawImage(fondo,0,0, null);
            
            Graphics2D g2=(Graphics2D)g;
      
            g.fillOval(cabx, caby, 50, 50);
            g.fillRect(bodx, body, 50, 100);
            
            g2.setStroke(new BasicStroke(20));
            g2.drawLine(piernaizqx, piernaizqy, piernaizqx-adelanto, piernaizqy+70);

            g2.setStroke(new BasicStroke(20));
            g2.drawLine(piernaderx, piernadery, piernaderx+adelanto, piernadery+70);
            
            
            g2.setStroke(new BasicStroke(20));
            g2.drawLine(brazoizqx, brazoizqy, brazoizqx-adelanto, brazoizqy+70);
            g2.setStroke(new BasicStroke(20));
            g2.drawLine(brazoderx, brazodery, brazoderx+adelanto, brazodery+70);
   
        }

        void mover(int i) {
            this.cabx+=i;

            this.bodx+=i;

            this.piernaizqx+=i;

            this.piernaderx+=i;

            this.brazoizqx+=i;

            this.brazoderx+=i;

        }
        void adelanto(int n)
        {
            this.adelanto=n;
        }
   


    }