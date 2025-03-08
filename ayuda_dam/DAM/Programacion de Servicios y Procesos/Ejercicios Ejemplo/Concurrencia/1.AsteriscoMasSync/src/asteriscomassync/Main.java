/*
 * Desarrolle un prog q viualice alternativamente N * y N +
 * La sync la garantiza la clase-monitor Pantalla
 */

package asteriscomassync;

import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author DAI
 */
public class Main {    
    
    public static void main(String[] args) {     
        int op=JOptionPane.showConfirmDialog(null, "¿Quieres Usar Monitores S/N?","Opción",JOptionPane.YES_NO_OPTION);
        
        if(op==JOptionPane.NO_OPTION){
            /*Lo hago Sin monitores*/
            Asterisco ast=new Asterisco();
            Mas mas=new Mas();
            mas.start();        
            ast.start();        
        }
        else        
        {
            /*Lo hago Con monitores*/         
            Random r=new Random();
            Pantalla p=new Pantalla(r.nextBoolean());
            Asterisco ast=new Asterisco(p);
            Mas mas=new Mas(p);
            mas.start();        
            ast.start();
        }
    }


}//~)