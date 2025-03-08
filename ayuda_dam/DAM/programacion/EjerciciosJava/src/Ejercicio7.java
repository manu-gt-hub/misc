/*
SENTENCIAS CASE
 */
public class Ejercicio7 {
    
    public static void main(String[] args) {
    //declaramos un primer valor a la variable 
    String nombre_persona = "Fernando";
    //se evalua la variable
    switch (nombre_persona)
    {
         //aqui se meten los cases con los que se va a comparar su valor
         case "Fernando":
            System.out.println(" la persona se llama Fernando");
         ;
         case "Manuel":
            System.out.println(" la persona se llama Manuel");
         ;
         default:
            System.out.println(" la persona tiene otro nombre");
         ;
    }
  }
    
}
