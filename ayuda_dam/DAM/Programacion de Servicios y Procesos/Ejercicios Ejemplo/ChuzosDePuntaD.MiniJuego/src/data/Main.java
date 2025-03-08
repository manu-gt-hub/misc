package data;

import GUI.Ventana;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.TimerTask;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 Vamos a hacer una pequeña mejora sobre las versiones anteriores que incluye:
 * La animación parará cuando:
    A) Algún muñeco llegue al extremo dcho de la pantalla
    B) No haya muñecos en la pantalla (todos mueren)
 * Además se borran los proyectiles al caer por debajo de la pantalla
  
  
 */
public class Main {
    private static String RUTA_IMAGENES="./res/img";
    public static Dimension TAM_PANTALLA=Toolkit.getDefaultToolkit().getScreenSize();
    static Ventana ventana;
    static Animacion a;    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        // TODO code application logic here
        a=new Animacion();
        
        ventana=new Ventana(a);
        ventana.setVisible(true);
        
        a.iniciar();
    }
    
    public static void finalizarPrograma(){        
        if(!a.isParado()){
            a.parar();
            JOptionPane.showMessageDialog(ventana, "FIN de la animación");
        }
        ventana.dispose();
    }
    
    
    public static Image cargarImagen(String sImg) {
        return new ImageIcon(RUTA_IMAGENES+"/"+sImg).getImage();
    }

    static Ventana getVentana() {
        return Main.ventana;
    }
    
    static class TareaLanzaMisiles extends TimerTask{
        
        MonitorListaProyectiles lp;

        public TareaLanzaMisiles(MonitorListaProyectiles lp) {
            this.lp = lp;
        }

        @Override
        public void run() {                         
            if(Math.random()>=0.5) {
                lp.añadir(new Proyectil((int)(Math.random()*Main.TAM_PANTALLA.width),10,50,75,true));
            }             
            else {
                lp.añadir(new Proyectil((int)(Math.random()*Main.TAM_PANTALLA.width),10,50,75,false));
            }            
        }    
    }
    
    
}
