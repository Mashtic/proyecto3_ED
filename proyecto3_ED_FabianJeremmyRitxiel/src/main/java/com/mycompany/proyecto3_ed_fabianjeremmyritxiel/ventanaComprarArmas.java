/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.proyecto3_ed_fabianjeremmyritxiel;

/**
 *
 * @author Llermy
 */
public class ventanaComprarArmas extends javax.swing.JFrame {

    VentanaJugador tempVent;
    
    public ventanaComprarArmas(VentanaJugador tempVent01) {
        initComponents();
        
        tempVent = tempVent01;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        botonCañon = new javax.swing.JButton();
        botonCañonM = new javax.swing.JButton();
        botonCañonBB = new javax.swing.JButton();
        botonBomba = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Comprar armas.");

        botonCañon.setText("Cañon");
        botonCañon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCañonActionPerformed(evt);
            }
        });

        botonCañonM.setText("Cañon M");
        botonCañonM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCañonMActionPerformed(evt);
            }
        });

        botonCañonBB.setText("Cañon BB");
        botonCañonBB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCañonBBActionPerformed(evt);
            }
        });

        botonBomba.setText("Bomba");
        botonBomba.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBombaActionPerformed(evt);
            }
        });

        jLabel2.setText("500kg");

        jLabel3.setText("1000kg");

        jLabel4.setText("2000kg");

        jLabel5.setText("5000kg");

        jLabel6.setText("El precio es en kg de hierro.");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(178, 178, 178))
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(botonCañon)
                .addGap(35, 35, 35)
                .addComponent(botonCañonM)
                .addGap(51, 51, 51)
                .addComponent(botonBomba)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addComponent(botonCañonBB)
                .addGap(67, 67, 67))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(jLabel2)
                        .addGap(76, 76, 76)
                        .addComponent(jLabel3)
                        .addGap(93, 93, 93)
                        .addComponent(jLabel4)
                        .addGap(76, 76, 76)
                        .addComponent(jLabel5))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(191, 191, 191)
                        .addComponent(jLabel6)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonCañon, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonCañonM, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonCañonBB, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonBomba, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonCañonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCañonActionPerformed
        // TODO add your handling code here:
        if (tempVent.cantHierro >= 500){
            tempVent.cantCanon++;
            tempVent.cantHierro -= 500;
            tempVent.setearLabels();
        }
    }//GEN-LAST:event_botonCañonActionPerformed

    private void botonCañonMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCañonMActionPerformed
        // TODO add your handling code here:
        if (tempVent.cantHierro >= 1000){
            tempVent.cantCanonM++;
            tempVent.cantHierro -= 1000;
            tempVent.setearLabels();
        }
    }//GEN-LAST:event_botonCañonMActionPerformed

    private void botonCañonBBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCañonBBActionPerformed
        // TODO add your handling code here:
        if (tempVent.cantHierro >= 5000){
            tempVent.cantCanonBB++;
            tempVent.cantHierro -= 5000;
            tempVent.setearLabels();
        }
    }//GEN-LAST:event_botonCañonBBActionPerformed

    private void botonBombaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBombaActionPerformed
        // TODO add your handling code here:
        if (tempVent.cantHierro >= 2000){
            tempVent.cantBomba++;
            tempVent.cantHierro -= 2000;
            tempVent.setearLabels();
        }
    }//GEN-LAST:event_botonBombaActionPerformed

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
            java.util.logging.Logger.getLogger(ventanaComprarArmas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ventanaComprarArmas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ventanaComprarArmas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ventanaComprarArmas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ventanaComprarArmas(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonBomba;
    private javax.swing.JButton botonCañon;
    private javax.swing.JButton botonCañonBB;
    private javax.swing.JButton botonCañonM;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    // End of variables declaration//GEN-END:variables
}
