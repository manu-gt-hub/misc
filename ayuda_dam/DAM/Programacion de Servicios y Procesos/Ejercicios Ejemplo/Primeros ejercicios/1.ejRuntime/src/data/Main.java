package data;

import java.io.*; 

/** 
 * Ejemplo simple que visualiza el contenido de un directorio del equipo
   (a través del comando dir de windows) 
 
 * @author  Javier 
 */ 
public class Main { 
    
    // Se lanza el ejecutable. 
    String comando="dir D:\\tarde";
    
    public static void main(String[] args) { 
        new Main(); 
    }
     
    public Main()  
    { 
        try 
        {             
            Process p=Runtime.getRuntime().exec ("cmd /c"+ comando); 
             
            // Se obtiene el stream de salida del programa 
            InputStream is = p.getInputStream();              
            /* Se prepara un bufferedReader para poder leer la salida más comodamente. */ 
            BufferedReader br = new BufferedReader (new InputStreamReader (is)); 
             
            // Se lee la primera linea 
            String aux = br.readLine();              
            // Mientras se haya leido alguna linea 
            while (aux!=null) 
            { 
                // Se escribe la linea en pantalla 
                System.out.println (aux);                  
                // y se lee la siguiente. 
                aux = br.readLine(); 
            } 
        }  
        catch (Exception e) 
        { 
            // Excepciones si hay algún problema al arrancar el ejecutable o al leer su salida.*/
            e.printStackTrace(); 
        } 
    }      
}

