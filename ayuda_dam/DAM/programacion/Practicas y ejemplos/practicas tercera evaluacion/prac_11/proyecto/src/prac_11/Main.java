
/**************************************
 * Autor: Manuel Gutierrez Torrero    *
 * 1º D.A.M.                          *
 * Practicas 3ª ev. Java              *
 **************************************/

package prac_11;

import GUI.VentanaEnt;
import GUI.VentanaMenu;
import GUI.VentanaSal;

public class Main {


    static Producto[] productos=new Producto[5];
    public static void main(String[] args) {
        Main ap=new Main();
        generarDatosPrueba();
        VentanaMenu ventM=new VentanaMenu("¿Que desea hacer?",ap);
        ventM.setVisible(true);
        
    }
    /*
     * generarDatosPrueba: Metodo que generara en este caso 5 objetos genericos
     * de tipo producto como datos de prueba
     */
    static void generarDatosPrueba()
    {
        productos[0]=new Producto("manzanas",0.30f,8);
        productos[1]=new Producto("peras",1.4f,2);
        productos[2]=new Producto("uvas",0.90f,5);
        productos[3]=new Producto("melocotones",0.07f,14);
        productos[4]=new Producto("cocos",0.34f,31);
    } 
    
    /*
     * evaluar: Este metodo se encargara segun la opcion elegida (op) de
     * realizar una operacion u otra de acuerdo con el menu mostrado
     */
    
    public void evaluar(int op)
    {
        VentanaSal ventS;
        VentanaEnt ventE;
        switch(op)
        {
            case 1:
                ventS=new VentanaSal();
                for (int i = 0; i < productos.length; i++) {
                    ventS.pintar("producto: "+productos[i].nombre+" - Existencias:  "+productos[i].existencias+"\n");
 
                }
                ventS.setVisible(true);
            break;
            case 2:
                ventS=new VentanaSal();
                for (int i = 0; i < productos.length; i++) {
                    ventS.pintar("producto: "+productos[i].nombre+
                                 " - Ganancia:  "+
                                 (productos[i].existencias*productos[i].precio)+
                                 " ("+productos[i].existencias+" X "+productos[i].precio+") "+"\n");
 
                }
                ventS.setVisible(true);
            break;
            case 3:
                ventS=new VentanaSal();
                int ver=0;
                for (int i = 0; i < productos.length; i++) {
                    if(productos[i].existencias<5)
                    {
                        ver=1;
                        ventS.pintar("producto: "+productos[i].nombre+" - Existencias: "+productos[i].existencias);
                    }
                }
                if(ver==0)
                {
                    ventS.pintar("Todos los productos tienen 5 o más existencias");
                }
                ventS.setVisible(true);
            break;
            case 4:
                ventE=new VentanaEnt("Teclee el nombre del producto que desea vender","Teclee la cantidad que desea vender:",this);
                ventE.setVisible(true);
            break;
        }
    }
    
    /*
     * vender: Metodo que realiza una "venta" en el sistema y que recibe como
     * parametros una cadena con el nombre del producto y la cantidad vendida.
     * 
     * Busca una coincidencia en el array productos en base al nombre y resta
     * dicha cantidad al atributo existencias
     */
    
    public void vender(String nom,int cant) {
                VentanaSal ventS=new VentanaSal();
                int ver=0;
                for (int i = 0; i < productos.length; i++) {
                    if(productos[i].nombre.compareTo(nom)==0)
                    {
                        ver=1;
                        ventS.pintar("Se han vendido: "+cant+" "+nom+" ,aun quedan: "+(productos[i].existencias-cant));
                        productos[i].existencias-=cant;
                    }
                }
                if(ver==0)
                {
                    ventS.pintar("Nombre o cantidad incorrectos!");
                }
                ventS.setVisible(true);
    }
}

