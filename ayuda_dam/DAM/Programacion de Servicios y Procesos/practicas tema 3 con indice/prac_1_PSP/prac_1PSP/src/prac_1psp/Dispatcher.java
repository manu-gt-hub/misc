
package prac_1psp;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import static prac_1psp.Main.v;

public class Dispatcher extends Thread{

    BufferedReader br;
    DataOutputStream bw;
    Socket skCliente;
    Ventana v;

    BufferedReader bufferEntrada;
    DataOutputStream bufferSalida;
    String valor="";

    float num1=0;
    float num2=0;
    String res="";

    Dispatcher(Socket cliente, Ventana v) {
        this.v=v;
        this.skCliente=cliente;
        
 
    }

    @Override
    public void run() {
        v.escribir("cliente aceptado");
              
              
               
               try
               {
                   //asigno a un buffer de entrada el flujo de datos de entrada
                    //del socket cliente sobre el que se volcaran los datos
                    //que me quiera enviar
                    bufferEntrada = new BufferedReader(new InputStreamReader(skCliente.getInputStream()));//

                    //buffer de salida hacia el socket cliente sobre el que
                    //se volcaran los datos que se envien al mismo
                    bufferSalida = new DataOutputStream(skCliente.getOutputStream());

                    //leo los datos de entrada del cliente
                    String datosEntrada=bufferEntrada.readLine();
                    v.escribir("Operacion solicitada: "+datosEntrada.substring(0,datosEntrada.indexOf('$')));


                    /*
                     cadena de prueba
                     String datosEntrada="40/2=\n";
                     */
                     valor="";

                     num1=0;
                     num2=0;
                     int ope=0;

                     res="";

                     //proceso los caracteres uno a uno
                     //los campos en la cadena recibida y enviada 
                     //estan delimitados por '$' y el fin de cadena por '\n'
                   for (int i = 0; i < datosEntrada.length(); i++) 
                    {
                       //if(datosEntrada.charAt(i)=='$' || datosEntrada.charAt(i)==')')
                       if(datosEntrada.charAt(i)=='$')
                       {
                           bufferSalida.writeBytes(res);
                           v.escribir("Respuesta enviada: "+res);
                           num1=0;
                           num2=0;
                           valor="";
                       }
                       else
                       {
                           char c=datosEntrada.charAt(i);
                           if(c=='/' || c=='*' || c=='+' || c=='-' || c=='s'  || c=='c')
                           {

                                 if(c!='s' && c!='c')
                                 {
                                    valor=valor.trim();
                                    num1=Float.parseFloat(valor);
                                    valor="";
                                 }
                                 else
                                 {
                                     valor="";
                                 }
                                 
                                 switch(c)
                                 {
                                     case '+':
                                         ope=1;
                                     break;

                                     case '-':
                                          ope=2;
                                     break;

                                     case '/':
                                          ope=3;
                                     break;

                                     case '*':
                                          ope=4;
                                     break;
                                         
                                     case 's':
                                          ope=5;
                                     break;
                                         
                                     case 'c':
                                          ope=6;
                                     break;

                                 }

                           }
                           else
                           {
                               if(c=='=')
                               {

                                     valor=valor.trim();
                                     num2=Float.parseFloat(valor);

                                     switch(ope)
                                     {
                                         case 1:
                                             res=String.valueOf(num1+num2);
                                         break;

                                         case 2:
                                              res=String.valueOf(num1-num2);
                                         break;

                                         case 3:
                                              res=String.valueOf(num1/num2);
                                         break;

                                         case 4:
                                              res=String.valueOf(num1*num2);
                                         break;
                                             
                                         case 5:
                                              res=String.valueOf(Math.sin(num2));
                                         break;
                                             
                                         case 6:
                                              res=String.valueOf(Math.cos(num2));
                                         break;
                                     }
                               }
                               
                               else
                               {
                                   if(datosEntrada.charAt(i)!=')' && datosEntrada.charAt(i)!='(')
                                   {
                                       valor+=datosEntrada.charAt(i);
                                   }
                               }
                           }

                       }


                   }
               }catch(Exception ex)
               {
                    try {
                        bufferSalida.writeBytes(res);
                        skCliente.close();
                        v.escribir("Error");
                        v.escribir("conexion cerrada");
                        num1=0;
                        num2=0;
                        valor="";
                    } catch (IOException ex1) {
                        Logger.getLogger(Dispatcher.class.getName()).log(Level.SEVERE, null, ex1);
                    }
                    
               }
               finally
               {
                    try {
                        skCliente.close();
                    } catch (IOException ex) {
                        Logger.getLogger(Dispatcher.class.getName()).log(Level.SEVERE, null, ex);
                    }
                   v.escribir("conexion cerrada");
               }
               
               //cierro la conexion con el cliente
              
    }
    
}
