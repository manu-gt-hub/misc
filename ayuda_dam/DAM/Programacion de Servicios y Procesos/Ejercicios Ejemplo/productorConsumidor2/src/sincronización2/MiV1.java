package sincronización2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


//Ventana inicial de la aplicación
//Contendrá 2 botones q permitirán iniciar y detener la misma
public class MiV1 extends JFrame implements ActionListener{
Container p;
JButton botonInicio,botonFin;

	public MiV1(){
		
		super("Primera Ventana");
                this.setSize(200,150);
		//Me creo el panel q rodea el JFrame
		p=getContentPane();				
		//Me creo ls botones y sus escuchadores
		botonInicio = new JButton("Iniciar");
		botonInicio.addActionListener(this);//Gestiono el evento en la propia clase
											
		botonFin = new JButton("Finalizar");
		botonFin.addActionListener(this);//Gestiono el evento en la propia clase
													
		//los añado al panel d la V
		p.add ("East",botonInicio);
		p.add ("West",botonFin);
		
		//Añado el cod necesario xa borrar ventana.
		addWindowListener( new WindowAdapter(){
                                      @Override
                                      public void windowClosing(WindowEvent aev){
                                        System.exit(0);
                                      }
                                    }//new WindowAdapter
                                  );//addWindowListener
               setVisible(true);
               this.setLocationRelativeTo(null);
        }//Ctor
        
	public void actionPerformed (java.awt.event.ActionEvent e){
            JButton aux = (JButton)e.getSource();
            Productor prod;
            Consumidor cons;
            if (aux.getText().compareTo("Iniciar")==0){

                    FicheroCompartido f = new FicheroCompartido("fich.txt");

                    prod= new Productor(f);
                    cons = new Consumidor(f);
                    prod.start();
                    cons.start();

            }else
                if (aux.getText().compareTo("Finalizar")==0){
                            prod=null;
                            cons=null;
                            dispose();
                            System.exit(-1);
                }//if
	}//actionPerformed

}//:ÞMiV1