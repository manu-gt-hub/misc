
import Clases.Coche;
import Clases.Estudiante;
import Clases.Persona;

/*
OBJETOS CON HERENCIA
 */
public class Ejercicio14 {
    public static void main(String[] args) {
        //DESCOMENTAR ESTA LINEA PARA VER QUE NO SE PUEDE CREAR UN OBJETO PERSONA
        //Persona mi_persona=new Persona();
        
        //nos creamos un nuevo estudiante utilizando la clase Estudiante
        Estudiante mi_estudiante = new Estudiante("Fernando","123456F",28,"Carlos III","informatica",6.98);
        //accedemos a sus atributos
        //estos campos son de persona, pero como Estudiante hereda de persona, podemos acceder a ellos
        System.out.println("Nombre: "+mi_estudiante.nombre);
        System.out.println("DNI: "+mi_estudiante.dni);
        System.out.println("Edad: "+mi_estudiante.edad);
        //estos campos son de estudiante
        System.out.println("Universidad: "+mi_estudiante.universidad);
        System.out.println("Carrera: "+mi_estudiante.nombre_carrera);
        System.out.println("Nota: "+mi_estudiante.nota_final);
    }
}
