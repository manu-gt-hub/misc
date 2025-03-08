
package GUI;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JTextArea;

/*clase escuchado que hereda de keylistener para escuchar eventos de pulsacion
 de tecla, que en este caso me serviran para ir evaluando tecla a tecla las teclas
 pulsadas y mientras que no sean la tecla de la barra espaciadora ire concatenando
 los caracteres tecleados en una cadena hasta que pulsen el espacio,
 momento en que llamare al metodo buscar y le pasare dicha cadena*/

class Escuchador implements KeyListener {
    Ventana vent;
    String paltext="";
    String trad="";
    String parrafo="";
    JTextArea texto2;
    JTextArea texto1;
    public Escuchador(Ventana ref) {
        vent=ref;
        texto2=vent.getTextArea1();
        texto1=vent.getTextArea2();
        
        
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        //si la tecla pulsada es el espacio
        if(e.getKeyChar()==' ')
        {
                trad=vent.Buscar(paltext);
                parrafo+=trad+" ";
                texto2.setText(parrafo);
                paltext="";
                trad="";
           
        }
        else
        {
            
           
            /*si la tecla pulsada es el backspace borro el ultimo caracter 
             del text area de las palabras que teclea el usuario*/
            if(e.getKeyChar()==8)  //si la tecla es backspace
            {
                if(paltext.length()>0)
                {
                    paltext=paltext.substring(0,(paltext.length()-1));
                }
                
                
            }
            /*si no es ni el espacio ni el backspace concateno en la cadena pal
            la tecla pulsada*/
            else
            {
                paltext+=e.getKeyChar();
            }
            //si el texto de palabras esta vacio, vacio tambien el de traducciones
            if(texto1.getText().compareToIgnoreCase("")==0)
            {
                    texto2.setText("");
                    parrafo="";
                    trad="";
                 
            }
           
        }
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
    
}
