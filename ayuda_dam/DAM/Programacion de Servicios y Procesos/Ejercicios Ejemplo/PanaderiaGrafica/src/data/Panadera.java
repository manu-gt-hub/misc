package data;

import java.awt.Graphics;
import java.awt.Image;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

/**
 *
 * @author profesor
 */
public class Panadera extends Sprite implements Runnable{    
    int numBarras; //num de barras q fabrica y lleva en cada paseo la panadera a la bandeja
    List<Pan> panes=new LinkedList();//Lista de barras de pan que lleva la panadera en su bandeja    
    Pan panTransitorio;//pan q cojo de la lista y q pinto en la pantalla cdo lo dejo en la bandeja compartida
    
    Bandeja bandeja;
    Horno horno;
    
    enum Estado {ESPERANDO,CREANDO, PONIENDO,DESPLAZANDO_IZDA,DESPLAZANDO_DCHA};//La panadera siempre estará en uno de estos estados
    Estado estado;
    
    Image img2=new ImageIcon("img/panadera2.png").getImage();

    
    
    public Panadera(Image img, int maxBarras,Bandeja b,Horno h,int x, int y) {
        super(img,x,y);
        this.numBarras = maxBarras;
        this.bandeja=b;    
        horno=h;
        estado=Estado.ESPERANDO;
    }

    @Override
    public void run() {            
        Random r=new Random();
        int i=0;
        do{
            estado=Estado.CREANDO;
            System.out.println("Creo las barras \n");
            for (int ii = 0; ii < numBarras; ii++) 
            {
                Pan.TipoBarra tipo=Pan.TipoBarra.GALLEGA;
                switch(r.nextInt(3))
                {
                    case 1:tipo=Pan.TipoBarra.HORNO;break;
                    case 2:tipo=Pan.TipoBarra.PICOS;break;
                }
                panes.add(new Pan(tipo,x+(ii*20),y+130+(ii*10)));
                System.out.println("barra creada");
                
                try {
                    Thread.sleep(1000);//Tarda un s en constuir una barra                    
                } catch (InterruptedException ex) {
                    Logger.getLogger(Panadera.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            //Me desplazo hasta la bandeja
            estado=Estado.DESPLAZANDO_IZDA;
            //1.mover hasta la bandeja de pan  
            mueveteHastaLaBandeja();            
            
            try {
                do{
                    estado=Estado.ESPERANDO;
                    panTransitorio=(Pan)((LinkedList)panes).pollFirst();
                    bandeja.colocarBarra(panTransitorio);
                    estado=Estado.PONIENDO;
                    hacerAnimacionPonerBarra(panTransitorio);                    
                    bandeja.notificaBarraColocada(panTransitorio);
                    panTransitorio=null;                    
                }while(!panes.isEmpty());
                
            } catch (InterruptedException ex) {
                Logger.getLogger(Panadera.class.getName()).log(Level.SEVERE, null, ex);
            }
            estado=Estado.DESPLAZANDO_DCHA;
            mueveteHastaHorno();
            i++;
        }while(i<2);
    
        System.out.println("YuHOOOOO FIN de la jornada laboral");
        Animacion.FIN_ANIMACION=true;
        Main.finalizar();
    
    }
    
    
    
    private void mueveteHastaLaBandeja() {
        while(x>bandeja.x+bandeja.img.getWidth(null)/2){
                this.x--;
                //El pan too se mueve ;)
                for (Pan pan : panes) 
                {
                    pan.x--;
                }
                try {
                    Thread.sleep(7);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
        while(y+img.getHeight(null)>bandeja.y+bandeja.img.getHeight(null)-50 ){
            this.y--;
            //El pan too se mueve ;)
            for (Pan pan : panes) 
            {
                pan.y--;
            }
            try {
                Thread.sleep(8);
            } catch (InterruptedException ex) {
                Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void mueveteHastaHorno() {
        while(x+img.getWidth(null)/2 <horno.x){
                this.x++;                
                try {
                    Thread.sleep(10);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
        while(y<horno.y-20 ){
            this.y++;
            try {
                Thread.sleep(10);
            } catch (InterruptedException ex) {
                Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
    //Animación en la q se pone una barra en la bandeja de pan
    private void hacerAnimacionPonerBarra(Pan p) 
    {
        for (int i = 0; i < 50; i++) {
            p.y--;
            try {
                Thread.sleep(6);
            } catch (InterruptedException ex) {
                Logger.getLogger(Panadera.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        for (int i = 0; i < 50; i++) {
            p.y++;
            try {
                Thread.sleep(6);
            } catch (InterruptedException ex) {
                Logger.getLogger(Panadera.class.getName()).log(Level.SEVERE, null, ex);
            }
        }        
        
        while(p.x>bandeja.x+50){
            p.x--;
            try {
                Thread.sleep(6);
            } catch (InterruptedException ex) {
                Logger.getLogger(Panadera.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }    
    
    @Override
    void pintar(Graphics g) {
        
        if(this.estado==Estado.DESPLAZANDO_DCHA)
            g.drawImage(img2, x,y, null);
        else
            g.drawImage(img, x,y, null);
        
        //pongo las barras en su bandeja
        for (Pan pan : panes) {
            pan.pintar(g);
        }
        
        if(panTransitorio!=null)
            panTransitorio.pintar(g);
        
    }
   
}
