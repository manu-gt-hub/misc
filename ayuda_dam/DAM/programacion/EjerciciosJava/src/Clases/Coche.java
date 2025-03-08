/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author M
 */
public class Coche {
    //atributos de la clase coche
    public String marca;
    public String modelo;
    public int año;
    //constructor de la clase Coche
    //ponemos el prefijo _ guion bajo a los parametros
    //para diferenciarlos de los atributos de la clase
    //a la hora de asignarlos
    public Coche(String _marca,String _modelo,int _año)
    {
        //atributos propios de Coche
        this.marca=_marca;
        this.modelo=_modelo;
        this.año=_año;
    }
}
