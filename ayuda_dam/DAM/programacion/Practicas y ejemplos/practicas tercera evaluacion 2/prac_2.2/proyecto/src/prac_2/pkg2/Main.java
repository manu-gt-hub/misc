
/*********************************
 * Practica 2 sorteo de la ONCE  *
 * Manuel Gutierrez Torrero      *
 * 1º DAM                        *
 *********************************/


package prac_2.pkg2;

import GUI.*;


public class Main {
    static final int premiado=29348;
    
    public static void main(String[] args) {
        Main ap=new Main();
        VentanaEnt ventE=new VentanaEnt(ap);
        ventE.setVisible(true);
    }
    
    public void comparar(int n)
    {
        VentanaSal ventS;
        int num=n;
        int num2 = (int) Math.floor(num*0.0001);
        int premiado2 = (int) Math.floor(premiado*0.0001);
        if((num%10==premiado%10)||(premiado2==num2))
        {
            ventS=new VentanaSal("El numero "+num+" si tiene reintegro");
            ventS.setVisible(true);
        }
        else
        {
            ventS=new VentanaSal("El numero "+num+" no tiene reintegro");
            ventS.setVisible(true);
        }
    }
}
