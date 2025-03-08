/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

/**
 *
 * @author Profesor
 */
public enum VelocidadAnimacion {
    
    MUY_LENTA(50),LENTA(30),NORMAL(15),RAPIDA(10),MUY_RAPIDA(5);
    
    private int valor;

    private VelocidadAnimacion(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }
    
    
    
    
}
