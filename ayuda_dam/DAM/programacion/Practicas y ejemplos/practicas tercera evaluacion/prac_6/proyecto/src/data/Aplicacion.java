/**************************************
 * Autor: Manuel Gutierrez Torrero    *
 * 1º D.A.M.                          *
 * Practicas 3ª ev. Java              *
 **************************************/

package data;

import GUI.VentanaEntrada;
import GUI.VentanaSalida;


public class Aplicacion {
    static final int numPaises=3;
    Pais[] paises; 
    int numPaisesCnValor=0;
    Pais p1;
    Pais p2;

    /*Metodo constructor de la clase Aplicacion que recibe como parametro
     el numero de paises que contendrá*/
    
    public Aplicacion(int numPaises) 
    {
        paises=new Pais[numPaises];
    }
   
    
    
    public static void main(String[] args) {
        Aplicacion ap=new Aplicacion(numPaises);
        new VentanaEntrada(ap).setVisible(true);
    }

    /*guardar: Metodo que se encarga de guardar el nombre y la poblacion de 
     cada pais en la posicion correspondiente del array paises.
     Será invocado desde los objetos de la clase VentanaEnt*/

    public void guardar(String nom, int pob) {
        VentanaEntrada vent=new VentanaEntrada(this);
        if(numPaisesCnValor<paises.length)
        {
            paises[numPaisesCnValor]=new Pais(nom,pob);
            numPaisesCnValor++;
        }
        if(numPaisesCnValor<paises.length){            
             
            vent.setVisible(true);
        }else
            vent.dispose();
            p1=mayor(paises);
            p2=menor(paises);
            float media=media(paises);
            new VentanaSalida(p1,p2,media).setVisible(true);
    }
    
    /*
     mayor: Metodo encargado de encontrar el objeto pais con mayor poblacion
     * del array paises.
     * recibe como parametro de entrada el array paises y devuelve un objeto pais
     */
    
    Pais mayor(Pais[] paises)
    {
        int mayor=0;
        for (int i = 1; i < this.numPaisesCnValor; i++) {
            if(paises[i].pob>paises[mayor].pob)
            {
                mayor=i;
            }
            
        }
        return paises[mayor];
    }
    
    /*
     menor: Metodo encargado de encontrar el objeto pais con menor poblacion
     * del array paises.
     * recibe como parametro de entrada el array paises y devuelve un objeto pais
     */
    
    Pais menor(Pais[] paises)
    {
        int menor=0;
        for (int i = 1; i < this.numPaisesCnValor; i++) {
            if(paises[i].pob<paises[menor].pob)
            {
                menor=i;
            }
            
        }
        return paises[menor];
    }
    
    /*
     media: Metodo encargado de calcular la media de poblacion dentro 
     * del array paises.
     * recibe como parametro de entrada el array paises y devuelve un numero
     * real con el resultado 
     */
    
    float media(Pais[] paises)
    {
        float media=0;
        int i;
        for (i = 0; i < paises.length; i++) {
            media=media+paises[i].pob;        
        }
        media=(media/i);
        return media;
    }
}
