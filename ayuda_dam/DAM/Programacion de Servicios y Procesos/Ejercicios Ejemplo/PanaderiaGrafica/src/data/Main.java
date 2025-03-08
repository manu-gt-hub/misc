package data;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import javax.swing.ImageIcon;

/**
 * Ejemplo en modo gráfico de un supermercado en el que se 
 * comparte una bandeja de pan
 * @author profesor
 */
public class Main {

    private static Ventana v;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        // TODO code application logic here
        
        Bandeja b=new Bandeja(new ImageIcon("img/bandeja.png").getImage(),10,340,380);
        
        Horno horno=new Horno(new ImageIcon("img/horno.png").getImage(),830,350);
        
        Panadera p=new Panadera(new ImageIcon("img/panadera.png").getImage(),5,b,horno,800,340);
        
        Random r=new Random();
        List<Cliente> lc=new LinkedList();
        lc.add(new Cliente("img/cliente"+(r.nextInt(4)+1) ,"Pedro",3,b,20,250));
        lc.add(new Cliente("img/cliente"+(r.nextInt(4)+1) ,"Vero",1,b,-20,250));
        //lc.add(new Cliente("img/cliente"+(r.nextInt(4)+1) ,"Fer",2,b,-50,300));
        
        //Creo la ventana
        v=new Ventana(p,lc,b,horno,1000,600);
        v.setVisible(true);
        
        //Creo la animación
        Animacion a=new Animacion(v,p,lc,b);
        
        //inicio a la panadera
        new Thread(p).start();
        
        //Inicio la animación
        a.start();
        
        //Los clientes tardan un poco más en entrar a la tienda
        Thread.sleep(3000);
        for (Cliente ccc : lc) {
            new Thread(ccc).start();
            Thread.sleep(20000);
        }
        
        /*Nota: la aplicación finaliza cdo:
            a) se cierra la ventana Y 
            b) se acaba el hilo de la panadera (esta pone la var de finAnimacion a true)
        */ 
    }

    static void finalizar() {
        v.dispose();
    }
}