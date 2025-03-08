/*
******************************************************************************************************
        Aquí muestro como leer y escribir de un fichero de una forma + completa (xa mi la mejor)
******************************************************************************************************

Se lee usando un fileReader xa traerse una línea(registro). Luego esa línea(registro), se trocea con un scanner
La escritura es mediante un FileWriter.
 */

package data;

/*
 *
 * @author Administrador
 */
public class Main {
    //public static String RUTAFICHS="E:\\_fichs\\";//Ruta de los recursos de la aplicación(completa)
    public static String RUTAFICHS="src/res/";//Ruta de los recursos de la aplicación(parcial)
    Clientes clientes=new Clientes();

    public static void main(String args[]) {        
        Main m=new Main();
        m.clientes.cargarDatos();
        m.clientes.tratarDatos();
        m.clientes.guardarDatos();
        System.out.println("\n\nGracias por usar nuestra aplicación");
    }//main

}//:~)
