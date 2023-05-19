/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package interfaz;

import javax.swing.JOptionPane;
import modelo.Movimiento;


/**
 *
 * @author josemaria
 */
public class JDRealizarPago extends javax.swing.JDialog {
    private static final int NUMERO_MOVIMINENTOS_MAXIMO = 50;
    
    private Movimiento nuevoMovimiento;
    private boolean isMovimientoCreado;
    private int numeroDeMovimientos;
    private double saldoDisponible;

    /**
     * Creates new form JDRealizarPago
     */
    public JDRealizarPago(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        isMovimientoCreado = false;
        jlSaldoDisponibles.setText(String.valueOf(saldoDisponible));
    }

    public void setSaldoDisponible (double saldoDisponible) {
        this.saldoDisponible = saldoDisponible;
        jlSaldoDisponibles.setText(String.valueOf(saldoDisponible));
    }
    public void setNumeroMovimientosDeTarjeta (int numeroDeMovimientos) {
        this.numeroDeMovimientos = numeroDeMovimientos;
    }
    public Movimiento getMovimiento () {
        return nuevoMovimiento;
    }
    public boolean isMovimientoCreado() {
        return isMovimientoCreado;
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
        jlTituloSaldoDisponibles = new javax.swing.JLabel();
        jlSaldoDisponibles = new javax.swing.JLabel();
        jtfConcepto = new javax.swing.JTextField();
        jlTituloConcepto = new javax.swing.JLabel();
        jlCantidad = new javax.swing.JLabel();
        jbAgregar = new javax.swing.JButton();
        jbSalir = new javax.swing.JButton();
        jtfCantidad = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jlTitulo.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jlTitulo.setText("Realizar Pago");

        jlTituloSaldoDisponibles.setText("Saldo Disponibles:");

        jlSaldoDisponibles.setText(" ");

        jlTituloConcepto.setText("Concepto:");

        jlCantidad.setText("Cantidad:");

        jbAgregar.setText("Agregar");
        jbAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAgregarActionPerformed(evt);
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
                        .addGap(144, 144, 144)
                        .addComponent(jlTitulo))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(122, 122, 122)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlTituloConcepto)
                            .addComponent(jtfConcepto, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlCantidad)
                            .addComponent(jtfCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(101, 101, 101)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jbAgregar)
                                .addGap(52, 52, 52)
                                .addComponent(jbSalir))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jlTituloSaldoDisponibles)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jlSaldoDisponibles)))))
                .addContainerGap(101, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jlTitulo)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlTituloSaldoDisponibles)
                    .addComponent(jlSaldoDisponibles))
                .addGap(18, 18, 18)
                .addComponent(jlTituloConcepto)
                .addGap(1, 1, 1)
                .addComponent(jtfConcepto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jlCantidad)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbAgregar)
                    .addComponent(jbSalir))
                .addContainerGap(49, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalirActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_jbSalirActionPerformed

    private void jbAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAgregarActionPerformed
        boolean validConcepto = true;
        boolean validCantidad = true;
        boolean validCantidadMovimientos = true;
        String concepto = jtfConcepto.getText();
        String cantidad = jtfCantidad.getText().replace(",", ".");
        
        if (numeroDeMovimientos+1 > NUMERO_MOVIMINENTOS_MAXIMO) {
            JOptionPane.showMessageDialog(this, "Esta tarjeta ya posee "+NUMERO_MOVIMINENTOS_MAXIMO,"Advertencia", JOptionPane.WARNING_MESSAGE);
            validCantidadMovimientos = false;
        } else if (concepto.isBlank() || concepto.length() > 50) {
            validConcepto = false;
            JOptionPane.showMessageDialog(this, "El concepto no puede estar vacío o contener mas de 50 caracteres","Advertencia", JOptionPane.WARNING_MESSAGE);
        } else if (!cantidad.matches("^\\d+.{0,1}\\d*$")) {
            validCantidad = false;
            JOptionPane.showMessageDialog(this, "El valor de la Cantidad debe de ser numérico","Advertencia", JOptionPane.WARNING_MESSAGE);
        } else if (Double.parseDouble(cantidad) <= 0) {
            validCantidad = false;
            JOptionPane.showMessageDialog(this, "La cantidad no puede ser negativa o 0","Advertencia", JOptionPane.WARNING_MESSAGE);    
        } else if (Double.parseDouble(cantidad) > saldoDisponible) {
            validCantidad = false;
            JOptionPane.showMessageDialog(this, "La cantidad ingresada es superior al Saldo Disponibles","Advertencia", JOptionPane.WARNING_MESSAGE);
        }
        
        if (validConcepto && validCantidad && validCantidadMovimientos) {
            nuevoMovimiento = new Movimiento(Double.parseDouble(cantidad), concepto);
            isMovimientoCreado = true;
            this.setVisible(false);
        }
    }//GEN-LAST:event_jbAgregarActionPerformed

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
                JDRealizarPago dialog = new JDRealizarPago(new javax.swing.JDialog(), true);
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jbAgregar;
    private javax.swing.JButton jbSalir;
    private javax.swing.JLabel jlCantidad;
    private javax.swing.JLabel jlSaldoDisponibles;
    private javax.swing.JLabel jlTitulo;
    private javax.swing.JLabel jlTituloConcepto;
    private javax.swing.JLabel jlTituloSaldoDisponibles;
    private javax.swing.JTextField jtfCantidad;
    private javax.swing.JTextField jtfConcepto;
    // End of variables declaration//GEN-END:variables

    
}