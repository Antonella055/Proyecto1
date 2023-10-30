/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package interfaces;

import Grafo.ConstructordeGrafoD;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.List;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JPanel;

import javax.swing.table.DefaultTableModel;
import proyecto1.GestordeArchivo;


/**
 *
 * @author Antonella
 */
public class VisualGrafo extends javax.swing.JFrame {
        private ConstructordeGrafoD grafo;
        private String matrizString;
        
       
    /**
     * Creates new form VisualGrafo
     */
    public VisualGrafo() {
        initComponents();
        InformacionMtriz.setVisible(false);
        
      
            InformacionUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                InformacionUserActionPerformed(evt);
            }
        });
    }
        

    
    
     public void componentesVent(){ 
        PanelGrafo= new JPanel();
        
        
        getContentPane().add(PanelGrafo,BorderLayout.CENTER);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
    }
    public JPanel getPanelGrafo(){
        return PanelGrafo;
    }

   
  
   

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        InformacionUser = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        PanelGrafo = new javax.swing.JPanel();
        Volver = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        matrizBtton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        InformacionMtriz = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(51, 51, 51));

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        InformacionUser.setBackground(new java.awt.Color(102, 255, 204));
        InformacionUser.setForeground(new java.awt.Color(0, 0, 0));
        InformacionUser.setText("Informacion de Usuario");
        InformacionUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InformacionUserActionPerformed(evt);
            }
        });

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        javax.swing.GroupLayout PanelGrafoLayout = new javax.swing.GroupLayout(PanelGrafo);
        PanelGrafo.setLayout(PanelGrafoLayout);
        PanelGrafoLayout.setHorizontalGroup(
            PanelGrafoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 807, Short.MAX_VALUE)
        );
        PanelGrafoLayout.setVerticalGroup(
            PanelGrafoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        Volver.setText("Volver");
        Volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VolverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 45, Short.MAX_VALUE)
        );

        matrizBtton.setBackground(new java.awt.Color(102, 255, 204));
        matrizBtton.setForeground(new java.awt.Color(0, 0, 0));
        matrizBtton.setText("Matriz");
        matrizBtton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                matrizBttonActionPerformed(evt);
            }
        });

        InformacionMtriz.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(InformacionMtriz);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PanelGrafo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 422, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(332, 332, 332)
                        .addComponent(Volver))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(matrizBtton, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(InformacionUser, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelGrafo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(88, 88, 88)
                .addComponent(matrizBtton, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(InformacionUser, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Volver)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
        
    private void InformacionUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InformacionUserActionPerformed
        // TODO add your handling code here:
        GestordeArchivo gestor= new GestordeArchivo();
        Map<String, List<String>> relaciones = gestor. obtenerRelaciones(); //Obtener las relaciones
        List<String> usuarios = gestor.obtenerUsuarios(relaciones); //Obtener la lista de usuarios
        
        DefaultTableModel modelo= new DefaultTableModel();
        modelo.addColumn("Usuarios");
        modelo.addColumn("Relaciones");
        
        for (String usuario:usuarios){
            List<String> Lrelaciones= relaciones.get(usuario);
            StringBuilder relacionesStr= new StringBuilder();
            for (String relacion: Lrelaciones){
                relacionesStr.append(relacion).append(",");
            }
            if (relacionesStr.length()>0){
                relacionesStr.delete(relacionesStr.length()-2, relacionesStr.length());
            }
            Object[] data={usuario,relacionesStr.toString()};
            modelo.addRow(data);
        }
        InformacionMtriz.setVisible(true);
        InformacionMtriz.setModel(modelo);
    }//GEN-LAST:event_InformacionUserActionPerformed

    private void VolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VolverActionPerformed
        // TODO add your handling code here:
         this.setVisible(false);
    }//GEN-LAST:event_VolverActionPerformed

    private void matrizBttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_matrizBttonActionPerformed
//         TODO add your handling code here:
         GestordeArchivo gestor= new GestordeArchivo();
        Map<String, List<String>> relaciones = gestor. obtenerRelaciones(); //Obtener las relaciones
        List<String> usuarios = gestor.obtenerUsuarios(relaciones); //Obtener la lista de usuarios
        int[][] matrizAdyacencia = gestor.crearmatrizAdyacencia(usuarios, relaciones); //instanciar al metodo donde se crea la matriz
        
       DefaultTableModel modelo=  new DefaultTableModel(); 
        for (String usuario : usuarios) { //Asignar las columnas de usuarios
        modelo.addColumn(usuario);
    }
       for (int i = 0; i < matrizAdyacencia.length; i++) { //columnas con los valores de la matriz 
        Object[] rowData = new Object[matrizAdyacencia[i].length + 1];
        rowData[0] = usuarios.get(i); // Nombre de fila
        for (int j = 0; j < matrizAdyacencia[i].length; j++) {
            rowData[j + 1] = matrizAdyacencia[i][j];
        }
        modelo.addRow(rowData);
    
        }
       InformacionMtriz.setVisible(true);
       InformacionMtriz.setModel(modelo);
    }//GEN-LAST:event_matrizBttonActionPerformed

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
            java.util.logging.Logger.getLogger(VisualGrafo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VisualGrafo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VisualGrafo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VisualGrafo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new VisualGrafo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable InformacionMtriz;
    private javax.swing.JButton InformacionUser;
    private javax.swing.JPanel PanelGrafo;
    private javax.swing.JButton Volver;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton matrizBtton;
    // End of variables declaration//GEN-END:variables
}
