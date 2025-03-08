
package prac_2pspserver;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import static prac_2pspserver.Main.v;


public class Dispatcher extends Thread{

    BufferedReader br;
    DataOutputStream bw;
    Socket skCliente;
    Ventana v;

    BufferedReader bufferEntrada;
    DataOutputStream bufferSalida;
    String valor="";

    float num1=0;
    float num2=0;
    String res="";

    Dispatcher(Socket cliente, Ventana v) {
        this.v=v;
        this.skCliente=cliente;
        
 
    }

    @Override
    public void run() {
       
              
                System.out.println("Cliente aceptado");
              
                ObjectInputStream bufferEntrada;
                try {
                    bufferEntrada = new ObjectInputStream(skCliente.getInputStream());
                    ObjectOutputStream os = new ObjectOutputStream(skCliente.getOutputStream());
                    
                    byte[] bytesImagen = (byte[]) bufferEntrada.readObject();
                    ByteArrayInputStream entradaImagen = new ByteArrayInputStream(bytesImagen);
                    BufferedImage img = ImageIO.read(entradaImagen);

                    System.out.println("Objeto leido");

                    v.getCanvas().setImagen(img);
                    v.dibujar(img);
                    System.out.println("Canvas pintado");
                    /*
                    ByteArrayOutputStream salida=new ByteArrayOutputStream();

                    ImageIO.write(v.getCanvas().getImagen(),"jpg",salida);
                    byte[] bytesImg=salida.toByteArray();
                    
                    os.writeObject(bytesImg);
                    System.out.println("objeto enviado");*/
                    
                    skCliente.close();
                    
                } catch (Exception ex) {
                    Logger.getLogger(Dispatcher.class.getName()).log(Level.SEVERE, null, ex);
                }
              
               //cierro la conexion con el cliente
              
    }
    
}
