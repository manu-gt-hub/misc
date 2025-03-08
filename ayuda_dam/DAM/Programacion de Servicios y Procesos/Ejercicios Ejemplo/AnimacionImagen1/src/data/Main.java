/*
 En este sencillo ejemplo mostramos a un muñeco animado por 3 imágenes,
 q se intercalarán de forma adecuada para mostrar una bonita animación sobre una ventana
 */
package data;

import java.awt.*;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main {
    
    private static final long DEMO_TIME = 10000; //t MAX en ms
    
    private JPanel pantalla;
    private Image bgImage;
    private Animacion anim;
    
    private Image dbImage=null;
    private Graphics dbg=null;

    public static void main(String[] args) {

        JFrame v=new JFrame("Ejemplo de animación");
        Main m=new Main();

        m.pantalla = new JPanel();
        
        v=new JFrame();
        v.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        v.setResizable(false);
        v.setSize(800,600);
        v.setContentPane(m.pantalla);
        v.setLocationRelativeTo(null);

        m.generarAnimación();
        v.setVisible(true);
        m.realizarAnimación();
    }  
    




    public void generarAnimación() {
        
        bgImage =       cargarImagen("images/background.jpg");
        Image imgPlayer1 = cargarImagen("images/player1.png");
        Image imgPlayer2 = cargarImagen("images/player2.png");
        Image imgPlayer3 = cargarImagen("images/player3.png");
        
        anim = new Animacion();//La animación estará formada por 5 frames(3 imágenes q se pueden repetir en este caso):
            anim.addFrame(imgPlayer1, 500);//Muestro el 1er frame de la animación durante 250 ms
            anim.addFrame(imgPlayer2, 1000);//Muestro el 2º  frame de la animación durante 150 ms
            anim.addFrame(imgPlayer3, 600);//..
            anim.addFrame(imgPlayer2, 100);              
    }


    private Image cargarImagen(String fileName) {
        return new ImageIcon(fileName).getImage();
    }  


    public void realizarAnimación() {
        long instanteInicial = System.currentTimeMillis();
        long elapsedTime = instanteInicial;
        Graphics g;

        while (elapsedTime - instanteInicial < DEMO_TIME) {
            long tiempoTranscurrido =  System.currentTimeMillis() - elapsedTime;//Cdo ejecute esta línea habrán transcurridos N ms desde q se ejecutó la última sentencia q capturaba el tiempo del reloj del sistema
                                                                                                          //=entre 2 sentencias con CurrentMillis() transcurren N ms
            elapsedTime += tiempoTranscurrido;

            // actualizamos la animación=Cambio/Actualizo el frame q se deberá visualizar (si es necesario en relación al tiempo transcurrido)
            anim.update(tiempoTranscurrido);

            // dibujo el frame en la pantalla
            g =pantalla.getGraphics();
            draw(g);
            if(g!=null)g.dispose();

            //Cedo el paso a otros hilos
            try {
                Thread.sleep(20);
            }
            catch (InterruptedException ex) { }
        }
    }


    public void draw(Graphics g) {
        if (g==null)return;
         gameRender(); // dibujo sobre una imagen
        // draw sprite
        if (dbImage != null)
            g.drawImage(dbImage, 0,0, this.pantalla.getWidth(),this.pantalla.getHeight(),null);       
    }
    
     //Dibujo sobre una imagen (Doble buffer)
    private void gameRender(){// draw the current frame to an image buffer
        if (dbImage == null){ // create the buffer
            dbImage = this.pantalla.createImage(this.pantalla.getWidth(),this.pantalla.getHeight()  );//Método heredado de java.awt.Component
            if (dbImage == null) {
                System.out.println("dbImage is null");
                return;
            }else
                dbg = dbImage.getGraphics();
        }
        
        // dibujo el fondo 
        dbg.drawImage(bgImage, 0, 0, null);

        // Y luego la imagen q corresponda en la animación
        dbg.drawImage(anim.getImage(), 0, 0, null);

    } // end of gameRender()

}//:~)
