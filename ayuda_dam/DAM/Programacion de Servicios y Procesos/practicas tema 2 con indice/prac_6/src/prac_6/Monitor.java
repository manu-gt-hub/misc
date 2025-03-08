
package prac_6;

import GUI.Ventana;
import static prac_6.Monitor.TOT_COCACOLAS;

public class Monitor {
    static final int TOT_COCACOLAS=10;
    static final int TOT_CERVEZAS=10;
    boolean reponiendo=false;
    boolean reponiendoCer=false;
    boolean reponiendoCoc=false;
    int numCocs=10;
    int numCervezas=10;

    public Monitor() {
        
    }
    public synchronized void beberCocacola(Main.PersonaA p,Ventana v) throws InterruptedException
    {

            
            while(numCocs<=0  && reponiendo==true)
            {

                  v.escribir("Esperando Cocacolas...");
                  this.wait();
                
            }
            v.escribir("Persona "+p.num+" Bebiendo cocacola...");
            numCocs-=1;
            
        
        
    }
    public void beberCerveza(Runnable p,Ventana v) throws InterruptedException
    {
        synchronized(this)
        {
            
            while(numCervezas<=0  &&  reponiendo==true)
            {

                  v.escribir("Esperando Cervezas...");
                  this.wait();
            }
            numCervezas-=1;
            
        }
        
    }
    public int getNumCocs()
    {

           return this.numCocs;       
        
       
        
    }
    public int getNumCervezas()
    {

           return this.numCervezas;
        
    }

    public void reponerCervezas(Ventana v) throws InterruptedException 
    {
        synchronized(this)
        {
            while(reponiendo==true)
            {

                this.wait();
                
            }
            
            this.reponiendo=true;
            this.numCervezas=TOT_CERVEZAS;
            v.escribir("REPONIENDO CERVEZAS");
            this.reponiendo=false;
            Thread.sleep(1200);
            notifyAll();
            Thread.sleep(3);
        
        
          
        }
        
        
    }
    public void reponerCocacolas(Main.PersonaA p,Ventana v) throws InterruptedException 
    {
        synchronized(this)
        {
            while(reponiendo==true)
            {

                  this.wait();
                
            }
            this.reponiendo=true;
            this.numCocs=TOT_COCACOLAS;
            v.escribir("Persona "+p.num+" REPONIENDO COCACOLAS");
            Thread.sleep(1200);
            this.reponiendo=false;
            notifyAll();
            Thread.sleep(3);

                
       }
       
        
    }
    
}
