package EjerciciosBidimensional;

import Funciones.OperacionesArray;

public class Ejercicio12 {
    public static void main(String[] args) {
        int[][] array = OperacionesArray.crearArrayAleatorioBidimensional(9,9,500,900);
        int fila = array.length-1;
        int columna = 0;
        int maximo = OperacionesArray.maximo(array);
        int minimo = OperacionesArray.minimo(array);
        int media = OperacionesArray.media(array);
        OperacionesArray.mostrarArrayBidimensional(array);

        System.out.println("La diagonal es:");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[fila][columna]+" ");
            fila--;
            columna++;
        }
        System.out.println(" ");
        System.out.println("El maximo es: "+maximo);
        System.out.println("El minimo es: "+minimo);
        System.out.println("La media es: "+media);



    }
}
