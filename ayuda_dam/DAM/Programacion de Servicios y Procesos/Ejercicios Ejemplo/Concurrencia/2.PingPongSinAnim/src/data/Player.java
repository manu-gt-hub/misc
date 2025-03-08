package data;


/**
 *
 * @author Profesor
 */

public class Player extends Thread {
    private Pelota pelota;
    private String nombre;    //mi nombre
    private Player oponente;//Nombre de mi oponente

    public Player(String n,Pelota juego) {
          nombre = n;          
          this.pelota  = juego;
    }

    public void setOponente(Player oponente) {
        this.oponente = oponente;
    }    

    //Golpeo la bola continuamente hacia el oponente
    @Override
    public void run() {
          while(!Main.FIN)
            try {               
                pelota.golpear(this);                
            } catch (InterruptedException ex) {
              System.out.println("Error al despertar el hilo dormido");
            }
    }


    public String getNombre(){
        return nombre;
    }

    public Player getOponente() {
        return oponente;
    }


}