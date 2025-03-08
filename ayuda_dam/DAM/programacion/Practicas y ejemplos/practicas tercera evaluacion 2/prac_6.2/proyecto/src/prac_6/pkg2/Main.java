
/*********************************
 * Practica 6   Ultramarinos     *
 * Manuel Gutierrez Torrero      *
 * 1º DAM                        *
 *********************************/

package prac_6.pkg2;

import GUI.VentanaEnt;
import GUI.VentanaSal;
import java.util.LinkedList;
import javax.swing.JOptionPane;

public class Main {

    static LinkedList<Articulo> lista;
    public static void main(String[] args) {
        Main ap=new Main();
        lista=new LinkedList();
        generarDatosPrueba(lista);
        new VentanaEnt(ap).setVisible(true);
        
  
    }
    
    private static void generarDatosPrueba(LinkedList list) {
        list.add(new Articulo(1,"art1",3,5.1f,5));
        list.add(new Articulo(2,"art2",1,3.2f,6));
        list.add(new Articulo(3,"art3",4,2.5f,7));
        list.add(new Articulo(4,"art4",3.5f,0.8f,8));
    }
    /*metodo encargado de buscar un nombre de articulo dentro de la lista
     * enlazada: lista
     */
    public void buscar(String nom,int cantidad,Main ref)
    {
        boolean ver=false;
        Main ap=ref;
        for (Articulo articulo : lista) {
            if(articulo.nombre.compareToIgnoreCase(nom)==0)
            {
                
                ver=true;
                //si la cantidad tecleada no sobrepasa las existencias
                if(articulo.cantidad>=cantidad)
                {
                  VentanaSal ventS=new VentanaSal(
                               "      *** ULTRAMARINOS *** \n\nTICKET DE VENTA:\n\nNombre articulo: "
                               +articulo.nombre+"\n"
                               +"  ID producto: "+articulo.id+"\n"+
                               "  Peso prod.: "+articulo.peso+"\n"+
                               "  Cantidad vendida: "+cantidad+"\n"+
                               "  Precio unit.: "+articulo.precio+"\n"+
                               "  Total a pagar: "+(articulo.precio*cantidad),ap);
                  ventS.setVisible(true);
                  articulo.cantidad=(articulo.cantidad-cantidad);
               }
                else
                {
                    JOptionPane.showMessageDialog(null,"No hay cantidad suficiente\ndel producto seleccionado");
                    new VentanaEnt(ap).setVisible(true);
                }
            }
            
        }
        if(ver==false)
        {
            JOptionPane.showMessageDialog(null,"ERROR: No se encontró ningún artículo con nombre: "+nom);
            new VentanaEnt(ap).setVisible(true);
        }
        
    }
}
