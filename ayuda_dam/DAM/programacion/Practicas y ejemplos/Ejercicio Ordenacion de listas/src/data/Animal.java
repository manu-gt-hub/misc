/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

/**
 *
 * @author profesor
 */
public class Animal 
{
    
    String especie;
    String nombre;
    int patas;

    public Animal(String especie, String nombre) {
        this.especie = especie;
        this.nombre = nombre;
    }

    
    
    public Animal(String especie, String nombre, int patas) {
        this.especie = especie;
        this.nombre = nombre;
        this.patas = patas;
    }

    @Override
    public String toString() {
        return "Animal{" + "especie=" + especie + ", nombre=" + nombre + ", patas=" + patas + '}';
    }
    
    
    
    
}
