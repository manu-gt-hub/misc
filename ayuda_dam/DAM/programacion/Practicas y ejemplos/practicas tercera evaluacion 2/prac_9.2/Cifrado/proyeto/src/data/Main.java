
/*********************************
 * Practica 9   Cifrados         *
 * Manuel Gutierrez Torrero      *
 * 1º DAM                        *
 *********************************/

package data;

import GUI.Ventana;
import java.io.FileNotFoundException;
import java.io.IOException;



public class Main {
    static Ventana vent;
    public static void main(String[] args) throws FileNotFoundException, IOException {
        vent=new Ventana();
        vent.setVisible(true);
    }
}
