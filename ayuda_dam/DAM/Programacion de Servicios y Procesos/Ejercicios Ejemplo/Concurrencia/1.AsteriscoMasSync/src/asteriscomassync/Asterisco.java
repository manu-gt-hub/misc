/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package asteriscomassync;

/**
 *
 * @author DAI
 */
public class Asterisco extends Thread{

    private static final int NUM_AST=5;//número de asteriscos por fila
    private Pantalla p;

    public Asterisco() {
        this.p=null;
    }
    
    public Asterisco(Pantalla m) {
        this.p=m;
    }

    
    @Override
    public void run() {        
        for (int i = 0; i < 100; i++){            
            if(p==null){//Si quiero hacerlo sin monitores
                    for(int j=0;j<NUM_AST;j++){
                        System.out.print("* ");
                    }
                    System.out.println("");
            }else //Si quiero hacerlo con monitores
                p.dibujarAst();            
        }
    }

}
