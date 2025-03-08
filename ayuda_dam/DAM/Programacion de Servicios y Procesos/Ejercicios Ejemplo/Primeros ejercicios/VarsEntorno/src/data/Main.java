package data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Profesor
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        //try {
            // TODO code application logic here
            //Runtime.getRuntime().exec("calc");
            /*
            ProcessBuilder pb=new ProcessBuilder();
            pb.command("calc");
            pb.start();            
            */
            /*Process p1=Runtime.getRuntime().exec("cmd /c set");
            InputStreamReader isr = new InputStreamReader(p1.getInputStream());            
            BufferedReader br = new BufferedReader(isr);
            
            String x;
            while((x=br.readLine())!=null){
                System.out.println(""+x);
            }*/
            
            /*
            //Lista de claves
            ProcessBuilder pb=new ProcessBuilder();
            Map<String,String> mapa=pb.environment();
            Iterator ii=mapa.keySet().iterator();
            while(ii.hasNext()){
                System.out.println(""+ii.next());
            }
            */
        
            //Lista de valores
            ProcessBuilder pb=new ProcessBuilder();
            Map<String,String> mapa=pb.environment();
            Iterator ii=mapa.values().iterator();
            while(ii.hasNext()){
                System.out.println(""+ii.next());
            }
            
            
       
        /*} catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }*/
            
            


    }
}