
import modelo.TarjetaCredito;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */

/**
 *
 * @author josemaria
 */
public class JDEliminarTarjeta extends javax.swing.JDialog {
    private ArrayList<TarjetaCredito> tarjetaCreditos;
    private boolean isElimiado = false;
    
    public boolean isEliminado() {
        return isElimiado;
    }
    
    /**
     * Creates new form JDEliminarTarjeta
     */
    public JDEliminarTarjeta(java.awt.Frame parent, boolean modal,ArrayList<TarjetaCredito> tarjetaCreditos) {
        super(parent, modal);
        initComponents();
        this.tarjetaCreditos = tarjetaCreditos;
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
        jlNIF = new javax.swing.JLabel();
        jtfNIF = new javax.swing.JTextField();
        jbElimiar = new javax.swing.JButton();
        jbSalir = new javax.swing.JButton();
        jlInformacion = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jlTitulo.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jlTitulo.setText("ELIMINAR TARJETA");

        jlNIF.setText("NIF:");

        jbElimiar.setText("Eliminar");
        jbElimiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbElimiarActionPerformed(evt);
            }
        });

        jbSalir.setText("Salir");
        jbSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalirActionPerformed(evt);
            }
        });

        jlInformacion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(117, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbElimiar)
                        .addGap(18, 18, 18)
                        .addComponent(jbSalir))
                    .addComponent(jlTitulo)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jlInformacion, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jlNIF)
                            .addGap(18, 18, 18)
                            .addComponent(jtfNIF, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(116, 116, 116))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jlTitulo)
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlNIF)
                    .addComponent(jtfNIF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(jlInformacion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbElimiar)
                    .addComponent(jbSalir))
                .addGap(60, 60, 60))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbElimiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbElimiarActionPerformed
        String nif = jtfNIF.getText().toUpperCase();
        if (!TarjetaCredito.validarNIF_NIE_CIF(nif)) {
            JOptionPane.showMessageDialog(this, "El NIF no es válido", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            int index = -1;
            boolean tarjetaEncontrada = false;
            for (int i = 0; i < tarjetaCreditos.size() && !tarjetaEncontrada; i++) {
                if (tarjetaCreditos.get(i).getNif().equals(nif)) {
                    index = i;
                    tarjetaEncontrada = true;
                }
            }
            if (tarjetaEncontrada) {
                jlInformacion.setText("Se ha eliminado la Tarjeta.");
                tarjetaCreditos.remove(index);
                isElimiado = true;
            } else {
                jlInformacion.setText("No se ha encontrado la Tarjeta");
            }
        }
    }//GEN-LAST:event_jbElimiarActionPerformed

    private void jbSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalirActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_jbSalirActionPerformed

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
            java.util.logging.Logger.getLogger(JDEliminarTarjeta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDEliminarTarjeta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDEliminarTarjeta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDEliminarTarjeta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JDEliminarTarjeta dialog = new JDEliminarTarjeta(new javax.swing.JFrame(), true,null);
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
    private javax.swing.JButton jbElimiar;
    private javax.swing.JButton jbSalir;
    private javax.swing.JLabel jlInformacion;
    private javax.swing.JLabel jlNIF;
    private javax.swing.JLabel jlTitulo;
    private javax.swing.JTextField jtfNIF;
    // End of variables declaration//GEN-END:variables
}
