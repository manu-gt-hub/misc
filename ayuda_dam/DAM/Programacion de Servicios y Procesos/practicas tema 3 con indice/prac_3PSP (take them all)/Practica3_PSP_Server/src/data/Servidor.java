package data;




import GUI.Ventana;
import data.ClientHandler;
import static data.Protocol.MSG_OVER_LOAD_PLAYERS;
import java.io.*;
import java.net.*;
import java.util.Timer;
import java.util.logging.Level;
import java.util.logging.Logger;

/*clase principal del servidor
encargada de recibir clientes
*/
public class Servidor implements Runnable{

    private ServerSocket serverSocket;

    Ventana ven;
    ClientHandler clientHandler;
    Timer timerSender;
    static final int MAX_JUGADORES=5;
    static int jugadores=0;
    
    public Servidor(int port) throws UnknownHostException
    {
        ven=new Ventana(InetAddress.getLocalHost().getHostAddress(),port);
        ven.setVisible(true);
        // me creo el socket del server
        try
        {
            serverSocket = new ServerSocket(port);
        }
        catch(IOException e)
        {
            ven.escribir("-> No se pudo crear el servidor en el puerto: "+port+"\n");
            System.exit(1);
        }

        ven.escribir("-> Servidor creado en puerto: "+port+"\n");
    }


    public void run()
    {
        while(true)
        {
            // esperando conexiones de clientes
            try
            {
                ven.escribir("-> Esperando conexiones de clientes..."+"\n");
                //Cada vez q recibo una petición del cliente me creo un 
                //data.server.CLientHandler, al q le mando el socket, 
                //xa gestionar la petición
                Socket socket=serverSocket.accept();
                clientHandler=new ClientHandler(socket,ven);
                
                
                if(jugadores<=MAX_JUGADORES)
                {
                    
     
                    ven.setClientHandler(clientHandler);
                 
                    

                }
                else
                {
                    clientHandler.sendMessage(MSG_OVER_LOAD_PLAYERS+"|"+MAX_JUGADORES);
                   
                    
                }
                
                
                
                
            }
            catch(IOException e)
            {
                ven.escribir("-> Error aceptando conexion de cliente: "+e+"\n");

            }
            try {
                Thread.sleep(50);
            } catch (InterruptedException ex) {
                Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
            }
           
        }
    }





}

