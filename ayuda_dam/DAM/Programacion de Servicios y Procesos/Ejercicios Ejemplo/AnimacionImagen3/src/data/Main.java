/*
 En este sencillo ejemplo mostramos la animación de Ryu.

 Incorporaciones sobre el ej anterior:
    - Fondo de imagen
    - Main como hilo para poder gestionar eventos mientras se muestra la animación
 */

package data;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JFrame;

public class Main extends Thread{
    
    private static final long DEMO_TIME = 15000; //t MAX q durará la anim en ms
    private static ImageIcon IMAGEN_FONDO=new ImageIcon("images/taj-mahal.jpg");
    private final int PWIDTH=800,PHEIGHT=400;//Tamaño de la ventana/panel
    private final Color COLOR_FONDO=Color.black;
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
        v.setResizable(false);
        v.setTitle("Ryu Animation");


        JButton botonInicio=new JButton("Iniciar animación");      
        botonInicio.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                    Main.this.start();
            }
        });
        v.add(botonInicio);
        v.setVisible(true);
    }


    @Override
    public void run() {

            v.setContentPane(pantalla);
            generarAnimación();//Cargo las imágenes y establezco los atributos necesarios
            realizarAnimación();//Hago el bucle q visualiza la animación y su movimiento

            try {
                Thread.sleep(150);
            }
            catch (InterruptedException ex) { }

    }
    

    public void generarAnimación() {        

        this.cargarImagenHero();
        sprite = new Sprite(anim);

        // start the sprite off moving down and to the right
        sprite.setVelocityX(0.1f);
        sprite.setVelocityY(0.1f);
    }


    private Image cargarImagen(String fileName) {
        return new ImageIcon(fileName).getImage();
    }

    
    private void cargarImagenHero() {

        Image img1 = cargarImagen("images/Ryu.png");
        Image img2 = cargarImagen("images/RyuA1.png");
        Image img3 = cargarImagen("images/RyuA2.png");
        Image img4 = cargarImagen("images/RyuA3.png");
        Image img5 = cargarImagen("images/RyuA4.png");
        Image img6 = cargarImagen("images/RyuA5.png");
        Image img7 = cargarImagen("images/RyuA6.png");



        anim = new Animacion();
            anim.addFrame(img1, 400);
            anim.addFrame(img2, 400);
            anim.addFrame(img3, 400);
            anim.addFrame(img4, 400);
            anim.addFrame(img5, 400);
            anim.addFrame(img6, 400);
            anim.addFrame(img7, 400);
            anim.addFrame(img2, 400);
            //anim.addFrame(img1, 200);
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
            g.drawImage(dbImage, 0,0, null);       
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
        //dbg.setColor(this.COLOR_FONDO);
        //dbg.fillRect (0, 0, PWIDTH, PHEIGHT);

        // En lugar de limpiar el fondo y pintarlo. agrego una imagen tan grade como la ventana
        dbg.drawImage(Main.IMAGEN_FONDO.getImage(), 0, 0, PWIDTH, PHEIGHT,this.v);

        // draw game elements
        dbg.drawImage(sprite.getImage(), Math.round(sprite.getX()), Math.round(sprite.getY()), null);

    } // end of gameRender()

}//:~)
