package interfaz;

import java.io.File;
import java.text.DecimalFormat;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;
import modelo.Cancion;

/**
 * Clase que representa un JDialog su función 
 * es la creación y modificación de canciones
 * posee dos constructores uno el cual es para la creación de una nueva canción
 * y otro el cual inicializa los campos con los datos de la canción pasada.
 * @author José María Campos Trujillo
 */
public class JDCancion extends javax.swing.JDialog {

    /**
     * Constructor el cual inicializa el JDialog,
     * el formato del JFormattedTextField de Duración.
     * @param parent JFrame padre
     * @param modal Si es modal o no.
     */
    public JDCancion(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        inicializarCrearCancion();
    }
    
    /**
     * Constructor el cual inicializa todos los TextField con 
     * los datos de la Canción pasada por parámetro.
     * @param parent JFrame padre
     * @param modal Si es modal o no
     * @param cancion El objeto Cancion que inicializa todo los JTextField
     */
    public JDCancion(java.awt.Frame parent, boolean modal, Cancion cancion) {
        this(parent, modal);
        inicializarEditarCancion(cancion);
    }
    /**
     * Método privado el cual asigna un formato al JFormattedTextField
     * de duración, le asigna un rango de 0 a Integer.MAX_VALUE e 
     * inicializa las variables privadas a default.
     */
    private void inicializarCrearCancion() {
        // Limitar el campo de Duración para que solo inserte valores Numéricos
        NumberFormatter formatoDuracion = new NumberFormatter(new DecimalFormat("0"));
        formatoDuracion.setValueClass(Integer.class);
        formatoDuracion.setMinimum(0);
        formatoDuracion.setMaximum(Integer.MAX_VALUE);
        jftfDuracion.setFormatterFactory(new DefaultFormatterFactory(formatoDuracion));
        jftfDuracion.setColumns(10); // Establecer el ancho del campo
        
        // Inicializando atributos
        this.isCancionCreadaOModificada = false;
        this.nuevaCancion = null;
    }
    
    /**
     * Método privado el cual realiza todas las modificaciones
     * necesarias para asignar los valores de la Canción pasada
     * por parámetro a los JTextFields, modificar el título y el botón de Aceptar.
     * Se llama cuando se pretende utilizar el JDialog para modification
     * @param cancion Objeto Cancion para asignar sus atributos a los JTextFields
     */
    private void inicializarEditarCancion(Cancion cancion) {
        jlTitulo.setText("Modificar Canción");
        jtfTitulo.setText(cancion.getTitulo());
        jtfRuta.setText(cancion.getRuta());
        jftfDuracion.setText(cancion.getDuracion()+"");
        jbAceptarCancion.setText("Actualizar");
    }
    
    /**
     * Método que devuelve True/False si la canción
     * se ha creado o modificado correctamente
     * @return Devuelve True si se ha creado o modificado y False en caso contrario
     */
    public boolean isCancionCreadaOModificada() {
        return this.isCancionCreadaOModificada;
    }
    
    /**
     * Método que devuelve el Objeto Canción
     * si existe en caso contrario null
     * @return Devuelve un Objeto Cancion o null.
     */
    public Cancion getCancion() {
        return new Cancion(nuevaCancion);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jlTitulo = new javax.swing.JLabel();
        jlTituloCancion = new javax.swing.JLabel();
        jlTituloRuta = new javax.swing.JLabel();
        jlTituloDuracion = new javax.swing.JLabel();
        jtfTitulo = new javax.swing.JTextField();
        jtfRuta = new javax.swing.JTextField();
        jftfDuracion = new javax.swing.JFormattedTextField();
        jbCancelar = new javax.swing.JButton();
        jbAceptarCancion = new javax.swing.JButton();
        jbSeleccionarCancion = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jbGenerarDuracion = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jlTitulo.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jlTitulo.setText("Crear Cancion");

        jlTituloCancion.setText("Titulo:");

        jlTituloRuta.setText("Ruta:");

        jlTituloDuracion.setText("Duración (s):");

        jbCancelar.setText("Cancelar");
        jbCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCancelarActionPerformed(evt);
            }
        });

        jbAceptarCancion.setText("Añadir");
        jbAceptarCancion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAceptarCancionActionPerformed(evt);
            }
        });

        jbSeleccionarCancion.setText("Seleccionar");
        jbSeleccionarCancion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSeleccionarCancionActionPerformed(evt);
            }
        });

        jLabel2.setText("Si desconoce la duración inserte 0");

        jbGenerarDuracion.setText("Generar");
        jbGenerarDuracion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbGenerarDuracionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addComponent(jbCancelar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbAceptarCancion)
                .addGap(64, 64, 64))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jlTituloDuracion)
                            .addComponent(jlTituloRuta)
                            .addComponent(jlTituloCancion))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtfTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jftfDuracion, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jbGenerarDuracion))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jlTitulo)
                                    .addComponent(jtfRuta, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jbSeleccionarCancion))))
                    .addComponent(jLabel2))
                .addGap(28, 28, 28))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlTitulo)
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlTituloCancion)
                    .addComponent(jtfTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlTituloRuta)
                    .addComponent(jtfRuta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbSeleccionarCancion))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlTituloDuracion)
                    .addComponent(jftfDuracion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbGenerarDuracion))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbCancelar)
                    .addComponent(jbAceptarCancion))
                .addGap(32, 32, 32))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Método el cual cierra el JDialog
     * @param evt Evento ActionEvent
     */
    private void jbCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCancelarActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_jbCancelarActionPerformed

    /**
     * Método el cual su función es abrir un JFileChooser
     * para seleccionar una canción las extensiones se encuentran
     * filtradas por (MP3, WAV, AIFF, WMA, FLAC, AAC, OGG).
     * Si no existe ninguno Título al escoger la canción se
     * insertará como título el nombre de la canción.
     * @param evt Evento ActionEvent
     */
    private void jbSeleccionarCancionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSeleccionarCancionActionPerformed
        JFileChooser gestorArchivos = new JFileChooser(); // Creamos el JFileChooser
        gestorArchivos.removeChoosableFileFilter( gestorArchivos.getFileFilter()); // Eliminamos el Filtro por defecto

        // Filtro de extensiones válidas
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Extensiones de Canciones (mp3, wav, aiff, wma, flac, aac, ogg)", "mp3", "wav", "aiff","wma","flac","aac","ogg");
        gestorArchivos.setFileFilter(filter); // Asignamos el Filtro de Extensiones

        int option = gestorArchivos.showSaveDialog(this); // Mostramos el JFileChooser
        if (option == JFileChooser.APPROVE_OPTION) { // Si a seleccionado un fichero o si ha escrito un fichero
            boolean isValidFile = true;
            File file = gestorArchivos.getSelectedFile(); // Creamos un File con la Ruta
            if (!file.exists()) { // Si el fichero seleccionado no existe le informamos del error
                JOptionPane.showMessageDialog(this, "El fichero seleccionado no existe", "Error", JOptionPane.WARNING_MESSAGE);
                isValidFile = false;
            } else if (!validarExtension(file.getName())){ // Si no posee una extensión válida le informamos del error
                JOptionPane.showMessageDialog(this, "La canción seleccionada no tiene una extensión válida\n Extensiones válidas: MP3, WAV, AIFF, WMA, FLAC, AAC, OGG", "Error", JOptionPane.WARNING_MESSAGE);
                isValidFile = false;
            } else if (jtfTitulo.getText().isBlank()){ // Si no posee Título le insertamos el nombre del Fichero
                int indexPunto = file.getName().indexOf(".");
                // Insertar el nombre sin la extension
                String nombreSinExtension = file.getName().substring(0, indexPunto);
                jtfTitulo.setText(nombreSinExtension);
            }
            
            if (isValidFile) { // Si el fichero es válido escribiremos la ruta
                jtfRuta.setText(gestorArchivos.getSelectedFile().getAbsolutePath()); // Asignamos la ruta al JTextField
            }
        } else {
            JOptionPane.showMessageDialog(this, "No se ha seleccionado ningún Archivo");
        }
    }//GEN-LAST:event_jbSeleccionarCancionActionPerformed

   
    /**
     * Método privado el cual valida que todos los campos sean válidos.
     * - Título: No puede estar vacío o contener solo espacios
     * - Ruta: No puede estar vacía o contener solo espacios, 
     *   debe de existir el fichero y la extensión del fichero debe
     *   corresponder con la extensión de una canción, las extensiones válidas son:
     *   (MP3, WAV, AIFF, WMA, FLAC, AAC, OGG).
     * - Duración: No puede estar vacía o contener solo espacios
     * 
     * Si todo lo anteriores es válido se crea la Canción y se cierra el JDialog
     * @param evt Evento ActionEvent
     */
    private void jbAceptarCancionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAceptarCancionActionPerformed
        boolean isCancionValida = true;
        String errorMessage = "";
        String titulo = jtfTitulo.getText();
        String ruta = jtfRuta.getText();
        File fichero = new File(ruta);
        String duracion = jftfDuracion.getText();
        
        if (titulo.isBlank()) { // Validamos que el Título no está vacío o en blanco
            isCancionValida = false;
            errorMessage = "El título no puede estar vacío";
        } else if (ruta.isBlank()) { // Validamos que la Ruta no está vacío o en blanco
            isCancionValida = false;
            errorMessage = "La ruta no puede estar vacía";
        } else if (!fichero.exists()){ // Validamos si el fichero no existe
            isCancionValida = false;
            errorMessage = "El fichero de la ruta no existe";
        } else if (!validarExtension(fichero.getName())){ // Validamos que la extensión del fichero sea válida
            isCancionValida = false;
            errorMessage = "La extensión del fichero no es válida debe de ser (mp3, wav, aiff, wma, flac, aac o ogg)";  
        } else if (duracion.isBlank()) { // Validamos que la Duración no está vacía
            isCancionValida = false;
            errorMessage = "La duración debe de ser numérica mayor o igual que 0";
        }
        
        if (isCancionValida) {
            this.isCancionCreadaOModificada = true;
            this.nuevaCancion = new Cancion(titulo, ruta, Integer.parseInt(duracion));
            this.setVisible(false);
        } else {
            JOptionPane.showMessageDialog(this, errorMessage, "Error", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jbAceptarCancionActionPerformed

    /**
     * Método privado para generar y asignar un número de segundos
     * aleatorio a los campos JFormattedTextField de Duración, se genera entre 0 y 1999 s
     * @param evt Evento ActionEvent
     */
    private void jbGenerarDuracionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGenerarDuracionActionPerformed
        jftfDuracion.setText(String.valueOf((int) (Math.random() * 2000)));
    }//GEN-LAST:event_jbGenerarDuracionActionPerformed

    /**
     * Método privado para validar si el nombre del fichero pasado 
     * por parámetro es válido. 
     * Para ser válido debe de contener un "." Y posterior al punto
     * una de las siguientes extensiones (MP3, WAV, AIFF, WMA, FLAC, AAC, OGG).
     * @param fileName Nombre del fichero a validar su extensión
     * @return Devuelve True si la extensión es válida y False en caso contrario
     */
    private static boolean validarExtension (String fileName) {
        boolean isExtensionValida = false;
 
        if (fileName.contains(".")) {
            // Obtenemos la extensión del fichero
            String extension = fileName.substring(fileName.indexOf(".")+1).toUpperCase();
            // Comprobamos que la extensión sea una de las válidas para la canción
            if (extension.matches("MP3|WAV|AIFF|WMA|FLAC|AAC|OGG")) {
                isExtensionValida = true;
            }
        }
        
        return isExtensionValida;
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
            java.util.logging.Logger.getLogger(JDCancion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDCancion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDCancion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDCancion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JDCancion dialog = new JDCancion(new javax.swing.JFrame(), true);
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

    private boolean isCancionCreadaOModificada;
    private Cancion nuevaCancion;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton jbAceptarCancion;
    private javax.swing.JButton jbCancelar;
    private javax.swing.JButton jbGenerarDuracion;
    private javax.swing.JButton jbSeleccionarCancion;
    private javax.swing.JFormattedTextField jftfDuracion;
    private javax.swing.JLabel jlTitulo;
    private javax.swing.JLabel jlTituloCancion;
    private javax.swing.JLabel jlTituloDuracion;
    private javax.swing.JLabel jlTituloRuta;
    private javax.swing.JTextField jtfRuta;
    private javax.swing.JTextField jtfTitulo;
    // End of variables declaration//GEN-END:variables
}
