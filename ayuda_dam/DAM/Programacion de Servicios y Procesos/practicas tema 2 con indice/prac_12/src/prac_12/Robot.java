
package prac_12;

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
    int alt=brazoderx;
    
    boolean cambio1=true;
    boolean cambio2=true;
    boolean impulsando=false;
    boolean saltando=false;
    boolean saludando=false;
    
    int acder=45;
    int acizq=45;
    
    String movAnterior="";
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
            
            g.drawImage(fondo,0,0, null);
            
            Graphics2D g2=(Graphics2D)g;
      
            g.fillOval(cabx, caby, 50, 50);
            g.fillRect(bodx, body, 50, 100);
            
            g2.setStroke(new BasicStroke(15));
            
            
                
            if(impulsando)
            {
                if(!saludando)
                {
                    g2.drawLine(brazoizqx, brazoizqy, brazoizqx-50, brazoizqy+30);
                    g2.drawLine(brazoizqx-50, brazoizqy+30, brazoizqx, brazoizqy+70);
                    g2.drawLine(piernaderx, piernadery, piernaderx+35, piernadery+35);
                    g2.drawLine(piernaderx+35, piernadery+35, piernaderx, piernadery+70);
                    impulsando=false;
                }
                
            }
            else
            {
                if(!saltando)
                {
                    if(!saludando)
                    {
                        g2.drawLine(piernaizqx, piernaizqy, piernaizqx-adelanto, piernaizqy+70);

                        g2.drawLine(piernaderx, piernadery, piernaderx+adelanto, piernadery+70);
                    }
                    else
                    {
                        g2.drawLine(piernaizqx+20, piernaizqy, piernaizqx+30, piernaizqy+70);

                        g2.drawLine(piernaderx-10, piernadery, piernaderx-20, piernadery+70);
                    }
                    
                }
                
                
            }
            if(saltando)
            {
                if(!saludando)
                {
                    g2.drawLine(brazoizqx-15, brazoizqy, brazoizqx-50, brazoizqy-50);
                    g2.drawLine(brazoderx+25, brazodery, brazoderx+50, brazoizqy-50);

                    g2.drawLine(piernaizqx+15, piernaizqy, piernaizqx+25, piernaizqy+70);
                    g2.drawLine(piernaderx-10, piernadery, piernaderx-25, piernadery+70);
                }
                
                
            }
            else
            {
                if(saludando)
                {
                    g2.drawLine(brazoderx, brazodery, brazoderx-alt, brazodery-50);
                    g2.drawLine(brazoizqx+30, brazoizqy+10, brazoizqx+40, brazoizqy+60);
            

                } 
                else
                {
                    
                    g2.drawLine(brazoizqx, brazoizqy, brazoizqx-adelanto, brazoizqy+70);
            
                    g2.drawLine(brazoderx, brazodery, brazoderx+adelanto, brazodery+70);
                }
                
            }   
                
          
            
   
        }

        void der(int i) {
            
            impulsando=false;
            if(movAnterior.compareToIgnoreCase("izq")==0)
            {
                acder=acizq;
            }
            movAnterior="der";
            if(cambio1)
            {
                acder-=i; 
            }
            else
            {
                acder+=i; 
                
            }
            
            if(acder>=50 ||acder <=0)
            {
                cambio1=!cambio1;
            }
            
            this.cabx+=i;

            this.bodx+=i;

            this.piernaizqx+=i;

            this.piernaderx+=i;

            this.brazoizqx+=i;

            this.brazoderx+=i;
            
            this.adelanto(acder);

        }
        void izq(int i) {
            
            impulsando=false;
            if(movAnterior.compareToIgnoreCase("der")==0)
            {
                acizq=acder;
            }
            movAnterior="izq";
            
            if(cambio2)
            {
                acizq-=i; 
            }
            else
            {
                acizq+=i; 
                
            }
            
            if(acizq>=50 ||acizq <=0)
            {
                cambio2=!cambio2;
            }
            
            this.cabx-=i;

            this.bodx-=i;

            this.piernaizqx-=i;

            this.piernaderx-=i;

            this.brazoizqx-=i;

            this.brazoderx-=i;
            
            this.adelanto(acizq);
            
            

        }
        void adelanto(int n)
        {
            this.adelanto=n;
        }
        
        public int getX()
        {
            return this.brazoderx;
        }


        

    


    }