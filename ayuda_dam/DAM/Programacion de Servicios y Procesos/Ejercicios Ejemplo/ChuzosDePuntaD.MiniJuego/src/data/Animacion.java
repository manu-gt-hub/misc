/*
  
 CONTIENE LA BASE DE PROGRAMACIÓN PARA GENERAR ANIMACIONES
 usando monitores xa gestionar la concurrencia
 
 */
package data;

import java.awt.Graphics;
import java.awt.Image;
import java.util.LinkedList;
import java.util.List;
import java.util.Timer;
import javax.swing.JOptionPane;

/**
 *
 * @author Profesor
 */
public class Animacion extends Thread{
    
    final Image imgFondo=Main.cargarImagen("PlanetNamek.jpg");
    List<Dummy> listaDummys;
    MonitorListaProyectiles monitorlp;
    private boolean pararAnimacion;
    
    Timer temporizador;//xa la tarea temporizada q lanza misiles
    

    public Animacion() {
        
        Dummy goku=new Dummy(90,300,40,40);
        Dummy pikolo=new Dummy(10,300,50,50);        
        Dummy krilin=new Dummy(10,300,35,35);        
               
        listaDummys = new LinkedList();
        listaDummys.add(goku);
        listaDummys.add(pikolo);            
        listaDummys.add(krilin);
        
        monitorlp = new MonitorListaProyectiles();        
        
        goku.setPos(120,Main.TAM_PANTALLA.height-goku.getHeight()-50);
        pikolo.setPos(60,Main.TAM_PANTALLA.height-pikolo.getHeight()-50);        
        krilin.setPos(10,Main.TAM_PANTALLA.height-krilin.getHeight()-50);        
    }
    

    public Animacion(List<Dummy> l, MonitorListaProyectiles lp) {
        this.listaDummys = l;
        this.monitorlp = lp;
    }
    
    

    @Override
    public void run() {                        
        while(!pararAnimacion){        
            actualizar();
            if(!pararAnimacion){
                Main.getVentana().repaint();
                try {        
                    Thread.sleep(VelocidadAnimacion.RAPIDA.getValor());
                } catch (InterruptedException ex) {
                    System.out.println("Error al detener el hilo");
                }            
            }
        }
        Main.finalizarPrograma();
    }
    

    private void actualizar() {
        //Miro si hay colsiones
        if(hayColisiones()){
            if(this.listaDummys.isEmpty()){
                JOptionPane.showMessageDialog(Main.ventana, "Han ganado los Proyectiles!!!!");
                this.parar();
            }
        }else{ //Si no colisión muevo los elementos            
            for (Dummy dummy : listaDummys) {         
                if(dummy.getPos().x+dummy.getBounds().width>=Main.ventana.getWidth()){ //Miro si he alcanzado el objetivo= el final de la pantalla
                    JOptionPane.showMessageDialog(Main.ventana, "Han ganado los Dummies!!!!");
                    this.parar();
                }else
                    dummy.moverHaciaDcha();        
            }
            monitorlp.moverHaciaAbajo();            
        }        
    }
    

    void iniciar() {
        Main.TareaLanzaMisiles t = new Main.TareaLanzaMisiles(monitorlp);
        temporizador=new Timer();
        temporizador.schedule(t, 0,300);      
        
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
        return listaDummys;
    }

    public void pintaProyectiles(Graphics g) {
        monitorlp.pintar(g);
    }

    /**
     * Mira si algún proyectil choca con personas
     * @return Devuelve true si un proyectil choca con una persona
     */
    private boolean hayColisiones() {
        for (Dummy dummy : listaDummys) {        
            if(monitorlp.hayColsionCon(dummy)){
                eliminarDummy(dummy);                
                return true;
            }
        }
        return false;
    }

    boolean isParado() {
        return this.pararAnimacion;
    }

    private void eliminarDummy(Dummy dummy) {
        this.listaDummys.remove(dummy);
    }

    
}//:~)
