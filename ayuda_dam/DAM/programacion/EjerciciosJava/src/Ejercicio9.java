/*
ARRAYS Y BUCLES WHILE, FOR Y FOR EACH
 */
public class Ejercicio9 {
            
    public static void main(String[] args) {
    //declaramos un array de 3 posiciones de tipo string
    //las posiciones del array siempre empiezan en cero
    //en este caso las posiciones serian 0 , 1 y 2
    String[] mi_array = new String[3];
    
    //asignamos valores a las posiciones del array
    
    mi_array[0] = "Fernando";
    mi_array[1] = "Manuel";
    mi_array[2] = "Juanito";
    
    int contador=0;
    //mostramos sus valores por pantalla con un bucle WHILE
    //desde 0 al final del array
    System.out.println("Bucle WHILE");
    while(contador < mi_array.length)
    {
        System.out.println("valor de la posicion "+contador+" del array "+mi_array[contador]);
        //incrementamos el contador en +1 contador++ es igual que hacer contador=contador+1
        contador++;
    }
            
    //mostramos sus valores por pantalla con un bucle FOR
    // la notacion significa:
    // partiendo de la variable int i=0;
    // mientras i sea menor que la longitud de mi_array
    //por cada loop del bucle: i = i + 1;
    System.out.println("Bucle FOR");
    for(int i=0;i < mi_array.length;i++)        
    {
       System.out.println("valor de la posicion "+i+" del array "+mi_array[i]);
    }
            
    //mostramos sus valores por pantalla con un bucle FOR
    // la notacion significa:
    // partiendo de la variable int i=0;
    // mientras i sea menor que la longitud de mi_array
    //por cada loop del bucle: i = i + 1;
    System.out.println("Bucle FOR EACH");
    int contador_foreach=0;
    for(String s:mi_array)       
    {
       System.out.println("valor de la posicion "+contador_foreach+" del array "+s);
       contador_foreach++;
    }
  }
}
