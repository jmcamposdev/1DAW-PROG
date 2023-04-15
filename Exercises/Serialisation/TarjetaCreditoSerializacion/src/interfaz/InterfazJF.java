/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package interfaz;

import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import modelo.ModeloListaTarjetasCredito;
import modelo.TarjetaCredito;

/**
 *
 * @author josemaria
 */
public class InterfazJF extends javax.swing.JFrame {

    /**
     * Creates new form JFInterfaz
     */
    public InterfazJF() {
        initComponents();
        // Creamos el Modelo de la Lista
        modelo = new ModeloListaTarjetasCredito();
        modelo.añadirTarjeta(new TarjetaCredito("Jose Maria Campos","54530823P","1111",4000,"4275060355274659"));
        // Actualizamos JTable para que use el Modelo de Tarjetas de Credito
        jtListaTarjetasCredito.setModel(modelo);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpmEliminarMenu = new javax.swing.JPopupMenu();
        jmiEliminarTarjeta = new javax.swing.JMenuItem();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtListaTarjetasCredito = new javax.swing.JTable();
        jmbMenu = new javax.swing.JMenuBar();
        jmArchivo = new javax.swing.JMenu();
        jmiGuardar = new javax.swing.JMenuItem();
        jmiCargar = new javax.swing.JMenuItem();
        jmAcciones = new javax.swing.JMenu();
        jmiAñadirTarjeta = new javax.swing.JMenuItem();
        jmiModificarTarjeta = new javax.swing.JMenuItem();

        jmiEliminarTarjeta.setText("Eliminar");
        jmiEliminarTarjeta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiEliminarTarjetaActionPerformed(evt);
            }
        });
        jpmEliminarMenu.add(jmiEliminarTarjeta);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jtListaTarjetasCredito.setModel(new javax.swing.table.DefaultTableModel(
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
        jtListaTarjetasCredito.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtListaTarjetasCreditoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtListaTarjetasCredito);

        jmArchivo.setText("Archivo");

        jmiGuardar.setText("Guardar");
        jmArchivo.add(jmiGuardar);

        jmiCargar.setText("Cargar");
        jmArchivo.add(jmiCargar);

        jmbMenu.add(jmArchivo);

        jmAcciones.setText("Acciones");

        jmiAñadirTarjeta.setText("Añadir Tarjeta");
        jmiAñadirTarjeta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiAñadirTarjetaActionPerformed(evt);
            }
        });
        jmAcciones.add(jmiAñadirTarjeta);

        jmiModificarTarjeta.setText("Modificar Tarjeta");
        jmAcciones.add(jmiModificarTarjeta);

        jmbMenu.add(jmAcciones);

        setJMenuBar(jmbMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(64, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(45, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jmiAñadirTarjetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiAñadirTarjetaActionPerformed
        JDCrearTarejeta jDCrearTarejeta = new JDCrearTarejeta(this,true);
        jDCrearTarejeta.setVisible(true);
        
        if (jDCrearTarejeta.isCreada()) {
            TarjetaCredito nuevaTarjeta = jDCrearTarejeta.getTarjetaCredito();
            modelo.añadirTarjeta(nuevaTarjeta);
        }
        
    }//GEN-LAST:event_jmiAñadirTarjetaActionPerformed

    private void jtListaTarjetasCreditoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtListaTarjetasCreditoMouseClicked
        if (evt.getButton() == MouseEvent.BUTTON3) { // Si es Click Derecho
            // Mostramos  el Menú
            jpmEliminarMenu.show(jtListaTarjetasCredito, evt.getX(), evt.getY());
        } else if (evt.getClickCount() == 2) { // Si ha realizado Dos Clicks
            /*
            int index = jtListaCanciones.getSelectedRow(); // Obtenemos el indice de la canción seleccionada (JTable)
            JDCancion jdCancion = new JDCancion(this, true); // Creamos el JDialog para modificar la Canción
            Cancion cancionAModificar = modelo.getCancion(index); //Obtenemos la Canción seleccionada por el Usuario
            jdCancion.setNombreCancion(cancionAModificar.getNombre()); // Insertamos en el JDialog el Nombre de la Canción
            jdCancion.setAutorCancion(cancionAModificar.getAutor()); // Insertamos en el JDialog el Autor de la Canción
            jdCancion.setDuracionCancion(cancionAModificar.getDuracion()); // Insetamos en el JDialog la Duracion de la Canción
            jdCancion.setVisible(true); // Hacemos Visible el JDialog
            
            if (jdCancion.isAceptada()) { // Si la película ha sido aceptada
                Cancion cancionModificada = jdCancion.getCancion(); // Obteneos la canción modificada
                modelo.setNombre(index,cancionModificada.getNombre()); // Modificamos el Nombre
                modelo.setAutor(index, cancionModificada.getAutor()); // Modificamos el Autor
                modelo.setDuracion(index, cancionModificada.getDuracion()); // Modificamos la Duración
                modelo.fireTableRowsUpdated(index, index);
            }
            */
        }
    }//GEN-LAST:event_jtListaTarjetasCreditoMouseClicked

    private void jmiEliminarTarjetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiEliminarTarjetaActionPerformed
        int result = JOptionPane.showConfirmDialog(this, "Esta seguro que deseas eliminar la Tajeta.");
        
        if (result == JOptionPane.YES_OPTION) {
            int indexSelectedTarjeta = jtListaTarjetasCredito.getSelectedRow();
            System.out.println(indexSelectedTarjeta);
            System.out.println(modelo.eliminarTarjeta(indexSelectedTarjeta));
        }
    }//GEN-LAST:event_jmiEliminarTarjetaActionPerformed

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
            java.util.logging.Logger.getLogger(InterfazJF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfazJF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfazJF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfazJF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterfazJF().setVisible(true);
            }
        });
    }

    private ModeloListaTarjetasCredito modelo;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenu jmAcciones;
    private javax.swing.JMenu jmArchivo;
    private javax.swing.JMenuBar jmbMenu;
    private javax.swing.JMenuItem jmiAñadirTarjeta;
    private javax.swing.JMenuItem jmiCargar;
    private javax.swing.JMenuItem jmiEliminarTarjeta;
    private javax.swing.JMenuItem jmiGuardar;
    private javax.swing.JMenuItem jmiModificarTarjeta;
    private javax.swing.JPopupMenu jpmEliminarMenu;
    private javax.swing.JTable jtListaTarjetasCredito;
    // End of variables declaration//GEN-END:variables
}