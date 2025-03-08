package data;

import java.awt.*;

/*clase con las propiedades de cada jugador*/
public class Player
{
    
    public int x, y;        //pos del jugador en la pantalla
    public String name;
    public int colId;       //identificador de color (xa elegir el color de la lista de colores)
    public int uniqueId;    //identificador único de cada jugador en el juego
    public int points;      //puntos del jugador

    public static final Color[] colors = {Color.red, 
                                          Color.green,
                                          Color.blue, 
                                          Color.yellow, 
                                          Color.magenta, 
                                          Color.white};
    
    public Player(int x, int y, int colId, int uniqueId)
    {
        this.x = x;
        this.y = y;
        this.colId = colId;
        this.uniqueId = uniqueId;
        this.points=0;
    }
    
}
