/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EntGrafico;

import Codigo.*;
import javax.swing.JLabel;

/**
 *
 * @author Tostadora
 */
public class CRuta extends javax.swing.JFrame {

    /**
     * Creates new form CRuta
     */
    Archivos arch = new Archivos();
    public CRuta() {
       
        initComponents();
    }
    
    private String Ruta;
    private Ruta R;
    private Bus[] Buses;
    private Parada[] Pa;
    private Horario[] Ho;
    private Tarifa[] Ta;
    
    public String getRuta() {
        return Ruta;
    }

    public void setRuta(String Ruta) {
        LbRuta.setText(Ruta);
        this.Ruta = Ruta;
         arch.crearCarpeta("Ruta",Ruta);
        arch.crearCarpeta("Ruta\\"+Ruta,"Bus");
        arch.crearCarpeta("Ruta\\"+Ruta,"Parada");
        arch.crearCarpeta("Ruta\\"+Ruta,"Horario");
        arch.crearCarpeta("Ruta\\"+Ruta,"Tarifa");
    }

    public Ruta getR() {
        return R;
    }

    public void setR(Ruta R) {
        this.R = R;
    }

    public Bus[] getBuses() {
        return Buses;
    }

    public void setBuses(Bus[] Buses) {
        this.Buses = Buses;
    }

    public Horario[] getHo() {
        return Ho;
    }

    public void setHo(Horario[] Ho) {
        this.Ho = Ho;
    }

    public Tarifa[] getTa() {
        return Ta;
    }

    public void setTa(Tarifa[] Ta) {
        this.Ta = Ta;
    }

    public JLabel getLbRuta() {
        return LbRuta;
    }

    public void setLbRuta(JLabel LbRuta) {
        this.LbRuta = LbRuta;
    }

    public Parada[] getPa() {
        return Pa;
    }

    public void setPa(Parada[] Pa) {
        this.Pa = Pa;
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        LbRuta = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(295, 340));
        getContentPane().setLayout(null);

        jButton1.setText("CREAR BUS");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(30, 40, 180, 32);

        jButton2.setText("CREAR PARADA");
        getContentPane().add(jButton2);
        jButton2.setBounds(30, 80, 180, 32);

        jButton3.setText("GENERAR HORARIO");
        getContentPane().add(jButton3);
        jButton3.setBounds(30, 130, 180, 32);

        jButton4.setText("GENERAR TARIFA");
        getContentPane().add(jButton4);
        jButton4.setBounds(30, 180, 180, 32);

        jButton5.setText("FINALIZAR");
        getContentPane().add(jButton5);
        jButton5.setBounds(140, 230, 90, 32);

        LbRuta.setText("Nombre RUta");
        getContentPane().add(LbRuta);
        LbRuta.setBounds(10, 0, 230, 40);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        CBus b = new CBus();
        b.setRuta(Ruta);
        b.show();
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(CRuta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CRuta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CRuta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CRuta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CRuta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LbRuta;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    // End of variables declaration//GEN-END:variables
}
