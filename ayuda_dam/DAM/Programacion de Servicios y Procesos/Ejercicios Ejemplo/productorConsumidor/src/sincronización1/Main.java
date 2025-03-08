/* 
 Ejemplo de sincronización entre hilos.
 Un Productor (de enteros) generará números que un Consumidor(de enteros) irá recogiendo.
 Se busca coordinar que no se capturen números cuando el almacén esté vacío ni 
 se produzca cuando esté lleno.
 En este caso el elemento a sincronizar/compartido, ya q varios hilos trabajan con él, 
 será un entero.
 En total se crearán y consumirán 10 enteros
  
 La solución se implementa mediante monitores 
 */

package sincronización1;

/**
 *
 * @author profesor
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EnteroCompartido h = new EnteroCompartido();
	Productor produceEnteros= new Productor(h);	
	Consumidor consumeEnteros = new Consumidor(h);
        produceEnteros.start();
	consumeEnteros.start();
    }

}
