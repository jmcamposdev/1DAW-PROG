package modelo;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;



public class ModeloListaMedia extends AbstractTableModel { 
    private ArrayList<Media> listaMedia;
    private final String[] nombresColumnas = {"Nombre", "Calificación de Edad","Puntuación"};
    
    public ModeloListaMedia() {
        this.listaMedia = new ArrayList<>();
    }
    
    public void añadirTarjeta(Media media) {
        this.listaMedia.add(media);
        this.fireTableDataChanged();
    }
    
    public boolean eliminarTarjeta (int index) {
        boolean tarjetaEliminada = false;
        
        if (index >= 0 && index < listaMedia.size()) {
            listaMedia.remove(index);
            tarjetaEliminada = true;
            this.fireTableDataChanged();
        }
        return  tarjetaEliminada;
    }
    
    public Media getTarjetaCredito (int index) {
        Media media = null;
        
        if (index >= 0 && index < listaMedia.size()) {
            media = listaMedia.get(index);
        }
        return media;
    }
    
    
     @Override
    public String getColumnName(int index){
        return this.nombresColumnas[index];
    }
    
    @Override
    public int getRowCount() {
        return this.listaMedia.size();
    }

    @Override
    public int getColumnCount() {
        return nombresColumnas.length;
    }

    @Override
    public Object getValueAt(int row, int column) {
        Media c = listaMedia.get(row);
        Object value = null;
        switch(column){
            case 0 -> value = c.getNombre();
            case 1 -> value = c.getCalificacionEdad();
            case 2 -> value = c.calcularPuntuacion();
        }
        return value;
    }
    
    
}
