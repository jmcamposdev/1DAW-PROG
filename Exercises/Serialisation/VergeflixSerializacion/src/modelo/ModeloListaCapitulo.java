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
public class ModeloListaCapitulo extends AbstractTableModel{
    private static DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy"); // Definir el formato deseado

    private ArrayList<Capitulo> listaCapitulos;
    private final String[] nombresColumnas = {"Titulo","Fecha Emisión", "Valoración"};
    
    public ModeloListaCapitulo() {
        this.listaCapitulos = new ArrayList<>();
    }
    
    public void añadirCapitulo(Capitulo capitulo) {
        this.listaCapitulos.add(capitulo);
        this.fireTableDataChanged();
    }
    
    public boolean eliminarCapitulo (int index) {
        boolean capituloEliminado = false;
        
        if (index >= 0 && index < listaCapitulos.size()) {
            listaCapitulos.remove(index);
            capituloEliminado = true;
            this.fireTableDataChanged();
        }
        return  capituloEliminado;
    }
    
    public void eliminarTodo() {
        this.listaCapitulos = new ArrayList<>();
        this.fireTableDataChanged();
    }
    
    public Capitulo getCapitulo (int index) {
        Capitulo capitulo = null;
        
        if (index >= 0 && index < listaCapitulos.size()) {
            capitulo = listaCapitulos.get(index);
        }
        return capitulo;
    }
    
    
     @Override
    public String getColumnName(int index){
        return this.nombresColumnas[index];
    }
    
    @Override
    public int getRowCount() {
        return this.listaCapitulos.size();
    }

    @Override
    public int getColumnCount() {
        return nombresColumnas.length;
    }

    @Override
    public Object getValueAt(int row, int column) {
        Capitulo c = listaCapitulos.get(row);
        Object value = null;
        switch(column){
            case 0 -> value = c.getTitulo();
            case 1 -> value = formato.format(c.getFechaEmision());
            case 2 -> value = c.calcularPuntuacion();
        }
        return value;
    }
}
