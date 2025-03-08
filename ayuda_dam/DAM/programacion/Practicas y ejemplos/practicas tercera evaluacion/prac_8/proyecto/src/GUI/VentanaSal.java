/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import prac_8.*;
import javax.swing.JFrame;

/** *
 * @author Manu
 */
public class VentanaSal extends javax.swing.JFrame {

    String cad="",color;
    int dimension;
    public VentanaSal(String c,int dim) {
        initComponents();
        color=c;
        this.dimension=dim;
        this.setTitle("");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        
        
        
        
    }
        @SuppressWarnings("unchecked")
        @Override
        public void paint(Graphics g) {
        super.paint(g);
        switch(color)
        {
            case "verde":
               g.setColor(Color.green);
            break;
            case "rojo":
               g.setColor(Color.red);
            break;
           case "azul":
               g.setColor(Color.blue);
            break;
            case "amarillo":
               g.setColor(Color.yellow);
            break;
        }
        
        int n=0,linea=0,total=0;

        for(total=0;total<dimension+(dimension-1);total++)
        {
         for(linea=0;linea<(dimension*2);linea++)
         {
             if(dimension-n==linea||dimension+n==linea)
             {
                 g.drawString("*", (total*10)+20, (linea*10)+40);

             }
             else
             {
                 if(linea>(dimension-n)&& linea<(dimension+n))
                 {
                    g.drawString("*", (total*10)+20, (linea*10)+40);
                 }
                 else
                 {
                    g.drawString(" ", (total*10)+20, (linea*10)+40);
                 }
             }
                 
         }

         if(total<dimension-1)
         {
             n++;
         }
         else
         {
             n--;
         }
        }
        total=(total*10)+40;
        linea=(linea*10)+60;
        this.setSize(total,linea);
    } 
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 245, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 261, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
