package sudoku;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;


public class ModeloSudoku  extends AbstractTableModel{
    private Sudoku sudoku;
    private final String [] nombresColumnas = {"1","2","3","4","5","6","7","8","9"};
    
    /**
     * Constructor que inicializa el ArrayList de Contacto
     */
    public ModeloSudoku(){
        this.sudoku = new Sudoku();
    }

    /**
     * Constructor que inicializa el Sudoku
     * @param sudoku Sudoku a cargar
     */
    public ModeloSudoku(Sudoku sudoku) {
        this.sudoku = sudoku;
    }

    /**
     * Método para obtener un Valor del Sudoku, si la fila o la columna
     * @param fila La fila del Sudoku. Debe ser un valor entre 0 y 8
     * @param columna La columna del Sudoku. Debe ser un valor entre 0 y 8
     * @param valor El valor del Sudoku. Debe ser un valor entre 1 y 9
     */
    public void setValor (int fila, int columna, int valor) {
        if (fila >= 0 && fila < 9 && columna >= 0 && columna < 9 && valor >= 1 && valor <= 9) {
            this.sudoku.colocarNumero(fila, columna, valor);
        }
    }

    /**
     * Método para cargar un Sudoku
     * @param sudoku Sudoku a cargar
     */
    public void setSudoku (Sudoku sudoku) {
        this.sudoku = sudoku;
        this.fireTableDataChanged();
    }

    /**
     * Método que devuelve el Objeto Sudoku
     * @return Devuelve la Copia del  Objeto Sudoku
     */
    public Sudoku getSudoku() {
        return new Sudoku(this.sudoku);
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
        return 9;
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
        return this.sudoku.obtenerNumero(row, column);
    }
}
