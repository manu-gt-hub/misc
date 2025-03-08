package data;

import java.util.Map;
import java.util.Set;

/**
 * ProcessBuider vale xa muchas cosas, como x ejemplo, acceder a las variables del sistema
 * En este ejemplo visualizamos las existentes para la sesión
 * 
 * @author Javier
 */
public class Main3 {
    public static void main(String[] args) {
        ProcessBuilder pb = new ProcessBuilder();
        Map<String,String> env = pb.environment();
        
        //Visualizo el conjunto de claves
        Set<String> keys = env.keySet();
        if (keys != null) {
         for (String key : keys) {
          System.out.println(key+":"+env.get(key));
         }
        }
    }
}
