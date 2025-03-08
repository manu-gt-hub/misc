
package prac_1psp;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.sql.SQLException;


public class Main {
    
    //static final String IP="192.168.1.7";
    static String IP="";
    //puerto de escucha de la app
    static final int puerto=8888;
    static Ventana v;
    
    public static String getIp()
    {
        return IP;
    }
    public static int getPuerto()
    {
        return puerto;
    }

    public static void main(String[] args) throws UnknownHostException, ClassNotFoundException, SQLException, IOException 
    {

        //recupero la ip local del equipo
        InetAddress addr= InetAddress.getLocalHost();
       
        IP=addr.getHostAddress();
        
        v=new Ventana();
        v.setVisible(true);
        
        //abro un socket servidor con la ip del equipo y el puerto de escucha
        ServerSocket server = new ServerSocket(puerto,0,addr);
       
        //abro un socket cliente
        Socket skCliente = new Socket();
            
        while(true)
        {
           
          try
          {

              
              
              v.escribir("Esperando clientes...");
              
              //si se conecta algun cliente
              skCliente=server.accept();
              Dispatcher dis=new Dispatcher(skCliente,v);
              dis.start();
    

          }
          catch ( Exception e )
          {
              System.out.println("ocurrio algun error:"+e.getMessage());

          }
        }


      }
    
    
}
