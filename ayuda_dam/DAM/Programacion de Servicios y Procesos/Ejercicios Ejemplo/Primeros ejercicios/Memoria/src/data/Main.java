package data;

import java.util.Iterator;
import java.util.LinkedList;

/**
 *
 * @author Profesor
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Mem max:"  +Runtime.getRuntime().maxMemory()/new Float(1024*1024) +" MB");
        System.out.println("Mem total:"+Runtime.getRuntime().totalMemory()/new Float(1024*1024) +" MB");
        System.out.println("Mem libre:"+Runtime.getRuntime().freeMemory()/new Float(1024*1024) +" MB");
        
        double m1=Runtime.getRuntime().freeMemory();
        LinkedList l=new LinkedList();
        for (int i = 0; i < 100000; i++) {
            l.add(new String("Juanio García"));            
        }
        double m2=Runtime.getRuntime().freeMemory();
        System.out.println("\nMem max:"  +Runtime.getRuntime().maxMemory()/new Float(1024*1024) +" MB");
        System.out.println("Mem total:"+Runtime.getRuntime().totalMemory()/new Float(1024*1024) +" MB");
        System.out.println("Mem libre:"+Runtime.getRuntime().freeMemory()/new Float(1024*1024) +" MB");
        System.out.println("\n Los objetos ocupan "+new Double ((m1-m2)/1024.0f)+" KB");
        
        System.out.println(""+Runtime.getRuntime().availableProcessors());
        
        
        
        
        
        /*Iterator it;
        it=l.listIterator();
        while(it.hasNext()){
            //System.out.println(""+it.next());
        }*/
        
    }
}
