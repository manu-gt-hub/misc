/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

/**
 *
 * @author Profesor
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        // TODO code application logic here
        Thread t=new Thread(new MiHilo());
        t.start();
        Thread.sleep(1000);        
        t.interrupt();
        
    }
}
