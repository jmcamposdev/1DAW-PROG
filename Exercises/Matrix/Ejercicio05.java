package EjerciciosBidimensional;
import Funciones.OperacionesArray;

/*
    Realiza un programa que rellene un array de 6 filas por 10 columnas con números enteros positivos comprendidos entre 0 y 1000
    (ambos incluidos). A continuación, el programa deberá dar la posición tanto del máximo como del mínimo.
 */

public class Ejercicio05 {
    public static void main(String[] args) {
        int[][] array = OperacionesArray.crearArrayAleatorioBidimensional(6,10,0,1000);
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
