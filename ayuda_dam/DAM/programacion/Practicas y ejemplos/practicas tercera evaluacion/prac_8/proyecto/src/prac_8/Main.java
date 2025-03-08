/**************************************
 * Autor: Manuel Gutierrez Torrero    *
 * 1º D.A.M.                          *
 * Practicas 3ª ev. Java              *
 **************************************/

package prac_8;

import GUI.VentanaEnt;
import GUI.VentanaSal;
import java.awt.Graphics;

public class Main {


    int dimension=0,linea=0,c,total=0,n=0;
    public static void main(String[] args) {
       Main ap=new Main();

       VentanaEnt ventE=new VentanaEnt("teclee la dimension del diamante (min 3)",ap);
       ventE.setVisible(true);

    }
    
    /*
     * DibujarDiamante: Metodo encargado de dibujar un diamante en la pantalla
     * en base a la dimension del lado enviada como parametro de entrada
     * que sera un numero entero. Para mostraro lanzara una ventana de salida
     */
    
    public void dibujarDiamante(int dim,String car,String color)
    {
        this.dimension=dim;
        VentanaSal ventS=new VentanaSal(color,this.dimension);
        ventS.setVisible(true);
        
        
    }

}
