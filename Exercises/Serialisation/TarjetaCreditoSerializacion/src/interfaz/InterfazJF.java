/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package interfaz;

import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import modelo.ModeloListaTarjetasCredito;
import modelo.TarjetaCredito;

/**
 *
 * @author josemaria
 */
public class InterfazJF extends javax.swing.JFrame {
    ArrayList<TarjetaCredito> listaTarjetas;

    /**
     * Creates new form JFInterfaz
     */
    public InterfazJF() {
        initComponents();
        listaTarjetas = new ArrayList<>();
        // Creamos el Modelo de la Lista
        modelo = new ModeloListaTarjetasCredito();
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
        jmiGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiGuardarActionPerformed(evt);
            }
        });
        jmArchivo.add(jmiGuardar);

        jmiCargar.setText("Cargar");
        jmiCargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiCargarActionPerformed(evt);
            }
        });
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

        jmbMenu.add(jmAcciones);

        setJMenuBar(jmbMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(51, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(44, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jmiAñadirTarjetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiAñadirTarjetaActionPerformed
        JDCrearTarejeta jDCrearTarejeta = new JDCrearTarejeta(this,true);
        jDCrearTarejeta.setVisible(true);
        
        
        if (jDCrearTarejeta.isCreada()) {
            TarjetaCredito nuevaTarjeta = jDCrearTarejeta.getTarjetaCredito();
            boolean tarjetaDuplicada = listaTarjetas.contains(nuevaTarjeta);
            boolean seguirCreando = true;
            
            while (tarjetaDuplicada && seguirCreando) {
                JOptionPane.showMessageDialog(rootPane, "Ya existe otra Tarjeta cono el mismo DNI");
                jDCrearTarejeta.setVisible(true);
                
                if (jDCrearTarejeta.isCreada()) {
                    nuevaTarjeta = jDCrearTarejeta.getTarjetaCredito();
                    tarjetaDuplicada = listaTarjetas.contains(nuevaTarjeta);
                } else {
                    seguirCreando = false;
                }
            }
            
            if (!tarjetaDuplicada) {
                listaTarjetas.add(nuevaTarjeta);
                modelo.añadirTarjeta(nuevaTarjeta);
            }
        }
    }//GEN-LAST:event_jmiAñadirTarjetaActionPerformed

    private void jtListaTarjetasCreditoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtListaTarjetasCreditoMouseClicked
        if (evt.getButton() == MouseEvent.BUTTON3) { // Si es Click Derecho
            // Mostramos  el Menú
            jpmEliminarMenu.show(jtListaTarjetasCredito, evt.getX(), evt.getY());
        } else if (evt.getClickCount() == 2) { // Si ha realizado Dos Clicks
            int index = jtListaTarjetasCredito.getSelectedRow(); // Obtenemos el indice de la Tarjeta seleccionada (JTable)
            TarjetaCredito selectedTarjeta = new TarjetaCredito(listaTarjetas.get(index));
            JDGestionarTarjeta jDGestionarTarjeta = new JDGestionarTarjeta(this, true, selectedTarjeta); // Creamos el JDialog para modificar la Tarjeta
            jDGestionarTarjeta.setVisible(true); // Hacemos Visible el JDialog
            
            if (jDGestionarTarjeta.isActualizado()) {
                TarjetaCredito tarjetaActualizada = jDGestionarTarjeta.getTarjetaCredito();
                this.listaTarjetas.set(index, tarjetaActualizada);
            }
        }
    }//GEN-LAST:event_jtListaTarjetasCreditoMouseClicked

    private void jmiEliminarTarjetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiEliminarTarjetaActionPerformed
        int result = JOptionPane.showConfirmDialog(this, "Esta seguro que deseas eliminar la Tajeta.");
        
        if (result == JOptionPane.YES_OPTION) {
            int indexSelectedTarjeta = jtListaTarjetasCredito.getSelectedRow();
            listaTarjetas.remove(indexSelectedTarjeta);
            modelo.eliminarTarjeta(indexSelectedTarjeta);
        }
    }//GEN-LAST:event_jmiEliminarTarjetaActionPerformed

    private void jmiGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiGuardarActionPerformed
        JFileChooser gestorArchivos = new JFileChooser();
        int option = gestorArchivos.showSaveDialog(this);
        
        if (option == JFileChooser.APPROVE_OPTION) {
            File selectedFile = gestorArchivos.getSelectedFile();
            
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(selectedFile))) {
                oos.writeObject(listaTarjetas);
                JOptionPane.showMessageDialog(this, "Se ha guardado la información exitosamente","EXITO",JOptionPane.INFORMATION_MESSAGE);

            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "No se ha podido escribir en el fichero","Error",JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_jmiGuardarActionPerformed

    private void jmiCargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiCargarActionPerformed
        JFileChooser gestorArchivos = new JFileChooser();
        int option = gestorArchivos.showSaveDialog(this);
        
        if (option == JFileChooser.APPROVE_OPTION) {
            File selectedFile = gestorArchivos.getSelectedFile();
            
            try (ObjectInputStream oos = new ObjectInputStream(new FileInputStream(selectedFile))) {
                this.listaTarjetas = (ArrayList<TarjetaCredito>) oos.readObject();
                
                for (TarjetaCredito t : listaTarjetas) {
                    modelo.añadirTarjeta(t);
                }
                JOptionPane.showMessageDialog(this, "Se ha cargado la información exitosamente","EXITO",JOptionPane.INFORMATION_MESSAGE);

            } catch (ClassNotFoundException | IOException ex) {
                JOptionPane.showMessageDialog(this, "El fichero es erronéo o esta corrupto","Error",JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_jmiCargarActionPerformed

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
    private javax.swing.JPopupMenu jpmEliminarMenu;
    private javax.swing.JTable jtListaTarjetasCredito;
    // End of variables declaration//GEN-END:variables
}
