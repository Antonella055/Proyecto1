/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package interfaces;

import java.io.FileNotFoundException;

import java.util.logging.Level;
import java.util.logging.Logger;
import proyecto1.GestordeArchivo;

/**
 *
 * @author Antonella
 */
public class  CargarArchivo extends javax.swing.JFrame {

    /**
     * Creates new form MenuPrincipal
     */
    public CargarArchivo() {
        initComponents();
        
       setLocationRelativeTo(null);
       CargaFile.setVisible(true);
    }
         
    public void accionBotonCargarArchivo(CargarArchivo carga) throws FileNotFoundException{
       
        GestordeArchivo gestor = new GestordeArchivo();
        gestor.ArchivoSeleccionado();
        
        MenuPrincipal menu= new MenuPrincipal();
        menu.setVisible(true);
       
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        CargaFile = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        CargaFile.setBackground(new java.awt.Color(0, 102, 51));
        CargaFile.setForeground(new java.awt.Color(204, 255, 204));
        CargaFile.setText("Cargar Archivo");
        CargaFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CargaFileActionPerformed(evt);
            }
        });

        jLabel1.setText("Bienvenido, para empezar por favor escoja el archivo a utilizar ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(CargaFile, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1))
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(CargaFile))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CargaFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CargaFileActionPerformed
        try {
            // TODO add your handling code here:
            accionBotonCargarArchivo(this);
            dispose();
                    } catch (FileNotFoundException ex) {
            Logger.getLogger(CargarArchivo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_CargaFileActionPerformed

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
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MenuPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CargaFile;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
