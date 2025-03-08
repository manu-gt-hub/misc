package data;



import GUI.Ventana;
import data.Protocol;
import static data.Protocol.MSG_ADD_NEW_PLAYER;
import static data.Protocol.MSG_MOVE_POSITION;
import static data.Protocol.MSG_ONE_POINT;
import static data.Protocol.MSG_SEND_POSITION;
import java.awt.Color;
import java.awt.Rectangle;
import java.io.*;
import java.net.*;
import java.util.*;
import javax.swing.JOptionPane;


/**
 Clase que recibe y gestiona las peticiones de cada cliente EN EL SERVIDOR 
 Se crea cada vez q un cliente se intenta conectar al server
 y se mantiene viva hasta q el cliente decide desconectarse
 
 por otro lado, si el cliente hace click en un punto de su pantalla, inmediatamente
 mandará un mensaje, que será recogido por esta clase, la cual actuará en consecuencia.
 */

public class ClientHandler implements Protocol
{
    private Socket socket;

    private IncomingMessageHandler incomingMessageHandler;
    private OutgoingMessageHandler outgoingMessageHandler;

    public boolean connected;

    public static ArrayList clientList = new ArrayList();

    public Player player;
    public  static int uniqueIdCount;
    Ventana ven;
    private static int x_present=0;
    private static int y_present=0;
    private static int num_img;
    private final int CALAVERA=4;
    
    public static LinkedList<Color> colores= new LinkedList();
    
//----------------------------------------------------------------------------------
//clases internas que gestionan mediante hilos la emisión y recepción de mensajes    
//----------------------------------------------------------------------------------
    
    public ClientHandler(Socket socket,Ventana v)
    {

        this.ven=v;
        try
        {
            this.socket = socket;

            DataInputStream in = new DataInputStream
                (socket.getInputStream());
            DataOutputStream out = new DataOutputStream
                (socket.getOutputStream());

            incomingMessageHandler = new IncomingMessageHandler(in);
            outgoingMessageHandler = new OutgoingMessageHandler(out);

            connected = true;

            Random rand = new Random();

            //importante, aquí se crea el jugador
            //Le doy una posición y un color aleatorios, así como un número único de jugador a modo de clave o identificador
            int num_color=rand.nextInt(6);
            boolean fin=false;
            do
            {
                
            
                if(colores.isEmpty())
                {
                    colores.add(player.colors[num_color]);
                }
                else
                {
                    if(!(colores.size()>=player.colors.length))
                    {
                        int coincidencias=0;
                        for (Color c : colores)
                        {
                            if(c.getRGB()==player.colors[num_color].getRGB())
                            {
                                coincidencias++;
                            }
                        }
                        if(coincidencias==0)
                        {
                            colores.add(player.colors[num_color]);
                            fin=true;
                        }
                        else
                        {
                            num_color=rand.nextInt(6);
                        }
                    }
                    
                }
            }while(!fin);
            Color col=player.colors[num_color];
            player = new Player(col.getRed(),
                    col.getGreen(),
                    num_color
                            , uniqueIdCount);
            uniqueIdCount++;

            //Agrego el cliente a la lista de jugadores
            synchronized(clientList)
            {
                clientList.add(this);
                Servidor.jugadores++;
            }

            //Mando un mensaje en el q indico q el jugador x ha iniciado el juego
            sendMessage(MSG_INIT_PLAYER+"|"+player.x+"|"+player.y+"|"
                             +player.colId+"|"+player.uniqueId);
            ven.escribir("El jugador "+player.uniqueId+" ha entrado en el juego\n");
        }
        catch(IOException e)
        {
            
        }
    }

    

    //Clase interna que gestiona, a través de un hilo, la recepción de mensajes
    public class IncomingMessageHandler implements Runnable
    {
        Thread receiver;
        private DataInputStream inStream;
        
        public IncomingMessageHandler(DataInputStream in)
        {
            inStream = in;
            receiver = new Thread(this);
            receiver.start();
        }

        public void run()
        {
            Thread thisThread = Thread.currentThread();
            while(receiver==thisThread)
            {
                try
                {
                    //Leo y manejo el mensaje recibido
                    String message = inStream.readUTF();
                    handleMessage(message);//Esta función (al final) es la q gestiona el msj recibido
                }
                catch(IOException e)
                {
                    disconnect();
                }
            }
        }

        public void destroy()
        {
            receiver = null;
        }
        
    }

    //Clase interna que gestiona, a través de un hilo, el envío de mensajes hacia los clientes
    public class OutgoingMessageHandler implements Runnable
    {
        Thread sender;
        LinkedList messageList;//lista con los mensajes a enviar
        DataOutputStream outStream;
        
        public OutgoingMessageHandler(DataOutputStream out)
        {
            outStream = out;
            messageList = new LinkedList();

            sender = new Thread(this);
            sender.start();
        }

        public void addMessage(String message)
        {
            synchronized(messageList)
            {
                messageList.add(message);
                messageList.notify();
            }
        }

        public void run()
        {
            String message;

            Thread thisThread = Thread.currentThread();
            while(sender==thisThread)
            {
                synchronized(messageList)
                {
                    //Si no tengo mensajes para enviar, espero
                    if(messageList.isEmpty() && sender!=null)
                    {
                        try
                        {
                            messageList.wait();
                        }
                        catch(InterruptedException e) { }
                    }
                }

                //Si ya tengo mensajes proceso la lista
                //La pongo en un while xq procesaré un mensaje por iteración
                while(messageList.size()>0)
                {
                    synchronized(messageList)
                    {
                        message = (String)messageList.removeFirst();
                    }

                    try
                    {
                        //Envío el mensaje
                        outStream.writeUTF(message);

                    }
                    catch(IOException e)
                    {
                        disconnect();
                    }
                }
            }
        }

        
        public void destroy()
        {
            sender = null;

            synchronized(messageList)
            {
                messageList.notify(); // despierta al hilo por si se encuentra atascado en el wait
            }
        }
        
    }//end of outgoingMessageHandler

//----------------------------------------------------------------------------------
//----------------------------------------------------------------------------------
//----------------------------------------------------------------------------------
// Métodos propios de la clase (ClientHandler)
//----------------------------------------------------------------------------------    
//----------------------------------------------------------------------------------    
//----------------------------------------------------------------------------------        
    

    //Si se desconecta un cliente....
    public synchronized void disconnect()
    {
        
        if(connected)
        {
            synchronized(clientList)
            {
                clientList.remove(this);
                Servidor.jugadores--;
                
            }

            //Mando un mensje a todos los clientes informando de la desconexón
            broadcast(MSG_REMOVE_PLAYER+"|"+player.uniqueId);

            connected = false;

            incomingMessageHandler.destroy();
            outgoingMessageHandler.destroy();

            try
            {
                socket.close();
            }
            catch(Exception e) {}
            socket = null;
        }

        ven.escribir("-> El cliente: "+this.player.name+"  ha abandonado el juego \n");
    }


    /**
     * Función importantísima que se encarga de difundir un mensaje a TODOS los jugadores
     * Esta función la usa el servidor para comunicar algo que ha generado él
     * @param message mensaje a difundir
     */
    public static void broadcast(String message)
    {
        synchronized(clientList)
        {
            ClientHandler client;
            for(int i=0; i<clientList.size(); i++)
            {
                client = (ClientHandler)clientList.get(i);
                client.sendMessage(message);
            }
        }
    }

    /**
     * Idem que la anterior pero no le manda la info al jugador q la genera
     * Esta función la usa el servidor para comunicar algo que ha generado un cliente concreto
     * @param message mensaje a difundir
     */
    public void broadcastFromClient(String message)
    {
        synchronized(clientList)
        {
            ClientHandler client;
            for(int i=0; i<clientList.size(); i++)
            {
                client = (ClientHandler)clientList.get(i);
                if(client!=this)
                    client.sendMessage(message);
            }
        }
    }

    /*Siempre q mando un mensaje pasaré por aquí, 
        añadiendo el mensaje a la lista de mensajes a enviar
        a través del método de la clase q los gestiona
    */ 
    public void sendMessage(String message)
    {
        outgoingMessageHandler.addMessage(message);
    }


    /**
     Probablemente la función más importante de la clase
     Se encarga de indicar como obrar ante la recepción de un mensaje x parte del cliente     
     */
    public  void handleMessage(String message)
    {
        StringTokenizer st = new StringTokenizer(message, "|");
        int type = Integer.parseInt(st.nextToken());
        
        switch(type)
        {
            case MSG_SET_NAME://Si recibo un msj de cambio de nombre...
            {
                player.name = st.nextToken();
                sendMessage(MSG_SET_NAME+"|"+player.name);
                broadcastFromClient(MSG_ADD_NEW_PLAYER+"|"+player.x+
                   "|"+player.y+"|"+player.colId+"|"+player.uniqueId
                   +"|"+player.name);

                Player p;
                ven.escribir("El jugador "+player.uniqueId+" ha cambiado el nombre a: "+player.name+"\n");
                
                //  tell this player about everyone else
                synchronized(clientList)
                {
                    for(int i=0; i<clientList.size(); i++)
                    {
                        p = ((ClientHandler)clientList.get(i)).player;
                        if(player != p)
                        {
                            sendMessage(MSG_ADD_NEW_PLAYER+"|"+p.x
                                +"|"+p.y+"|"+p.colId+"|"+p.uniqueId+
                                "|"+p.name);
                        }
                    }
                }
                break;
            }

            case MSG_MOVE_POSITION://si me muevo
            {
                player.x = Integer.parseInt(st.nextToken());
                player.y = Integer.parseInt(st.nextToken());

                broadcast(MSG_MOVE_POSITION+"|"+player.uniqueId+"|"
                    +player.x+"|"+player.y);
                break;
            }
            case MSG_SEND_POSITION://si me muevo
            {
                this.num_img=Integer.parseInt(st.nextToken());
                this.x_present=Integer.parseInt(st.nextToken());
                this.y_present=Integer.parseInt(st.nextToken());
                broadcast(message);
                break;
            }
            case MSG_PRESSED://si me muevo
            {
                
                Player p;
               
                
                //  tell this player about everyone else
                synchronized(clientList)
                {
                    for(int i=0; i<clientList.size(); i++)
                    {
                        p = ((ClientHandler)clientList.get(i)).player;
                        if(player == p)
                        {
                            
                            int x=Integer.parseInt(st.nextToken());
                            int y=Integer.parseInt(st.nextToken());
                            //System.out.println("PULSACION CAPTADAAA  X: "+x+"  Y: "+y);
                            Rectangle r=new Rectangle(x_present,y_present,65,65);
                            if(r.intersectsLine(x, y, x, y))
                            {
                                //System.out.println("INTERSECCIONAAAAAAAA X: "+x_present+" y: "+y_present);
                                System.out.println("NUMERO DE IMAGEN: "+num_img);
                                if(num_img==CALAVERA)
                                {
                                    sendMessage(MSG_ONE_POINT_LESS+"");
                                    
                                }
                                else
                                {
                                    sendMessage(MSG_ONE_POINT+"");
                                    this.x_present=-100;
                                    this.y_present=-100;
                                    broadcast(MSG_SEND_POSITION+"|"+-1+"|"+x_present+"|"+y_present);
                                }
                                
                            }
                            else
                            {
                                //System.out.println("NO INTERSECCIONAAAAAAAA X: "+x_present+" y: "+y_present);
                            }
                            
                        }
                    }
                }
                break;
            }
        }
    }

    
}

