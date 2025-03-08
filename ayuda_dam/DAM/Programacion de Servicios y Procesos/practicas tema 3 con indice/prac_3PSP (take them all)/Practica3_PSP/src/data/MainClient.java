package data;

import javax.swing.JOptionPane;

/*CLASE MAIN DE CADA CLIENTE*/
public class MainClient {
    
    public static void main(String[] args) {
        
        String nombre=JOptionPane.showInputDialog("Dime tu nombre por favor:");
        
        
        //Y ahora lanzo los clientes
        ClienteJugador player = new ClienteJugador(nombre);
        player.hiloJugador = new Thread(player);
        player.hiloJugador.start();
    }
    
}
