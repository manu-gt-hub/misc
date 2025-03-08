package carrera;

import java.awt.Image;
import javax.swing.ImageIcon;

class Corredor extends Thread{
    
    private int x,y,ancho,alto;//Coordenadas del círculo q repre a cada corredor
    private int retardo;
    private static boolean continuar=true;
    private final int SALTO =2;
    private final Image imagen; 
    private final Image estela;    
    
    public Corredor(int yy,int retard,String ruta){        
        y=yy;
        x=50;        
        ancho=alto=50;
        imagen= new ImageIcon((System.getProperty("user.dir")+"\\res\\imgs\\"+ruta+".jpg")).getImage();
        estela= new ImageIcon((System.getProperty("user.dir")+"\\res\\imgs\\estela2.jpg")).getImage();        
        //Retoco los retardos xa q sea mas equilibrada la carrera
        if (retard>=10&& retardo <=300)
            retardo=retard;
        else
            if (retard<10)
                retardo=retard+10;
            else
                retardo-=300;
    }

    public void dibujar(java.awt.Graphics g){        
        //Dibujo la estela
        g.drawImage(estela,0,y,x,64,null);
        //Dibujo el coche
        g.drawImage(imagen,x,y,100,90,null);

        //Dibujo el retardo asignado
        g.setColor(java.awt.Color.GREEN);
        g.drawString(""+retardo, x-50, y-10);
    }
    
    //El corredor cambia su pos x todo el tiempo q puede
    @Override
     public void run(){
        while(Corredor.continuar){           
            try{
                 sleep(retardo);
            }catch(InterruptedException ex){} 
            x+=this.SALTO;
        }//while continuar
     }//run
    
    /**
     * Termina la ejecución de la hebra.
     */
    public static void parar(){
        Corredor.continuar=false;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getAncho() {
        return ancho;
    }


    
}//Class Corredor