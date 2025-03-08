
package data;

import java.io.File;
import java.io.IOException;

/**
 *                   ProcessBuilder con órdenes externas
 * 
 * Sencillo ejemplo en el q creo/modifico(si ya existe) un fichero de texto llamado test.txt
 * El directorio de creación, si no se indica mediante el comando directory, será la raíz del proyecto
 * Notas: 
 *      La primera vez, (no existe el fichero), notepad te dará a elegir donde guardar
 *      Ten en cuenta los permisos del SSOO xa tu usuario (= con el q has iniciado sesión)
 */
public class Main1 {
    public static void main(String[] args) throws IOException {

      // create a new list of arguments for our process
      String[] list = {"notepad.exe", "test.txt"};

      // create the process builder
      ProcessBuilder pb = new ProcessBuilder(list);
      
      //Si quiero usar otro directorio, lo establezco con el método directory
      //pb.directory(new File("C:\\"));
      //System.out.println("" + pb.directory());
      
      pb.start();
   }
}
