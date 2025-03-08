
package data;

import java.io.File;
import java.io.IOException;
import java.util.GregorianCalendar;

/**
 *                Ejemplo de ejecución de varias ordenes 
 * En este ejemplo vamos a dar un paso mas:
 * vamos a meter varias órdenes en un fichero (llamado batch)
 * y las vamos a ejecutar teniendo en cuenta su formato.
 * 
 * El fichero batch lo tenemos en el directorio res y tuene 3 sencillas órdenes:
        echo Hello: %1
        echo %Javi%  (escribe por pantalla el valor de la var de entorno Javi, q crearemos desde Java)
        dir
 */
public class Main1 {
    public static void main(String[] args) throws IOException, InterruptedException {
            
        // The batch file to execute and its argument
        final File batchFile = new File("res\\process.bat");
        final String argument = "Super López";
        

        //El ProcessBuilder
        final ProcessBuilder processBuilder = new ProcessBuilder(batchFile.getAbsolutePath(), argument);    
        // Redirigimos la salida de la ejecución del batch a un fihero de nombre fsalida + la hora actual:fSalida_12.33.txt                
        final File outputFile = new File(String.format("res\\fSalida_%1$tH.%1$tM.txt",new GregorianCalendar()));
        processBuilder.redirectOutput(outputFile);
        processBuilder.redirectErrorStream(true);

        
        // Añadimos una var al entorno (la var Javi no está por defecto en el entorno de vars del SOP)
        processBuilder.environment().put("Javi", "Ejemplo de manejo de ficheros batch desde Java");

        // Iniciamos el proceso y esperamos a q finalice su ejecución
        final Process process = processBuilder.start();
        final int exitStatus = process.waitFor();
        System.out.println("Processed finished with status: " + exitStatus);
   }
}
/************************** COMENTADO POR MÍ ***********************/
        /*LOS FICHEROS BATCH-->.bat*/
            //ES UN FICHERO QUE SIGUE LA PROGRAMACION SECUENCIAL. Es un ejecutable. Y es la mejor forma para cuando se
            //  quiere ejecutar varios ejecutables. Puedo poner cualquier orden como en->Inicio/Ejecutar.
            //Pueden recibir parametros.
            //Ejemplo de un fichero bat
                //echo Hola %1
                //echo %Javi% voy a visualizar el contenido de una variable de entorno creada por mi que se llama javi
                //dir
            //28-Para pasarle toda la ruta del bat a processBuilder
            //30-Fichero donde voy a escribir la informacion del batch.El Calendario se genera con la fecha actual. Donde pone salida me va a convertir a horas y minutos, que sera el nombre del fichero.
            //31-Llamo a redirect para redirigir la salida del proceso(todo lo que genere el proceso) al fichero de salida.
            //32-También redirígeme los flujos de error
            //36-Creamos una variable de entorno
                //El resultado es la creación de un fichero con fecha actual donde se visualiza “Hola SuperLopez” y “Ejemplo de manejo de ficheros batch desde Java”.
                //Lo más importante es que sepamos ejecutar varias órdenes así como la redirección.