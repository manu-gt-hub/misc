package data;

import java.io.*; 

/** 
 *                   ProcessBuilder con órdenes internas
 * 
 * Sencillo ejemplo de como visualizar el contenido de un fichero de disco por pantalla
 * a través de un comando sel SSOO (sólo xa windows)
 
 * @author  Javier 
 */ 
public class Main2 { 
    
    public static void main(String[] args) throws IOException, InterruptedException { 
      // OJO!!! No vale con poner "cmd /c", "dir"-->ProcessBuilder lo interpretará como error
      //String[] list = {"cmd", "/c"," dir"};
      String[] list = {"cmd", "/c","type","test.txt"};  

      // create the process builder
      ProcessBuilder pb = new ProcessBuilder(list);

      // set the command list
      pb.command(list);

      // print the new command list
      System.out.println("Comando a ejecutar:" + pb.command());
      
      //Ejecuto la orden, creando el proceso p
      Process process=pb.start();
      
      //Vuelco el resultado por la pantalla
       InputStream is = process.getInputStream();
       InputStreamReader isr = new InputStreamReader(is);
       BufferedReader br = new BufferedReader(isr);
       
       System.out.println("\n*********************************\nContenido del fichero test.txt:");
       String line;
       while ((line = br.readLine()) != null) {
         System.out.println(line);
       }
       System.out.println("*********************************\n");

      
      
      process.waitFor();      
      //Espero a q el proceso acabe la visualización xa visualizar este mensaje
      System.out.println("Valor retorno del proceso: " + process.exitValue());
    }      
    
}

