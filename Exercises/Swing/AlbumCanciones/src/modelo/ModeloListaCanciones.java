package modelo;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 * 
* @author deifont
 */
public class ModeloListaCanciones extends AbstractTableModel{

    private ArrayList<Cancion> listaCanciones;
    private final String [] nombresColumnas = {"Titulo", "Autor", "Duración"};
    
    public ModeloListaCanciones(){
        this.listaCanciones = new ArrayList<>();
    }
    
    public void añadirCancion(Cancion c){
        this.listaCanciones.add(c);
        this.fireTableDataChanged();
    }
    public boolean eliminarCancion (int index) {
        boolean cancionEliminada = false;
        if (index >= 0 && index < listaCanciones.size()) {
            listaCanciones.remove(index);
            cancionEliminada = true;
        }
        return cancionEliminada;
    }
    
    public Cancion getCancion(int index) {
        Cancion cancion = null;
        if (index >= 0 && index < listaCanciones.size()) {
            cancion = new Cancion(listaCanciones.get(index));
        }
        return cancion;
    }
    
    public boolean setNombre(int index, String nombre) {
        boolean nombreCambiado = false;
        if (index >= 0 && index < listaCanciones.size() && !nombre.isBlank()) {
            listaCanciones.get(index).setNombre(nombre);
            nombreCambiado = true;
        }
        return nombreCambiado;
    }
    
    public boolean setAutor(int index, String autor) {
        boolean autorCambiado = false;
        if (index >= 0 && index < listaCanciones.size() && !autor.isBlank()) {
            listaCanciones.get(index).setAutor(autor);
            autorCambiado = true;
        }
        return autorCambiado;
    }
    
    public boolean setDuracion(int index, int duracion) {
        boolean duracionCambiado = false;
        if (index >= 0 && index < listaCanciones.size() && duracion > 0) {
            listaCanciones.get(index).setDuracion(duracion);
            duracionCambiado = true;
        }
        return duracionCambiado;
    }
    
    public void updateRow (int row) {
        this.fireTableRowsUpdated(row, row);
    }
    
    
    @Override
    public String getColumnName(int index){
        return this.nombresColumnas[index];
    }
    
    @Override
    public int getRowCount() {
        return this.listaCanciones.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int row, int column) {
        Cancion c = listaCanciones.get(row);
        Object value = null;
        switch(column){
            case 0:
                value = c.getNombre();
                break;
            case 1: 
                value = c.getAutor();
                break;
            case 2:
                value = c.getDuracion();
                break;
        }
        return value;
    }
    
}
