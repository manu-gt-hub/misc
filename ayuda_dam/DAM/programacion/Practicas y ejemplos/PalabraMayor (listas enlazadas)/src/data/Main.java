/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.LinkedList;


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
        String txt="me me gusta me el deporte me el cine y mas mas y mas";
        LinkedList<Palabra> lista=new LinkedList();
        
        
        //1.Seleccionar las palabras del textoy guardarlas en la lista
        int posActual=0;
        int posEspacio=0;
        do{
            posEspacio=txt.indexOf(' ',posActual);
            if(posEspacio>=0)
            {
                posActual=gestionaPalabra(lista,txt,posActual,posEspacio);
            }
        }while(posEspacio>=0);        
        posActual=gestionaPalabra(lista,txt,posActual,txt.length());
        //lista.add(new Palabra(txt.substring(txt.lastIndexOf(" ")+1)));        
        
        //Compruebo q la lista es correcta
        for (Palabra palabra : lista) {
            System.out.println(""+palabra+" ");
        }                
        
        Palabra pMayor=lista.getFirst();
        /*
        for (Palabra palabra : lista) {
            if(pMayor.cont<palabra.cont)
                pMayor=palabra;
        }*/
        
        for (int i = 1; i < lista.size(); i++) {
            if(pMayor.cont<lista.get(i).cont)
                pMayor=lista.get(i);
        }
        
        System.out.println("La palabra que mas le gusta al autor es:"+pMayor);
        
        
        
        
    }

    /**
     * Busca la palabra p en la lista l
     * Si la encuentra devuelve un puntero a ella
     * Si no devuelve null 
     * @param lista
     * @param palabra
     * @return 
     */
    private static Palabra encontrado(LinkedList<Palabra> l, Palabra p) {
        
        for (Palabra palabra : l) 
        {
            if(palabra.cad.equals(p.cad))
                return palabra;
        }        
        return null;
    }

    private static int gestionaPalabra(LinkedList<Palabra>lista,String txt,int posActual,int posEspacio) {
        
        Palabra palabra=new Palabra(txt.substring(posActual, posEspacio));
        Palabra p=encontrado(lista,palabra);
        if( p!=null   )//lo he encontrado
        {
            //incremento el contador                    
            p.cont++;
        }else{
            //Agrego la palabra
            lista.add(palabra);                    
        }
        posActual=posEspacio+1;
        return posActual;
    }
}





class Palabra
{
    String cad;
    int cont;

    public Palabra(String cad) {
        this.cad = cad;
        cont=1;
    }

    @Override
    public String toString() {
        return cad+" -->"+cont;
    }
    
    
    
    
}
