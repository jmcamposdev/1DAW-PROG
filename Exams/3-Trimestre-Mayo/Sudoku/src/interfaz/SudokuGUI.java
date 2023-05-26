package interfaz;

import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import sudoku.EntradaSalida;
import sudoku.ModeloSudoku;
import sudoku.Sudoku;

public class SudokuGUI extends javax.swing.JFrame {

    /**
     * Creates new form SudokuGUI
     */
    public SudokuGUI() {
        initComponents();
        inicializar();
    }

    private void inicializar() {
        // Inicializamos el modelo de la tabla
        modelo = new ModeloSudoku();
        // Asignamos el modelo a la tabla
        jtSudoku.setModel(modelo);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jlTitulo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtSudoku = new javax.swing.JTable();
        jbComprobarSudoku = new javax.swing.JButton();
        jmbMenu = new javax.swing.JMenuBar();
        jmArchivo = new javax.swing.JMenu();
        jmiCargar = new javax.swing.JMenuItem();
        jmiGuardar = new javax.swing.JMenuItem();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jlTitulo.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jlTitulo.setText("SUDOKU");

        jtSudoku.setModel(new javax.swing.table.DefaultTableModel(
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
        jtSudoku.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtSudokuMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtSudoku);

        jbComprobarSudoku.setText("Comprobar");
        jbComprobarSudoku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbComprobarSudokuActionPerformed(evt);
            }
        });

        jmArchivo.setMnemonic('A');
        jmArchivo.setText("Archivo");

        jmiCargar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jmiCargar.setText("Cargar");
        jmiCargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiCargarActionPerformed(evt);
            }
        });
        jmArchivo.add(jmiCargar);

        jmiGuardar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jmiGuardar.setText("Guardar");
        jmiGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiGuardarActionPerformed(evt);
            }
        });
        jmArchivo.add(jmiGuardar);

        jmbMenu.add(jmArchivo);

        setJMenuBar(jmbMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jlTitulo)
                .addGap(162, 162, 162))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(82, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(80, 80, 80))
            .addGroup(layout.createSequentialGroup()
                .addGap(165, 165, 165)
                .addComponent(jbComprobarSudoku)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlTitulo)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jbComprobarSudoku)
                .addContainerGap(46, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtSudokuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtSudokuMouseClicked
        int[] columnasSeleccionadas = jtSudoku.getSelectedRows(); // Obtenemos la lista de los indice de las filas seleccionadas
        if (columnasSeleccionadas.length > 1) { // Si se han seleccionado más de una fila
            JOptionPane.showMessageDialog(this, "Por favor seleccione una sola columan");
        } else if (evt.getClickCount() == 2) { // Si ha realizado doble click abrimos el JDialog
            actualizarValor();
        }
    }//GEN-LAST:event_jtSudokuMouseClicked

    private void jmiCargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiCargarActionPerformed
        JFileChooser gestorArchivo = crearFileChooserLista(); // Creamos el JFileChooser
        int option = gestorArchivo.showOpenDialog(this); // Mostramos el JFileChooser
        if (option == JFileChooser.OPEN_DIALOG) { // Si ha seleccionado un fichero 
            File selectedFile = gestorArchivo.getSelectedFile(); // Obtenemos el fichero seleccionado

            if (validSelectedFile(selectedFile)) {
                try {
                    // Comprobamos si el fichero existe y posee una extensión válida
                    Sudoku sudoku = EntradaSalida.cargarSudoku(selectedFile.getAbsolutePath());
                    modelo.setSudoku(sudoku);
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(this, "Ha cocurrido un error al leer el fichero.", "Error", JOptionPane.ERROR_MESSAGE);
                }

            }
        }
    }//GEN-LAST:event_jmiCargarActionPerformed

    private void jmiGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiGuardarActionPerformed
        JFileChooser gestorArchivos = crearFileChooserLista(); // Creamos el FileChooser
        int option = gestorArchivos.showSaveDialog(this); // Mostramos el JFileChooser
        if (option == JFileChooser.APPROVE_OPTION) { // Si ha seleccionado un fichero o lo ha escrito
            File selectedFile = gestorArchivos.getSelectedFile(); // Obtenemos le Fichero

            if (!validarExtensionListadoPredicate.test(selectedFile.getName())) { // Si no es válida la extensión
                JOptionPane.showMessageDialog(this, "El fichero Seleccionada no posee una extensión válida (txt)", "Error", JOptionPane.WARNING_MESSAGE);
            } else { // Si la extensión es válida
                boolean escribirFichero = true;
                if (selectedFile.exists()) { // Si el fichero existeº
                    // Mostramos confirmación para sobreescribirlo
                    int optionSobreEscribir = JOptionPane.showConfirmDialog(this, "Deseas sobreescribir el fichero", "Sobreescribir", JOptionPane.YES_NO_CANCEL_OPTION);
                    if (optionSobreEscribir != JOptionPane.OK_OPTION) { // Si no desea sobreescribirlo
                        escribirFichero = false; // No lo escribimos
                    }
                }

                if (escribirFichero) { // Si se escribe en el fichero
                    try {
                        EntradaSalida.guardarSudoku(selectedFile.getAbsolutePath(), modelo.getSudoku());
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(this, "Ha cocurrido un error al escribir el fichero.", "Error", JOptionPane.ERROR_MESSAGE);

                    }
                }
            }
        }
    }//GEN-LAST:event_jmiGuardarActionPerformed

    private void jbComprobarSudokuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbComprobarSudokuActionPerformed
        boolean estaResuelto = modelo.getSudoku().comprobarSudoku();
        String message = estaResuelto ? "El sudoku se encuentra resuelto" : "El sudoku no se encuentra resuelto";
        JOptionPane.showMessageDialog(this, message, "Comprobación", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jbComprobarSudokuActionPerformed

    private void actualizarValor() {
        JDModificarSudoku jDModificarSudoku = new JDModificarSudoku(this, true);
        jDModificarSudoku.setVisible(true);

        if (jDModificarSudoku.isActualizado()) {
            int row = jtSudoku.getSelectedRow();
            int column = jtSudoku.getSelectedColumn();

            if (row >= 0 && column >= 0) {
                modelo.setValor(row, column, jDModificarSudoku.getValor());
                JOptionPane.showMessageDialog(this, "Se ha modificado correctamente el valor de la fila: " + row + " y columna: " + column,"Modificado", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    /**
     * Método que devuelve un JFileChooser con el Filtro de Listas las cuales
     * son (TXT) y solo deja elegir ficheros.
     *
     * @return Devuelve un Objeto JFileChooser.
     */
    private JFileChooser crearFileChooserLista() {
        JFileChooser gestorArchivos = new JFileChooser(); // Creamos el JFileChooser
        gestorArchivos.removeChoosableFileFilter(gestorArchivos.getFileFilter()); // Eliminamos el Filtro por defecto (Todos)
        // Creamos el filtro para extensiones txt
        gestorArchivos.setFileFilter(new FileNameExtensionFilter("Extensiones de Listas (txt)", "txt")); // Asignamos el Filtro de Extensiones
        gestorArchivos.setFileSelectionMode(JFileChooser.FILES_ONLY); // Permitimos solo que pueda seleccionar archivos
        return gestorArchivos;
    }

    /**
     * Método que valida si el fichero pasado por parámetro existe y si posee la
     * extensión valida la cuales son (TXT)
     *
     * @param selectedFile El fichero a validar
     * @return Devuelve True si el fichero existe y posse la extensión válida en
     * caso contrario False
     */
    private boolean validSelectedFile(File selectedFile) {
        boolean validFile = true;

        if (!selectedFile.exists()) {
            JOptionPane.showMessageDialog(this, "El fichero seleccionado no existe", "Error", JOptionPane.WARNING_MESSAGE);
            validFile = false;
        } else if (!validarExtensionListadoPredicate.test(selectedFile.getName())) {
            JOptionPane.showMessageDialog(this, "La extensión del fichero es inválida\n Extensiones válidas: TXT", "Error", JOptionPane.WARNING_MESSAGE);
            validFile = false;
        }

        return validFile;
    }

    /**
     * Predicado que valida la Extensión del nombre pasado. Si el nombre
     * contiene "." y posterior al "." posee una extensión válida las cuales son
     * (TXT) Devuelve un boolean al llamar al método test().
     */
    private final Predicate<String> validarExtensionListadoPredicate = (fileName) -> {
        boolean isExtensionValida = false;

        if (fileName.contains(".")) {
            // Obtenemos la extensión del fichero
            String extension = fileName.substring(fileName.indexOf(".") + 1).toUpperCase();
            // Comprobamos que la extensión sea una de las válidas para el sudoku   
            if (extension.matches("TXT")) {
                isExtensionValida = true;
            }
        }

        return isExtensionValida;
    };

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
            java.util.logging.Logger.getLogger(SudokuGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SudokuGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SudokuGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SudokuGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SudokuGUI().setVisible(true);
            }
        });
    }

    private ModeloSudoku modelo;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbComprobarSudoku;
    private javax.swing.JLabel jlTitulo;
    private javax.swing.JMenu jmArchivo;
    private javax.swing.JMenuBar jmbMenu;
    private javax.swing.JMenuItem jmiCargar;
    private javax.swing.JMenuItem jmiGuardar;
    private javax.swing.JTable jtSudoku;
    // End of variables declaration//GEN-END:variables
}
