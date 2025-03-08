/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author profesor
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        LinkedList<String> l1;
        l1=new LinkedList();
        l1.add("Hola");
        l1.add("Adios");
        l1.add("Puppy");
        Collections.sort(l1);
        for (String s : l1) {
            System.out.println(""+s);
        }
        
        LinkedList<Integer> l2;
        l2=new LinkedList();
        l2.add(new Integer(1).intValue());
        l2.add(20);
        l2.add(5);
        Collections.sort(l2);
        for (int x : l2) {
            System.out.println(""+x);
        }
        
        LinkedList<Coche> l3;
        l3=new LinkedList();
        l3.add(new Coche("m-123",4,"SEAT","Leon"));
        l3.add(new Coche("a-123",4,"SEAT","Malaga"));
        l3.add(new Coche("a-123",4,"SEAT","Exeo"));
        l3.add(new Coche("b-123",4,"SEAT","Ibiza"));
        Collections.sort(l3);
        for (Coche x : l3) {
            System.out.println(""+x);
        }
        
        LinkedList<Animal> l4;
        l4=new LinkedList();
        l4.add(new Animal("Mamifero","Perro",4));
        l4.add(new Animal("Mamifero","Conejo",4));
        l4.add(new Animal("Reptil","serpiente"));
        //Collections.sort(l4,new Criterio2() );
        Collections.sort(l4,new Criterio1(false) );
        for (Animal x : l4) {
            System.out.println(""+x);
        }        
        
        int []aa={1,2,5,3,4,6,99,7};
        Arrays.sort(aa);
        for (int i = 0; i < aa.length; i++) {
            System.out.print(" "+aa[i]);
            
        }
        
    }
}


/**
 * Compara por especie y nombre
 * @author profesor
 */
class Criterio1 implements Comparator{

    boolean asc;

    public Criterio1(boolean asc) {
        this.asc = asc;
    }
    
    @Override
    public int compare(Object o1, Object o2) {
        Animal a1=(Animal)o1;
        Animal a2=(Animal)o2;
        if(a1.especie.compareToIgnoreCase(a2.especie)==0)
            if(asc)
                return  a1.nombre.compareToIgnoreCase(a2.nombre);
            else    
                return  -a1.nombre.compareToIgnoreCase(a2.nombre);
        if(asc)
            return a1.especie.compareToIgnoreCase(a2.especie);        
        else
            return -a1.especie.compareToIgnoreCase(a2.especie);        
        
    }
}

/**
 * Compara por patas y nombre
 * @author profesor
 */
class Criterio2 implements Comparator{

    @Override
    public int compare(Object o1, Object o2) {
        Animal a1=(Animal)o1;
        Animal a2=(Animal)o2;
        if(a1.patas==a2.patas)
           return  a1.nombre.compareToIgnoreCase(a2.nombre);
        return a1.patas-a2.patas;
    }
}