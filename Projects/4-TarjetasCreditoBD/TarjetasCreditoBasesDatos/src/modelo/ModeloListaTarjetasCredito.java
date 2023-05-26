package modelo;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa un modelo para JTable
 * Se compone de Tarjetas y se muestra 3 columnas
 * las cuales son: Nombre, Número Tarjeta y Gasto Total
 * @author josemaria
 */
public class ModeloListaTarjetasCredito extends AbstractTableModel{

    private ArrayList<TarjetaCredito> listaTarjetas;
    private final String[] nombresColumnas = {"Nombre", "Número Tarjeta", "Gasto Total"};
    
    /**
     * Constructor que inicializa el ArrayList de Tarjetas
     */
    public ModeloListaTarjetasCredito() {
        this.listaTarjetas = new ArrayList<>();
    }
    
    /**
     * Método para añadir tarjetas al Modelo
     * @param tarjetaCredito Tarjeta para añadir
     */
    public void añadirTarjeta(TarjetaCredito tarjetaCredito) {
        this.listaTarjetas.add(tarjetaCredito);
        this.fireTableDataChanged();
    }
    
    /**
     * Método insertar una nueva tarjeta en una posición existente
     * Si la posición no existe no se insertará nada, si existe
     * se sustituye la antigua por la pasada por parámetro
     * @param index Índice de la tarjeta
     * @param tarjetaCredito La nueva Tarjeta
     */
    public void setTarjeta (int index, TarjetaCredito tarjetaCredito) {
        if (index >= 0 && index < listaTarjetas.size()) {
            listaTarjetas.set(index, tarjetaCredito);
            this.fireTableDataChanged();
        }
    }
    
    /**
     * Método para eliminar una tarjeta a través de
     * su índice, si el índice no existe devolverá false,
     * y si se ha eliminado con existo devolverá true.
     * @param index Índice de la Tarjeta a Eliminar
     * @return Devuelve False si no se ha eliminado y True en caso contrario
     */
    public boolean eliminarTarjeta (int index) {
        boolean tarjetaEliminada = false;
        
        if (index >= 0 && index < listaTarjetas.size()) {
            listaTarjetas.remove(index);
            tarjetaEliminada = true;
            this.fireTableDataChanged();
        }
        return  tarjetaEliminada;
    }
    
    /**
     * Método para eliminar una Tarjeta,
     * se eliminará si se encuentra una tarjeta
     * igual a la pasada por parámetro. (Igual si poseen el mismo Número de Tarjeta)
     * @param tarjetaCredito La tarjeta a eliminar
     * @return Devolverá true si se ha encontrado y eliminado y false en caso contrario
     */
    public boolean eliminarTarjeta (TarjetaCredito tarjetaCredito) {
        boolean tarjetaEliminada = listaTarjetas.remove(tarjetaCredito);
        if (tarjetaEliminada) {
            this.fireTableDataChanged();
        }
        return tarjetaEliminada;
    }
    
    /**
     * Método para limpiar todo el modelo
     * Elimina todas la tarjetas existente en el modelo
     */
    public void clearAll () {
        listaTarjetas.clear();
        this.fireTableDataChanged();
    }
    
    /**
     * Método para eliminar todas las tarjetas iguales a
     * las pasadas por parámetro.
     * @param listaAEliminar  ArrayList de las tarjetas a eliminar
     */
    public void removeAll (List<TarjetaCredito> listaAEliminar) {
        this.listaTarjetas.removeAll(listaAEliminar);
        this.fireTableDataChanged();
    }
    
    
    /**
     * Método para obtener un Objeto Tarjeta
     * del índice pasado, si el índice no existe 
     * devolverá null en caso contrario el Objeto Tarjeta
     * @param index Índice de la Tarjeta a obtener
     * @return Devuelve la tarjeta si el índice se encuentra
     * entre 0 y el número de tarjetas en caso contrario
     * devolverá null
     */
    public TarjetaCredito getTarjetaCredito (int index) {
        TarjetaCredito tarjetaCredito = null;
        
        if (index >= 0 && index < listaTarjetas.size()) {
            tarjetaCredito = new TarjetaCredito(listaTarjetas.get(index));
        }
        return tarjetaCredito;
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
        return this.listaTarjetas.size();
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
     * es inválida devolverá null si no el valor.
     * @param row El índice de la fila
     * @param column El índice de la Columna
     * @return Devolverá el valor indicado sino null si una de los valores es null
     */
    @Override
    public Object getValueAt(int row, int column) {
        TarjetaCredito c = listaTarjetas.get(row);
        Object value = null;
        switch(column){
            case 0 -> value = c.getTitular();
            case 1 -> value = c.getNumeroTarjeta();
            case 2 -> value = (Math.round(c.gastado() * 100.0) / 100.0);
        }
        return value;
    }
    
    
 }
