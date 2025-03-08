package data;

import data.client.NetworkEvent;
import data.client.NetworkHandler;
import data.client.NetworkListener;
import data.Player;
import static data.Protocol.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.File;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.*;
import javax.swing.*;

/**  
  Clase muy importante que visualiza la interfaz(GUI) que ve cada jugador en su ordenador.
  Envía mensajes cada vez que el jugador produce un evento y recibe mensajes del server   
*/

public final class ClienteJugador extends JFrame implements Runnable, EventProcessable, NetworkListener,MouseListener,MouseMotionListener, Protocol{
        
    int points=0;
    private EventProcessor eventProcessor;
    private NetworkHandler networkHandler;
    String IP="";
    final int PUERTO=50000;
    Image regalo;
    Image fondo;
    int num_img;
    int x_obj=-100;
    int y_obj=-100;
    PanelJuego panel_juego;
 

    Thread hiloJugador;
    private BufferedImage backBuffer;
    private Graphics2D bbGraphics;

    private final int DISPLAY_X; // value assigned in constructor
    private final int DISPLAY_Y; // value assigned in constructor
    
    //Tamaño de la ventana del jugador
    private static final int DISPLAY_WIDTH = 640;
    private static final int DISPLAY_HEIGHT = 480;

    public Player player;
    public ArrayList playerList; //lista de jugadores
    public String playerName;
    private Color playerColor;
    public String nombre="";

    
    
    public ClienteJugador(String nombre){

        this.nombre=nombre;
        if(nombre.isEmpty())
        {
            nombre="Jugador";
        }
        this.playerName=nombre;
        
        //leo la ip que teclee el cliente

        IP=JOptionPane.showInputDialog("Hola, "+this.playerName+" para jugar teclea la IP del servidor");   

        fondo=new ImageIcon(getClass().getResource("/imgs/background.jpeg")).getImage();
        
        //creo el panel de juego
        panel_juego=new PanelJuego(fondo);
      
        setTitle("Jugador - "+playerName);
        getContentPane().setLayout(new BorderLayout());
        
        getContentPane().add(panel_juego,BorderLayout.CENTER);
        
        setResizable(false);
        setIgnoreRepaint(true);

        addWindowListener(new WindowAdapter() {
        @Override
         public void windowClosing(WindowEvent e) {
           exitProgram();
         }
       });

        backBuffer = new BufferedImage(DISPLAY_WIDTH, DISPLAY_HEIGHT,BufferedImage.TYPE_INT_RGB);
   
        //cojo los graficos de la iamgen auxiliar d epintado
        bbGraphics = (Graphics2D) backBuffer.getGraphics();

        playerList = new ArrayList();

        
        
        getContentPane().addMouseListener(this);
        getContentPane().addMouseMotionListener(this);
        
            
        
        eventProcessor = new EventProcessor(this);
        networkHandler = new NetworkHandler(IP,PUERTO, this);

        setVisible(true);

        Insets insets = getInsets();
        DISPLAY_X = insets.left;
        DISPLAY_Y = insets.top;
        resizeToInternalSize(DISPLAY_WIDTH, DISPLAY_HEIGHT);
        this.setLocationRelativeTo(null);
    }

    //metodo encargado de actualizar la resolucion    
    public void resizeToInternalSize(int internalWidth, int internalHeight)
    {
        Insets insets = getInsets();
        final int newWidth = internalWidth + insets.left
            + insets.right;
        final int newHeight = internalHeight + insets.top
            + insets.bottom;

        Runnable resize = new Runnable()
        {
            public void run()
            {
                setSize(newWidth, newHeight);
            }
        };

        if(!SwingUtilities.isEventDispatchThread())
        {
            try
            {
                SwingUtilities.invokeAndWait(resize);
            }
            catch(Exception e) {}
        }
        else
            resize.run();

        validate();
    }

    //Bucle del actualizo/pinto/espero
    public void run()
    {
        long startTime, waitTime, elapsedTime;
        //    1000/25 Frames Per Second = 40 millisecond delay
        int delayTime = 1000/25;

        Thread thisThread = Thread.currentThread();
        while(hiloJugador==thisThread)
        {
            startTime = System.currentTimeMillis();

            // actualizo (proceso los eventos recibidos)
            eventProcessor.processEventList();

            //pinto
            // primero renderizo
            Graphics g = panel_juego.getGraphics();
            render(this.bbGraphics);
            // Vuelco la imagen renderizada sobre la pantalla
            //Graphics g = getGraphics();
            if(g!=null)
            {
                g.drawImage(backBuffer,0,0, DISPLAY_WIDTH, DISPLAY_HEIGHT, null);
             
                g.dispose();
            }
            
            

            //Espero en base a lo q tardé en pintar y renderizar
            elapsedTime = System.currentTimeMillis() - startTime;
            waitTime = Math.max(delayTime - elapsedTime, 5);

            try
            {
                Thread.sleep(waitTime);
            }
            catch(InterruptedException e) {}
            
        }

        System.out.println("Program Exited");

        dispose();
        System.exit(0);
    }

    public void render(Graphics g)
    {
        
        g.clearRect(0, 0, DISPLAY_WIDTH, DISPLAY_HEIGHT);
        g.drawImage(fondo,0,0,DISPLAY_WIDTH, DISPLAY_HEIGHT, null);
        // visualizo la pos de todos los jugadores sobre la pantalla
        Player p;
        g.setColor(Color.black);
        g.setFont(new Font("Serif", Font.BOLD, 16));
        g.drawString("Puntuación: "+points,10,20);
        for(int i=0; i<playerList.size(); i++)
        {
            p = (Player)playerList.get(i);
            if(p.uniqueId==this.player.uniqueId)
            {
                playerColor=Player.colors[p.colId];
            }
                
            g.setColor(Player.colors[p.colId]);

            g.fillOval(p.x-10, p.y-10, 20, 20);

            g.drawString(p.name, p.x+20, p.y);
            
            
        }
        
        //g.setColor(Color.white);
        g.drawImage(regalo, x_obj, y_obj, 65,65, null);
        //g.fillOval(x_obj, y_obj, 30,30);
        
    }

    //Cada vez q produzco un evento se ejecuta este método, que envía un mensaje 
    //al server xa q informe al resto de jugadores
    //Too se viene aquó si recibo un mensaje del servidor-->Evento de red :)
    public void handleEvent(AWTEvent e)
    {
        switch(e.getID())
        {     
            case MouseEvent.MOUSE_MOVED://Si hago click le envío un msj al server         
                MouseEvent mouseEvent1 = (MouseEvent)e;
                networkHandler.sendMessage(MSG_MOVE_POSITION+"|"+ mouseEvent1.getX()+"|"+mouseEvent1.getY());
            break;  
            case MouseEvent.MOUSE_PRESSED://Si hago click le envío un msj al server         
                MouseEvent mouseEvent = (MouseEvent)e;
                networkHandler.sendMessage(MSG_PRESSED+"|"+ mouseEvent.getX()+"|"+mouseEvent.getY());
             break;            

            case NetworkEvent.NETWORK_MESSAGE_RECEIVED: //si recibo un mensaje lo manejo en la función de abajo                
                handleNetworkMessage(((NetworkEvent)e).message);
                break;

            case NetworkEvent.NETWORK_DISCONNECTED:    //Si recibo el mensje del server de fin del cliente...        
                System.out.println("Network Disconnected. Bye!!!");
                JOptionPane.showMessageDialog(null,"Error de conexion con el servidor");
                System.exit(0);

                break;            
        }
    }


    /*
     Esta es la función que procesa los mensajes que recibo del server
     */
    public void handleNetworkMessage(String message)
    {
        StringTokenizer st = new StringTokenizer(message, "|");
        int type = Integer.parseInt(st.nextToken());
        Player p;

        switch(type)
        {
           case MSG_INIT_PLAYER:
                    player = new Player(Integer.parseInt(st.nextToken()),
                               Integer.parseInt(st.nextToken()),
                               Integer.parseInt(st.nextToken()),
                               Integer.parseInt(st.nextToken()));
                    if(this.nombre.isEmpty())
                    {
                        this.setTitle("Jugador "+player.uniqueId);
                        networkHandler.sendMessage(MSG_SET_NAME+"|"+playerName+" "+player.uniqueId);
                        
                        
                    }
                    else
                    {
                        networkHandler.sendMessage(MSG_SET_NAME+"|"+playerName);
                    }
                    

                    
                    break;

           case MSG_SET_NAME:
                    if(this.nombre.isEmpty())
                    {
                        this.setTitle("Jugador "+player.uniqueId);
                        player.name = st.nextToken();
                        this.playerName=player.name;
                    }
                    else
                    {
                        player.name = st.nextToken();
                        this.playerName=player.name;
                    }
                    
                    playerList.add(player);
                    break;

           case MSG_ADD_NEW_PLAYER:
           {
                    p = new Player(Integer.parseInt
                    (st.nextToken()),
                          Integer.parseInt(st.nextToken()),
                          Integer.parseInt(st.nextToken()),
                          Integer.parseInt(st.nextToken()));

                    
                    if(this.nombre.isEmpty())
                    {
                        this.setTitle("Jugador "+player.uniqueId);
                        p.name = st.nextToken();
                        this.playerName=p.name;
                    }
                    else
                    {
                        p.name = st.nextToken();
                        this.playerName=p.name;
                    }
                    playerList.add(p);
                    
                    break;
            }

            case MSG_MOVE_POSITION:
            {                
                    int id = Integer.parseInt(st.nextToken());
                    for(int i=0; i<playerList.size(); i++)
                    {
                        p = (Player)playerList.get(i);
                        if(p.uniqueId==id)
                        {
                            p.x = Integer.parseInt(st.nextToken());
                            p.y = Integer.parseInt(st.nextToken());
                            break;
                        }
                    }

                    break;
            }

            case MSG_REMOVE_PLAYER:
            {
                
                int id = Integer.parseInt(st.nextToken());
                for(int i=0; i<playerList.size(); i++)
                {
                    p = (Player)playerList.get(i);
                    if(p.uniqueId==id)
                    {
                        playerList.remove(i);
                        break;
                    }
                }
            }
                
            case MSG_SEND_POSITION:
            {                
                    try
                    {
                        num_img=Integer.parseInt(st.nextToken());
                        x_obj = Integer.parseInt(st.nextToken());
                        y_obj = Integer.parseInt(st.nextToken());
                        regalo=new ImageIcon(getClass().getResource("/imgs/"+num_img+".png")).getImage();
                    }
                    catch(Exception ex)
                    {
                        
                    }
                    
                    break;
            }
            case MSG_ONE_POINT:
            {                
                    this.points++;
                    break;
            }
            case MSG_ONE_POINT_LESS:
            {                
                    this.points--;
                    break;
            }
            case MSG_OVER_LOAD_PLAYERS:
            {                
                    JOptionPane.showMessageDialog(null,"No se admiten mas jugadores en la partida (max: "+st.nextToken()+")");
                    System.exit(0);
                    break;
            }
        }
    }

    public void networkMessageReceived(NetworkEvent e)
    {
        eventProcessor.addEvent(e);
    }


    public void networkDisconnected(NetworkEvent e)
    {
        eventProcessor.addEvent(e);
    }


    public void mousePressed(MouseEvent e)
    {
        eventProcessor.addEvent(e);
    }

    public void mouseReleased(MouseEvent e){}
    public void mouseClicked(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}


    public void exitProgram()
    {
        hiloJugador = null;
    }   

    @Override
    public void mouseDragged(MouseEvent e) {}

    @Override
    public void mouseMoved(MouseEvent e) {
        System.out.println("movimiento");
        Graphics g = panel_juego.getGraphics();

        g.setColor(playerColor);
        g.fillOval(e.getX()-10, e.getY()-10, 20, 20);
       
        eventProcessor.addEvent(e);
        
       
    }
    
}
