/*
MATRICES
 */
public class Ejercicio11 {
              
    public static void main(String[] args) {
    //creamos una matriz de 3 x 3 posiciones en la que incluiremos numeros aleatorios 
    // del 0 al 10
    int[][] numeros = new int[3][3];
    //definimos el rango
    int max = 9; 
    int min = 1; 
    int range = max - min + 1; 
    //recorremos la posicion de la matriz añadiendo los numeros
    for (int i = 0; i < numeros.length; i++) {
        for (int j = 0; j < numeros.length; j++) {
            int aleatorio = (int)(Math.random() * range) + min; 
            System.out.println("metiendo en la posicion: "+i+"-"+j+" el valor: "+aleatorio);
            numeros[j][i]=aleatorio;            
        }         
    }
    //recorremos la matriz para mostrar los numeros
    for (int i = 0; i < numeros.length; i++) {
        System.out.print("|");
        for (int j = 0; j < numeros.length; j++) {
          System.out.print(numeros[j][i]+" | ");
        }    
        System.out.print("\n");
    }
  }
}
