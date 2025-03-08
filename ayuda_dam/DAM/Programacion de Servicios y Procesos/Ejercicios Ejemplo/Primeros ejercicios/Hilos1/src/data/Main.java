package data;

/**
 *
 * @author Profesor
 */
public class Main {
    int vero=9;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Thread t1=new MiHilo("AAAA");        
        Thread t2=new MiHilo("BBBB");
        t1.start();
        t2.start();        
        for (int i = 0; i < 10; i++) {
            System.out.print("poner ladrillos"); 
            if(i!=0 && i%100==0)
                System.out.println("");
        }
        System.out.println("FIN\n");
        
        
    }
    
    class MiHilo extends Thread{
    private String x;

    public MiHilo(String x) {
        this.x = x;
    }
    
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.print(x); 
            if(i!=0 && i%10==0)
                System.out.println("");            
        }
        pepe();
    }        
    }

class MiHilo2 extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            System.out.print("poner tuberías "); 
            if(i!=0 && i%10==0)
                System.out.println("");
        }
        pepe();
    }    
}
    

private void pepe() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    
}





