/**************************************
 * Autor: Manuel Gutierrez Torrero    *
 * 1º D.A.M.                          *
 * Practicas 3ª ev. Java              *
 **************************************/


package prac_2;

import GUI.VentanaEnt;
import GUI.VentanaModal;
import GUI.VentanaSal;
import java.util.Scanner;
import java.io.*;


public class Main {
    

    static int i=0;
    static final int asis=3;
    static Asistente[] asistentes=new Asistente[asis];   
    public static void main(String[] args) {

        Main ap=new Main();  
        VentanaModal ventM=new VentanaModal(ap,i);
        ventM.setVisible(true);

    }
    /*
     El metodo recoAsistentes lanzara tantas ventanas de entrada como posiciones
     * haya en el array asistentes, una vez relleno, se lanzara una ventana
     * de entrada para solicitar el nombre del niño a buscar 
     */
    public void RecoAsistentes(String nom)
    {
        this.asistentes[this.i]=new Asistente(nom);
        i++;
        if(this.i<asistentes.length)
        {
            
            
            VentanaEnt ventE=new VentanaEnt("Teclee el nombre del niño numero: "+(this.i+1),this,0);
            ventE.setVisible(true);
        }
        else
        {
            VentanaEnt ventE=new VentanaEnt("Teclee el nombre del niño a buscar: ",this,1);
            ventE.setVisible(true);
        }
    }
    
    /*
     El metodo buscarAsis se encarga de buscar un asistente dentro del array
     * asistentes basando su busqueda en el parametro nom, que sera el nombre
     * del mismo
     */
    
    public void BuscarAsis(String nom) {
        VentanaSal ventS=new VentanaSal();
        ventS.setVisible(true);
        boolean ver=false;
        for (int i = 0; i < asistentes.length && asistentes[i]!=null && ver!=true; i++) {
            if(asistentes[i].nombre.compareTo(nom)==0)
            {
                ventS.pintar("El niño asistió a la fiesta");
                ver=true;
            }
            
        }
        if(ver==false)
        {
            ventS.pintar("El niño no asistio a la fiesta");
        }
    }
    public Asistente[] getArrayAsis() {
        return this.asistentes;
    }
    
    /*
     * ModoTexto: Metodo encargado de realizar la gestion del programa enteramente en modo 
     * texto
     */
    
    public void ModoTexto()
    {
        Scanner sc=new Scanner(System.in);
        //Console consola = System.console();
        String nom;
        for (int j = 0; j < asistentes.length; j++) {
            //consola.printf("Teclee el nombre del niño numero: "+(j+1));
            System.out.println("Teclee el nombre del niño numero: "+(j+1));
            nom=sc.nextLine();
            //nom=consola.readLine();
            asistentes[j]=new Asistente(nom);
            
        }
        System.out.println("Teclee el nombre del niño a buscar: ");
        nom=sc.nextLine();
        //nom=consola.readLine();
        boolean ver=false;
        for (int i = 0; i < asistentes.length && asistentes[i]!=null && ver!=true; i++) {
            if(asistentes[i].nombre.compareTo(nom)==0)
            {
                System.out.println("El niño asistió a la fiesta");
                ver=true;
            }
            
        }
        if(ver==false)
        {
            System.out.println("El niño no asistio a la fiesta");
        }
    }
}
