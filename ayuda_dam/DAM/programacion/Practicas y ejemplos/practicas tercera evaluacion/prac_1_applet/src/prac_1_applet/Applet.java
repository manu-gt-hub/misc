
/**************************************
 * Autor: Manuel Gutierrez Torrero    *
 * 1º D.A.M.                          *
 * Practicas 3ª ev. Java              *
 **************************************/

package prac_1_applet;

import javax.swing.JApplet;
import java.awt.*;


public class Applet extends JApplet{

    @Override
    public void paint(Graphics g){
     g.drawString("Practica 1: Applet",40,20);
     g.drawString("Nombre: Manuel",40,80);
     g.drawString("Apellido 1: Gutierrez",40,100);
     g.drawString("Apellido 2: Torrero",40,120);
     g.drawString("Edad: 23",40,140);
   }
       
}
