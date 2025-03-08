/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

/**
 *
 * @author profesor
 */
public class Coche implements Comparable{
    String matricula;
    int numPlazas;
    String marca, modelo;

    public Coche(String matricula, int numPlazas, String marca, String modelo) {
        this.matricula = matricula;
        this.numPlazas = numPlazas;
        this.marca = marca;
        this.modelo = modelo;
    }

    @Override
    public int compareTo(Object o) {
        Coche otro=(Coche)o;
        if(this.matricula.compareToIgnoreCase(otro.matricula)==0)
            return this.modelo.compareToIgnoreCase(otro.modelo);
        
        return this.matricula.compareToIgnoreCase(otro.matricula);
    }

    @Override
    public String toString() {
        return "Coche{" + "matricula=" + matricula + ", numPlazas=" + numPlazas + ", marca=" + marca + ", modelo=" + modelo + '}';
    }
    
    
    
    
    
}
