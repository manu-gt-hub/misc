package data;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;


/**
 *
 * @author juanxxiii
 */
public class Clientes {

    //Fichero de donde recojo la info de la aplicación (datos del cliente)
    private final String FClientes=Main.RUTAFICHS  +"clientes.txt";//Main.RUTAFICHS  +"clientes.txt";
    private List<Cliente> clientes;//Lista de animales q estén en el clientes sin curar y curados, listos para facturar
    
    //Creo las listas q contendrán los datos del Clientes
    public Clientes() {
        clientes=new LinkedList();
    }

    void cargarDatos() {        
        BufferedReader br = null;
        String linea;        

        try {          
          br = new BufferedReader(new FileReader(FClientes));
          while (null != (linea = br.readLine())) {
             Scanner sc=new Scanner(linea);
             sc.useDelimiter("[:\r\n]");
             while(sc.hasNext()){
                 //Relleno los datos del cliente
                 Cliente c=new Cliente(Integer.parseInt(sc.next().trim()),
                                        sc.next().trim(),
                                        Long.parseLong(sc.next().trim())
                                       );
                 //Añado el reg a la lista de clientes
                 clientes.add(c);
             }
          }
        }
        catch (Exception e) {
            System.out.println("Error al leer del fichero de clientes.");
            System.out.println(""+e.getMessage());
        }
        finally {
          try {
            if (br != null) br.close();            
          }
          catch (IOException e) {
            System.out.println("Error al cerrar el fichero de clientes.");
          }
        }
    }

    

    /**
     * Método muy importante q vuelca el contenido de las colecciones de datos
     * sobre los ficheros q conforman la aplicación
     */
    void guardarDatos()
    {
        File fnew=new File(Main.RUTAFICHS+"cli.txt");
        //Escribe txt en un fichero cuyo nombre se recibe como parámetro
        BufferedWriter bufferedWriter = null;

        try {            
             bufferedWriter =    new BufferedWriter(new FileWriter(fnew));
             for (Object o : this.clientes) {
                Cliente c=(Cliente)o;                
                bufferedWriter.write(""+c.getNumCliente());
                bufferedWriter.write(":"+c.getNombre());
                bufferedWriter.write(":"+c.getTlf());
                bufferedWriter.newLine();//-->Cambio de registro
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Error al escribir en el fichero");
        } catch (IOException ex) {
            System.out.println("Error al escribir en el fichero");
        } finally {
            //Close the BufferedWriter
            try {
                if (bufferedWriter != null) {
                    bufferedWriter.flush();
                    bufferedWriter.close();
                }
            } catch (IOException ex) {
                System.out.println("Error al cerrar el fichero de escritura");
            }
        }
        
        //Finalmente renombro los ficheros xa q quede uno solo
        //**************************************************************************
        //Para operar con ficheros hay una clase genial, java.nio.file.Files
        //Lo malo q solo opera a partir de la ver 1.7        
        /*try {
            java.nio.file.Files.delete(Main.RUTAFICHS+FClientes);
        } catch (NoSuchFileException x) {
            System.err.format("%s: no such" + " file or directory%n", path);
        } catch (DirectoryNotEmptyException x) {
            System.err.format("%s not empty%n", path);
        } catch (IOException x) {
            // File permission problems
            // are caught here.
            System.err.println(x);
        }*/
        //**************************************************************************

        //Antes de la clase File....
        File old=new File(FClientes);
        if(!old.delete())
            System.out.println("Error al borrar el fichero");
        File noi=new File(FClientes);
        fnew.renameTo(noi);        
    }
     

    void tratarDatos() {
        int i=1;
        for (Cliente cliente : clientes) {
            System.out.println(""+i+"-->"+cliente);
            i++;
        }

        //Agrego un nuevo cliente xa comprobar q se guarda bien
        clientes.add(new Cliente(27,"Juanito Navarro",29999999));
    }


    


}//:~)
