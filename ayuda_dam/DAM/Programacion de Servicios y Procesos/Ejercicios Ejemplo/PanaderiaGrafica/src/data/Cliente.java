package data;

import java.awt.Graphics;
import java.awt.Image;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

/**
 *
 * @author profesor
 */
public class Cliente extends Sprite implements Runnable{
    String nom;
    Bandeja bandeja;    
    
    int numBarras;//Número de barras q quiere llevarse el cliente
    List<Pan> panes=new LinkedList();//Lista de barras de pan que lleva la panadera en su bandeja    
    boolean muevoHaciaDcha=true;
    Image img2;

    public Cliente(String cad, String nom, int numBarras,Bandeja b,int x, int y) {
        super(new ImageIcon(cad+".png").getImage(),x,y);        
        this.nom = nom;
        this.numBarras = numBarras;
        this.bandeja=b;
        img2=new ImageIcon(cad+"b.png").getImage();
        
    }

    @Override
    public void run() 
    {
         //1.mover hasta la bandeja de pan  
        mueveteHastaLaBandeja(); 
       
        //Solicitar numBarras barras de pan de la bandeja
        //Si hay las coje        
            //Si-no espera        
        //Se va con las barras a la caja
        int i=0;
        do{
            try {
                this.panes.add(bandeja.dameUnaBarra());
                System.out.println("Yuhoo !!!! Tengo una Barra ("+nom+")");
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
            }           
           i++;            
        }while(i<numBarras);            
        
        try {
            this.muevoHaciaDcha=false;
            veteACasa();
        } catch (InterruptedException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    private void mueveteHastaLaBandeja() {
        while(x+img.getWidth(null)-50 <bandeja.x){
                this.x++;                
                try {
                    Thread.sleep(8);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
        while(!this.intersects(bandeja))
        {
            if(y+img.getHeight(null)>bandeja.y+bandeja.img.getHeight(null)-50 )
            {
                this.y--;          
                try {
                    Thread.sleep(8);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(y<bandeja.y+50 )
            {
                this.y++;          
                try {
                    Thread.sleep(8);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    private void veteACasa() throws InterruptedException {
        System.out.println("ME voy a casa "+nom);
        
        //Muevo el pan hasta el cliente
        
        for (Pan pan : panes) {
            while(pan.x>(x+this.width/4)){
                pan.x--;
                Thread.sleep(5);
            }
            while(pan.y>y+this.getHeight()/3){
                pan.y--;
                Thread.sleep(5);
            }
        }
        
        //1.mover hasta fuera de la ventana
        while(x>0-img.getWidth(null)){
            this.x--;
            for (Pan pan : panes) {
                pan.x--;
            }            
            Thread.sleep(10);
        }
    }
    
    
    @Override
    void pintar(Graphics g) {
        
         if(this.muevoHaciaDcha)
            g.drawImage(img, x,y, null);
        else
            g.drawImage(img2, x,y, null);
        
        //pinto el pan del cliente
        for (Pan pan : panes) {
            pan.pintar(g);
        }
        
    }
    
}
