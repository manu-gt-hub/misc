/**************************************
 * Autor: Manuel Gutierrez Torrero    *
 * 1º D.A.M.                          *
 * Practicas 3ª ev. Java              *
 **************************************/

package prac_4;

import GUI.VentanaSal;
import java.util.Scanner;

/*
 * Esta aplicacion muestra los numeros perfectos del 0 al 500 haciendo uso
 * para ello de un acumulador en el que vamos sumando uno a uno los divisores
 * exactos de dicho numero
 */

public class Main {

    public static void main(String[] args) {
        int num=500,ac=0;
        VentanaSal ventS=new VentanaSal();
        ventS.setVisible(true);
        ventS.pintar("Numeros perfectos del 1 al "+num+":\n");
        for (int n = 1; n < num; n++) {
            for (int div = 1; div < n; div++) {
               if(n%div==0)
                {
                   ac+=div;
                }                
            }
            if(ac==n)
            {
              ventS.pintar(ac+"\n");
            }
            ac=0;
            
        }
        
  
        
    }
}
