/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

//hacemos la clase abstracta porque no queremos que se instancie
//una persona como tal, si no su clase hija: estudiante,profesor etc
public abstract class Persona {
    //atributos propios de la clase persona
    public String dni="";
    public String nombre="";
    public int edad;
}
