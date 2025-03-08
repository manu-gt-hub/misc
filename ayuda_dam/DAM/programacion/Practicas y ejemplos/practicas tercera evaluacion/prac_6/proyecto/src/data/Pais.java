/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

public class Pais {
    String nombre;
    int pob;//Grados centígrados
    
    public Pais(String nombre, int pob) {
        this.nombre = nombre;
        this.pob = pob;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPob() {
        return pob;
    }
    
    

}
