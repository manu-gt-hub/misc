

package prac_1.pkg2;

import GUI.Ventana;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class Main {


    static Scanner sc=null;
    static int n;
    static String pal="";
    public static void main(String[] args) {
        //genero numero aleatorio para buscar palabra dentro del fichero palabras.txt
       seleccionarPalabra();
        
        //lanzo la ventana
        new Ventana(n,pal).setVisible(true);
    }
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        sc.close();
    }

    static void seleccionarPalabra() {
        File archivo=new File("palabras.txt");
        
        Random rand = new Random();
        n = rand.nextInt(18);
        int i=0;
        try {
            sc=new Scanner(archivo);
            sc.useDelimiter("[:\n]");
        } catch (FileNotFoundException ex) {
            System.out.println("\nERROR: No se encontro el fichero: "+archivo.getName()+"\n");
            System.exit(1);
        } 
        while(sc.hasNext() && pal=="")
        {
            
            if(i==n)
            {
               pal=sc.next(); 
            }
            else
            {
                sc.next();
            }
            i++;
        }
    }
}
