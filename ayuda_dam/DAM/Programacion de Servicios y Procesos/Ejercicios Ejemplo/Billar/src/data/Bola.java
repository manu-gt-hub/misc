package data;

import java.awt.Color;
import java.awt.Graphics;

public class Bola {
    int x;
    int y;
    int ancho;
    int alto;

    public Bola(int x, int y, int ancho, int alto) {
        this.x = x;
        this.y = y;
        this.ancho = ancho;
        this.alto = alto;
    }
    
    public void dibujar(java.awt.Graphics2D g2){
        g2.setColor(Color.BLACK);
        g2.fillOval(x, y, ancho, alto);
    }
}
