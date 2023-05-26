package sudoku;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Clase que representa un tablero de Sudoku.
 * @author josemaria
 */
public class Sudoku {
    private final int[][] tablero;

    /**
     * Constructor que crea un tablero vacío.
     */
    public Sudoku() {
        tablero = new int[9][9];
    }

    /**
     * Constructor que crea un tablero y coloca los números iniciales recibidos por parámetro
     * Para cada valor el ArrayList contiene tres números en este orden: fila, columna, número. Se debe comprobar que
     * el número esté en el rango permitido, en caso contrario se lanzarán IllegalArgumentException.
     * @param numerosIniciales ArrayList con los números iniciales del tablero.
     */
    public Sudoku (ArrayList<Integer> numerosIniciales) {
        this(); // Llamamos al constructor que crea un tablero vacío
        if (numerosIniciales.size() % 3 != 0) { // Comprobamos que el número de elementos sea múltiplo de 3
            throw new IllegalArgumentException("El número de elementos del ArrayList debe ser múltiplo de 3");
        }
        for (int i = 0; i < numerosIniciales.size(); i+=3) { // Recorremos el ArrayList de 3 en 3
            int fila = numerosIniciales.get(i); // Obtenemos la fila
            int columna = numerosIniciales.get(i+1); // Obtenemos la columna
            int numero = numerosIniciales.get(i+2); // Obtenemos el número
            if (numero < 1 || numero > 9) { // Comprobamos que el número esté en el rango permitido
                throw new IllegalArgumentException("El número debe estar entre 1 y 9");
            }
            tablero[fila][columna] = numero; // Colocamos el número en el tablero
        }
    }

    public Sudoku(Sudoku sudoku) {
        this(); // Llamamos al constructor que crea un tablero vacío
        // Copiamos los valores del tablero recibido por parámetro
        for (int i = 0; i < sudoku.tablero.length; i++) {
            System.arraycopy(sudoku.tablero[i], 0, this.tablero[i], 0, sudoku.tablero[i].length);
        }
    }

    /**
     * Devuelve el número de la fila y columna especificadas.
     * @param fila La fila del número a devolver. Debe estar entre 0 y 8.
     * @param columna La columna del número a devolver. Debe estar entre 0 y 8.
     * @return El número de la fila y columna especificadas.
     * @throws IllegalArgumentException Si la fila o la columna no están entre 0 y 8.
     */
    public int obtenerNumero(int fila, int columna) {
        if (fila < 0 || fila > 8 || columna < 0 || columna > 8 ) {
            throw new IllegalArgumentException("La fila y la columna deben estar entre 0 y 8");
        }
        return this.tablero[fila][columna];
    }

    /**
     * Coloca el número especificado en la fila y columna especificadas.
     * @param fila La fila donde colocar el número. Debe estar entre 0 y 8.
     * @param columna La columna donde colocar el número. Debe estar entre 0 y 8.
     * @param numero El número a colocar. Debe estar entre 1 y 9.
     * @throws IllegalArgumentException Si el número no está entre 1 y 9.
     */
    public void colocarNumero(int fila, int columna, int numero) {
        if (fila < 0 || fila > 8 || columna < 0 || columna > 8 ) { // Comprobamos que la fila y la columna estén entre 0 y 8
            throw new IllegalArgumentException("La fila y la columna deben estar entre 0 y 8");
        }
        if (numero < 1 || numero > 9) { // Comprobamos que el número esté entre 1 y 9
            throw new IllegalArgumentException("El número debe estar entre 1 y 9");
        }
        this.tablero[fila][columna] = numero; // Colocamos el número en el tablero
    }

    /**
     * Elimina el número de la fila y columna especificadas.
     * @param fila La fila del número a eliminar. Debe estar entre 0 y 8.
     * @param columna La columna del número a eliminar. Debe estar entre 0 y 8.
     */
    public void eliminarNumero(int fila, int columna) {
        this.tablero[fila][columna] = 0;
    }

    /**
     * Devuelve un ArrayList con los números posibles para la fila y columna especificada.
     * @param fila La fila para la que se quieren obtener los números posibles. Debe estar entre 0 y 8.
     * @param columna La columna para la que se quieren obtener los números posibles. Debe estar entre 0 y 8.
     * @return Un ArrayList con los números posibles para la fila y columna especificada.
     */
    public ArrayList<Integer> numerosPosibles(int fila, int columna) {
        Set<Integer> numerosPosibles = new HashSet<>();
        numerosPosibles.addAll(numerosPosiblesFila(fila));
        numerosPosibles.addAll(numerosPosiblesColumna(columna));
        numerosPosibles.addAll(numeroPosiblesRegion(fila, columna));

        return new ArrayList<>(numerosPosibles);
    }

    /**
     * Método que devuelve si el Sudoku está completo.
     * @return true si el Sudoku está completo, false en caso contrario.
     */
    public boolean comprobarSudoku() {
        boolean sudokuCorrecto = true;
        for (int i = 0; i < tablero.length && sudokuCorrecto; i++) {
            sudokuCorrecto = comprobarFila(i);
        }
        for (int i = 0; i < tablero[0].length && sudokuCorrecto; i++) {
            sudokuCorrecto = comprobarColumna(i);
        }
        for (int i = 0; i < 9 && sudokuCorrecto; i++) {
            sudokuCorrecto = comprobarRegion(i);
        }
        return sudokuCorrecto;
    }





    /*
        Método pasa validar si el tablero es correcto.
     */
    private boolean comprobarFila(int fila) {
        ArrayList<Integer> numeros = new ArrayList<>(); // Lista con los número de la Fila
        boolean filaCorrecta = true; // Variable para comprobar si la fila es correcta
        for (int i = 0; i < tablero[0].length && filaCorrecta; i++) {
            int numero = this.tablero[fila][i]; // Obtienes el número de la Fila
            if (numero > 0) { // Si el número es mayor a 0
                if (numeros.contains(numero)) { // Si ya está en la lista implica que está duplicado
                    filaCorrecta = false;
                } else { // Si no esta lo añadimos
                    numeros.add(numero);
                }
            } else  { // Si el número es 0 o negativo esa casilla no asignada y salimos
                filaCorrecta = false;
            }
        }
        return filaCorrecta;
    }

    private boolean comprobarColumna(int columna) {
        ArrayList<Integer> numeros = new ArrayList<>(); // Lista con los números de la Columna
        boolean columnaCorrecta = true;
        for (int i = 0; i < tablero.length && columnaCorrecta; i++) { // Iteramos sobre toda la columna
            int numero = this.tablero[i][columna]; // Obtenemos el número
            if (numero > 0) { // Si es mayor a 0 significa que está asignado
                if (numeros.contains(numero)) { // Si ya está en el ArrayList implica que está duplicado y es inválida la columna
                    columnaCorrecta = false;
                } else { // Si no lo añadimos
                    numeros.add(numero);
                }
            } else { // Si el número es negativo o 0 no está asignado y es inválida la columna
                columnaCorrecta = false;
            }
        }
        return columnaCorrecta;
    }

    private boolean comprobarRegion(int region) {
        ArrayList<Integer> numeros = new ArrayList<>(); // Lista con los números de la Region
        boolean regionCorrecta = true;
        int filaInicial = (region / 3) * 3; // Calculamos la fila inicial de la región
        int columnaInicial = (region % 3) * 3; // Calculamos la columna inicial de la región

        for (int i = filaInicial; i < filaInicial + 3 && regionCorrecta; i++) { // Iteramos las filas 3 veces
            for (int j = columnaInicial; j < columnaInicial + 3 && regionCorrecta; j++) { // Iteramos las Columnas 3 veces
                int numero = this.tablero[i][j]; // Obtenemos el número
                if (numero > 0) { //  Si es mayor a 0 significa que está asignado
                    if (numeros.contains(numero)) { // Si ya está en el ArrayList implica que está duplicado y es inválida la región
                        regionCorrecta = false;
                    } else { // Si no lo añadimos
                        numeros.add(numero);
                    }
                } else { // Si el número es negativo o 0 no está asignado y es inválida la región
                    regionCorrecta = false;
                }
            }
        }
        return regionCorrecta;
    }




    /*
        Métodos para obtener los números posibles en una fila, columna o región.
     */
    private ArrayList<Integer> numerosPosiblesFila(int fila) {
        // Creamos un ArrayList con los números del 1 al 9
        ArrayList<Integer> numerosPosibles = listaDeNumerosUnoANuevo();

        // Recorremos la fila y vamos eliminando los números que ya están en la fila
        for (int i = 0; i < tablero[0].length; i++) {
            int numero = this.tablero[fila][i];
            // Es necesario el Casting para que elimine como un Objeto y no como un índice
            numerosPosibles.remove((Integer) numero);
        }
        return numerosPosibles;
    }

    private ArrayList<Integer> numerosPosiblesColumna(int columna) {
        // Creamos un ArrayList con los números del 1 al 9
        ArrayList<Integer> numerosPosibles = listaDeNumerosUnoANuevo();

        // Recorremos la columna y vamos eliminando los números que ya están en la columna
        for (int i = 0; i < tablero.length; i++) {
            int numero = this.tablero[i][columna];
            // Es necesario el Casting para que elimine como un Objeto y no como un índice
            numerosPosibles.remove((Integer) numero);
        }
        return numerosPosibles;
    }

    private ArrayList<Integer> numeroPosiblesRegion(int fila, int columna) {
        // Creamos un ArrayList con los números del 1 al 9
        ArrayList<Integer> numerosPosibles = listaDeNumerosUnoANuevo();

        int filaInicial = fila - (fila % 3); // Calculamos la fila inicial de la región
        int columnaInicial = columna - (columna % 3); // Calculamos la columna inicial de la región

        // Recorremos la región y vamos eliminando los números que ya están en la región
        for (int i = filaInicial; i < filaInicial + 3; i++) {
            for (int j = columnaInicial; j < columnaInicial + 3; j++) {
                int numero = this.tablero[i][j];
                if (numero != 0) {
                    // Es necesario el Casting para que elimine como un Objeto y no como un índice
                    numerosPosibles.remove((Integer) numero);
                }
            }
        }
        return numerosPosibles;
    }

    private ArrayList<Integer> listaDeNumerosUnoANuevo() {
        ArrayList<Integer> numerosPosibles = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            numerosPosibles.add(i);
        }
        return numerosPosibles;
    }

    @Override
    public String toString() {
        StringBuilder resultado = new StringBuilder();
        for (int i = 0; i < tablero.length; i++) {
            if (i % 3 == 0) {
                resultado.append("-------------------------\n");
            }
            for (int j = 0; j < tablero[0].length; j++) {
                if (j % 3 == 0) {
                    resultado.append("| ");
                }
                resultado.append(tablero[i][j]).append(" ");
            }
            resultado.append("|\n");
        }
        resultado.append("-------------------------\n");
        return resultado.toString();
    }
}
