package data;

import java.net.UnknownHostException;

/**
 Este ejemplo, basado en el ejemplo de juego en red tiene la siguiente mecánica:
 * Los jugadores se conectan a la partida cuando quieran (mínimo 2)
 * De ellos uno es el administrador de la misma (el primero en conectarse)
 * Cuando el administrador lo decida ya no se admiten más jugadores
 * Cada jugador estará representado por una figura de color  

 El juego consiste en que de repente aparecen iconos (de valor entre 10 y 50 puntos)
 en la pantalla.

 El primer jugador que colisione con un icono se lleva los puntos y este desaparece.
 El juego se desarrolla hasta que alguien obtenga 100 puntos, momento en el que se determina un ganador.  
 */

/*****************************************************************************
 Nota estos ejemplos se pueden enfocar desde 2 puntos de vista:
 a) Serialización
 b) Generando nosotros nuestro protocolo
  
 Este ejemplo sigue el segundo formato, debido a que así ilustro otro camino 
 para resolver este tipo de problemas.
 ******************************************************************************/





public class Main {
    static int PUERTO=50000;

    public static void main(String args[]) throws InterruptedException, UnknownHostException
    {
        // creo el server...
        Servidor server = new Servidor(PUERTO);
     
        new Thread(server).start();
    }
}