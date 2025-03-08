/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ficheros2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author juanxxiii
 */
public class Ficheros2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        File archivo=new File("informe.txt");
        Scanner sc=null;
        BufferedWriter bw = new BufferedWriter(new FileWriter("informe2.txt"));
        try {
            sc=new Scanner(archivo);
            sc.useDelimiter("[-:\n]");
        } catch (FileNotFoundException ex) {
            System.out.println("\nERROR: No se encontro el fichero: "+archivo.getName()+"\n");
            System.exit(1);
        } 
        
        //System.out.println("\n *** INFORME DE BAJAS ***\n");
        bw.write("*** INFORME DE BAJAS ***");bw.newLine();bw.newLine();
        String dato;
        int n=0;
        while(sc.hasNext()){
            bw.flush();
            dato=sc.next();
            //System.out.println("dato: "+dato);
            n++;
            switch(n)
            {
                case 1:
                    bw.write("Provincia: "+dato);bw.newLine();
                break;
                case 2:
                    bw.write("  "+dato);
                break;
                case 3:
                    bw.write(": "+dato);bw.newLine();
                break;
                case 4:
                    bw.write("  "+dato);
                break;
                case 5:
                    bw.write(": "+dato);bw.newLine();bw.newLine();
                    n=0;
                break;
            }    
            
            //System.out.println(dato);  

        }
        bw.close();
        
        
    }
}
