package data;

import java.awt.Image;
import java.util.ArrayList;

/**
  Esta clase gestiona una animación como una serie de referencias a imágenes 
  (llamados frames)
  q se visualizan de forma consecutiva en relación 
  * a un tiempo asociado a cada una de ellas
  Ej: frame 1-->X ms, frame 2-->Y ms, frame 3-->Z ms, ...


  NOTA: Las imágenes q forman la animación se pueden repetir
*/
public final class Animacion {

    private ArrayList<AnimFrame> frames;     //Lista de frames q componen la aplicación
    private int frameAVisualizar;            //Contiene el índice del frame q se va visualizar (= índice de la lista de frames)
    private long animTime;                   //Tiempo transcurrido desde q comenzó la animación
    private long tiempoTotalAnimación;       //La suma de tiempos de todos los frames produce el tiempo total q durará la animación


    /**
        Crea una animación vacía
    */
    public Animacion() {
        frames = new ArrayList();
        tiempoTotalAnimación = 0;
        empezarAnimación();
    }


    /**
        Añade una img a la animación, así como el tiempo q se deberá visualizar la img dentro de ésta
    */
    public synchronized void addFrame(Image image, long t)
    {
        tiempoTotalAnimación += t;
        frames.add(new AnimFrame(image, tiempoTotalAnimación));
    }


    /**
        Inicialmente el frame q se va a visualizar es el 0, y el t q se ha visualizado la aplicación, es, evidentemente 0 ms
    */
    public synchronized void empezarAnimación() {
        frameAVisualizar = 0;
        animTime = 0;
    }


    /**
        Actualiza el frame a visualizar actualmente en la animación, 
        * si es necesario
    */
    public synchronized void update(long tiempoTranscurrido) {
        
        if (frames.size() > 1) {
            animTime += tiempoTranscurrido;            

            //Si me paso vuelvo a mostrar el primer frame de la animación (hago loop)
            if (animTime >= tiempoTotalAnimación) {
                animTime = animTime % tiempoTotalAnimación;
                frameAVisualizar = 0;
            }

            //Si no, miro si el tiempo q ha pasado es superior al del frame q estoy visualizando; si es así visualizo el siguiente frame
            while (animTime > getFrame(frameAVisualizar).instanteFinal) {
                frameAVisualizar++;
            }
        }
    }


    /**
        Devuelve el frame, en forma de obj de tipo Image, que se debe visualizar en la animación
    */
    public synchronized Image getImage() {
        if (frames.isEmpty()) {
            return null;
        }
        else {
            return getFrame(frameAVisualizar).image;
        }
    }


    private AnimFrame getFrame(int i) {
        return (AnimFrame)frames.get(i);
    }


    private class AnimFrame {

        Image image;
        long instanteFinal;//Guarda el instante a partir del cual se deberá mostrar el siguiente frame de la animación.
                           //Ej:Si soy el primer frame, y duro 10ms(0..9), 
                           //se guarda un 10; 
                           //Si soy el 2º frame y duro 20ms(10..29), se guarda un 30. 
                           //Y así sucesivamente.

        public AnimFrame(Image image, long endTime) {
            this.image = image;
            this.instanteFinal = endTime;
        }
    }
}//:~)
