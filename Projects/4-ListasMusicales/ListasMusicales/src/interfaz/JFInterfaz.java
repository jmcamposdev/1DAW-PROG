package interfaz;

import java.awt.Toolkit;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import modelo.Cancion;
import modelo.Formato;
import modelo.ModeloListaCanciones;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
/**
 *
 * @author josemaria
 */
public class JFInterfaz extends javax.swing.JFrame {

    /**
     * Creates new form InterfazJF
     */
    public JFInterfaz() {
        initComponents();
        inicializar();
    }
    
    /**
     * Método el cúal inicializa la lista de Canciones y 
     * crea y asigna el modelo al JTable
     */
    private void inicializar() {
        this.listaCanciones = new ArrayList<>(); // Inicializamos la lista de Canciones
        this.modelo = new ModeloListaCanciones(); // Creamos el Modelo de las Canciones
        this.jtListaCanciones.setModel(modelo); // Asignamos el Modelo al JTable
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpmMenuCancion = new javax.swing.JPopupMenu();
        jpmiEliminarCancion = new javax.swing.JMenuItem();
        jpmiModificarCancion = new javax.swing.JMenuItem();
        jpmMenuMultipleEleccion = new javax.swing.JPopupMenu();
        jpmiEliminarMultiplesCanciones = new javax.swing.JMenuItem();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtListaCanciones = new javax.swing.JTable();
        jlTitulo = new javax.swing.JLabel();
        jbAñadirCancion = new javax.swing.JButton();
        jbEliminarCancion = new javax.swing.JButton();
        jbModificarCancion = new javax.swing.JButton();
        jbCrearLista = new javax.swing.JButton();
        jbGuardar = new javax.swing.JButton();
        jlArchivo = new javax.swing.JLabel();
        jbCargar = new javax.swing.JButton();
        jmbMenu = new javax.swing.JMenuBar();
        jmArchivo = new javax.swing.JMenu();
        jmiGuardar = new javax.swing.JMenuItem();
        jmiCargar = new javax.swing.JMenuItem();
        jmListas = new javax.swing.JMenu();
        jmiCrearLista = new javax.swing.JMenuItem();
        jmCancion = new javax.swing.JMenu();
        jmiAñadirCancion = new javax.swing.JMenuItem();
        jmiEliminarCancion = new javax.swing.JMenuItem();
        jmiModificarCancion = new javax.swing.JMenuItem();

        jpmiEliminarCancion.setText("Eliminar");
        jpmiEliminarCancion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jpmiEliminarCancionActionPerformed(evt);
            }
        });
        jpmMenuCancion.add(jpmiEliminarCancion);

        jpmiModificarCancion.setText("Modificar");
        jpmiModificarCancion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jpmiModificarCancionActionPerformed(evt);
            }
        });
        jpmMenuCancion.add(jpmiModificarCancion);

        jpmiEliminarMultiplesCanciones.setText("Eliminar Canciones");
        jpmiEliminarMultiplesCanciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jpmiEliminarMultiplesCancionesActionPerformed(evt);
            }
        });
        jpmMenuMultipleEleccion.add(jpmiEliminarMultiplesCanciones);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jtListaCanciones.setModel(new javax.swing.table.DefaultTableModel(
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
        jtListaCanciones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtListaCancionesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtListaCanciones);

        jlTitulo.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jlTitulo.setText("LISTA CANCIONES");

        jbAñadirCancion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/add.png"))); // NOI18N
        jbAñadirCancion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAñadirCancionActionPerformed(evt);
            }
        });

        jbEliminarCancion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/delete.png"))); // NOI18N
        jbEliminarCancion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEliminarCancionActionPerformed(evt);
            }
        });

        jbModificarCancion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/modify.png"))); // NOI18N
        jbModificarCancion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbModificarCancionActionPerformed(evt);
            }
        });

        jbCrearLista.setText("Crear Lista");
        jbCrearLista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCrearListaActionPerformed(evt);
            }
        });

        jbGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/export.png"))); // NOI18N
        jbGuardar.setText("Exportar");
        jbGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbExportarActionPerformed(evt);
            }
        });

        jlArchivo.setText("Archivo:");

        jbCargar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/import.png"))); // NOI18N
        jbCargar.setText("Importar");
        jbCargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbImportarActionPerformed(evt);
            }
        });

        jmArchivo.setMnemonic('A');
        jmArchivo.setText("Archivo");

        jmiGuardar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
        jmiGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/export.png"))); // NOI18N
        jmiGuardar.setText("Exportar");
        jmiGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiExportarActionPerformed(evt);
            }
        });
        jmArchivo.add(jmiGuardar);

        jmiCargar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
        jmiCargar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/import.png"))); // NOI18N
        jmiCargar.setText("Importar");
        jmiCargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiImportarActionPerformed(evt);
            }
        });
        jmArchivo.add(jmiCargar);

        jmbMenu.add(jmArchivo);

        jmListas.setMnemonic('L');
        jmListas.setText("Listas");

        jmiCrearLista.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
        jmiCrearLista.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/add.png"))); // NOI18N
        jmiCrearLista.setText("Crear Lista");
        jmiCrearLista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiCrearListaActionPerformed(evt);
            }
        });
        jmListas.add(jmiCrearLista);

        jmbMenu.add(jmListas);

        jmCancion.setMnemonic('C');
        jmCancion.setText("Cancion");

        jmiAñadirCancion.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask() | InputEvent.SHIFT_DOWN_MASK));
        jmiAñadirCancion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/add.png"))); // NOI18N
        jmiAñadirCancion.setText("Añadir");
        jmiAñadirCancion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiAñadirCancionActionPerformed(evt);
            }
        });
        jmCancion.add(jmiAñadirCancion);

        jmiEliminarCancion.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
        jmiEliminarCancion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/delete.png"))); // NOI18N
        jmiEliminarCancion.setText("Eliminar");
        jmiEliminarCancion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiEliminarCancionActionPerformed(evt);
            }
        });
        jmCancion.add(jmiEliminarCancion);

        jmiModificarCancion.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
        jmiModificarCancion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/modify.png"))); // NOI18N
        jmiModificarCancion.setText("Modificar");
        jmiModificarCancion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiModificarCancionActionPerformed(evt);
            }
        });
        jmCancion.add(jmiModificarCancion);

        jmbMenu.add(jmCancion);

        setJMenuBar(jmbMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(156, 156, 156)
                        .addComponent(jlTitulo))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jlArchivo)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jbCargar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jbGuardar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(jbCrearLista))
                                .addGap(81, 81, 81)
                                .addComponent(jbAñadirCancion)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jbEliminarCancion)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jbModificarCancion)))))
                .addContainerGap(57, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlTitulo)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbAñadirCancion)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jbModificarCancion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jbCrearLista, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jbEliminarCancion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jlArchivo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbCargar)))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Método que se ejecuta cuando se realiza click al JTable.
     * Si se selecciona una canción y realizar un Click Derecho se muestra un
     * Popup Menu con (Eliminar, Modificar).
     * Si realizar doble click sobre una canción se abre un JDialog para modificar la canción
     * Si selecciona varias canciones y realiza click derecho se muestra un Popup Menu
     * con la opción "Eliminar Canciones".
     * @param evt 
     */
    private void jtListaCancionesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtListaCancionesMouseClicked
        int[] columnasSeleccionadas = jtListaCanciones.getSelectedRows(); // Obtenemos la lista de los indice de las canciones seleccionadas
        if (columnasSeleccionadas.length == 1) { // Si selecciona una canción
            if (evt.getButton() == MouseEvent.BUTTON3) { // Si realiza click Derecho
                // Mostramos  el Menú
                jpmMenuCancion.show(jtListaCanciones, evt.getX(), evt.getY());
            } else if (evt.getClickCount() == 2) { // Si realiza Doble Click
                modificarCancion(); // Modificamos la canción
            }
        } else if (evt.getButton() == MouseEvent.BUTTON3) {  // Si selecciona varias canciones mostramos el menú indicado
            jpmMenuMultipleEleccion.show(jtListaCanciones, evt.getX(), evt.getY());
        }
    }//GEN-LAST:event_jtListaCancionesMouseClicked

    /**
     * Acción llamada cuando se realiza click en el Botón "Crear Lista".
     * Llama al método crearLista().
     * @param evt Action Event
     */
    private void jbCrearListaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCrearListaActionPerformed
        crearLista();
    }//GEN-LAST:event_jbCrearListaActionPerformed

    /**
     * Acción llamada cuando se realiza click en el Menu Item "Crear Lista".
     * Llama al método crearLista().
     * @param evt Action Event
     */
    private void jmiCrearListaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiCrearListaActionPerformed
        crearLista();
    }//GEN-LAST:event_jmiCrearListaActionPerformed

    /**
     * Acción llamada cuando se realiza click en el Botón "+" (Añadir Canción).
     * Llama al método añadirCancion().
     * @param evt Action Event
     */
    private void jbAñadirCancionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAñadirCancionActionPerformed
        añadirCancion();
    }//GEN-LAST:event_jbAñadirCancionActionPerformed

    /**
     * Acción llamada cuando se realiza click en el Menu Item "Añadir Canción".
     * Llama al método crearCancion().
     * @param evt Action Event
     */
    private void jmiAñadirCancionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiAñadirCancionActionPerformed
        añadirCancion();
    }//GEN-LAST:event_jmiAñadirCancionActionPerformed

    /**
     * Acción llamada cuando se realiza click en el Menu Item "Eliminar Cancion".
     * Llama al método eliminarCancion().
     * @param evt Action Event
     */
    private void jmiEliminarCancionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiEliminarCancionActionPerformed
        eliminarCancion();
    }//GEN-LAST:event_jmiEliminarCancionActionPerformed

    /**
     * Acción llamada cuando se realiza click en el Botón "Eliminar Canción".
     * Llama al método eliminarCancion().
     * @param evt Action Event
     */
    private void jbEliminarCancionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEliminarCancionActionPerformed
        eliminarCancion();
    }//GEN-LAST:event_jbEliminarCancionActionPerformed

    /**
     * Acción llamada cuando se realiza click en el Menu Popup "Eliminar Canción".
     * Llama al método eliminarCancion().
     * @param evt Action Event
     */
    private void jpmiEliminarCancionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jpmiEliminarCancionActionPerformed
        eliminarCancion();
    }//GEN-LAST:event_jpmiEliminarCancionActionPerformed

    /**
     * Acción llamada cuando se realiza click en el Botón "Modificar Canción".
     * Llama al método modificarCancion().
     * @param evt Action Event
     */
    private void jbModificarCancionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbModificarCancionActionPerformed
        modificarCancion();
    }//GEN-LAST:event_jbModificarCancionActionPerformed

    /**
     * Acción llamada cuando se realiza click en el Menu Popup "Modificar Canción".
     * Llama al método modificarCancion().
     * @param evt Action Event
     */
    private void jpmiModificarCancionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jpmiModificarCancionActionPerformed
        modificarCancion();
    }//GEN-LAST:event_jpmiModificarCancionActionPerformed

    /**
     * Acción llamada cuando se realiza click en el Menu Item "Modificar Canción".
     * Llama al método modificarCancion().
     * @param evt Action Event
     */
    private void jmiModificarCancionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiModificarCancionActionPerformed
        modificarCancion();
    }//GEN-LAST:event_jmiModificarCancionActionPerformed

    /**
     * Acción llamada cuando se realiza click en el Menu Item "Exportar Lista".
     * Llama al método exportarLista().
     * @param evt Action Event
     */
    private void jmiExportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiExportarActionPerformed
        exportarLista();
    }//GEN-LAST:event_jmiExportarActionPerformed
    
    /**
     * Acción llamada cuando se realiza click en el Botón "Exportar Lista".
     * Llama al método exportarLista().
     * @param evt Action Event
     */
    private void jbExportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbExportarActionPerformed
        exportarLista();
    }//GEN-LAST:event_jbExportarActionPerformed

    /**
     * Acción llamada cuando se realiza click en el Botón "Importar Lista".
     * Llama al método importarLista().
     * @param evt Action Event
     */
    private void jbImportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbImportarActionPerformed
        importarFichero();
    }//GEN-LAST:event_jbImportarActionPerformed

    /**
     * Acción llamada cuando se realiza click en el Menu Item "Importar Lista".
     * Llama al método importarLista().
     * @param evt Action Event
     */
    private void jmiImportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiImportarActionPerformed
        importarFichero();
    }//GEN-LAST:event_jmiImportarActionPerformed

    /**
     * Acción llamada cuando se realiza click en el Menu Item "Eliminar Canciones".
     * Llama al método eliminarCancion().
     * @param evt Action Event
     */
    private void jpmiEliminarMultiplesCancionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jpmiEliminarMultiplesCancionesActionPerformed
        eliminarCancion();
    }//GEN-LAST:event_jpmiEliminarMultiplesCancionesActionPerformed

    
    
    /**
     * Método para exportar las canciones a un archivo (M3U, PLS, XSPF).
     * Deben de existir canciones para exportar.
     * Se abrirá un JFileChooser al cual estar filtrador por las extensiones.
     * Se validará que el fichero posea una extensión válida en caso contrario se le informa del error,
     * Si el fichero existe se preguntará si se desea sobreescribir en caso afirmativo se procede a escribir en el fichero
     * Si el fichero no existe directamente se crea y se escribe.
     * Se selecciona el formato a través de la extensión
     */
    private void exportarLista() {
        if (listaCanciones.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No existen canciones para exportar", "Error", JOptionPane.WARNING_MESSAGE);
        } else {
            JFileChooser gestorArchivos = crearFileChooserLista(); // Creamos el FileChooser
            int option = gestorArchivos.showSaveDialog(this); // Mostramos el JFileChooser
            if (option == JFileChooser.APPROVE_OPTION) { // Si ha seleccionado un fichero o lo ha escrito
                File selectedFile = gestorArchivos.getSelectedFile(); // Obtenemos le Fichero
                
                if (!validarExtensionListadoPredicate.test(selectedFile.getName())) { // Si no es válida la extensión
                    JOptionPane.showMessageDialog(this, "El fichero Seleccionada no posee una extensión válida (m3u, pls, xspf)", "Error", JOptionPane.WARNING_MESSAGE);
                } else { // Si la extensión es válida
                    
                    boolean escribirFichero = true;
                    if (selectedFile.exists()) { // Si el fichero existe
                        // Mostramos confirmación para sobreescribirlo
                        int optionSobreEscribir = JOptionPane.showConfirmDialog(this, "Deseas sobreescribir el fichero", "Sobreescribir", JOptionPane.YES_NO_CANCEL_OPTION);
                        if (optionSobreEscribir != JOptionPane.OK_OPTION) { // Si no desea sobreescribirlo
                            escribirFichero = false; // No lo escribimos
                        }
                    } 
                    
                    if (escribirFichero) { // Si se escribe en el fichero
                        // Obtenemos el formato y lo guardamos en el formato correspondiente
                        switch (getFormato(selectedFile.getName())) {  // Guardamos en la extensión correspondiente
                            case M3U -> guardarListaM3U(selectedFile);
                            case PLS -> guardarListaPLS(selectedFile);
                            case XSPF -> guardarListaXSPF(selectedFile);
                        } 
                    }
                }
            }
        }
    }
    
    /**
     * Método para importar las canciones al programa.
     * Se abrirá un JFileChooser el cual posee un filtro por extensiones las cuales son (M3U, PLS, XSPF).
     * Una vez que el usuario ha seleccionado el fichero sé válida que exista y que la extensión sea válida.
     * Por último se llama al método correspondiente dependiendo de la extensión.
     */
    private void importarFichero() {
        JFileChooser gestorArchivo = crearFileChooserLista(); // Creamos el JFileChooser
        int option = gestorArchivo.showOpenDialog(this); // Mostramos el JFileChooser
        if (option == JFileChooser.OPEN_DIALOG) { // Si ha seleccionado un fichero 
            File selectedFile = gestorArchivo.getSelectedFile(); // Obtenemos el fichero seleccionado
            
            if (validSelectedFile(selectedFile)) { // Comprobamos si el fichero existe y posee una extensión válida
                // Limpiamos tanto la Lista como el JTable de canciones
                listaCanciones.clear(); 
                modelo.clear();
                
                // Obtenemos el formato y lo importamos
                switch (getFormato(selectedFile.getName())) {
                    case M3U -> cargarListaM3U(selectedFile);
                    case PLS -> cargarListaPLS(selectedFile);
                    case XSPF -> cargarListaXSPF(selectedFile);
                }
            }
        }
    }
    
    
    /**
     * Método para guardar la lista en Formato M3U
     * Crea o sobreescribe el fichero y escribe todas las canciones respetando el formato.
     * Se informa si se ha realizado con exito como si se ha producido un error al escribir el fichero
     * @param file El fichero en el que se guardara las canciones
     */
    private void guardarListaM3U(File file) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            bw.write("#EXTM3U" +  NEW_LINE); // Escribimos la Cabecera
            
            /* 
                Obtenemos el String con todas las canciones con el formato asignado
                EJ:     #EXTINF:315,David Bowie - Space Oddity 
                        Music/David Bowie/Singles 1/01-Space Oddity.ogg
                Gracias al Stream iteramos cada canción y la convertimos en un String con el formato.
                Por último unimos todos los String de las canciones con un salto de Línea
                Es más óptimo que escribir en cada iteración
            */
            String canciones = listaCanciones.stream()
                .map(c -> "#EXTINF:" + (c.getDuracion() == 0 ? -1 : c.getDuracion()) + "," + c.getTitulo() + NEW_LINE + c.getRuta())
                .collect(Collectors.joining(NEW_LINE));
            
            bw.write(canciones); // Escribimos las canciones en el fichero
            JOptionPane.showMessageDialog(this, "Se ha guardado la lista correctamente en:" + NEW_LINE + file.getAbsolutePath(), "Éxito", JOptionPane.INFORMATION_MESSAGE); // Informamos al Usuario del Exito
        } catch (IOException ex) {
            // Informamos que se ha producido un error al escribir
            JOptionPane.showMessageDialog(this, "No se ha guardado la lista.","Error", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    /**
     * Método para guardar la lista en Formato PLS
     * Crea o sobreescribe  el fichero y escribe todas las canciones respetando el formato.
     * Se informa si se ha realizado con exito como si se ha producido un error al escribir el fichero
     * @param file El fichero en el que se guardara las canciones
     */
    private void guardarListaPLS(File file) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            bw.write("[playlist]" + NEW_LINE); // Escribimos la cabecera
            
            // Convertimos todas las canciones en su formato
            StringBuilder canciones = new StringBuilder();
            int contador = 0;
            for (Cancion c : listaCanciones) {
                canciones.append("File").append(++contador).append("=").append(c.getRuta()).append(NEW_LINE);
                canciones.append("Title").append(contador).append("=").append(c.getTitulo()).append(NEW_LINE);
                canciones.append("Length").append(contador).append("=").append((c.getDuracion() == 0 ? -1 : c.getDuracion())).append(NEW_LINE);
            }

            bw.write(canciones.toString()); // Escribimos las canciones
            bw.write("NumberOfEntries=" + (contador) +  NEW_LINE); // Escribimos el número de canciones que existen en el fichero
            bw.write("Version=2"); // Escribimos la versión del formato
            JOptionPane.showMessageDialog(this, "Se ha guardado la lista correctamente en:" + NEW_LINE+ file.getAbsolutePath(), "Éxito", JOptionPane.INFORMATION_MESSAGE); // Informamos al Usuario del Exito
        } catch (IOException ex) {
            // Informamos que se ha producido un error al escribir
            JOptionPane.showMessageDialog(this, "No se ha guardado la lista.","Error", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    /**
     * Método para guardar la lista en Formato XSPF
     * Crea o sobreescribe  el fichero y escribe todas las canciones respetando el formato.
     * Se informa si se ha realizado con exito como si se ha producido un error al escribir el fichero
     * @param file El fichero en el que se guardara las canciones
     */
    private void guardarListaXSPF(File file) {
        try {
            DocumentBuilder docBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            
            // Documento
            Document doc = docBuilder.newDocument();
            
            // Creamos el elemento playlist con atributos de versión y espacio de nombres
            Element rootElement = doc.createElement("playlist");
            rootElement.setAttribute("version", "1");
            rootElement.setAttribute("xmlns", "http://xspf.org/ns/0/");
            
            // Creamos el elemento trackList para contener las canciones
            Element trackList = doc.createElement("trackList");
            // Agregamos el elemento trackList como hijo de playlist
            rootElement.appendChild(trackList);
            
            // Track
            for (Cancion c : listaCanciones) {
                Element track = doc.createElement("track"); // Creamos el Track
                
                // Convertimos la duracion de Segundos a Milisegundos
                int durationValue = c.getDuracion() == 0 ? 0 : c.getDuracion()*1000;                
                // Añadimos los elementos location, title, duration como hijos de tack
                track.appendChild(createElementWithTextContent(doc, "location", c.getRuta()));
                track.appendChild(createElementWithTextContent(doc, "title", c.getTitulo()));
                track.appendChild(createElementWithTextContent(doc, "duration", String.valueOf(durationValue)));

                // Agregamos el elemento track como hijo de trackList
                trackList.appendChild(track);
            }

            // Añadimos todo al documento
            doc.appendChild(rootElement);

            // Creamos el Transformer para transformar a XML
            Transformer tranformer = TransformerFactory.newInstance().newTransformer();
            
            tranformer.setOutputProperty(OutputKeys.INDENT, "yes"); // Indentar el Documento XML
            tranformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8"); // Establece la codificación en UTF-8
            
            // Creamos un objeto StreamResult que especifica el archivo donde se guardará el resultado de la transformación
            StreamResult result = new StreamResult(file);
            // Creamos un objeto DOMSource que contiene el documento XML a transformar
            DOMSource source = new DOMSource(doc);
            
            // Transformamos el documento XML contenido en el objeto DOMSource en el resultado especificado por el objeto StreamResult
            tranformer.transform(source, result);
            
            JOptionPane.showMessageDialog(this, "Se ha guardado la lista correctamente en:" + NEW_LINE + file.getAbsolutePath()); // Informamos al Usuario del Exito

        } catch (TransformerException | ParserConfigurationException ex) {
            JOptionPane.showMessageDialog(this, "No se ha podido crear el fichero", "Error", JOptionPane.WARNING_MESSAGE);
        }
    }
   
    /**
     * Método el cual crea un elemento con la etiqueta
     * pasada por parámetro asignándole contenido en su interior.
     * @param doc Documento XML
     * @param tagName Nombre de la Etiqueta XML
     * @param textContent Texto del interior de la etiqueta
     * @return Devuelve un elemento XML
     */
    private Element createElementWithTextContent(Document doc, String tagName, String textContent) {
        Element element = doc.createElement(tagName); // Creamos un nuevo elemento con el nombre de etiqueta especificado
        element.setTextContent(textContent); // Establecemos el contenido de texto del elemento
        return element; // Devolvemos el elemento creado
    }

    /**
     * Método para cargar el contenido de un Fichero M3U pasado por parámetro
     * Lee el contenido y lo formatea para obtener los datos necesarios
     * Se informa al usuario con un JOptionPane si se ha cargado correctamente o informa del error y la línea
     * @param file El Fichero M3U para leer su contenido
     */
    private void cargarListaM3U (File file) {
        int linea = 1; // Contador para llevar registro de la línea actual en el archivo

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            // Saltar las líneas vacías al principio del archivo
            String line;
            while ((line = br.readLine()) != null && line.trim().isEmpty())linea++;

            if (!Objects.equals(line, "#EXTM3U")) { // Verificamos que la primera línea sea "#EXTM3U"
                throw new IOException();
            }
            
            int numCancionesCargadas = 0; // Almacenamos el número de Canciones agregadas
            String cadDuracionYNombre; // Cadena que contiene la duración y el nombre de la canción
            String cadRuta;  // Cadena que contiene la ruta de la canción
            Cancion cancion;
            while ((cadDuracionYNombre = br.readLine()) != null && (cadRuta = br.readLine()) != null) {
                linea++; // Aumentamos el contador de línea
                if (!cadDuracionYNombre.startsWith("#EXTINF:")) { // Si la cadena no empieza por el formato M3U lanzar excepción
                    throw new IOException();
                }
                String[] duracionYTitulo = cadDuracionYNombre.substring(cadDuracionYNombre.indexOf(":")+1).split(","); // Separamos la duración y el nombre de la canción en un array
                int duracionValue = Integer.parseInt(duracionYTitulo[0]); // Convertimos la duración de la canción a entero
                duracionValue = duracionValue == -1 ? 0 : duracionValue; // Si la duración es -1, la cambiamos a 0
                cancion = new Cancion(duracionYTitulo[1], cadRuta, duracionValue); // Creamos un objeto Cancion con la información obtenida

                listaCanciones.add(cancion); // Añadimos la canción a la lista de canciones
                modelo.añadirCancion(cancion); // Añadimos la canción al JTable
                numCancionesCargadas++; // Aumentamos el número de canciones agregadas
                linea++; // Aumentamos el contador de línea
            }
            
            // Mostramos un mensaje de éxito al usuario
            JOptionPane.showMessageDialog(this, "Se han cargado en la lista "+numCancionesCargadas+" canciones con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException | ArrayIndexOutOfBoundsException | NumberFormatException ex) {
            // Mostramos un mensaje de error al usuario con el número de línea donde se produjo el error
            JOptionPane.showMessageDialog(this, "Formato erróneo del archivo, error en la línea " + linea,"Error", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    /**
     * Método para cargar el contenido de un Fichero PLS pasado por parámetro
     * Lee el contenido y lo formatea para obtener los datos necesarios
     * Se informa al usuario con un JOptionPane si se ha cargado correctamente o informa del error y la línea
     * @param file El Fichero PLS para leer su contenido
     */
    private void cargarListaPLS(File file) {
        int linea = 1; // variable para llevar un seguimiento de la línea actual del archivo
        int numCancionesCargadas = 0; // variable para contar el número de canciones cargadas correctamente
        try (Scanner scanner = new Scanner(file)) {
            // Saltar las líneas vacías al principio del archivo
            String lineaFile;
            while ((lineaFile = scanner.nextLine()) != null && lineaFile.trim().isEmpty()){
                linea++;
            }
            
            if (!lineaFile.equals("[playlist]")) { // Si no empieza con la cabecera
                throw new IllegalArgumentException(); // Lanzar Excepción
            }
            int numEntradasCount = 0; // Contador de Entradas (Canciones) leídas
            int numEntradasFile = -1; // Contador de Canciones definido en el fichero
            
            while (scanner.hasNextLine()) { // Se lee el archivo línea por línea
                if (lineaFile.startsWith("File")) { // Si empieza con File
                    numEntradasCount++; // Sumamos una Entrada
                    linea++; // Sumamos una línea
                    String ruta = lineaFile.substring(lineaFile.indexOf("=") + 1); // Obtenemos la Ruta
                    String lineaTitulo = scanner.nextLine(); // Leemos el Título
                    linea++; // Sumamos una línea
                    String titulo = lineaTitulo.substring(lineaTitulo.indexOf("=") + 1); // Obtenemos el Título
                    String lineaDuracion = scanner.nextLine(); // Leemos la Duración
                    linea++; // Sumamos una línea
                    int duracion = Integer.parseInt(lineaDuracion.substring(lineaDuracion.indexOf("=") + 1)); // Obtenemos la Duración
                    duracion = duracion == -1 ? 0 : duracion;

                    // Creamos y añadimos la canción
                    Cancion cancion = new Cancion(titulo, ruta, duracion); // Se crea un objeto Cancion
                    listaCanciones.add(cancion); // Se añade la canción a la lista de canciones
                    modelo.añadirCancion(cancion); // Se añade la canción al modelo de la lista de canciones
                    numCancionesCargadas++; // Se incrementa el contador de canciones cargadas
                }
                lineaFile = scanner.nextLine(); // Leemos la siguiente línea
                linea++; // Se incrementa la variable de línea
                if (lineaFile.startsWith("NumberOfEntries")) { // Si empieza por NumberOfEntries
                    // Obtenemos el número de canciones definidas en el fichero
                    numEntradasFile = Integer.parseInt(lineaFile.substring(lineaFile.indexOf("=") + 1));
                }
            }
            if (numEntradasCount > 0) { // Si se ha añadido canciones
                if (numEntradasFile != numEntradasCount) { // Si no coinciden las canciones añadidas con el número de canciones definidas en el fichero
                    // Limpiamos las Canciones
                    this.listaCanciones.clear(); 
                    this.modelo.clear();
                    // Mostramos un mensaje de Error
                    JOptionPane.showMessageDialog(this, "El numero de canciones obtenidas es"+ numEntradasCount +"y el número de canciones definidas en el fichero es " + numEntradasFile, "Error", JOptionPane.WARNING_MESSAGE);
                } else { // Si coinciden los números mostramos mensaje de Éxito
                    JOptionPane.showMessageDialog(this, "Se han cargado en la lista "+numCancionesCargadas+" canciones con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }   catch (FileNotFoundException | IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(this, "Formato erróneo del archivo, error en la línea " + linea,"Error", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    /**
     * Método para cargar el contenido de un Fichero XSPF pasado por parámetro
     * Lee el contenido y lo formatea para obtener los datos necesarios
     * Se informa al usuario con un JOptionPane si se ha cargado correctamente o informa del error y la línea
     * @param file El Fichero XSPF para leer su contenido
     */
    private void cargarListaXSPF(File file) {
        try {
            int numCancionesCargadas = 0;
            boolean invalidXSPF = false;
            String errorMessage = "";
            
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance(); // Creamos el Factory
            DocumentBuilder db = dbf.newDocumentBuilder(); // Inicializamos un nuevo Documento
            Document doc = db.parse(file); // Cargamos el XSPF
            
            NodeList list = doc.getElementsByTagName("track"); // Buscamos todos los track
            
            for (int temp = 0; temp < list.getLength() && !invalidXSPF; temp++) { // Iteramos todos los track
                Node node = list.item(temp); // Obtenemos el track
                if (node.getNodeType() == Node.ELEMENT_NODE) { // Si es un elemento
                    Element element = (Element) node; // Transformamos el Node (Track) a Element

                    Node tituloNode = element.getElementsByTagName("title").item(0); // Obtenemos el elemento <title>
                    Node rutaNode = element.getElementsByTagName("location").item(0); // Obtenemos el elemento <location>
                    Node duracionNode = element.getElementsByTagName("duration").item(0); // Obtenemos el elemento <duration>

                    if (tituloNode == null) { // Si no existe el elemento <title>
                       invalidXSPF = true; // El XSPF es inválido
                       errorMessage = "No se ha encontrado la etiqueta <title> en el <track> numero " + (temp+1); // Mensaje de Error
                    }
                    if (!invalidXSPF && rutaNode == null) { // Si el XSPF es válido y no existe el elemento <location>
                       invalidXSPF = true; // El XSPF es inválido
                       errorMessage = "No se ha encontrado la etiqueta <location> en el <track> numero " + (temp+1); // Mensaje de Error
                    }
                    if (!invalidXSPF && duracionNode == null) { // Si el XSPF es válido y no existe el elemento <duration>
                       invalidXSPF = true; // El XSPF es inválido
                       errorMessage = "No se ha encontrado la etiqueta <duration> en el <track> numero " + (temp+1); // Mensaje de Error
                    }

                    if (!invalidXSPF) { // Si es válido el XSPF
                        // Obtenemos el contenido del <title>
                        String titulo = element.getElementsByTagName("title").item(0).getTextContent(); 
                        // Obtenemos el contenido del <location>
                        String ruta = element.getElementsByTagName("location").item(0).getTextContent();
                        // Obtenemos el contenido del <duration>
                        String duration = element.getElementsByTagName("duration").item(0).getTextContent();
                        

                        // Creamos la canción
                        int durationValue = Integer.parseInt(duration);
                        durationValue = durationValue == 0 ? 0 : durationValue/1000;
                        
                        Cancion cancion = new Cancion(titulo, ruta, durationValue);
                        // Añadimos la cancion a la Lista y el JTable
                        listaCanciones.add(cancion);
                        modelo.añadirCancion(cancion);
                        numCancionesCargadas++; // Aumentamos las canciones añadidas
                    }
                    
                }
            } 
            
            if (numCancionesCargadas == 0) { // Si no se ha añadido ninguna canción
                invalidXSPF = true; // El XSPF es invalido
                errorMessage = "No se ha encontrado las etiquetas <track>"; // Mensaje de Error
            }
            
            if (invalidXSPF) { // Si es invalido el XSPF
                // Borramos los datos insertados
                this.listaCanciones.clear();
                this.modelo.clear();
                // Mostramos el mensaje personalizado
                JOptionPane.showMessageDialog(this, errorMessage, "Error", JOptionPane.WARNING_MESSAGE);
            } else { // Si es válido el XSPF
                    JOptionPane.showMessageDialog(this, "Se han cargado en la lista "+numCancionesCargadas+" canciones con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            }
            
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            JOptionPane.showMessageDialog(this, "Formato de XSPF no válido." + NEW_LINE + "Error: " + ex.getMessage(), "Error", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    
    /**
     * Método para crear una nueva Lista 
     * borra el contenido de la lista y del JTable.
     * Se informa al usuario que se ha creado una nueva Lista.
     */
    private void crearLista() {
        this.listaCanciones.clear();
        this.modelo.clear();
        JOptionPane.showMessageDialog(this, "Se ha creado una nueva Lista", "Nueva Lista", JOptionPane.INFORMATION_MESSAGE);
    }
    
    /**
     * Método para añadir una nueva Canción
     * Crea un JDCancion y si la ha creado la cancion
     * la añadimos a la lista y al JTable
     */
    private void añadirCancion() {
        JDCancion jDCrearCancion = new JDCancion(this, true); // Creamos el JDialog
        jDCrearCancion.setVisible(true); // Lo hacemos visible
        
        if (jDCrearCancion.isCancionCreadaOModificada()) { // Si ha creado la canción
            Cancion nuevaCancion = jDCrearCancion.getCancion(); // Obtenemos la canción
            // Añadimos la Canción a la Lista y al JTable
            listaCanciones.add(nuevaCancion);
            modelo.añadirCancion(nuevaCancion);
        }
    }
    
    /**
     * Método par eliminar una canción o varias.
     * Si no ha seleccionado ninguna canción se le informa.
     * Si ha seleccionado alguna canción o varias del JTable se
     * pregunta al usuario si desea realizar la acción.
     * Si hace click en "Si" se procede a eliminar las canciones.
     */
    private void eliminarCancion() {
        int[] indices = jtListaCanciones.getSelectedRows();
        if (indices.length == 0) { // Si no ha seleccionado ninguna canción
            JOptionPane.showMessageDialog(this, "No has seleccionado ninguna canción", "Error", JOptionPane.WARNING_MESSAGE); 
        } else { // Si ha seleccionado alguna canción
            // Mostramos mensaje de confirmación
            int option = JOptionPane.showConfirmDialog(this, "Deseas eliminar la canción.", "Eliminar", JOptionPane.YES_NO_CANCEL_OPTION);
            if (option == JOptionPane.OK_OPTION) { // Si realiza la confirmación
                if (indices.length == 1) {
                    // Eliminamos la canción de la Lista y el JTable
                    listaCanciones.remove(indices[0]);
                    modelo.eliminarCancion(indices[0]);
                } else {
                    ArrayList<Cancion> cancionesAEliminar = new ArrayList<>(); // Array con las canciones a eliminar
        
                    for (int i = 0; i < indices.length; i++) { // Obtenemos todas las canciones a eliminar
                        cancionesAEliminar.add(listaCanciones.get(indices[i]));
                    }
                    // Eliminamos las canciones de la lista y del Modelo
                    listaCanciones.removeAll(cancionesAEliminar);
                    modelo.removeAll(cancionesAEliminar);
                }
                
            }
        }
    }
    
    /**
     * Método para modificar una Canción seleccionada del JTable.
     * Si no ha seleccionado ninguna canción se le informa o si
     * ha seleccionado más de una también se le informa.
     * Si ha seleccionado solo una canción se abre un JDialog
     * con los datos de la Canción seleccionada cargados
     * si realiza cualquier modificación se comprueba si es así
     * y a pulsado "Actualizar" se procese a cambiar la canción por
     * la actualizada.
     */
    private void modificarCancion() {
        int[] indices = jtListaCanciones.getSelectedRows();
        if (indices.length == 0) { // Si no ha seleccionado ninguna canción
            JOptionPane.showMessageDialog(this, "No has seleccionado ninguna canción", "Error", JOptionPane.WARNING_MESSAGE); 
        } else if (indices.length > 1){ // Si ha seleccionado mas de 1 canción
            JOptionPane.showMessageDialog(this, "Tienes varias canciones seleccionadas, por favor seleccione una sola.", "Error", JOptionPane.WARNING_MESSAGE);
        } else { // Si ha seleccionado una canción
            // Creamos y mostramos el JDialog
            JDCancion jDEditarCancion = new JDCancion(this, true, new Cancion(listaCanciones.get(indices[0])));
            jDEditarCancion.setVisible(true);

            if (jDEditarCancion.isCancionCreadaOModificada()) { // Si la cancion ha sido modificada
                Cancion cancionActualizada = jDEditarCancion.getCancion(); // Obtenemos la Canción modificada
                // Actualizamos la canción
                listaCanciones.set(indices[0], cancionActualizada);
                modelo.setCancion(indices[0], cancionActualizada);
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
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFInterfaz().setVisible(true);
            }
        });
    }

    /**
     * Método que valida si el fichero pasado por parámetro
     * existe y si posee la extensión valida la cuales son (M3U, PLS, XSPF)
     * @param selectedFile El fichero a validar
     * @return Devuelve True si el fichero existe y posse la extensión válida en caso contrario False
     */
    private boolean validSelectedFile (File selectedFile) {
        boolean validFile = true;
        
        if (!selectedFile.exists()) {
            JOptionPane.showMessageDialog(this, "El fichero seleccionado no existe", "Error", JOptionPane.WARNING_MESSAGE);
            validFile = false;
        } else if (!validarExtensionListadoPredicate.test(selectedFile.getName())) {
            JOptionPane.showMessageDialog(this, "La extensión del fichero es inválida\n Extensiones válidas: M3U, PLS, XSPF", "Error", JOptionPane.WARNING_MESSAGE);
            validFile = false;
        }
        
        return validFile;
    }
    
    /**
     * Método que devuelve un JFileChooser 
     * con el Filtro de Listas las cuales son (M3U, PLS , XSPF)
     * y solo deja elegir ficheros.
     * @return Devuelve un Objeto JFileChooser.
     */
    private JFileChooser crearFileChooserLista () {
        JFileChooser gestorArchivos = new JFileChooser(); // Creamos el JFileChooser
        gestorArchivos.removeChoosableFileFilter( gestorArchivos.getFileFilter()); // Eliminamos el Filtro por defecto (Todos)
        // Creamos el filtro para extensiones m3u, pls, xspf
        gestorArchivos.setFileFilter(this.filter); // Asignamos el Filtro de Extensiones
        gestorArchivos.setFileSelectionMode(JFileChooser.FILES_ONLY); // Permitimos solo que pueda seleccionar archivos
        return gestorArchivos;
    }
    
    /**
     * Método que devuelve el ENUM Formato correspondiente 
     * a la extensión del fichero pasado.
     * @param fileName
     * @return 
     */
    private Formato getFormato (String fileName) {
        Formato formato = null;
        String extension = fileName.substring(fileName.indexOf(".")+1).toUpperCase();
        if (extension.matches("M3U|PLS|XSPF")) {
            formato = Formato.valueOf(extension);
        }
        return formato;
    }
            
    
    /**
     * Predicado que valida la Extensión del nombre pasado.
     * Si el nombre contiene "." y posterior al "." posee 
     * una extensión válida las cuales son (M3U, PLS, XSPF)
     * Devuelve un boolean al llamar al método test().
     */
    private final Predicate<String> validarExtensionListadoPredicate = (fileName) -> {
        boolean isExtensionValida = false;
 
        if (fileName.contains(".")) {
            // Obtenemos la extensión del fichero
            String extension = fileName.substring(fileName.indexOf(".")+1).toUpperCase();
            // Comprobamos que la extensión sea una de las válidas para la canción
            if (extension.matches("M3U|PLS|XSPF")) {
                isExtensionValida = true;
            }
        }
        
        return isExtensionValida;
    };
    
    // Compatible con el salto de línea de Windows y Linux
    private static final String NEW_LINE = System.getProperty("line.separator"); 
    private static final FileNameExtensionFilter filter = new FileNameExtensionFilter("Extensiones de Listas (m3u, pls, xspf)", "m3u", "pls", "xspf");

    private ModeloListaCanciones modelo;
    private ArrayList<Cancion> listaCanciones;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbAñadirCancion;
    private javax.swing.JButton jbCargar;
    private javax.swing.JButton jbCrearLista;
    private javax.swing.JButton jbEliminarCancion;
    private javax.swing.JButton jbGuardar;
    private javax.swing.JButton jbModificarCancion;
    private javax.swing.JLabel jlArchivo;
    private javax.swing.JLabel jlTitulo;
    private javax.swing.JMenu jmArchivo;
    private javax.swing.JMenu jmCancion;
    private javax.swing.JMenu jmListas;
    private javax.swing.JMenuBar jmbMenu;
    private javax.swing.JMenuItem jmiAñadirCancion;
    private javax.swing.JMenuItem jmiCargar;
    private javax.swing.JMenuItem jmiCrearLista;
    private javax.swing.JMenuItem jmiEliminarCancion;
    private javax.swing.JMenuItem jmiGuardar;
    private javax.swing.JMenuItem jmiModificarCancion;
    private javax.swing.JPopupMenu jpmMenuCancion;
    private javax.swing.JPopupMenu jpmMenuMultipleEleccion;
    private javax.swing.JMenuItem jpmiEliminarCancion;
    private javax.swing.JMenuItem jpmiEliminarMultiplesCanciones;
    private javax.swing.JMenuItem jpmiModificarCancion;
    private javax.swing.JTable jtListaCanciones;
    // End of variables declaration//GEN-END:variables
}
