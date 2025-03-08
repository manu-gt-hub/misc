/*
UTILIZAR UNA VARIABLE NULA
 */
public class Ejercicio5 {    

    public static void main(String[] args) {
        //asignamos un valor nulo a la variable palabra
        String palabra=null;
        //la mostramos por consola
        System.out.println("Hola, me llamo: "+palabra);
        //intentamos llamar a un metodo de esa variable (siendo nula) y vemos que
        //nos da una excepcion
        palabra.isEmpty();
    }
}
