/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.io.IOException;

/**
 *
 * @author Profesor
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, InterruptedException {
        // TODO code application logic here
       Runtime rr=Runtime.getRuntime();        
       //rr.exec("F:\\Archivos de programa\\Google\\Chrome\\Application\\chrome.exe");
       Process p=rr.exec(new String[]{"cmd", "/k"," dir"});
       p.waitFor();
       
               
       
    }
}
