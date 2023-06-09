/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author josemaria
 */
public class ModeloListaMovimientos extends AbstractTableModel{
    private ArrayList<Movimiento> listaMovimientos;
    private final String [] nombresColumnas = {"Cocepto", "Cantidad", "Fecha"};
    
    public ModeloListaMovimientos() {
        this.listaMovimientos = new ArrayList<>();
    }
    
    public void añadirMovimiento(Movimiento m){
        this.listaMovimientos.add(m);
        this.fireTableDataChanged();
    }
    
    public boolean eliminarMovimiento (int index) {
        boolean cancionEliminada = false;
        if (index >= 0 && index < listaMovimientos.size()) {
            listaMovimientos.remove(index);
            cancionEliminada = true;
        }
        return cancionEliminada;
    }
    public void clearAll () {
        listaMovimientos.clear();
        this.fireTableDataChanged();
    }

    @Override
    public String getColumnName(int index){
        return this.nombresColumnas[index];
    }
    
    @Override
    public int getRowCount() {
        return this.listaMovimientos.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int row, int column) {
        Movimiento m = listaMovimientos.get(row);
        Object value = null;
        switch(column){
            case 0 -> value = m.getConcepto();
            case 1 -> value = m.getCantidad();
            case 2 -> {
                LocalDateTime fecha = m.getFecha();
                value = fecha.getDayOfMonth()+"/"+fecha.getMonthValue()+"/"+fecha.getYear();
            }
        }
        return value;
    }
    
}
