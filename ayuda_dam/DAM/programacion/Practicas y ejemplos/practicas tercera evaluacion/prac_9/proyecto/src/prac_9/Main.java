/**************************************
 * Autor: Manuel Gutierrez Torrero    *
 * 1º D.A.M.                          *
 * Practicas 3ª ev. Java              *
 **************************************/


package prac_9;

import GUI.*;


public class Main {

    static int num;
    public static void main(String[] args) {
        
        Main ap=new Main();
        VentanaEnt ventanaEnt = new VentanaEnt("Teclee un numero: ",ap);
        ventanaEnt.setVisible(true);
        
        
    }
    
    /*
     El metodo calcular se encargara de calcular los divisores exatos de un
     * numero "n" enviado como parametro de entrada que sera un numero
     * entero
     */
    
    public void calcular(int n)
    {
        num=n;
        VentanaSal ventSal=new VentanaSal();
        ventSal.setVisible(true);
        ventSal.pintar(num+" (1");

        for (int i = 2; i < num; i++) {
            
            if(num%i==0)
            {
                ventSal.pintar("+"+i);
                
            }
            
        }
        
        ventSal.pintar(")");
    }
}
