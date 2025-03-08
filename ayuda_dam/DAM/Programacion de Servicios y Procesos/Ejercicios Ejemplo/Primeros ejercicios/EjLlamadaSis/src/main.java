/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author JuanXXIII
 */
public class main {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        long memoriaTotal;
        long memoriaDisponible;
        
        memoriaTotal = Runtime.getRuntime().totalMemory();
        memoriaDisponible = Runtime.getRuntime().freeMemory();
        
        System.out.println("Memeoria Total: "+memoriaTotal/new Float(1024*1024)+".mb");
        System.out.println("Memoria Disponible: "+memoriaDisponible/new Float(1024*1024)+".mb");
        for (int i = 0; i < 1000; i++) {
            Delegado d=new Delegado();
        }
        System.out.println("Memoria restante: "+Runtime.getRuntime().freeMemory()/new Float(1024*1024)+".mb");
        int p=Runtime.getRuntime().availableProcessors();
        System.out.println("Numero de procesadores: "+p);
    }
}