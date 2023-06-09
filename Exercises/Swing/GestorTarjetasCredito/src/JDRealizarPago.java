
import javax.swing.JOptionPane;
import modelo.Movimiento;
import modelo.TarjetaCredito;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */

/**
 *
 * @author josemaria
 */
public class JDRealizarPago extends javax.swing.JDialog {
    private TarjetaCredito tarjeta;
    private boolean pagoRealizado = false;
    
    public boolean isPagoRealizado() {
        return pagoRealizado;
    }
    
    /**
     * Creates new form JDRealizarPago
     */
    public JDRealizarPago(java.awt.Dialog parent, boolean modal, TarjetaCredito tarjeta) {
        super(parent, modal);
        initComponents();
        this.tarjeta = tarjeta;
        jlLimite.setText(String.valueOf(tarjeta.getLimite()));
        actualizarSaldoDisponible(tarjeta.getLimite()-tarjeta.gastado());
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jlTitulo = new javax.swing.JLabel();
        jlConcepto = new javax.swing.JLabel();
        jtfConcepto = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jtfCantidad = new javax.swing.JTextField();
        jlLimiteTitulo = new javax.swing.JLabel();
        jlLimite = new javax.swing.JLabel();
        jlSaldoDisponiblesTitulo = new javax.swing.JLabel();
        jlSaldoDisponibles = new javax.swing.JLabel();
        jbAñadir = new javax.swing.JButton();
        jbSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jlTitulo.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jlTitulo.setText("REALIZAR PAGO");

        jlConcepto.setText("Concepto:");

        jLabel1.setText("Cantidad:");

        jlLimiteTitulo.setText("Limite:");

        jlLimite.setText(" ");

        jlSaldoDisponiblesTitulo.setText("Saldo Disponibles:");

        jlSaldoDisponibles.setText(" ");

        jbAñadir.setText("Añadir");
        jbAñadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAñadirActionPerformed(evt);
            }
        });

        jbSalir.setText("Salir");
        jbSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(127, 127, 127)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtfCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jlTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jtfConcepto)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jlLimiteTitulo)
                                        .addComponent(jlConcepto))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jlLimite)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jbAñadir)
                                .addGap(70, 70, 70)
                                .addComponent(jbSalir))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jlSaldoDisponiblesTitulo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jlSaldoDisponibles)))))
                .addContainerGap(109, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jlTitulo)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlLimiteTitulo)
                    .addComponent(jlLimite))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlSaldoDisponiblesTitulo)
                    .addComponent(jlSaldoDisponibles))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addComponent(jlConcepto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfConcepto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbAñadir)
                    .addComponent(jbSalir))
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalirActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_jbSalirActionPerformed

    private void jbAñadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAñadirActionPerformed
        String concepto = jtfConcepto.getText();
        String userCantidadString = jtfCantidad.getText();
        if (!userCantidadString.matches("\\d+")) {
            JOptionPane.showMessageDialog(this, "La cantidad debe de ser númerica", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (Double.parseDouble(userCantidadString) > this.tarjeta.getLimite()-this.tarjeta.gastado()) {
            JOptionPane.showMessageDialog(this, "La cantidad insertada es superior al Saldo Disponible", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (Double.parseDouble(userCantidadString) <= 0){
            JOptionPane.showMessageDialog(this, "La cantidad no puede ser negativa o 0", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            if (tarjeta.pagar(Double.parseDouble(userCantidadString), concepto)) {
                actualizarSaldoDisponible(tarjeta.getLimite()-tarjeta.gastado());
                JOptionPane.showMessageDialog(this, "Pago Realizado con Existo", "Exito", JOptionPane.INFORMATION_MESSAGE);
                pagoRealizado = true;
            } else {
                JOptionPane.showMessageDialog(this, "No se ha podido añadir el pago", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_jbAñadirActionPerformed

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
            java.util.logging.Logger.getLogger(JDRealizarPago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDRealizarPago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDRealizarPago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDRealizarPago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JDRealizarPago dialog = new JDRealizarPago(new javax.swing.JDialog(), true,null);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    
    
    private void actualizarSaldoDisponible(double saldoDisponible) {
        jlSaldoDisponibles.setText(String.valueOf(saldoDisponible));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton jbAñadir;
    private javax.swing.JButton jbSalir;
    private javax.swing.JLabel jlConcepto;
    private javax.swing.JLabel jlLimite;
    private javax.swing.JLabel jlLimiteTitulo;
    private javax.swing.JLabel jlSaldoDisponibles;
    private javax.swing.JLabel jlSaldoDisponiblesTitulo;
    private javax.swing.JLabel jlTitulo;
    private javax.swing.JTextField jtfCantidad;
    private javax.swing.JTextField jtfConcepto;
    // End of variables declaration//GEN-END:variables
}
