package modelo;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 * Clase que repesenta un modelo para JTable
 * Se compone de Canciones y se muestra 3 columnas
 * las cuales son: Título, Duración (s), Ruta 
 * @author josemaria
 */
public class ModeloListaCanciones extends AbstractTableModel{
    
    private final ArrayList<Cancion> listaCanciones;
    private final String [] nombresColumnas = {"Titulo", "Duración (s)", "Ruta"};
    
    /**
     * Constructor que inicializa el ArrayList de Canciones
     */
    public ModeloListaCanciones(){
        this.listaCanciones = new ArrayList<>();
    }
    
    /**
     * Método para añadir canciones al Modelo
     * @param c Canción para añadir
     */
    public void añadirCancion(Cancion c){
        this.listaCanciones.add(c);
        this.fireTableRowsInserted(listaCanciones.size()-1, listaCanciones.size()-1);
    }
    
    /**
     * Método insetar una nueva canción en una posición existente
     * Si la posición no existe no se insertará nada, si existe
     * se sutituye la antigua por la pasada por parámetro
     * @param index Índice de la canción
     * @param cancion La nueva Canción
     */
    public void setCancion (int index, Cancion cancion) {
        if (index >= 0 && index < listaCanciones.size()) {
            listaCanciones.set(index, cancion);
            this.fireTableRowsUpdated(index, index);
        }
    }
    
    /**
     * Método para eliminar una canción a traves de
     * su índice, si el indice no exite devolverá false,
     * y si se ha eliminado con existo devolverá true.
     * @param index Índice de la Canciónn a Eliminar
     * @return Devuelve False si no se ha eliminado y True en caso contrario
     */
    public boolean eliminarCancion (int index) {
        boolean cancionEliminada = false;
        if (index >= 0 && index < listaCanciones.size()) {
            listaCanciones.remove(index);
            this.fireTableRowsDeleted(index, index);
            cancionEliminada = true;
        }
        return cancionEliminada;
    }
    
    public boolean removeAll (List<Cancion> listaCancionesAEliminar) {
        boolean cancionesEliminadas = listaCanciones.removeAll(listaCancionesAEliminar);
        if (cancionesEliminadas) {
            this.fireTableDataChanged();
        }
        return cancionesEliminadas;
    }
    
    /**
     * Método para limpiar de contendio
     * todo el Modelo
     */
    public void clear () {
        this.listaCanciones.clear();
        this.fireTableDataChanged();
    }
    
    /**
     * Método para obtener un Objecto Cancion
     * del índice pasado, si el índice no existe 
     * devolverá null en caso contrario el Objecto Canción
     * @param index Índice de la Canción a obtener
     * @return Devuvelve la canción si el índice se encuentra
     * entre 0 y el número de canciones en caso contrario
     * devolverá null
     */
    public Cancion getCancion(int index) {
        Cancion cancion = null;
        if (index >= 0 && index < listaCanciones.size()) {
            cancion = new Cancion(listaCanciones.get(index));
        }
        return cancion;
    }
    
    /**
     * Método para actualizar una Fila de la Tabla
     * @param row Índice de la Fila a actualizar
     */
    public void updateRow (int row) {
        this.fireTableRowsUpdated(row, row);
    }
    
    /**
     * Método que devuelve el nombre de la Columna
     * gracias al indice
     * @param index El índice del nombre de la Columna
     * @return Devuelve el nombre de la Columna que represente el índice pasado
     * si el indice esta fuera del rango se devolverá null
     */
    @Override
    public String getColumnName(int index){
        String nombreColumna = null;
        if (index >= 0 && index < nombresColumnas.length) {
            nombreColumna = this.nombresColumnas[index];
        }
        return nombreColumna;
    }
    
    /**
     * Devuelve el número de filas del Modelo
     * @return El número de filas del Modelo
     */
    @Override
    public int getRowCount() {
        return this.listaCanciones.size();
    }

    /**
     * Devuelve el número de Columnas del Modelo
     * @return El número de Columnas del Modelo
     */
    @Override
    public int getColumnCount() {
        return nombresColumnas.length;
    }

    /**
     * Método para obtener un Valor del Modelo, si la fila o la columna
     * es inválida devolverá null sino el valor.
     * @param row El índice de la fila
     * @param column El índice de la Columna
     * @return Devolverá el valor indicado sino null si una de los valores es null
     */
    @Override
    public Object getValueAt(int row, int column) {
        Cancion c = listaCanciones.get(row);
        return switch (column) {
            case 0 -> c.getTitulo();
            case 1 -> c.getDuracion()+"s";
            case 2 -> c.getRuta();
            default -> null;
        };
    }
    
}
