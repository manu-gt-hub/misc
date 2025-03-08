package data;

import GUI.Ventana;

public class main {

    public static void main(String[] args) {
        Bola b1=new Bola(50,50,50,50);
        Bola b2=new Bola(250,50,50,50);
        new Ventana(b1,b2).setVisible(true);
    }
}
