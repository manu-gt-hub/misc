package asteriscomassync;

/**
 *
 * @author Administrator
 */
public class Pantalla {
    private boolean dibujarAsterisco;//true si dibujamos el *; false si dibujamos el +

    public Pantalla(boolean x) {
        this.dibujarAsterisco=x;        
    }

    public synchronized void dibujarMas() {
        while(dibujarAsterisco==true){
            try {
                this.wait();//Main es el recurso compartido
            } catch (InterruptedException ex) {}
        }//while

        for(int i=0;i<10;i++)
            System.out.print("+ ");

        System.out.println();
        dibujarAsterisco=true;
        notifyAll();
    }

    public synchronized void dibujarAst() {
        while(dibujarAsterisco==false){
            try {
                this.wait();//Main es el recurso compartido
            } catch (InterruptedException ex) {}
        }//while

        for(int i=0;i<10;i++)
            System.out.print("* ");

        System.out.println();
        dibujarAsterisco=false;
        notifyAll();
    }

}
