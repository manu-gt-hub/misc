/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sincronización2;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

//***********************************************************
//***********************************************************
//Clase q dibuja las segundas ventanas
class MiV2 extends JFrame{
	
private Container p;
private JTextArea vis;

	MiV2(){

		super("MiV2");
				
		//Me creo el panel q rodea el JFrame
		p=getContentPane();
		p.setLayout(new BorderLayout());
		
		// TextArea
		vis= new JTextArea(" ");
		p.add ("Center",vis);
		
		//A�ado el cod necesario xa borrar ventana.
		addWindowListener( new WindowAdapter(){
                    public void windowClosing(WindowEvent aev){
                            hide();
                    }
		}//new WindowAdapter
                );//addWindowListener
				
	}//MiV2	
	
	void escribir(String cad){
		
		vis.append(cad+'\n');
		
	}
	

}//MiV2