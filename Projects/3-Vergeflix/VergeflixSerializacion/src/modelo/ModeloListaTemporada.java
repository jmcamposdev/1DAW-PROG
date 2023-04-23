/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author josemaria
 */
public class ModeloListaTemporada extends AbstractTableModel{
    private static DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy"); // Definir el formato deseado

    private ArrayList<Temporada> listaTemporadas;
    private final String[] nombresColumnas = {"Temporada", "Fecha Estreno", "Valoración"};
    
    public ModeloListaTemporada() {
        this.listaTemporadas = new ArrayList<>();
    }
    
    public void añadirTemporada(Temporada temporada) {
        this.listaTemporadas.add(temporada);
        this.fireTableDataChanged();
    }
    
    public boolean eliminarTemporada (int index) {
        boolean temporadaEliminada = false;
        
        if (index >= 0 && index < listaTemporadas.size()) {
            listaTemporadas.remove(index);
            temporadaEliminada = true;
            this.fireTableDataChanged();
        }
        return  temporadaEliminada;
    }
    
    public void clear() {
        this.listaTemporadas.clear();
        this.fireTableDataChanged();
    }
    
    public Temporada getTemporada (int index) {
        Temporada temporada = null;
        
        if (index >= 0 && index < listaTemporadas.size()) {
            temporada = listaTemporadas.get(index);
        }
        return temporada;
    }
    
    
     @Override
    public String getColumnName(int index){
        return this.nombresColumnas[index];
    }
    
    @Override
    public int getRowCount() {
        return this.listaTemporadas.size();
    }

    @Override
    public int getColumnCount() {
        return nombresColumnas.length;
    }

    @Override
    public Object getValueAt(int row, int column) {
        Temporada c = listaTemporadas.get(row);
        Object value = null;
        switch(column){
            case 0 -> value = "Temporada "+(row+1);
            case 1 -> value = formato.format(c.getFechaEstreno());
            case 2 -> value = c.calcularPuntuacion();
        }
        return value;
    }
}
