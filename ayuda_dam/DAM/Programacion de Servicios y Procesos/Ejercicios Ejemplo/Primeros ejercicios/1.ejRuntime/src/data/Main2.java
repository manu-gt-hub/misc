package data;

import java.io.*; 

/** 
 * Para alumnos: visualizar todos los ficheros (y solo el nombre del fichero)
 * xa un directorio dado
 * @author  Javier 
 */ 
public class Main2 { 
    
    public static void main(String[] args) { 
        new Main2(); 
    }
     
    public Main2()  
    { 
        try 
        {     
            String dir="\"c:\\\"";
            String orden="cmd /c dir /a:-d /b "+dir;
            Process p=Runtime.getRuntime().exec (orden); 
             
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

