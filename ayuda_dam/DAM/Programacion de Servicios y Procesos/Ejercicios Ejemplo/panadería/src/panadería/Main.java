/* 
 Ejemplo de sincronización entre hilos.
 Un Productor (de barras de pan) generará números que un cliente (Consumidor de barras de pan) irá recogiendo.
 Las barras se depositarán en una bandeja de capacidad MAX
 No se podrá producir si la bandeja está llena ni llevarse pan si está vacía
  
 La sincronización la garantiza un monitor llamado BandejaPan

 NOTA: Cada elemento (productor/consumidores)irá a su ritmo, sin importarle los demás(solo si la bandeja está o no vacía)
 */

package panadería;

import java.util.logging.Level;
import java.util.logging.Logger;



 /**
 *
 * @author profesor
 */
public class Main extends Thread{

    /**
     * @param args the command line arguments
     */

    public static boolean FIN=false;
    Consumidor []clientes;
    bandejaPan bandeja;
    Productor produceBarras;

    public static void main(String[] args) {
        try {
            new Main().start();
        } catch (InterruptedException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Main() throws InterruptedException {
        
        bandeja = new bandejaPan(10);

        clientes = new Consumidor[50];
        
        for (int i = 0; i < clientes.length; i++){
            clientes[i]=new Consumidor(bandeja,i);
            clientes[i].setPriority(Thread.MIN_PRIORITY);
        }

        for (int i = 0; i < clientes.length; i++)
            clientes[i].start();
        
        produceBarras= new Productor(bandeja);
        produceBarras.setPriority(Thread.MAX_PRIORITY);
        produceBarras.start();
        
        Thread.sleep(1000);
        finalizar();        
        
    }

    /**
     * LLamaré a este método en el momento q quiera q finalice la aplicación
     * Es decir, al cierre del supermercado
     * (Actualmente es infinito ya q no la llamo en ningún momento)
     */
    public void finalizar(){
        FIN=true;

        //Libero a los hilos q estén colgados en sus wait
        //Le digo al panadero q se vaya a su casa
        if(this.produceBarras.isAlive())
            this.produceBarras.interrupt();
        
        //Libero a los clientes de la espera, ya q el productor ha acabado su jornada
        //Se cierra el Carrefour y mando a los clientes q esperan su barra "a casa"-
        for (int i = 0; i < clientes.length; i++)
            if(clientes[i].isAlive()){
                clientes[i].interrupt();
                System.out.println("Se interrumpió"+clientes[i]);
            }
    }



}
