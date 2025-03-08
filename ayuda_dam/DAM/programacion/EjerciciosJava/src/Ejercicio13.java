
import Clases.Coche;

/*
CREACION DE OBJETOS
 */
public class Ejercicio13 {
    public static void main(String[] args) {
        //nos creamos un nuevo coche utilizando la clase Coche
        Coche mi_coche = new Coche("Volkswagen","Passat",1995);
        //accedemos a sus atributos
        System.out.println("Marca: "+mi_coche.marca);
        System.out.println("Modelo: "+mi_coche.modelo);
        System.out.println("Año: "+mi_coche.año);
        
        //nos creamos otro coche
        Coche mi_coche2 = new Coche("Peugeot","406",2000);
        System.out.println("OTRO COCHE");
        //accedemos a sus atributos
        System.out.println("Marca: "+mi_coche2.marca);
        System.out.println("Modelo: "+mi_coche2.modelo);
        System.out.println("Año: "+mi_coche2.año);
    }
}
