package EjerciciosBidimensional;

import Funciones.OperacionesArray;

/*
    Escribe un programa que pida 20 números enteros. Estos números se deben introducir en un array de 4 filas por 5 columnas.
    El programa mostrará las sumas parciales de filas y columnas igual que si de una hoja de cálculo se tratara.
    La suma total debe aparecer en la esquina inferior derecha.
 */
public class Ejercicio02 {
    public static void main(String[] args) {
        int[][] array = OperacionesArray.crearArrayAleatorioBidimensional(6,8,500);
        int suma = 0;
        int indice = 0;
        for (int j = 0; j < array.length; j++) {
                for (int k = 0; k < array[0].length; k++) {
                    System.out.print(" | " + array[indice][k] + " | ");
                    suma += array[indice][k];
                }
                indice++;
                System.out.print("Total: "+suma);
                suma = 0;
                System.out.println(" ");
        }

        /*
        // Imprimimos la primera fila con su suma
        for (int i = 0; i < array.length; i++) {
            System.out.print(" | " + array[0][i] + " | ");
            suma+=array[0][i];
        }
        System.out.print("Total: "+suma);
        suma = 0;
        System.out.println(" ");

        // Imprimimos la segunda fila
        for (int i = 0; i < array.length; i++) {
            System.out.print(" | " + array[1][i] + " | ");
            suma+= array[1][i];
        }
        System.out.print("Total: "+suma);
        suma = 0;
        System.out.println(" ");

        // Imprimimos la tercera fila
        for (int i = 0; i < array.length; i++) {
            System.out.print(" | " + array[2][i] + " | ");
            suma+= array[2][i];
        }
        System.out.print("Total: "+suma);
        suma = 0;
        System.out.println(" ");

        // Imprimimos la cuarta fila
        for (int i = 0; i < array.length; i++) {
            System.out.print(" | " + array[3][i] + " | ");
            suma+= array[3][i];
        }
        System.out.print("Total: "+suma);
        suma = 0;
        System.out.println(" ");
        */

        for (int i = 0; i < array[0].length; i++) {
            for (int j = 0; j < array.length; j++) {
                suma+= array[j][i];
            }
            System.out.print("Total:"+suma+" ");
            suma = 0;
        }
        suma = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                suma+=array[i][j];
            }
        }
        System.out.print("Total : "+suma);

    }
}
