/*
  
 CONTIENE LA BASE DE PROGRAMACIÓN PARA GENERAR ANIMACIONES
 
 */
package data;

import java.awt.Image;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Timer;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 *
 * @author Profesor
 */
public class Animacion extends Thread{
    
    final Image imgFondo=Main.cargarImagen("PlanetNamek.jpg");
    List<Dummy> l;
    List<Proyectil> lp;
    private boolean pararAnimacion;
    private Timer temporizador;

    public Animacion() {
        
        Dummy goku=new Dummy(90,300,40,40);
        Dummy pikolo=new Dummy(10,300,50,50);        
        Dummy krilin=new Dummy(10,300,35,35);        
               
        l = new LinkedList();
        l.add(goku);
        l.add(pikolo);            
        l.add(krilin);
        
        lp = new LinkedList();        
        
        goku.setPos(120,Main.TAM_PANTALLA.height-goku.getHeight()-50);
        pikolo.setPos(60,Main.TAM_PANTALLA.height-pikolo.getHeight()-50);        
        krilin.setPos(10,Main.TAM_PANTALLA.height-krilin.getHeight()-50);        
    }

    public Animacion(List<Dummy> l, List<Proyectil> lp) {
        this.l = l;
        this.lp = lp;
    }
    
    

    @Override
    public void run() {        
        
        while(!pararAnimacion){        
            actualizar();
            Main.getVentana().repaint();
            try {        
                Thread.sleep(VelocidadAnimacion.RAPIDA.getValor());
            } catch (InterruptedException ex) {
                System.out.println("Error al detener el hilo");
            }            
        }
    }

    private void actualizar() {
            for (Dummy dummy : l) {
                dummy.moverHaciaDcha();        
            }               
            //Lo cambio x el copyOnwriteArrayList xa evitar problemas de concurrencia
            /*for (Proyectil proyectil : lp) {
                proyectil.moverHaciaAbajo();
            } */            
            
            List<Proyectil> lpc=new CopyOnWriteArrayList((List<Proyectil>) lp);
            Iterator itr=lpc.iterator();
            while(itr.hasNext()){
                Proyectil proyectil=(Proyectil)itr.next();
                proyectil.moverHaciaAbajo();
            }        
    }
    

    void iniciar() {
        Main.TareaLanzaMisiles t = new Main.TareaLanzaMisiles(lp);
        temporizador=new Timer();
        temporizador.schedule(t, 0,1000);      
        
        pararAnimacion=false;
        this.start();
        
    }
    
    void parar() {
        this.pararAnimacion=true;
        this.temporizador.cancel();
    }

    public Image getImgFondo() {
        return this.imgFondo;
    }

    public List<Dummy> getListaDummys() {
        return l;
    }

    public List<Proyectil> getListaProyectiles() {
        return lp;
    }  

    
    
    
    
}
