
package data;

public class Pelota {    

     /**
      * Golpeamos la bola...
      * Como la bola es algo común, se pone en un elemento intermedio sincronizado
      * Nunca 2 jugadores pueden golpear la bola a la vez (no puede haber 2 hilos ejecutando este método a la vez)
      * @param p jugador q va a golpear la bola
      * @return
      */
     public synchronized boolean golpear(Player p) throws InterruptedException {
            
          if(Main.FIN)
                return false;
          
           while(Main.turno!=p)
           {                
                //System.out.println(""+p.getNombre()+" espera su turno para jugar.");
                 wait();
           }
          
          System.out.println(p.getNombre()+" golpea la bola");//golpeo la bola
          Thread.sleep(500);//Espero un ratito antes de volver a golpear          
          Main.turno = p.getOponente(); //cambio el turno          
          notify();                     //Notifico q he golpeado la bola xa liberar el otro hilo

          //Aunq funcione xq la CU va muy rápida, No se debe poner notify antes de cambiar el turno, ya q así no no liberáis el while
                    
          return true;
    }
}