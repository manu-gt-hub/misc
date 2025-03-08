package data;

/**
 *
 * @author juanxxiii
 */
public class Cliente {



    private int numCliente;    
    private String nombre;
    private long teléfono;

    public Cliente(int numCliente, String nombre, long tlf) {
        this.numCliente = numCliente;
        this.teléfono=tlf;
        this.nombre = nombre;
    }

    /**
     * Ctor xa buscar clientes en el mapa
     * @param numCliente
     */
    public Cliente(int numCliente) {
        this.numCliente = numCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumCliente() {
        return numCliente;
    }

    public void setNumCliente(int numCliente) {
        this.numCliente = numCliente;
    }

    public long getTlf() {
        return teléfono;
    }

    public void setTlf(long tlf) {
        this.teléfono = tlf;
    }

    
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cliente other = (Cliente) obj;
        if (this.numCliente != other.numCliente) {
            return false;
        }
        return true;
    }


    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + this.numCliente;
        return hash;
    }

    @Override
    public String toString() {
        return "{" + "numCliente=" + numCliente + " nombre=" + nombre + " tel\u00e9fono=" + teléfono + '}';
    }

    //Comprueba si el txt recibido se puede convertir en numCli
    public static int validaNumCli(String txt) throws Exception{
        int numCli=-1;
        try{
            numCli=Integer.parseInt(txt);
        }catch(Exception e)
        {
               throw new Exception("Error, el campo numCLi debe ser un entero!!!");
        }
        if(numCli<1){
            throw new Exception("El campo de número de cliente debe ser un número entero positivo!!!!");
        }
        return numCli;
    }

}
