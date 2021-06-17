/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EntGrafico;

import Codigo.*;

/**
 *
 * @author Tostadora
 */
public class Inicio extends javax.swing.JFrame {

    /**
     * Creates new form Inicio
     */
    
    private PilaRuta pilaRuta = new PilaRuta();
    private PilaContratacion pilaContrato = new PilaContratacion();
    
    public Inicio() {
        initComponents();
        this.setSize(364, 297);
    }
    
    public void Base(PilaRuta pilaRuta,PilaContratacion pilaContrato){
    
        this.pilaContrato = pilaContrato;
        this.pilaRuta = pilaRuta;
    
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PRS = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        USR = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(193, 297));
        getContentPane().setLayout(null);

        PRS.setText("ENTRAR");
        PRS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PRSActionPerformed(evt);
            }
        });
        getContentPane().add(PRS);
        PRS.setBounds(130, 210, 90, 40);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("ADMINISTRACIÓN DE PERSONAL");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(30, 150, 310, 50);

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setText("USUARIO");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(130, 20, 130, 50);

        USR.setText("ENTRAR");
        USR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                USRActionPerformed(evt);
            }
        });
        getContentPane().add(USR);
        USR.setBounds(130, 90, 90, 40);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void PRSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PRSActionPerformed
        // TODO add your handling code here:
        Personal pr = new Personal();
        pr.setRuta(pilaRuta, pilaContrato);
        pr.show();
        this.dispose();
    }//GEN-LAST:event_PRSActionPerformed

    private void USRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_USRActionPerformed
        // TODO add your handling code here:
        CContrato cc = new CContrato();
        cc.Base(pilaContrato, pilaRuta);
        cc.show();
        this.dispose();
    }//GEN-LAST:event_USRActionPerformed

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
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inicio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton PRS;
    private javax.swing.JButton USR;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
