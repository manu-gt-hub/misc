/**************************************
 * Autor: Manuel Gutierrez Torrero    *
 * 1º D.A.M.                          *
 * Practicas 3ª ev. Java              *
 **************************************/


package prac_7;

import GUI.VentanaEnt;
import GUI.VentanaSal;
import java.util.Scanner;

public class Main {

    int[] monedas={50,20,10,5,2,1};
    int mon;
    int num=0;
    public static void main(String[] args) {
        Main ap=new Main();
        VentanaEnt ventE=new VentanaEnt("Introduzca la moneda: ",ap);
        ventE.setVisible(true);
        

    }
    
    /*
     * cambio: Metodo que se encargara de calcular el cambio optimo para la moneda
     * "m" que se recibe como parametro y que sera un numero entero
     */
    
    public void cambio(int m)
    {
        this.mon=m;
        VentanaSal ventS=new VentanaSal();
        ventS.setVisible(true);
        ventS.pintar("Cambio de: "+mon+"\n");
        if(mon>1)
        {
          for (int i = 0; i < monedas.length; i++) {
            if(mon==monedas[i])
            {
                
                num=mon/monedas[i+1];
                int mod=mon%monedas[i+1];
                ventS.pintar(num+" monedas de "+monedas[i+1]+" centimo/s");
                if(mod!=0)
                {
                    ventS.pintar("1 moneda de "+mod+" centimo/s");
                }
            }
            
          }
          if(num==0)
          {
            ventS.pintar("ERROR: no hay cambio para esa moneda");
          }
        }
        else
        {
          ventS.pintar("1 moneda de 1 centimo"); 
        }
    }
}
