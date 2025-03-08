
package prac_1;

import GUI.Ventana;
/**************************************
 * Autor: Manuel Gutierrez Torrero    *
 * 1º D.A.M.                          *
 * Practicas 3ª ev. Java              *
 **************************************/
public class Prac_1 {

    public static void main(String[] args) {
        String nom="Manuel",ape1="Gutierrez",ape2="Torrero";
        int edad=23;
        Ventana ventana1=new Ventana(nom,ape1,ape2,edad);
        ventana1.setVisible(true);
    }
}
