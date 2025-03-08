package data;
import java.awt.Image;

/*
 * Un sprite es un objeto animado que tiene siempre una posición y una velocidad en la pantalla
 */
public class Sprite {

    private Animacion anim;
    
    // posición (pixels)
    private float x;
    private float y;

    // velocidad (pixels por milisegundo)
    private float dx;
    private float dy;

   
    public Sprite(Animacion anim) {
        this.anim = anim;
    }

    /**
        Actualizo pos del sprite en base a su velocidad
        Posteriormente (sigui línea) actualizo el frame de la animación
    */
    public void update(long elapsedTime) {
        x += dx * elapsedTime;
        if(y<200)
            y += dy * elapsedTime;
        anim.update(elapsedTime);
    }

//-------------------------------------------------------------------
//
//                   ACCEDENTES Y MUTADORES
//
//-------------------------------------------------------------------


    /**
        Gets this Sprite's current x position.
    */
    public float getX() {
        return x;
    }

    /**
        Gets this Sprite's current y position.
    */
    public float getY() {
        return y;
    }

    /**
        Sets this Sprite's current x position.
    */
    public void setX(float x) {
        this.x = x;
    }

    /**
        Sets this Sprite's current y position.
    */
    public void setY(float y) {
        this.y = y;
    }

    /**
        Gets this Sprite's width, based on the size of the
        current image.
    */
    public int getWidth() {
        return anim.getImage().getWidth(null);
    }

    /**
        Gets this Sprite's height, based on the size of the
        current image.
    */
    public int getHeight() {
        return anim.getImage().getHeight(null);
    }

    /**
        Gets the horizontal velocity of this Sprite in pixels
        per millisecond.
    */
    public float getVelocityX() {
        return dx;
    }

    /**
        Gets the vertical velocity of this Sprite in pixels
        per millisecond.
    */
    public float getVelocityY() {
        return dy;
    }

    /**
        Sets the horizontal velocity of this Sprite in pixels
        per millisecond.
    */
    public void setVelocityX(float dx) {
        this.dx = dx;
    }

    /**
        Sets the vertical velocity of this Sprite in pixels
        per millisecond.
    */
    public void setVelocityY(float dy) {
        this.dy = dy;
    }

    /**
        Gets this Sprite's current image.
    */
    public Image getImage() {
        return anim.getImage();
    }
}
