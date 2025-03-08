/*
ACUMULADORES
 */
public class Ejercicio10 {
                
    public static void main(String[] args) {
    //declaramos un array de 3 posiciones de tipo string
    //las posiciones del array siempre empiezan en cero
    //en este caso las posiciones serian 0 , 1 y 2
    int[] numeros = new int[3];
    
    //asignamos valores a las posiciones del array
    
    numeros[0] = 4;
    numeros[1] = 6;
    numeros[2] = 2;
    //el acumulador empieza valiendo cero
    int mi_acumulador=0;
    //vamos a sumar todos los valores del array numeros y a irlos acumulando
    //en la variable acumulador "mi_acumulador"
    System.out.println("valor del acumulador antes del bucle: "+mi_acumulador);
    for(int i=0;i < numeros.length;i++)    
    {
        //sumamos el valor de numeros[i] al acumulador
        mi_acumulador=mi_acumulador + numeros[i];
    }
    System.out.println("valor del acumulador despues del bucle: "+mi_acumulador);
  }
}
