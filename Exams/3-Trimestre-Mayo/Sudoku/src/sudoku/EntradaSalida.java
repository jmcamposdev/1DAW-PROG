package sudoku;

import java.io.*;
import java.util.ArrayList;

public class EntradaSalida {
    public static Sudoku cargarSudoku(String path) throws IOException {
        ArrayList<Integer> posiciones = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            // Variables para recorrer el tablero
            int rowIndex = 0;
            int columnIndex = 0;
            String line;
            for (int i = 0; i < 9; i++) { // Recorremos las 9 filas
                line = br.readLine(); // Leemos la fila
                String[] numbers = line.split(" "); // Separamos los números

                for (int j = 0; j < 9; j++) { // Recorremos las 9 columnas
                    int number = Integer.parseInt(numbers[j]); // Convertimos el número a entero
                    if (number > 0) { // Si el número es distinto de 0, lo añadimos a la lista
                        posiciones.add(rowIndex); // Añadimos la fila
                        posiciones.add(columnIndex); // Añadimos la columna
                        posiciones.add(number); // Añadimos el número
                    }
                    columnIndex++; // Pasamos a la siguiente columna
                }
                // Al terminar la fila, pasamos a la siguiente y volvemos a la primera columna
                columnIndex = 0;
                rowIndex++;
            }
        }

        return new Sudoku(posiciones);
    }

    public static void guardarSudoku(String path, Sudoku s) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
            for (int i = 0; i < 9; i++) { // Recorremos las 9 filas
                for (int j = 0; j < 9; j++) { // Recorremos las 9 columnas
                    bw.write(s.obtenerNumero(i, j) + " "); // Escribimos el número
                }
                bw.newLine(); // Al terminar la fila, pasamos a la siguiente
            }
        }
    }
}
