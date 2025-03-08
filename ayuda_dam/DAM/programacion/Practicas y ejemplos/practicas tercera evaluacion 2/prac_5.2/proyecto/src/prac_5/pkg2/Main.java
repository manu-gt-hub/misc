

/*********************************
 * Practica 5 El bingo           *
 * Manuel Gutierrez Torrero      *
 * 1º DAM                        *
 *********************************/

package prac_5.pkg2;

import GUI.Ventana;
import java.util.Random;

public class Main {
    
    boolean ver=false;
    Random rand = new Random();
    int n;
    public static void main(String[] args) {
        Main ap=new Main();
        new Ventana(ap).setVisible(true);

    }

    
}
