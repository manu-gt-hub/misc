
package GUI;

public class Balance extends javax.swing.JFrame {

    int[] ventas;
    int[] entradas;
    public Balance(int[] ent,int[]vent) {
        //this.setResizable(false);
        ventas=vent;
        entradas=ent;
        String texto="";
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("Balance del dia");
        this.jTextArea1.setEditable(false);
        texto+="Resultados: \n\nVenta de entradas:\n";
        this.jTextArea1.setText(texto);
        int ac=0;
        for (int i = 0; i < entradas.length ; i++) {
            texto+="  sala: "+(i+1)+" -> "+entradas[i]+" entradas\n";
            this.jTextArea1.setText(texto);
            ac+=entradas[i];
        }
        texto+="  total: "+ac+"\n\n";
        this.jTextArea1.setText(texto);
        ac=0;
        texto+="Ganancias: \n";
        this.jTextArea1.setText(texto);
        for (int i = 0; i < ventas.length; i++) {
            texto+="  sala: "+(i+1)+" -> "+ventas[i]+" euros\n";
            this.jTextArea1.setText(texto);
            ac+=ventas[i];
        }
        texto+="  total: "+ac+"\n";
        this.jTextArea1.setText(texto);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
