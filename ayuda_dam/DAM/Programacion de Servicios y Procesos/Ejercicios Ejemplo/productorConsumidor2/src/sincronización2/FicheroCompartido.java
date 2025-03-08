package sincronización2;

import java.io.*;

/***********************************************************
  Clase q gestiona el recurso compartido. Creo un monitor para acceder a él
  Nota: Cdo escribo en el fichero siempre sobreescribo, no añado
*/ 
public class FicheroCompartido {
private File f;	
	
	private MiV2 v1,v2;
	private int contEscrituras, contLecturas;
	private OutputStream out;
	private InputStream in;
        
        private final int NUM_CARS=5;
        private final char CAR='*';
        
        private boolean dataAvailable=false;// variable de condición 
        
	/**
         * Constructor
         * @param vnombre nombre del fichero compartido (nombre externo. Se toma como raíz la del proyecto)
         */	
	public FicheroCompartido(String vnombre){
		
		f=new File(vnombre);
                if(f==null){
                    System.out.print("Error, no se puede crear el fichero");
                    System.exit(1);                
                }
                
                //Creo las ventanas q visualizarán el proceso
		v1=new MiV2();
		v2=new MiV2();
		
		v1.setSize(250,500);
		v1.setVisible(true);		
		v1.setLocation(60,150);
                
                v2.setSize(250,500);
                v2.setVisible(true);		
		v2.setLocation(260,150);		
				
	}//Ctor
	
	
	public synchronized void escribir(){
		
		while (dataAvailable == true){  //me quedo a la espera de que el dato lo coja un "consumidor
			try{
				wait();
			}catch (InterruptedException e){}
		}//si no hay un dato "producido",lo produzco y pongo como el dato como disponible
		
		try{
			out=new FileOutputStream(f.getName());
		}catch(FileNotFoundException fnf){}
		
		try{
			for (float i=0;i<NUM_CARS;i++)
                            out.write(CAR);
			out.close();
		}catch(IOException io){}
                
		dataAvailable=true;
		notifyAll(); //Notifico a los demas que ya he dejado los 50000 cars en el arch
		
		contEscrituras++;
		v1.escribir(contEscrituras + " escribo "+NUM_CARS+" cars.");
	}
	

        public synchronized void leer(){
		
		while (dataAvailable == false){ //Mientras el "productor" no haya escrito un dato no lo puedo leer.Espero
                    
                    try{
				this.wait();
                    } catch (InterruptedException e) { }
                }                
                //Si ya tengo un dato lo leo. Notifico que ya lo he leido y que ya no hay dato disponible
		try{
			in=new FileInputStream(f.getName());
		}catch(FileNotFoundException fnf){}
		
		try{
			for (float i=0;i<NUM_CARS;i++)
                            in.read();
			in.close();
		}catch(IOException io){}
		
		dataAvailable = false;
		notifyAll();
		contLecturas++;
		v2.escribir(contLecturas+" Leo "+ NUM_CARS+" cars.");		
	}
	
}//FicheroCompartido

