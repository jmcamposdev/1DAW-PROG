/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package interfaz;

import javax.swing.JOptionPane;
import modelo.ModeloListaContactos;

public class JFInterfaz extends javax.swing.JFrame {

    public JFInterfaz() {
        initComponents();
        inicializar();
    }
    
    public void inicializar() {
        modelo = new ModeloListaContactos();
        jtListaContactos.setModel(modelo);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jlTitulo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtListaContactos = new javax.swing.JTable();
        jbAgregarContacto = new javax.swing.JButton();
        jbEliminarContacto = new javax.swing.JButton();
        jbModificarContacto = new javax.swing.JButton();
        jmbAcciones = new javax.swing.JMenuBar();
        jmArchivo = new javax.swing.JMenu();
        jmiImportar = new javax.swing.JMenuItem();
        jmiExportar = new javax.swing.JMenuItem();
        jmAcciones = new javax.swing.JMenu();
        jmiAgregarContacto = new javax.swing.JMenuItem();
        jmiModificarContacto = new javax.swing.JMenuItem();
        jmiEliminarContacto = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jlTitulo.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jlTitulo.setText("Lista Contactos");

        jtListaContactos.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jtListaContactos);

        jbAgregarContacto.setText("Agregar Contacto");
        jbAgregarContacto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAgregarContactoActionPerformed(evt);
            }
        });

        jbEliminarContacto.setText("Eliminar");
        jbEliminarContacto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEliminarContactoActionPerformed(evt);
            }
        });

        jbModificarContacto.setText("Modificar Contacto");
        jbModificarContacto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbModificarContactoActionPerformed(evt);
            }
        });

        jmArchivo.setText("Archivo");

        jmiImportar.setText("Importar");
        jmArchivo.add(jmiImportar);

        jmiExportar.setText("Exportar");
        jmArchivo.add(jmiExportar);

        jmbAcciones.add(jmArchivo);

        jmAcciones.setText("Acciones");

        jmiAgregarContacto.setText("Agregar Contacto");
        jmiAgregarContacto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiAgregarContactoActionPerformed(evt);
            }
        });
        jmAcciones.add(jmiAgregarContacto);

        jmiModificarContacto.setText("Modificar");
        jmiModificarContacto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiModificarContactoActionPerformed(evt);
            }
        });
        jmAcciones.add(jmiModificarContacto);

        jmiEliminarContacto.setText("Eliminar");
        jmiEliminarContacto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiEliminarContactoActionPerformed(evt);
            }
        });
        jmAcciones.add(jmiEliminarContacto);

        jmbAcciones.add(jmAcciones);

        setJMenuBar(jmbAcciones);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(jlTitulo))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jbAgregarContacto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jbModificarContacto))
                        .addGap(123, 123, 123)
                        .addComponent(jbEliminarContacto)))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jlTitulo)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbAgregarContacto)
                    .addComponent(jbEliminarContacto))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbModificarContacto)
                .addContainerGap(69, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbAgregarContactoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAgregarContactoActionPerformed
        agregarContacto();
    }//GEN-LAST:event_jbAgregarContactoActionPerformed

    private void jmiAgregarContactoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiAgregarContactoActionPerformed
        agregarContacto();
    }//GEN-LAST:event_jmiAgregarContactoActionPerformed

    private void jbEliminarContactoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEliminarContactoActionPerformed
        eliminarContacto();
    }//GEN-LAST:event_jbEliminarContactoActionPerformed

    private void jmiEliminarContactoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiEliminarContactoActionPerformed
        eliminarContacto();
    }//GEN-LAST:event_jmiEliminarContactoActionPerformed

    private void jbModificarContactoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbModificarContactoActionPerformed
        modificarContacto();
    }//GEN-LAST:event_jbModificarContactoActionPerformed

    private void jmiModificarContactoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiModificarContactoActionPerformed
        modificarContacto();
    }//GEN-LAST:event_jmiModificarContactoActionPerformed

    
    
    private void agregarContacto() {
        JDContacto jDContacto = new JDContacto(this, true);
        jDContacto.setVisible(true);
        
        if (jDContacto.isCreado()) {
            modelo.añadirContacto(jDContacto.getContacto());
        }
    }
    
    private void eliminarContacto() {
        int index = jtListaContactos.getSelectedRow();
        
        if (index == -1) {
            JOptionPane.showMessageDialog(this, "Debes de seleccionadar un contacto", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            modelo.eliminarContacto(index);
            JOptionPane.showMessageDialog(this, "Se ha elimiado correctamente", "Éxito", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void modificarContacto() {
        int index = jtListaContactos.getSelectedRow();
        
        if (index == -1) {
            JOptionPane.showMessageDialog(this, "Debes de seleccionadar un contacto", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            JDContacto jDContacto = new JDContacto(this, true, modelo.getContacto(index));
            jDContacto.setVisible(true);
            if (jDContacto.isCreado()) {
                modelo.setContacto(index, jDContacto.getContacto());
            }
        }
        
    }
    
    
    
    
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
            java.util.logging.Logger.getLogger(JFInterfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFInterfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFInterfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFInterfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFInterfaz().setVisible(true);
            }
        });
    }

    private ModeloListaContactos modelo;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbAgregarContacto;
    private javax.swing.JButton jbEliminarContacto;
    private javax.swing.JButton jbModificarContacto;
    private javax.swing.JLabel jlTitulo;
    private javax.swing.JMenu jmAcciones;
    private javax.swing.JMenu jmArchivo;
    private javax.swing.JMenuBar jmbAcciones;
    private javax.swing.JMenuItem jmiAgregarContacto;
    private javax.swing.JMenuItem jmiEliminarContacto;
    private javax.swing.JMenuItem jmiExportar;
    private javax.swing.JMenuItem jmiImportar;
    private javax.swing.JMenuItem jmiModificarContacto;
    private javax.swing.JTable jtListaContactos;
    // End of variables declaration//GEN-END:variables
}
