/**************************************
 * Autor: Manuel Gutierrez Torrero    *
 * 1º D.A.M.                          *
 * Practicas 3ª ev. Java              *
 **************************************/


package prac_5;

import GUI.VentanaEnt;
import GUI.VentanaModal;
import GUI.VentanaSal;
import java.util.Scanner;

public class Main {
    int cont=0,num_original=0,decimal=0;
    String res="";
    public static void main(String[] args) {
        Main ap=new Main();
        VentanaModal ventM=new VentanaModal(ap);
        ventM.setVisible(true);

        
        
    }
    
    /*
     * CalcularBin: Este metodo calcula un numero binario en base a un parametro
     * num, siendo num un numero entero en base decimal.
     */
    
    public void calcularBin(int num)
    {
        decimal=num;
        do
        { 
           res=(num%2)+res;
           num=num/2;
           cont++;
        }while(num!=0);
        Mostrar(Integer.parseInt(res)); 
    }
    
    /*
     * CalcularDec: Este metodo calcula un numero decimal en base a un parametro
     * num, siendo num un numero entero en base binaria.
     */
    
    public void calcularDec(int num)
    {
        num_original=num;
        do
        { 
           decimal+=((num%10)*Math.pow(2,cont));
           num=num/10;
           cont++;
        }while(num!=0);
        Mostrar(decimal); 
    }
    
    /*
     Metodo que muestra los resultados obtenidos por CalcularBin ó CalcularDec
     */
    
    public void Mostrar(int num)
    {
        
        int res=num;
        VentanaSal ventS=new VentanaSal();
        ventS.setVisible(true);
        ventS.pintar("El numero "+num_original+" convertido es: "+res);

    }
}
