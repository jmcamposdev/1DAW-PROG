package modelo;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;


public class ModeloListaTarjetasCredito extends AbstractTableModel{

    private ArrayList<TarjetaCredito> listaTarjetas;
    private final String[] nombresColumnas = {"Nombre", "Número Tarjeta", "Gasto Total"};
    
    public ModeloListaTarjetasCredito() {
        this.listaTarjetas = new ArrayList<>();
    }
    
    public void añadirTarjeta(TarjetaCredito tarjetaCredito) {
        this.listaTarjetas.add(tarjetaCredito);
        this.fireTableDataChanged();
    }
    
    public void setTarjeta (int index, TarjetaCredito tarjetaCredito) {
        if (index >= 0 && index < listaTarjetas.size()) {
            listaTarjetas.set(index, tarjetaCredito);
            this.fireTableDataChanged();
        }
    }
    
    public boolean eliminarTarjeta (int index) {
        boolean tarjetaEliminada = false;
        
        if (index >= 0 && index < listaTarjetas.size()) {
            listaTarjetas.remove(index);
            tarjetaEliminada = true;
            this.fireTableDataChanged();
        }
        return  tarjetaEliminada;
    }
    
    public boolean eliminarTarjeta (TarjetaCredito tarjetaCredito) {
        boolean tarjetaEliminada = listaTarjetas.remove(tarjetaCredito);
        if (tarjetaEliminada) {
            this.fireTableDataChanged();
        }
        return tarjetaEliminada;
    }
    public void clearAll () {
        listaTarjetas.clear();
        this.fireTableDataChanged();
    }
    
    public TarjetaCredito getTarjetaCredito (int index) {
        TarjetaCredito tarjetaCredito = null;
        
        if (index >= 0 && index < listaTarjetas.size()) {
            tarjetaCredito = new TarjetaCredito(listaTarjetas.get(index));
        }
        return tarjetaCredito;
    }
    
    
     @Override
    public String getColumnName(int index){
        return this.nombresColumnas[index];
    }
    
    @Override
    public int getRowCount() {
        return this.listaTarjetas.size();
    }

    @Override
    public int getColumnCount() {
        return nombresColumnas.length;
    }

    @Override
    public Object getValueAt(int row, int column) {
        TarjetaCredito c = listaTarjetas.get(row);
        Object value = null;
        switch(column){
            case 0:
                value = c.getTitular();
                break;
            case 1: 
                value = c.getNumeroTarjeta();
                break;
            case 2:
                value = c.gastado();
                break;
        }
        return value;
    }
    
    
 }
