/*
INTENTAR ASIGNAR OTRO VALOR A UNA CONSTANTE
 */
public class Ejercicio3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // declaramos un primer valor a la CONSTANTE palabra
        // con el atributo final al principio
        final String palabra="Fernando";
        //intentamos asignar otro valor a la CONSTANTE  y vemos que no nos deja
//DESCOMENTAR        palabra="Javier";
        //la mostramos por pantalla
        System.out.println("Hola, me llamo: "+palabra);
    }
    
}
