/**************************************
 * Autor: Manuel Gutierrez Torrero    *
 * 1º D.A.M.                          *
 * Practicas 3ª ev. Java              *
 **************************************/


package prac_3;

import GUI.*;
import java.util.Scanner;

public class Main {
    static int MAX=5;

    static int cont3=0,cont5=0,cont=0,i=0;

    public static void main(String[] args) {
        Main ap=new Main();
         VentanaEnt ventE=new VentanaEnt("Teclee el numero nº: ",Main.i+1,ap);
         ventE.setVisible(true);
        
        
    }
    
    /*
     * Calcular: Metodo encargado de evaluar si el numero pasado como parametro
     * es divisible entre 3, 5 o ninguno de los dos, incrementando ademas
     * el contador correspondiente y lanzando ventanas de entrada en el caso
     * de que i sea menor que MAX y una ventana de salida en caso contrario
     * con los resultados
     */
    
    public void calcular(int num)
    {
        if(num%3==0)
            {
                cont3++;
            }
            else
            {
                if(num%5==0)
                {
                    cont5++;
                }
                else
                {
                    cont++;
                }
                    
            }
        if(this.i>=MAX-1)
        {
            VentanaSal ventS=new VentanaSal();
            ventS.setVisible(true);
            ventS.pintar("Numeros multiplos de 3: "+cont3);
            ventS.pintar("\n\nNumeros multiplos de 5: "+cont5);
            ventS.pintar("\n\nNumeros que no son \nni multiplos de 5 ni de 3: "+cont);
        }
        else
        {
            i++;
            VentanaEnt ventE=new VentanaEnt("Teclee el numero nº: ",this.i+1,this);
            ventE.setVisible(true);
            
        }
    }
}
