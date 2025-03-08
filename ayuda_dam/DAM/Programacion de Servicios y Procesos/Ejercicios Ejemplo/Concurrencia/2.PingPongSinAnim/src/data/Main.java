package data;

/**
 * Ej en el q simulamnos una partida de ping-pong
 * Elemento compartido: la bola
 * 
 * Solución mediante un sencillo monitor llamado Pelota
 * 
 * @author Profesor
 */

public class Main {
    static boolean FIN=false;
    static Player turno=null; //Jugador q tiene el turno

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws InterruptedException {
        Pelota pelota = new Pelota();
        //Cada jugador se ejecutará en un hilo
        Player p1=new Player("Michael",pelota);
        Player p2=new Player("Guille",pelota);

        p1.setOponente(p2);
        p2.setOponente(p1);

        turno=p1;
        p1.start();    // Michael empieza a jugar(golpea la bola xa sacar)        
        p2.start();
        try {
            // HAGO Q LA PARTIDA DURE n SEGUNDOS
            Thread.sleep(5000);
        } catch (InterruptedException e) { }        

        Main.FIN=true;
        while(p1.isAlive() || p2.isAlive());//Espero hasta q los hilos acaben para sacar el mensaje de fin
        System.out.println("Fin de la partida!");

       }
}
