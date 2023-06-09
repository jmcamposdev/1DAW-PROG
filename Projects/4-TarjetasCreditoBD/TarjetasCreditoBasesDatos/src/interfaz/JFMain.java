package interfaz;

/**
 * Clase JFrame realiza de intermediario entre los dos 
 * JFrame para elegir uno de los dos (JDBC, JPA).
 * @author josemaria
 */
public class JFMain extends javax.swing.JFrame {

    /**
     * Creates new form JFMain
     */
    public JFMain() {
        initComponents();
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
        jBAbrirJDBC = new javax.swing.JButton();
        jBAbrirJPA = new javax.swing.JButton();
        jLTituloJDBC = new javax.swing.JLabel();
        jLTituloJPA = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jlTitulo.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jlTitulo.setText("GESTIONAR TARJETAS");

        jBAbrirJDBC.setText("ABRIR");
        jBAbrirJDBC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAbrirJDBCActionPerformed(evt);
            }
        });

        jBAbrirJPA.setText("ABRIR");
        jBAbrirJPA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAbrirJPAActionPerformed(evt);
            }
        });

        jLTituloJDBC.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jLTituloJDBC.setText("JDBC");

        jLTituloJPA.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jLTituloJPA.setText("JPA");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(jBAbrirJDBC)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBAbrirJPA)
                .addGap(63, 63, 63))
            .addGroup(layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(jlTitulo)
                .addContainerGap(104, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addComponent(jLTituloJDBC)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLTituloJPA)
                .addGap(81, 81, 81))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jlTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 127, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLTituloJDBC)
                    .addComponent(jLTituloJPA))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBAbrirJDBC)
                    .addComponent(jBAbrirJPA))
                .addGap(68, 68, 68))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Método para mostrar el JFrame de JDBC y se cerrará 'this'
     * @param evt Action Event 
     */
    private void jBAbrirJDBCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAbrirJDBCActionPerformed
        JFInterfazJDBC gestionarJDBC = new JFInterfazJDBC();
        this.setVisible(false);
        gestionarJDBC.setVisible(true);
    }//GEN-LAST:event_jBAbrirJDBCActionPerformed

    /**
     * Método para mostrar el JFrame de JPA y se cerrará 'this' 
     * @param evt Action Event 
     */
    private void jBAbrirJPAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAbrirJPAActionPerformed
        JFInterfazJPA gestionarJPA = new JFInterfazJPA();
        this.setVisible(false);
        gestionarJPA.setVisible(true);
    }//GEN-LAST:event_jBAbrirJPAActionPerformed

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
            java.util.logging.Logger.getLogger(JFMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFMain().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBAbrirJDBC;
    private javax.swing.JButton jBAbrirJPA;
    private javax.swing.JLabel jLTituloJDBC;
    private javax.swing.JLabel jLTituloJPA;
    private javax.swing.JLabel jlTitulo;
    // End of variables declaration//GEN-END:variables
}
