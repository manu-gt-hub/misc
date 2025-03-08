/*
 En este sencillo ejemplo mostramos el Hero de antes/un Pacman, animados por 3/4 imágenes,
 q se intercalarán de forma adecuada para mostrar una bonita animación sobre una ventana.
 Incorporaciones sobre el ej anterior:
    - El sprite se moverá por la pantalla
    - Se usa la técnica del doble buffer para evitar el efecto de parpadeo (blinking) al repintar, molesto del anterior ejercicio
 */

package data;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main {
    
    private static final long DEMO_TIME = 7000; //t MAX q durará la anim en ms
    private final int PWIDTH=1000,PHEIGHT=600;//Tamaño de la ventana/panel
    private final Color COLOR_FONDO=Color.yellow;
    private final boolean IMG_COME_COCOS=false;//V si quiero mostrar la animación del comecocos, y f si quiero mostrar la del Hero
    
    private JFrame v;
    private JPanel pantalla;
    private Animacion anim;
    private Sprite sprite;
    
    private Image dbImage=null;
    private Graphics dbg=null;


    public static void main(String[] args) {
        new Main();
    }

    public Main(){

        v=new JFrame("Ejemplo de animación");

        pantalla = new JPanel();
        pantalla.setSize(PWIDTH,PHEIGHT);
        pantalla.setBackground(COLOR_FONDO);
        
        v=new JFrame();
        v.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        
        v.setSize(PWIDTH,PHEIGHT);


        JButton botonInicio=new JButton("Iniciar animación");      
        botonInicio.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                    Main.this.iniciarAnimación();
            }
        });
        v.add(botonInicio);
        v.setVisible(true);
    }


    private void iniciarAnimación() {
        v.setContentPane(pantalla);
        generarAnimación();//Cargo las imágenes y establezco los atributos necesarios        
        realizarAnimación();//Hago el bucle q visualiza la animación y su movimiento
    }

    public void generarAnimación() {        

        if(IMG_COME_COCOS)
            this.cargarImagenComeCocos();
        else
            this.cargarImagenHero();
        sprite = new Sprite(anim);

        // start the sprite off moving down and to the right
        sprite.setVelocityX(0.2f);
        sprite.setVelocityY(0.2f);
    }


    private Image cargarImagen(String fileName) {
        return new ImageIcon(fileName).getImage();
    }

    private void cargarImagenComeCocos() {

        Image img1 = cargarImagen("images/pacMan1.gif");
        Image img2 = cargarImagen("images/pacMan2.gif");
        Image img3 = cargarImagen("images/pacMan3.gif");
        Image img4 = cargarImagen("images/pacMan4.gif");


        anim = new Animacion();//La animación estará formada por 7 frames(4 imágenes q se pueden repetir en este caso):
            anim.addFrame(img1, 100);//Muestro el 1er frame de la animación durante x ms
            anim.addFrame(img2, 200);//Muestro el 2º  frame de la animación durante y ms
            anim.addFrame(img3, 150);//..
            anim.addFrame(img4, 50);
            anim.addFrame(img3, 150);
            anim.addFrame(img2, 150);
            anim.addFrame(img1, 100);//Muestro el 1er frame de la animación durante x ms
    }

    private void cargarImagenHero() {

        Image img1 = cargarImagen("images/player1.png");
        Image img2 = cargarImagen("images/player2.png");
        Image img3 = cargarImagen("images/player3.png");


        anim = new Animacion();
            anim.addFrame(img1, 200);
            anim.addFrame(img2, 200);
            anim.addFrame(img3, 200);
            anim.addFrame(img2, 200);            
    }



    public void realizarAnimación() {
        long instanteInicial = System.currentTimeMillis();
        long instanteActual = instanteInicial;
        Graphics g;

        while (instanteActual - instanteInicial < DEMO_TIME) {
            long tiempoTranscurrido =  System.currentTimeMillis() - instanteActual;//Cdo ejecute esta línea habrán transcurridos N ms desde q se ejecutó la última sentencia q capturaba el tiempo del reloj del sistema
                                                                                                          //=entre 2 sentencias con CurrentMillis() transcurren N ms
            instanteActual += tiempoTranscurrido;

            // actualizamos la animación=Cambio/Actualizo el frame q se deberá visualizar y su posición(si es necesario en relación al tiempo transcurrido)
            sprite.update(tiempoTranscurrido);

            // dibujo el frame en la pantalla, usando la técnica del doble buffer xa evitar parpadeos
            g =pantalla.getGraphics();
            draw(g);     // pinto el contenido del buffer
            
            if(g!=null)g.dispose();

            //Cedo el paso a otros hilos
            try {
                Thread.sleep(25);
            }
            catch (InterruptedException ex) { }
            
        }

    }    

    public void draw(Graphics g) {
        if (g==null)return;
        gameRender(); // dibujo sobre una imagen
        // draw sprite
        if (dbImage != null)
            g.drawImage(dbImage, 0, 0, null);
        
    }

    //Dibujo sobre una imagen (Doble buffer)
    private void gameRender(){// draw the current frame to an image buffer
        
        if (dbImage == null){ // create the buffer
            dbImage = this.pantalla.createImage(PWIDTH, PHEIGHT);//Método heredado de java.awt.Component
            if (dbImage == null) {
                System.out.println("dbImage is null");
                return;
            }else
                dbg = dbImage.getGraphics();
        }

        // clear the background
        dbg.setColor(this.COLOR_FONDO);
        dbg.fillRect (0, 0, PWIDTH, PHEIGHT);

        // draw game elements
        dbg.drawImage(sprite.getImage(), Math.round(sprite.getX()),  Math.round(sprite.getY()), null);

    } // end of gameRender()

}//:~)
