package interfaz;

import Funciones.Utilities;
import java.awt.ComponentOrientation;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.Media;
import modelo.ModeloListaTemporada;
import modelo.Pelicula;
import modelo.Serie;
import modelo.Temporada;

public class JDGestionarSerie extends javax.swing.JDialog {

    public JDGestionarSerie(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    public JDGestionarSerie(java.awt.Frame parent, boolean modal, Serie serie) {
        this(parent, modal);
        this.serieSeleccionada = serie;
        inicializar();
    }
    
    private void inicializar() {
        // Creamos el Modelos de la Lista
        modelo = new ModeloListaTemporada();
                
        // Actualizamos JTable para que use el Modelo de Canción
        jtListaTemporadas.setModel(modelo);
        
        jcbDisponibilidad.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        
        jtfNombre.setText(serieSeleccionada.getNombre());
        jtfCalificacionEdad.setText(String.valueOf(serieSeleccionada.getCalificacionEdad()));
        jtfFechaIncorporacion.setText(formato.format(serieSeleccionada.getFechaIncorporacionAlCatalogo()));
        jcbDisponibilidad.setSelected(serieSeleccionada.isEstaDisponible());
        jtfFechaEstreno.setText(formato.format(serieSeleccionada.getFechaEstreno()));
        
        actualizarTablaTemporadas();
    }
    
    public boolean isActualizada() {
        return this.isActualizada;
    }
    public boolean isActualizadoNombre() {
        return this.isActualizadoNombre;
    }
    public boolean isActualizadoCalificacionEdad() {
        return this.isActualizadoCalificacionEdad;
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

        jpmEliminarTemporada = new javax.swing.JPopupMenu();
        jmiEliminarTemporada = new javax.swing.JMenuItem();
        jLabel1 = new javax.swing.JLabel();
        jbCancelar = new javax.swing.JButton();
        jlTituloNombre = new javax.swing.JLabel();
        jlTituloCalificacionEdad = new javax.swing.JLabel();
        jlTituloFechaIncorporacion = new javax.swing.JLabel();
        jcbDisponibilidad = new javax.swing.JCheckBox();
        jlTituloFechaEstreno = new javax.swing.JLabel();
        jtfNombre = new javax.swing.JTextField();
        jtfCalificacionEdad = new javax.swing.JTextField();
        jtfFechaIncorporacion = new javax.swing.JTextField();
        jtfFechaEstreno = new javax.swing.JTextField();
        jbActualizar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtListaTemporadas = new javax.swing.JTable();
        jmbMenu = new javax.swing.JMenuBar();
        jmCrear = new javax.swing.JMenu();
        jmiCrearTemporada = new javax.swing.JMenuItem();
        jmiCrearCapitulo = new javax.swing.JMenuItem();

        jmiEliminarTemporada.setText("Eliminar");
        jmiEliminarTemporada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiEliminarTemporadaActionPerformed(evt);
            }
        });
        jpmEliminarTemporada.add(jmiEliminarTemporada);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jLabel1.setText("GESTIONAR SERIE");

        jbCancelar.setText("Cancelar");
        jbCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCancelarActionPerformed(evt);
            }
        });

        jlTituloNombre.setText("Nombre:");

        jlTituloCalificacionEdad.setText("Calificación de Edad (0 - 18):");

        jlTituloFechaIncorporacion.setText("Fecha de Incorporación (dd/mm/yyyy):");

        jcbDisponibilidad.setText("Se encuetra Disponibles");

        jlTituloFechaEstreno.setText("Fecha de Estreno (dd/mm/yyyy):");

        jbActualizar.setText("Actualizar");
        jbActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbActualizarActionPerformed(evt);
            }
        });

        jtListaTemporadas.setModel(new javax.swing.table.DefaultTableModel(
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
        jtListaTemporadas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtListaTemporadasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtListaTemporadas);

        jmCrear.setText("Crear");

        jmiCrearTemporada.setText("Crear Temporada");
        jmiCrearTemporada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiCrearTemporadaActionPerformed(evt);
            }
        });
        jmCrear.add(jmiCrearTemporada);

        jmiCrearCapitulo.setText("Crear Capitulo");
        jmCrear.add(jmiCrearCapitulo);

        jmbMenu.add(jmCrear);

        setJMenuBar(jmbMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jlTituloCalificacionEdad)
                            .addComponent(jlTituloNombre))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfCalificacionEdad, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jlTituloFechaIncorporacion)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtfFechaIncorporacion, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(34, 34, 34)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jcbDisponibilidad)
                                            .addComponent(jlTituloFechaEstreno)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(62, 62, 62)
                                        .addComponent(jbActualizar)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jbCancelar)
                                    .addComponent(jtfFechaEstreno, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 91, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(318, 318, 318))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlTituloNombre)
                            .addComponent(jtfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlTituloCalificacionEdad)
                            .addComponent(jtfCalificacionEdad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlTituloFechaIncorporacion, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfFechaIncorporacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addComponent(jcbDisponibilidad)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlTituloFechaEstreno)
                            .addComponent(jtfFechaEstreno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 90, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jbActualizar)
                            .addComponent(jbCancelar)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(39, 39, 39))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCancelarActionPerformed
        this.isActualizada = false;
        this.setVisible(false);
    }//GEN-LAST:event_jbCancelarActionPerformed

    private void jbActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbActualizarActionPerformed
        boolean isValidInput = true;
        String nombre = jtfNombre.getText();
        String calificacionEdadString = jtfCalificacionEdad.getText();
        String fechaIncorporacionString = jtfFechaIncorporacion.getText();
        boolean disponibilidad = jcbDisponibilidad.isSelected();
        String fechaEstrenoString = jtfFechaEstreno.getText();

        if (nombre.isBlank()) {
        JOptionPane.showMessageDialog(this, "El nombre no puede estar vacío", "Error", JOptionPane.ERROR_MESSAGE);
        isValidInput = false;
        }

        if (isValidInput && (!calificacionEdadString.matches("\\d+") || !Utilities.validateRange(Integer.valueOf(calificacionEdadString), 0, 19))) {
            JOptionPane.showMessageDialog(this, "La calificación de edad debe de estar entre 0 y 18", "Error", JOptionPane.ERROR_MESSAGE);
            isValidInput = false;
        }

        if (isValidInput && !Utilities.validateLocalDate(fechaIncorporacionString)) {
            JOptionPane.showMessageDialog(this, "Fecha de Incorporación es inválida", "Error", JOptionPane.ERROR_MESSAGE);
            isValidInput = false;
        }

        if (isValidInput && !Utilities.validateLocalDate(fechaEstrenoString)) {
            JOptionPane.showMessageDialog(this, "Fecha de Estreno es inválida", "Error", JOptionPane.ERROR_MESSAGE);
            isValidInput = false;
        }
        
        if (isValidInput && !validarFechaEstrenoConTemporadas(Utilities.convertToLocalDate(fechaEstrenoString))) {
            JOptionPane.showMessageDialog(this, "La Fecha de Estreno es posterior a las Temporadas.", "Error", JOptionPane.ERROR_MESSAGE);
            isValidInput = false;
        }

        if (isValidInput) {
            int calificacionEdad = Integer.valueOf(calificacionEdadString);
            LocalDate fechaIncorporacion = Utilities.convertToLocalDate(fechaIncorporacionString);
            LocalDate fechaEstreno = Utilities.convertToLocalDate(fechaEstrenoString);
            
            if (!serieSeleccionada.getNombre().equals(nombre)) {
                serieSeleccionada.setNombre(nombre);
                isActualizada = true;
                isActualizadoNombre = true;
            }
            if (serieSeleccionada.getCalificacionEdad() != calificacionEdad) {
                serieSeleccionada.setCalificacionEdad(calificacionEdad);
                isActualizada = true;
                isActualizadoCalificacionEdad = true;
            }
            if (!serieSeleccionada.getFechaIncorporacionAlCatalogo().equals(fechaIncorporacion)) {
                serieSeleccionada.setFechaIncorporacionAlCatalogo(fechaIncorporacion);
                isActualizada = true;
            }
            if (serieSeleccionada.isEstaDisponible() != disponibilidad) {
                serieSeleccionada.setEstaDisponible(disponibilidad);
                isActualizada = true;
            }
            if (!serieSeleccionada.getFechaEstreno().equals(fechaEstreno)) {
                serieSeleccionada.setFechaEstreno(fechaEstreno);
                isActualizada = true;
            }
            
            this.setVisible(false);
        }
    }//GEN-LAST:event_jbActualizarActionPerformed

    private void jmiCrearTemporadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiCrearTemporadaActionPerformed
        boolean validFecha = false;
        boolean exit = false;
        String fecha = "";
        do {
            fecha = JOptionPane.showInputDialog(this,"Ingrese la Fecha de la Nueva Temporada (dd/mm/yyyy):","Nueva Temporada",JOptionPane.INFORMATION_MESSAGE);
            if (fecha != null && Utilities.validateLocalDate(fecha) && Utilities.validateLocaDateIsAfterOrEquals(Utilities.convertToLocalDate(fecha), serieSeleccionada.getFechaEstreno())) {
                validFecha = true;
            } else if (fecha != null) {
                JOptionPane.showMessageDialog(this, "Fecha inválida la fecha debe de ser posterior a la fecha de estreno de la serie");
                validFecha = false;
            } else {
                exit = true;
            }
        } while (!validFecha && !exit);
        
        if (validFecha && serieSeleccionada.añadirTemporada(Utilities.convertToLocalDate(fecha))) {
            actualizarTablaTemporadas();
            JOptionPane.showMessageDialog(this, "Temporada Creada con exito");
            isActualizada = true;
        } else {
            JOptionPane.showMessageDialog(this, "Ya existe una Temporada el mismo mes.");
        }
        
    }//GEN-LAST:event_jmiCrearTemporadaActionPerformed

    private void jtListaTemporadasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtListaTemporadasMouseClicked
        if (evt.getButton() == MouseEvent.BUTTON3) { // Si es Click Derecho
            // Mostramos  el Menú
            jpmEliminarTemporada.show(jtListaTemporadas, evt.getX(), evt.getY());
        } else if (evt.getClickCount() == 2) { // Si ha realizado Dos Clicks
            int index = jtListaTemporadas.getSelectedRow(); // Obtenemos el indice de la temporada seleccionada (JTable)
            Serie copiaSerie = new Serie(serieSeleccionada);
            JDGestionarTemporada jDGestionarTemporada = new JDGestionarTemporada(this, true, copiaSerie, index);
            jDGestionarTemporada.setVisible(true);
            
            if (jDGestionarTemporada.isActualizado()) {
                Serie serieModificada = jDGestionarTemporada.getSerie();
                serieSeleccionada = new Serie(serieModificada);
                this.isActualizada = true;
                actualizarTablaTemporadas();
            }
        }
    }//GEN-LAST:event_jtListaTemporadasMouseClicked

    private void jmiEliminarTemporadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiEliminarTemporadaActionPerformed
        int index = jtListaTemporadas.getSelectedRow();
        if (serieSeleccionada.eliminarTemporada(index)) {
            modelo.eliminarTemporada(index);
            isActualizada = true;
        }
        
    }//GEN-LAST:event_jmiEliminarTemporadaActionPerformed

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
            java.util.logging.Logger.getLogger(JDGestionarSerie.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDGestionarSerie.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDGestionarSerie.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDGestionarSerie.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JDGestionarSerie dialog = new JDGestionarSerie(new javax.swing.JFrame(), true);
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

    
    private void actualizarTablaTemporadas() {
        modelo.clear();
        int contador = 0;
        Temporada temporada = serieSeleccionada.getCopiaTemporada(contador++);
        while (temporada != null) {
            modelo.añadirTemporada(temporada);
            temporada = serieSeleccionada.getCopiaTemporada(contador++);
        }
    }
    
    private boolean validarFechaEstrenoConTemporadas (LocalDate fechaEstrenoSerie) {
        boolean isFechaValida = true;
        int contador = 0;
        Temporada temporada = serieSeleccionada.getCopiaTemporada(contador++);
        while (temporada != null && isFechaValida) {
            if (!Utilities.validateLocaDateIsAfterOrEquals(temporada.getFechaEstreno(), fechaEstrenoSerie)) {
                isFechaValida = false;
            }
            temporada = serieSeleccionada.getCopiaTemporada(contador++);
        }
        return isFechaValida;
    }
    
    private static DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy"); // Definir el formato deseado
    private ModeloListaTemporada modelo;
    private Serie serieSeleccionada;
    private boolean isActualizada;
    private boolean isActualizadoNombre;
    private boolean isActualizadoCalificacionEdad;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbActualizar;
    private javax.swing.JButton jbCancelar;
    private javax.swing.JCheckBox jcbDisponibilidad;
    private javax.swing.JLabel jlTituloCalificacionEdad;
    private javax.swing.JLabel jlTituloFechaEstreno;
    private javax.swing.JLabel jlTituloFechaIncorporacion;
    private javax.swing.JLabel jlTituloNombre;
    private javax.swing.JMenu jmCrear;
    private javax.swing.JMenuBar jmbMenu;
    private javax.swing.JMenuItem jmiCrearCapitulo;
    private javax.swing.JMenuItem jmiCrearTemporada;
    private javax.swing.JMenuItem jmiEliminarTemporada;
    private javax.swing.JPopupMenu jpmEliminarTemporada;
    private javax.swing.JTable jtListaTemporadas;
    private javax.swing.JTextField jtfCalificacionEdad;
    private javax.swing.JTextField jtfFechaEstreno;
    private javax.swing.JTextField jtfFechaIncorporacion;
    private javax.swing.JTextField jtfNombre;
    // End of variables declaration//GEN-END:variables
}
