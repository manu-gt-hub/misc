
package carrera;


public class Ventana extends javax.swing.JFrame {
    
    private GamePanel panel;//Panel sobre el q dibujo toda la carrera
    
    public Ventana(int numCorredores) throws InterruptedException{    
        super("Ejemplo de animación simultánea - Mini Carrera de hilos");
        setSize(800,700);
        //this.setResizable(false);        
        
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent e){
                //HiloCarrera.parar();
                System.exit(0);
            }
        });  
        
        //Añado mi panel a la ventana
        panel=new GamePanel(numCorredores);        
        getContentPane().setLayout(null);
        getContentPane().add(panel);
        panel.setBounds(0,0,this.getWidth(),this.getHeight());

        setVisible(true);
        //pack();
    }
    
    public static void main(String[] args) throws InterruptedException {        
        new Ventana(5);
    }    
    
}
