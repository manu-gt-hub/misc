
/*********************************
 * Practica 7   Cine             *
 * Manuel Gutierrez Torrero      *
 * 1º DAM                        *
 *********************************/

package prac_7.pkg2;

import GUI.Maquina;
import GUI.Taquilla;

public class Main {

    public static void main(String[] args) {
        //lanzo la maquina de tickets
        Maquina venta=new Maquina();
        venta.setVisible(true);
        //lanzo la ventana de venta en taquilla
        Taquilla taq=new Taquilla(venta);
        taq.setVisible(true);
        
    }
}
