/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package interfaz;

import Funciones.Utilities;
import java.awt.Dialog;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
import modelo.Capitulo;
import modelo.ModeloListaCapitulo;
import modelo.Serie;
import modelo.Temporada;

/**
 *
 * @author josemaria
 */
public class JDGestionarTemporada extends javax.swing.JDialog {

    /**
     * Creates new form JDGestionarTemporada
     */
    public JDGestionarTemporada(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    public JDGestionarTemporada(Dialog parent, boolean modal, Serie serie, int indiceTemporada) {
        super(parent,modal);
        initComponents();
        this.serieSeleccionada = serie;
        this.indiceTemporada = indiceTemporada;
        inicializar();
    }
    
    private void inicializar() {
        modelo = new ModeloListaCapitulo();
        this.jtListaCapitulos.setModel(modelo);
        jlNombreTemporada.setText("Temporada "+(this.indiceTemporada+1));
        jtfFechaEstreno.setText(formato.format(serieSeleccionada.getCopiaTemporada(indiceTemporada).getFechaEstreno()));
    }
    
    public boolean isActualizado() {
        return this.isActualizado;
    }
    public Serie getSerie() {
        return new Serie(serieSeleccionada);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jtListaCapitulos = new javax.swing.JTable();
        jlNombreTemporada = new javax.swing.JLabel();
        jlTituloFechaEstreno = new javax.swing.JLabel();
        jtfFechaEstreno = new javax.swing.JTextField();
        jbActualizar = new javax.swing.JButton();
        jbCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jlTitulo.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jlTitulo.setText("GESTIONAR TEMPORADA");

        jtListaCapitulos.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jtListaCapitulos);

        jlNombreTemporada.setText("jLabel1");

        jlTituloFechaEstreno.setText("Fecha Estreno:");

        jbActualizar.setText("Actualizar");
        jbActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbActualizarActionPerformed(evt);
            }
        });

        jbCancelar.setText("Cancelar");
        jbCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jlTitulo)
                .addGap(195, 195, 195))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jlNombreTemporada)
                            .addComponent(jlTituloFechaEstreno))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfFechaEstreno, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jbActualizar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbCancelar)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlTitulo)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jlNombreTemporada)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlTituloFechaEstreno)
                            .addComponent(jtfFechaEstreno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jbActualizar)
                            .addComponent(jbCancelar))
                        .addGap(46, 46, 46))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCancelarActionPerformed
        this.isActualizado = false;
        this.setVisible(false);
    }//GEN-LAST:event_jbCancelarActionPerformed

    private void jbActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbActualizarActionPerformed
        boolean isValidInput = true;
        String fechaEstrenoString = jtfFechaEstreno.getText();
        
        if (!Utilities.validateLocalDate(fechaEstrenoString)) {
            JOptionPane.showMessageDialog(this, "La fecha de estreno es inválida", "Error", JOptionPane.ERROR_MESSAGE);
            isValidInput = false;
        }
        if (isValidInput && !Utilities.validateLocaDateIsAfterOrEquals(Utilities.convertToLocalDate(fechaEstrenoString), serieSeleccionada.getFechaEstreno())) {
            JOptionPane.showMessageDialog(this, "La fecha de estreno es anterior a la Fecha de Estreno de la Serie", "Error", JOptionPane.ERROR_MESSAGE);
            isValidInput = false;
        }
        
        if (isValidInput) {
            LocalDate fechaEstrenoTemporada = Utilities.convertToLocalDate(fechaEstrenoString);
            if (serieSeleccionada.setFechaEstrenoTemporada(this.indiceTemporada, fechaEstrenoTemporada)) {
                this.isActualizado = true;
                this.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(this, "Ya existe una Temporada el mismo mes.");
            }
        }
    }//GEN-LAST:event_jbActualizarActionPerformed

    
    private void actualizarListaCapitulos() {
        modelo.eliminarTodo();
        Temporada temporada = serieSeleccionada.getCopiaTemporada(indiceTemporada);
        int contador = 0;
        Capitulo capitulo = temporada.getCapitulo(contador++);
        while (capitulo != null) {
            modelo.añadirCapitulo(capitulo);
            capitulo = temporada.getCapitulo(contador++);
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
            java.util.logging.Logger.getLogger(JDGestionarTemporada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDGestionarTemporada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDGestionarTemporada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDGestionarTemporada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JDGestionarTemporada dialog = new JDGestionarTemporada(new javax.swing.JFrame(), true);
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

    
    private static DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy"); // Definir el formato deseado
    private boolean isActualizado;
    private Serie serieSeleccionada;
    private int indiceTemporada;
    private ModeloListaCapitulo modelo;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbActualizar;
    private javax.swing.JButton jbCancelar;
    private javax.swing.JLabel jlNombreTemporada;
    private javax.swing.JLabel jlTitulo;
    private javax.swing.JLabel jlTituloFechaEstreno;
    private javax.swing.JTable jtListaCapitulos;
    private javax.swing.JTextField jtfFechaEstreno;
    // End of variables declaration//GEN-END:variables
}
