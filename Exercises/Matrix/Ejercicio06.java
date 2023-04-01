package EjerciciosBidimensional;
/*
    Modifica el programa anterior de tal forma que no se repita ningún número en el array.
 */

import Funciones.OperacionesArray;

public class Ejercicio06 {
    public static void main(String[] args) {
        int[][] array = OperacionesArray.crearArrayAleatorioBidimensionalSinRepetir(6,10,0,1000);
        int mayor = 0,minimo = array[0][0];

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                if (array[i][j] > mayor){
                    mayor = array[i][j];
                }
                if (array[i][j]< minimo){
                    minimo = array[i][j];
                }
            }
        }
        OperacionesArray.mostrarArrayBidimensional(array);
        int[] posicionMaximo = new int[2];
        int[] posicionMinimo = new int[2];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                if (array[i][j] == mayor){
                    System.out.println("El mayor se encuentra en la Fila: "+i+" y la Columna: "+j);
                }
                if (array[i][j] == minimo){
                    System.out.println("El mínimo se encuentra en la Fila: "+i+" y la Columna: "+j);
                }
            }
        }

    }
}
