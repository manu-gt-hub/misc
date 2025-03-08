/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author profesor
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        File f=new File("prueba.txt");
        Scanner sc=null;
        try {
            sc=new Scanner(f);
        } catch (FileNotFoundException ex) {
            System.out.println("No encuentro el fichero"+f.getName());
            System.exit(1);
        }        
        while(sc.hasNext()){
            System.out.println(""+ sc.nextLine());
        }
    }
}
