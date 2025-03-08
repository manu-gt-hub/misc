/*
Ejercicio para manejar flujos de entrada y salida y listas enlazadas
* 
* consiste en copiar un fichero completo pero al reves
 */
package ficheros3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedList;


/**
 *
 * @author juanxxiii
 */
public class Ficheros3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        LinkedList<Integer> lista=new LinkedList();
        FileInputStream in= null;
        FileOutputStream out= null;

            in = new FileInputStream("origen.txt");
            out = new FileOutputStream("destino.txt");
            int c=0,cont=0;
            while ((c=in.read())!=-1)
            {
                cont++;
                lista.add(c);
            }
            for (cont=cont-1;cont>-1 ; cont--) {
                 out.write(lista.get(cont));
            }
            
          
            if(in!=null)
            {
                in.close();
            }
            if(out!=null)
            {
                out.close();
                System.out.println("FICHERO COPIADO");
            }
            
        
    }
}
