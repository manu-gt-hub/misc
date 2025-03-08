package data;

import java.awt.Image;
import javax.swing.JPanel;

/*Panel donde se desarrollara todo el juego y que tiene un fondo*/
public class PanelJuego extends JPanel{
    Image imagen;


    PanelJuego(Image fondo) {
         this.setOpaque(true);
         this.imagen=fondo;   
        
    }



}