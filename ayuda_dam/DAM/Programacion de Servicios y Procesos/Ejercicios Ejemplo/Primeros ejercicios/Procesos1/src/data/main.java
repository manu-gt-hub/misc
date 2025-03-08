package data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/* ENUNCIADO
Haga un programa que visualice por pantalla unicamente los ficheros de un directorio.
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        Scanner sc=new Scanner(System.in);
        System.out.println("Introduce la ruta: ");
        String comando=sc.nextLine();
        try{
        String[] ruta={"cmd","/c","dir","/a-d","/b",comando};
            Process p=Runtime.getRuntime().exec(ruta);
            BufferedReader input= new BufferedReader(new InputStreamReader(p.getInputStream()));        
                do{
                    System.out.println(input.readLine());
                }while(input.readLine()!=null);
        }catch(Exception e){
        
        }
    }
}
