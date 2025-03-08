
import java.util.LinkedList;

/*
LISTAS ENLAZADAS
 */
public class Ejercicio12 {
    public static void main(String[] args) {
        //creamos una lista enlazada de tipo int vacia
        LinkedList<Integer> lista_enlazada = new LinkedList<Integer>();
        //añadimos 3 valores
        lista_enlazada.add(24);
        lista_enlazada.add(56);
        lista_enlazada.add(12);
        System.out.println("MOSTRAMOS RESULTADOS");
        //los mostramos por consola
        for (int i = 0; i < lista_enlazada.size(); i++) {
            System.out.println("valor "+i+": "+lista_enlazada.get(i));
        }
        //eliminamos un elemento (elemento 2) de la lista
        lista_enlazada.remove(2);
        System.out.println("MOSTRAMOS RESULTADOS");
        //volvemos a mostrar los valores
        for (int i = 0; i < lista_enlazada.size(); i++) {
            System.out.println("valor "+i+": "+lista_enlazada.get(i));
        }
    }
}
