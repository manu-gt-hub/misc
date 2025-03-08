/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package asteriscomassync;

/**
 *
 * @author DAI
 */
public class Mas extends Thread{

    private static final int NUM_MAS=5;
    private Pantalla p;
    
    public Mas() {p=null;}
    
    public Mas(Pantalla m) {
        this.p=m;
    }    

    @Override
    public void run() {
         for (int i = 0; i < 100; i++){            
            if(p==null){//Si quiero hacerlo sin monitores
                    for(int j=0;j<NUM_MAS;j++){
                        System.out.print("+ ");
                    }
                    System.out.println("");
            }else //Si quiero hacerlo con monitores
                p.dibujarMas();            
        }        
    }


    


}
