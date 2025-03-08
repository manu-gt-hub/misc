

package temporizador;

import java.util.TimerTask;


//Tarea q quiero temporizar
//Lo q hace es actualizar la x cada cierto tiempo(ver cdo se crea)y repintar
public class MiTarea extends TimerTask{

    Panel p;
    int cont=0;

    public MiTarea(Panel p) {
        this.p=p;
    }


    //OJO!!!Esto es <> a hilos, dnd run se ejecuta una única vez por objeto
    //Aquí run se ejecuta una vez cada intervalo, x lo q no se suele poner bucle
    @Override
    public void run() {
        if(p.x<=250)
            p.x+=2;
        else{
            p.x-=200;
            cont++;
        }
        if(cont>=3)
            cancel();
        p.repaint();        
    }
}
