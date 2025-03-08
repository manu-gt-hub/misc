package data;

import GUI.Ventana;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.List;
import java.util.TimerTask;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 * En este ejemplo enseño como crear animaciones básicas 
    * No hay colisiones ni complejidades gráficas
    * Pero si una clase Animación que nos ayuda mucho a entender este tipo de programas
     
  Hay un problema de concurrencia sore la lista de misiles  ( que cada vez es más grande :)   ya que no elimino datos)
  Lo abordo en 2 proyectos diferentes desde 2 enfoques:
    * Monitores
    * ConcurrentList 
  
  
  
 */
public class Main {
    private static String RUTA_IMAGENES="./res/img";
    public static Dimension TAM_PANTALLA=Toolkit.getDefaultToolkit().getScreenSize();
    static Ventana ventana;
    static int DURACION_ANIMACION=10000; //Tiempo que durará la animación antes de parar su ejecución

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        // TODO code application logic here
        Animacion a=new Animacion();
        
        ventana=new Ventana(a);
        ventana.setVisible(true);
        
        a.iniciar();
        Thread.sleep(DURACION_ANIMACION);
        a.parar();
        JOptionPane.showMessageDialog(ventana, "FIN de la animación");
        ventana.dispose();
    }
    
    
    public static Image cargarImagen(String sImg) {
        return new ImageIcon(RUTA_IMAGENES+"/"+sImg).getImage();
    }

    static Ventana getVentana() {
        return Main.ventana;
    }
    
    static class TareaLanzaMisiles extends TimerTask{
        
        List <Proyectil> lp;

        public TareaLanzaMisiles(List<Proyectil> lp) {
            this.lp = lp;
        }

        @Override
        public void run() {                         
            if(Math.random()>=0.5) {
                lp.add(new Proyectil((int)(Math.random()*Main.TAM_PANTALLA.width),10,50,75,true));
            }             
            else {
                lp.add(new Proyectil((int)(Math.random()*Main.TAM_PANTALLA.width),10,50,75,false));
            }            
        }    
    }
    
    
}
