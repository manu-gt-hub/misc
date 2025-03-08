
package prac_6;

import GUI.Ventana;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    static Monitor monitor;
    static final int N=2;
    public static class PersonaA implements Runnable
    {
        Ventana v;
        int num=0;
        Random r;

        public PersonaA(int n) {
            this.num=n;
            r=new Random();
        }
       public int getNum()
       {
           return this.num;
       }
        @Override
        public void run() {
            v=new Ventana();
            v.setTitle("Persona "+num);
            v.setVisible(true);
            v.setSize(200, 600);
            v.setLocation(100, 100);
            while(true)
            {
                if(monitor.getNumCocs()<1)
                {
                    
                    try {
                        
                        monitor.reponerCocacolas(this,v);
                        
                        
       
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                else
                {
                    try {
                    
                    monitor.beberCocacola(this,v);
                    
                    Thread.sleep(300+r.nextInt(300));
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                
            }
        }

        
    }
    public static class PersonaB implements Runnable
    {

        Ventana v;
        int num=0;
        Random r;
        public PersonaB(int n) {
            this.num=n;
            r=new Random();
        }
        @Override
        public void run() {
            v=new Ventana();
            v.setTitle("Persona "+num);
            v.setVisible(true);
            v.setSize(200, 600);
            v.setLocation(700, 100);
            while(true)
            {
                if(monitor.getNumCervezas()<1)
                {
                    
                    try {
                        
                        monitor.reponerCervezas(v);
                  
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                }
                else
                {
                    try {
                    
                    monitor.beberCerveza(this,v);
                    v.escribir("Persona "+num+" bebiendo cerveza...");
                    
                    Thread.sleep(300+r.nextInt(300));
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                
            }
            
        }

        
    }
    public static void main(String[] args) {
        monitor=new Monitor();
       for (int i = 1; i <= N; i++) {
           new Thread(new PersonaA(i)).start();
           new Thread(new PersonaB(i)).start();
           
       }
        
        
    }
}
