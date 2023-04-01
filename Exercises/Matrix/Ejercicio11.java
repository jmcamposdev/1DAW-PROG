package EjerciciosBidimensional;

/*
    Realiza un programa que muestre por pantalla un array de 10 filas por 10 columnas relleno con números aleatorios entre 200 y 300. A continuación, el programa debe mostrar los números de la diagonal que va desde la esquina superior izquierda a la esquina inferior derecha, así como el máximo, el mínimo y la media de los números que hay en esa diagonal.

 */

import Funciones.OperacionesArray;

public class Ejercicio11 {
    public static void main(String[] args) {
        int[][] array = OperacionesArray.crearArrayAleatorioBidimensional(10,10,200,300);
        OperacionesArray.mostrarArrayBidimensional(array);

        // Mostrar la diagonal
    }
}
