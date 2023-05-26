package modelo;

import javax.swing.table.AbstractTableModel;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * Clase que representa un modelo para JTable
 * Se compone de Movimientos y se muestra 3 columnas
 * las cuales son: Concepto, Cantidad, Fecha
 * @author josemaria
 */
public class ModeloListaMovimientos extends AbstractTableModel{
    private ArrayList<Movimiento> listaMovimientos;
    private final String [] nombresColumnas = {"Concepto", "Cantidad", "Fecha"};
    
        
    /**
     * Constructor que inicializa el ArrayList de Movimientos
     */
    public ModeloListaMovimientos() {
        this.listaMovimientos = new ArrayList<>();
    }
    
    /**
     * Método para añadir movimientos al Modelo
     * @param m Movimientos para añadir
     */
    public void añadirMovimiento(Movimiento m){
        this.listaMovimientos.add(m);
        this.fireTableDataChanged();
    }
    
    /**
     * Método para eliminar un movimiento a través de
     * su índice, si el índice no existe devolverá false,
     * y si se ha eliminado con éxito devolverá true.
     * @param index Índice del Movimiento a Eliminar
     * @return Devuelve False si no se ha eliminado y True en caso contrario
     */
    public boolean eliminarMovimiento (int index) {
        boolean cancionEliminada = false;
        if (index >= 0 && index < listaMovimientos.size()) {
            listaMovimientos.remove(index);
            cancionEliminada = true;
        }
        return cancionEliminada;
    }
    
    /**
     * Método para limpiar todo el modelo
     * Elimina todos los movimientos existente en el modelo
     */
    public void clearAll () {
        listaMovimientos.clear();
        this.fireTableDataChanged();
    }

    /**
     * Método que devuelve el nombre de la Columna 
     * que representa el índice pasado por parámetro
     * @param index El índice del nombre de la Columna
     * @return Devuelve el nombre de la Columna que represente el índice pasado
     * si el índice está fuera del rango se devolverá null
     */
    @Override
    public String getColumnName(int index){
        return this.nombresColumnas[index];
    }
    
    /**
     * Devuelve el número de filas del Modelo
     * @return El número de filas del Modelo
     */
    @Override
    public int getRowCount() {
        return this.listaMovimientos.size();
    }

    /**
     * Devuelve el número de Columnas del Modelo
     * @return El número de Columnas del Modelo
     */
    @Override
    public int getColumnCount() {
        return 3;
    }

    /**
     * Método para obtener un Valor del Modelo, si la fila o la columna
     * es inválida devolverá null si no el valor.
     * @param row El índice de la fila
     * @param column El índice de la Columna
     * @return Devolverá el valor indicado sino null si una de los valores es null
     */
    @Override
    public Object getValueAt(int row, int column) {
        Movimiento m = listaMovimientos.get(row);
        Object value = null;
        switch(column){
            case 0 -> value = m.getConcepto();
            case 1 -> value = m.getCantidad();
            case 2 ->  {
                LocalDateTime fecha = m.getFecha();
                value = fecha.getDayOfMonth()+"/"+fecha.getMonthValue()+"/"+fecha.getYear();
            }
        }
        return value;
    }
    
}
