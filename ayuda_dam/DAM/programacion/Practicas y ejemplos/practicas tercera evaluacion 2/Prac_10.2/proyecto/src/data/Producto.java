
package data;
/*clase que contendra productos y almacenara todos sus datos, incluidas las ventas*/
public class Producto {
    
    int codigo;
    int precio;
    int ventas=0;
    String nombre;
    public Producto() {
        
    }
    public Producto(int codigo, String nom,int p) {
        this.codigo = codigo;
        this.precio=p;
        this.nombre=nom;
        this.ventas=0;

    }
    public int getPrecio() {
        return precio;
    }
    public String getNombre() {
        return nombre;
    }
      public int getCodigo() {
        return codigo;
    }
    public void setPrecio(int x) {
        this.precio=x;
    }
   
    public void setCodigo(int x) {
        this.codigo=x;
    }
      public void setNombre(String x) {
        this.nombre=x;
    }
    public void setVentas(int x) {
        this.ventas=this.ventas+x;
    }
    @Override
    public String toString() {
        return "Codigo: " + codigo + "\n\n   Nombre: "+nombre+
                "\n   precio: " + precio + "\n   Ventas: " + 
                ventas + "\n   Ganancias: " + (ventas*precio) +"\n\n";
    }
  
}
