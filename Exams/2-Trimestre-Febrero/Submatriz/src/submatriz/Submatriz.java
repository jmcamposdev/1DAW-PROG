package submatriz;

import Funciones.GetData;
import Funciones.OperacionesArray;
import Funciones.OperacionesArrayBidimensional;

/**
 *
 * @author josemaria
 */
public class Submatriz {

    public static void main(String[] args) {

        /*
        int[][] matriz = {
                {1,2,3,4,5},
                {6,7,8,9,10},
                {11,12,13,14,15},
                {16,17,18,19,20},
                {21,22,23,24,25},
        };
        OperacionesArray.mostrarArrayBidimensional(matriz);
        int[][] subMatriz = submatriz(matriz,6,6,3,3);
        System.out.println(" ");
        OperacionesArray.mostrarArrayBidimensional(subMatriz);
         */
        System.out.println("Bienvenido al programa para crear SubMatrices");
        int rows = GetData.getInt("Ingrese las filas de la matriz: ",2);
        int columns = GetData.getInt("Ingrese las columnas de la matriz: ",2);
        int[][] matriz = OperacionesArrayBidimensional.crearArrayAleatorioBidimensional(rows,columns,1000);
        int subMatrizInitialRows = GetData.getInt("Ingrese las fila Inicial de la submatriz: ",0,matriz.length);
        int subMatrizInitialColumns = GetData.getInt("Ingrese las columna Inicial de la submatriz: ",0,matriz[0].length);
        int subMatrizFinishRows = GetData.getInt("Ingrese las fila Final de la submatriz: ",0,matriz.length);
        int subMatrizFinishlColumns = GetData.getInt("Ingrese las columna Final de la submatriz: ",0,matriz[0].length);
        int[][] subMatriz = submatriz(matriz,subMatrizInitialRows,subMatrizInitialColumns,subMatrizFinishRows,subMatrizFinishlColumns);
        OperacionesArrayBidimensional.mostrarArrayBidimensional(subMatriz);

    }

    public static int[][] submatriz (int[][] matriz, int filaInicial, int colInicial, int filaFinal, int colFinal) {
        if (matriz.length != matriz[0].length) {
            throw new IllegalArgumentException("La matriz no es cuadrática");
        }
        int rows = (filaFinal - filaInicial)+1;
        int columns = (colFinal - colInicial)+1;
        if (rows != columns) {
            throw new IllegalArgumentException("La subMatriz no es cuadrática");
        }
        if (rows < 2 || colFinal < 2) {
            throw new IllegalArgumentException("La matriz que se generará es mejor a 2x2");
        }
        if (filaInicial < 0 || filaInicial > matriz.length-1 || filaFinal > matriz.length-1 || colInicial < 0 || colFinal > matriz[0].length-1) {
            throw new IllegalArgumentException("Los valores de la submatriz excede la matriz padre");
        }
        // validar columna

        int subRowIndex = 0;
        int subColIndex = 0;
        int[][] subMatriz = new int[rows][columns];
        for (int i = filaInicial; i <= filaFinal ; i++) {
            for (int j = colInicial; j <= colFinal ; j++) {
                subMatriz[subRowIndex][subColIndex] = matriz[i][j];
                subColIndex++;
            }
            subRowIndex++;
            subColIndex = 0;
        }
        return subMatriz;
    }
    
}
