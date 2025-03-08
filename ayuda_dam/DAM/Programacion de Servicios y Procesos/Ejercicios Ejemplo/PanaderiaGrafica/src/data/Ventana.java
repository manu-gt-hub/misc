package data;

import java.util.LinkedList;
import java.util.List;


public class Ventana extends javax.swing.JFrame {
    
    //Mis vars    
    private final PanelPantalla panel;
    List<Cliente> listaClientes=new LinkedList();
    Panadera panadera;
    Bandeja bandeja;
    Horno horno;

    /** Creates new form Ventana */
    public Ventana(Panadera p, List<Cliente> lc,Bandeja b, Horno h,int ancho, int alto) {        
        this.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(ancho, alto);
        this.setTitle("Ej de sincroización de una bandeja de pan de un supermercado");
        this.setLocationRelativeTo(null);
        panel=new PanelPantalla(this);
        this.setContentPane(panel);
        this.listaClientes=lc;
        this.panadera=p;
        this.bandeja=b;
        this.horno=h;
    }
    
   
}//:~)