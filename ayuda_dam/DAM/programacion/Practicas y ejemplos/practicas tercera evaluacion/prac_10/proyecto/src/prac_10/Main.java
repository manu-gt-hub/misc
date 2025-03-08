/**************************************
 * Autor: Manuel Gutierrez Torrero    *
 * 1º D.A.M.                          *
 * Practicas 3ª ev. Java              *
 **************************************/


package prac_10;

import GUI.*;


public class Main {

    int cont=0,i=0;
    String cad1=null;
    String cad2=null;
    public static void main(String[] args) {
        Main ap=new Main();

        VentanaEnt ventE=new VentanaEnt("teclee la primera cadena: ","Teclee la cadena a buscar: ",ap);
        ventE.setVisible(true);
       
        
        
            
        
    }
    
    /*
     * metodo set de cadena 1 (cad1) que verificara que cad1 no sea nulo antes
     * de insertar cualquier valor
     */
    
    public void setCad1(String cad)
    {
        if(cad!=null)
        {
            this.cad1=cad;
        }
        else
        {
            VentanaEnt ventE=new VentanaEnt("teclee la primera cadena: ","Teclee la cadena a buscar: ",this);
            ventE.setVisible(true);
        }
    }
    /*
     * metodo set de cadena 2 (cad2) que verificara que cad2 no sea nulo antes
     * de insertar cualquier valor
     */
    public void setCad2(String cad)
    {
        if(cad!=null)
        {
            this.cad2=cad;
        }
        else
        {
            VentanaEnt ventE=new VentanaEnt("teclee la primera cadena: ","Teclee la cadena a buscar: ",this);
            ventE.setVisible(true);
        }
    }
    
    /*
     El metodo buscarCadena se encargara de buscar el numero de ocurrencias
     * de la cadena: cad2 sobre la cadena: cad1
     */
    
    public void buscarCadena()
    {
        int index=cad1.length();
        do
        {

            index=cad1.lastIndexOf(cad2, index-1);
            if(index!=-1)
            {
                cont++;
            }
            i++;
        }while(i<cad1.length() && index!=-1);
        VentanaSal ventS=new VentanaSal();
        ventS.setVisible(true);
        ventS.pintar("La cadena: "+cad2+" aparece "+cont+" veces");
    }
}
