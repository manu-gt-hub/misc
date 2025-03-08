/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;


import data.Animacion;
import data.Main;
import java.awt.HeadlessException;
import javax.swing.JFrame;

/**
 *
 * @author Profesor
 */
public class Ventana extends JFrame{
    public Ventana(Animacion a) throws HeadlessException 
    {        
        this.setTitle("Ejemplo");        
        this.setSize(Main.TAM_PANTALLA.width,Main.TAM_PANTALLA.height);        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);                
        this.setContentPane(new MiPanel(a));
    }
    
    
}
