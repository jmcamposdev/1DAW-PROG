package EjerciciosBidimensional;

import Funciones.OperacionesArray;

public class Ejercicio01 {
    public static void main(String[] args) {
        double[][] array = new double[3][6];
        array[0][0] = 0;
        array[0][1] = 30;
        array[0][2] = 2;
        array[0][5] = 5;
        array[1][0] = 75;
        array[1][4] = 0;
        array[2][2] = -2;
        array[2][3] = 9;
        array[2][5] = 11;
        OperacionesArray.mostrarArrayBidimensional(array);
    }
}
