package carrera;

import java.awt.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public final class GamePanel extends JPanel implements Runnable{
    
    
    private volatile Thread updateThread;//Hilo de alta prioridad q se encarga del repintado    
                                         //Volatile es xa q todos los hilos trabajen con la misma copia
    Corredor []corredores;               //Hilos q conformar?n la carrera
    
    private volatile boolean running=false;
    private volatile boolean gameOver=false;
    
    private Image fondo= new ImageIcon((System.getProperty("user.dir")+"\\res\\imgs\\asfalto.jpg")).getImage();        
    
    //Variables xa hacer la renderizaci?n/Doble Buffering
    private Graphics dbg;
    private Image dbImage=null;
    
    public class Tiempo implements Runnable{
        JLabel label1;

        public Tiempo() {
            label1=new JLabel();
            label1.setBounds(180, 180, 100, 100);
            label1.setForeground(Color.white);
            
            
        }
        
        
        @Override
        public void run() {
            
            try {
                for (int i = 3; i >0; i--) {
                    label1.setText(String.valueOf(i));
                    Thread.sleep(1000);
                    repaint();
                }

            } catch (InterruptedException ex) {
                Logger.getLogger(GamePanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    
    }
    
    public GamePanel(int numCorredores) throws InterruptedException {
        //Establezco los atributos del panel        
        setSize(800,600);
        
        //Creo a los Corredor y establezco sus propiedades
        //Max 5 Corredor;m?nimo 2 Corredor
        if(numCorredores>5)numCorredores=5;
        if(numCorredores<2)numCorredores=2;
        corredores=new Corredor[numCorredores];
        
        //Empiezo la carrera
        nuevaCarrera(); 

    }
    
    
    public void pararCarrera(){    
        running=false;    
        int seleccion = JOptionPane.showOptionDialog(
        this, // Componente padre
        "¿Volver a jugar?", 
        "Fin de la carrera", 
        JOptionPane.YES_NO_CANCEL_OPTION,
        JOptionPane.QUESTION_MESSAGE,
        null,
        new Object[] { "Si", "No"},
        "Si");
    }
    
    
    public void nuevaCarrera() throws InterruptedException{        
        //Relleno los atributos (=c?rculos) q repre a los Corredor
        //x=y=ancho=20;alto=15;            
        
        //Lanzo el hilo q gestiona la animaci?n
        
        
        for(int i=0;i<corredores.length;i++){                    
            if(corredores[i]==null){
                int retardo=(int) (Math.random() * 100); 
                switch(i)
                {
                    case 0:
                        corredores[i]=new Corredor((i+1)*100, retardo,"coche1");
                    break;
                    case 1:
                        corredores[i]=new Corredor((i+1)*100, retardo,"coche2");
                    break;
                    case 2:
                        corredores[i]=new Corredor((i+1)*100, retardo,"coche3");
                    break;
                    case 3:
                        corredores[i]=new Corredor((i+1)*100, retardo,"coche4");
                    break;
                        case 4:
                        corredores[i]=new Corredor((i+1)*100, retardo,"coche5");
                    break;
                }
                
                
                
            }
        }
        if (updateThread == null || !running) {
            updateThread = new Thread(this, "Hilo de actualización del repintado");
            updateThread.setPriority(Thread.MAX_PRIORITY);//Le doy la mayor prioridad (1..10)
            
            updateThread.start();
            
            
             
              
            
        }


    }
    
    /*
     Siempre hago lo mismo repetidamente:
     * 1-->Actualizo los datos
     * 2-->Renderizo a un buffer aux
     * 3-->Pinto
     * 4-->Hago una pausa
    */
    @Override
    public void run() {
        boolean esperando=true;
        running=true;
        while (running) {
            
            actualizarDatos();            
            repaint();//Repinto la pantalla cada cierto tiempo
            if(esperando)
            {
                Thread tiempo=new Thread(new Tiempo());
                try {
                    tiempo.start();
                    Thread.sleep(3000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(GamePanel.class.getName()).log(Level.SEVERE, null, ex);
                }
                esperando=false;
                for (int i = 0; i < corredores.length; i++) {
                     corredores[i].start();
                
                }
            }
            try {//dejo paso al resto de hilos(=Corredor) xa q se exe tambi?n
                Thread.sleep(5);
            } catch (InterruptedException e) {}
        }
    }
    
    private void actualizarDatos() {
        //Miro si hay ganador. SI es así paro la carrera
        //Nota:Cada hilo=corredor se actualiza solo
        if(corredores==null)return;
        for (int i = 0; i < corredores.length; i++)
            if(corredores[i]!=null&&(corredores[i].getX()+corredores[i].getAncho()) >= this.getWidth()-10 )//Cada borde de la ventana son 5 px aprox
                this.pararCarrera();
    }
    
    private void renderizar(){
        
        if(dbImage==null){
            dbImage=createImage(this.getWidth(),this.getHeight());
            if(dbImage==null){
                System.out.print("dbImage is Null");
                return;
            }else
                dbg=dbImage.getGraphics();
        }
        
        //Limpio el fondo
        dbg.drawImage(fondo,0,0,this.getWidth(),this.getHeight(),null);        
        
        //Dibujo a los Corredores
        for (int i = 0; i < corredores.length; i++)             
            corredores[i].dibujar(dbg);            
    }    
  
   
    @Override
    public void paintComponent(java.awt.Graphics g){            
        renderizar();             
        if(dbImage!=null)    
            g.drawImage(dbImage, 0,0,null);
    }




       
}//:~)

