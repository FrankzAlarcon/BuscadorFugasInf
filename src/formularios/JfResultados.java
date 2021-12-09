/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formularios;

import javax.swing.JLabel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 * @author dell
 */
public class JfResultados extends javax.swing.JFrame {

    DefaultTableModel modelo;
    public JfResultados() {
        initComponents();
        this.setLocationRelativeTo(this);
        modelo= new DefaultTableModel();
        modelo.addColumn("Algoritmo");
        modelo.addColumn("Tiempo Ejecución(ms)");
        modelo.addColumn("Cantidad de Ocurrencias encontradas");  
        //Reflejamos el modelo en la tabla del jframe
        this.jTResultados.setModel(modelo);
        
        //Centrar el contenido de las celdas de la columna 1
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        jTResultados.getColumnModel().getColumn(1).setCellRenderer( centerRenderer );
    }
    
    public void agregarDatos(String nomAlgortimo,long tiempoE, String numVeces){
        String [] Datos= new String[4];
        Datos[0] = nomAlgortimo;
        Datos[1] = ""+tiempoE;
        Datos[2] = numVeces;
        this.modelo.addRow(Datos); //Anadimos los datos
        
        jTResultados.getColumnModel().getColumn(1).setPreferredWidth(150); //Establecemos en 150 el ancho de la columna 1
        jTResultados.getColumnModel().getColumn(2).setPreferredWidth(300); //Establecemos en 300 el ancho de la columna 2
        this.jTResultados.setModel(modelo);
        jTResultados.setRowHeight(30); //Establecemos la altura de las filas en 30
    }
    public void setValoresFB(String resultados){
        txaFB.setText(resultados);
    }
    public void setValoresKMP(String resultados){
        txaKMP.setText(resultados);
    }
    public void setValoresBM(String resultados){
        txaBM.setText(resultados);
    }
        

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTResultados = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txaFB = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        txaBM = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        txaKMP = new javax.swing.JTextArea();
        lblFB = new javax.swing.JLabel();
        lblKMP = new javax.swing.JLabel();
        lblBM = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTResultados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTResultados);

        jLabel1.setFont(new java.awt.Font("Tekton Pro Ext", 1, 24)); // NOI18N
        jLabel1.setText("RESULTADOS");

        txaFB.setColumns(20);
        txaFB.setFont(new java.awt.Font("Monospaced", 0, 10)); // NOI18N
        txaFB.setRows(5);
        jScrollPane2.setViewportView(txaFB);

        txaBM.setColumns(20);
        txaBM.setFont(new java.awt.Font("Monospaced", 0, 10)); // NOI18N
        txaBM.setRows(5);
        jScrollPane3.setViewportView(txaBM);

        txaKMP.setColumns(20);
        txaKMP.setFont(new java.awt.Font("Monospaced", 0, 10)); // NOI18N
        txaKMP.setRows(5);
        jScrollPane4.setViewportView(txaKMP);

        lblFB.setText("Fuerza Bruta");

        lblKMP.setText("KMP");

        lblBM.setText("BM");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(232, 232, 232))
            .addGroup(layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addComponent(lblFB)
                .addGap(165, 165, 165)
                .addComponent(lblKMP)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblBM)
                .addGap(116, 116, 116))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 696, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFB)
                    .addComponent(lblKMP)
                    .addComponent(lblBM))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
                    .addComponent(jScrollPane3))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JfResultados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JfResultados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JfResultados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JfResultados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JfResultados().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTResultados;
    private javax.swing.JLabel lblBM;
    private javax.swing.JLabel lblFB;
    private javax.swing.JLabel lblKMP;
    private javax.swing.JTextArea txaBM;
    private javax.swing.JTextArea txaFB;
    private javax.swing.JTextArea txaKMP;
    // End of variables declaration//GEN-END:variables
}
