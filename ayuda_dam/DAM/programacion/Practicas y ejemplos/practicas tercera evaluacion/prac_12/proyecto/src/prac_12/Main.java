
/**************************************
 * Autor: Manuel Gutierrez Torrero    *
 * 1º D.A.M.                          *
 * Practicas 3ª ev. Java              *
 **************************************/

package prac_12;

import GUI.*;
import javax.swing.JTextField;


public class Main {

    static final int PRES=10;

    static int pres_con_valor=4;
    static Prestamista[] prestamistas=new Prestamista[PRES];
    public static void main(String[] args) {
        Main ap=new Main();
        generarDatosPrueba();
        VentanaModal ventM=new VentanaModal(ap);
        ventM.setVisible(true);
        
    }
    public void AñadirPres(Prestamista pre)
    {
        prestamistas[pres_con_valor]=pre;
        pres_con_valor++;
    }
    
    
    /*
     * ModificarPres: Es un metodo encargado de  modificar el campo que haya
     * seleccionado el usuario en el combobox de la ventana de modificacion
     * por el valor que haya tecleado
     */
    
    public void ModificarPres(String nom,int op,String mod)
    {
        int j;
        for (int i = 0; i < prestamistas.length; i++) {
            if(prestamistas[i].nom.compareTo(nom)==0)
            {
                   switch(op)
                   {
                       case 0:
                           prestamistas[i].nom=mod;
                           break;
                       case 1:
                           prestamistas[i].interes=Float.parseFloat(mod);
                           break;
                       case 2:
                           prestamistas[i].plazo=Integer.parseInt(mod);
                           break;
                       case 3:
                           prestamistas[i].tot_cuota=Integer.parseInt(mod);
                           break;
                   }
                   new VentanaSal("Prestamista modificado");
            }
            
        }
    }
    /*
     * EliminarPres: Metodo encargado de eliminar un prestamista del array
     * prestamistas y de recolocarlo una vez eliminado dicho prestamista, 
     * el cual sera localizado mediante el parametro nom de tipo cadena
     */
    
    public void EliminarPres(String nom)
    {
        int j;
        for (int i = 0; i < prestamistas.length; i++) {
            if(prestamistas[i].nom.compareTo(nom)==0)
            {
                for (j = i; j < prestamistas.length-1; j++) {
                    prestamistas[j]=prestamistas[j+1];
                    
                }
                i=j;
            }
            
        }
    }
    
    /*
     * generarDatosPrueba: Metodo que generara en este caso 4 objetos prestamista
     * para usarlos como datos de prueba
     */
    
    public static void generarDatosPrueba() {
        
        prestamistas[0]=new Prestamista("manu",1.5f,12,2);
        prestamistas[1]=new Prestamista("pedro",0.5f,24,2);
        prestamistas[2]=new Prestamista("pepe",2.0f,6,2);
        prestamistas[3]=new Prestamista("ignacio",1.8f,24,2);

        
    }
    public void VisPres()
    {
        
        VentanaSal ventS=new VentanaSal("Prestamistas");
        ventS.setVisible(true);
        for (int i = 0; i < prestamistas.length; i++) {
            ventS.pintar("Nombre: "+prestamistas[i].nom+"\n");
            ventS.pintar("   interes: "+String.valueOf(prestamistas[i].interes)+"\n");
            ventS.pintar("   plazos: "+String.valueOf(prestamistas[i].plazo)+"\n");
            ventS.pintar("   total cuota:"+String.valueOf(prestamistas[i].tot_cuota)+"\n\n");
            
        }
    }
    public void VisPres(String nom)
    {
        int ver=0;
        VentanaSal ventS=new VentanaSal("Prestamista");
        ventS.setVisible(true);
        for (int i = 0; i < prestamistas.length; i++) {
            if(prestamistas[i].nom.compareTo(nom)==0)
            {
                ver=1;
                ventS.pintar("Nombre: "+prestamistas[i].nom+"\n");
                ventS.pintar("   interes: "+String.valueOf(prestamistas[i].interes)+"\n");
                ventS.pintar("   plazos: "+String.valueOf(prestamistas[i].plazo)+"\n");
                ventS.pintar("   total cuota:"+String.valueOf(prestamistas[i].tot_cuota)+"\n\n");
            }
            
            
        }
        if(ver==0)
        {
            ventS.pintar("No se encontro ningun prestamista\ncon el nombre "+nom);
        }
    }

}
