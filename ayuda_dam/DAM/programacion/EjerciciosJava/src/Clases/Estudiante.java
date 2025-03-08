/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;
//estudiante hereda de persona
public class Estudiante extends Persona{
    public String universidad;
    public String nombre_carrera;
    public double nota_final;
    //constructor de la clase Estudiante
    //le pasamos tanto los atributos propios del estudiante como los de persona
    public Estudiante(
            String _nombre,String _dni,int _edad,String _universidad,
            String _nombre_carrera,double _nota_final)
    {
        //atributos propios de Estudiante
        this.universidad=_universidad;
        this.nombre_carrera=_nombre_carrera;
        this.nota_final=_nota_final;
        
        //atributos propios de Persona
        //podemos asignarlos aunque no estan en esta clase
        //porque estudiante hereda de persona
        this.edad=_edad;
        this.dni=_dni;
        this.nombre=_nombre;
    }
}
