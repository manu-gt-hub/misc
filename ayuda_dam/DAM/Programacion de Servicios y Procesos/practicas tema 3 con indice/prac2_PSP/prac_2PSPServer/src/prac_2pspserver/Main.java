

/*SERVER BUENOOOOOOOOOO*/
package prac_2pspserver;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class Main {
    private static String IP;
    private static int puerto=8888;
    static Ventana v;

    public static void main(String[] args) throws UnknownHostException, IOException {
        v=new Ventana();
        v.setVisible(true);

         //recupero la ip local del equipo
        InetAddress addr= InetAddress.getLocalHost();
       
        IP=addr.getHostAddress();

        v.setTitle("practica 2 PSP Server  IP: "+IP+" puerto: "+puerto);
        //abro un socket servidor con la ip del equipo y el puerto de escucha
        ServerSocket server = new ServerSocket(puerto,0,addr);
       
        //abro un socket cliente
        Socket skCliente = new Socket();
              
        while(true)
        {
           
          try
          {

              System.out.println("Esperando clientes");
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
