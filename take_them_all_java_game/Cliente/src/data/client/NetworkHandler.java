package data.client;


import java.io.*;
import java.net.*;
import java.util.*;
import javax.swing.JOptionPane;



/*
 * Gestiona los envíos de datos y recepción de los mismos a través de la red en el cliente
 * Un objeto de esta clase se crea cada vez que un cliente inicia una conexión para jugar
 */
public class NetworkHandler{
    
    private Socket socket;

    private IncomingMessageHandler incomingMessageHandler;
    private OutgoingMessageHandler outgoingMessageHandler;

    private NetworkListener listener;
    public boolean connected;

    public NetworkHandler(String address, int port, NetworkListener listener)
    {
        try
        {
            socket = new Socket(address, port);

            this.listener = listener;

            DataInputStream in = new DataInputStream
                (socket.getInputStream());
            DataOutputStream out = new DataOutputStream
                (socket.getOutputStream());

            incomingMessageHandler = new IncomingMessageHandler(in);
            outgoingMessageHandler = new OutgoingMessageHandler(out);

            connected = true;
        }
        catch(IOException e)
        {
            System.out.println("Unable to connect: "+e);
            
            listener.networkDisconnected(new NetworkEvent(this, NetworkEvent.NETWORK_DISCONNECTED, null));
        }
    }

    //manejador d emensajes de entrada
    public class IncomingMessageHandler implements Runnable
    {
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
                    String message = inStream.readUTF();
                    listener.networkMessageReceived(new NetworkEvent (this, NetworkEvent.NETWORK_MESSAGE_RECEIVED,
                         message));
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

        Thread receiver;
        private DataInputStream inStream;
    }


    ///manejador de mensajes de salida
    public class OutgoingMessageHandler implements Runnable
    {
        public OutgoingMessageHandler(DataOutputStream out)
        {
            outStream = out;
            messageList = new LinkedList();

            sender = new Thread(this);
            sender.start();
        }

        //agrega un mensaje a la lista de mensajes
        public void addMessage(String message)
        {
            synchronized(messageList)
            {
                messageList.add(message);
                messageList.notify();
            }
        }

        /*bucle principal de funcionamiento*/
        public void run()
        {
            String message;

            Thread thisThread = Thread.currentThread();
            while(sender==thisThread)
            {
                synchronized(messageList)
                {
                    if(messageList.isEmpty() && sender!=null)
                    {
                        try
                        {
                            messageList.wait();
                        }
                        catch(InterruptedException e) { }
                    }
                }

                while(messageList.size()>0)
                {
                    synchronized(messageList)
                    {
                        message = (String)messageList.removeFirst();
                    }

                    try
                    {
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
                messageList.notify();
               // wake up if stuck in waiting stage
            }
        }

        Thread sender;
        LinkedList messageList;
        DataOutputStream outStream;
    }


    //desconecta al cliente del server y destruye su flujo de comunicacion
    public synchronized void disconnect()
    {
        if(connected)
        {
            connected = false;
            incomingMessageHandler.destroy();
            outgoingMessageHandler.destroy();

            try
            {
                socket.close();
            }
            catch(Exception e) {}
            socket = null;

            listener.networkDisconnected(new NetworkEvent(this,NetworkEvent.NETWORK_DISCONNECTED, null));
        }
    }


    //añade el mensaje a la lista de salida
    public void sendMessage(String message)
    {
        outgoingMessageHandler.addMessage(message);
    }


    
}

