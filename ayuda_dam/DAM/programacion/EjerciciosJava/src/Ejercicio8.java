/*
ARRAYS
 */
public class Ejercicio8 {
        
    public static void main(String[] args) {
    //declaramos un array de 3 posiciones de tipo string
    //las posiciones del array siempre empiezan en cero
    //en este caso las posiciones serian 0 , 1 y 2
    String[] mi_array = new String[3];
    
    //asignamos valores a las posiciones del array
    
    mi_array[0] = "Fernando";
    mi_array[1] = "Manuel";
    mi_array[2] = "Juanito";
    
    //mostramos sus valores por pantalla
    System.out.println("valor posicion 0 del array: "+mi_array[0]);
    System.out.println("valor posicion 1 del array: "+mi_array[1]);
    System.out.println("valor posicion 2 del array: "+mi_array[2]);
  }
}
