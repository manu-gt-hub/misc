
/*********************************
 * Practica 9   Desifrados       *
 * Manuel Gutierrez Torrero      *
 * 1º DAM                        *
 *********************************/

package prac_descifrados;

import GUI.Ventana;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
Aplicacion creada para descifrar un texto cifrado en este caso por mi compañero
*Juan Jose.
* Primero se comprueba si hay coincidencias coherentes (letras mayusculas, minusculas,
* espacios o numeros) al descifrar el contenido sumandole cierto numero a todos los caracteres
* , el siguiente proceso es el mismo pero restandole el numero a todos los caracteres
* del texto a descifrar, el tercer proceso es sumando un numero a las vocales y restando
* ese mismo numero a las consonantes, espacios o numeros y el ultimo proceso
* se encarga de restar el numero a las vocales y sumarselo a los caracteres que sean
* consonantes, espacios o numeros.
* Los numeros crecen con un ciclo for que va desde 0 a 127 para recorrer la tabla ASCII.
* Si los caracteres descifrados son "coherentes" se añaden a una lista enlazada que se mostrara
* al final de la lectura del texto si todos sus caracteres eran coherentes y se rechazara en 
* caso contrario.
* 
* METODOS DE DESCIFRADO:
* 
* 1. Sumando numeros a los caracteres
* 2. Restando numeros a los caracteres
* 3. Sumando numeros a las vocales y restandoselo a las consonantes, espacios y/o numeros
* 4. Sumando numeros a las consonantes, espacios u/o numeros y restandoselo a las vocales
 */
public class Main {
    static Main ap;
    public static void main(String[] args) throws FileNotFoundException, IOException {
        ap=new Main();
        new Ventana(ap).setVisible(true);
        
    }
    
}
