
package prac_2psp2ev;

import java.awt.Canvas;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.TimerTask;
import javax.imageio.ImageIO;


public class TimerEnvio extends TimerTask{

    String IP;
    int puerto;
    MiCanvas can;
    Ventana v;
    
    TimerEnvio(String i, String p,MiCanvas c,Ventana v) {
        this.v=v;
        this.can=c;
        this.IP=i;
        this.puerto=Integer.parseInt(p);
    }

    @Override
    public void run() {

        
            IP=v.getIp();
            puerto=Integer.parseInt(v.getPuerto());
             System.out.println("Iniciando conexion a IP: "+IP+" PUERTO: "+puerto);
             try
             {

                   ImgCanvas img=can.getImagen();
                   if(img.img!=null)
                   {
                       //aqui se almacenaran los datos de entrada desde arduino
                    Socket clientSocket=new Socket();//creo la conexion
                    clientSocket.connect(new InetSocketAddress(IP,puerto), 100);

                    System.out.println("Conectado a:"+IP+" al puerto:"+puerto);



                    ObjectOutputStream os = new ObjectOutputStream(clientSocket.getOutputStream()); 
                    ObjectInputStream in = new ObjectInputStream(clientSocket.getInputStream());  
                    ByteArrayOutputStream salida=new ByteArrayOutputStream();
                    
                    ImageIO.write(img.img,"jpg",salida);
                    byte[] bytesImg=salida.toByteArray();
                    
                    os.writeObject(bytesImg);
           
                    System.out.println("Objeto enviado");
                   /*
                    byte[] bytesImagen = (byte[]) in.readObject();
                    ByteArrayInputStream entradaImagen = new ByteArrayInputStream(bytesImagen);
                    BufferedImage img_rec = ImageIO.read(entradaImagen);
                    System.out.println("Objeto leido");
                    if(img_rec!=null)
                    {
                        v.getCanvas().setImagen(img_rec);
                        v.dibujar(img_rec);
                        
                    }*/

                    clientSocket.close();
                   }
                   


             }
             catch(Exception e)
             {
                 System.out.println("ERROR: ocurrio algun problema durante la conexion:\n"+e.getMessage());
             }
    }
    
}
