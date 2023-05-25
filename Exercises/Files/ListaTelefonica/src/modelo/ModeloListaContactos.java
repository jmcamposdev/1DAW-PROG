package modelo;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;


public class ModeloListaContactos  extends AbstractTableModel{
    private final ArrayList<Contacto> listaContacto;
    private final String [] nombresColumnas = {"Titulo", "Número"};
    
    /**
     * Constructor que inicializa el ArrayList de Contacto
     */
    public ModeloListaContactos(){
        this.listaContacto = new ArrayList<>();
    }
    
    /**
     * Método para añadir contactos al Modelo
     * @param c Canción para añadir
     */
    public void añadirContacto(Contacto c){
        this.listaContacto.add(c);
        this.fireTableRowsInserted(listaContacto.size()-1, listaContacto.size()-1);
    }
    
    /**
     * Método insetar una nuevo contacto en una posición existente
     * Si la posición no existe no se insertará nada, si existe
     * se sutituye la antigua por la pasada por parámetro
     * @param index Índice del contacto
     * @param contacto La nueva Canción
     */
    public void setContacto (int index, Contacto contacto) {
        if (index >= 0 && index < listaContacto.size()) {
            listaContacto.set(index, contacto);
            this.fireTableRowsUpdated(index, index);
        }
    }
    
    /**
     * Método para eliminar un contacto a traves de
     * su índice, si el indice no exite devolverá false,
     * y si se ha eliminado con existo devolverá true.
     * @param index Índice del contacto a Eliminar
     * @return Devuelve False si no se ha eliminado y True en caso contrario
     */
    public boolean eliminarContacto (int index) {
        boolean contactoEliminada = false;
        if (index >= 0 && index < listaContacto.size()) {
            listaContacto.remove(index);
            this.fireTableRowsDeleted(index, index);
            contactoEliminada = true;
        }
        return contactoEliminada;
    }
    
    public boolean removeAll (List<Contacto> listaContactoAEliminar) {
        boolean contactosEliminadas = listaContacto.removeAll(listaContactoAEliminar);
        if (contactosEliminadas) {
            this.fireTableDataChanged();
        }
        return contactosEliminadas;
    }
    
    /**
     * Método para limpiar de contendio
     * todo el Modelo
     */
    public void clear () {
        this.listaContacto.clear();
        this.fireTableDataChanged();
    }
    
    /**
     * Método para obtener un Objecto Contacto
     * del índice pasado, si el índice no existe 
     * devolverá null en caso contrario el Objecto Canción
     * @param index Índice del contacto a obtener
     * @return Devuvelve un contacto si el índice se encuentra
     * entre 0 y el número de contactos en caso contrario
     * devolverá null
     */
    public Contacto getContacto(int index) {
        Contacto contacto = null;
        if (index >= 0 && index < listaContacto.size()) {
            contacto = new Contacto(listaContacto.get(index));
        }
        return contacto;
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
        return this.listaContacto.size();
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
        Contacto c = listaContacto.get(row);
        return switch (column) {
            case 0 -> c.getTitular();
            case 1 -> c.getNumero();
            default -> null;
        };
    }
}
