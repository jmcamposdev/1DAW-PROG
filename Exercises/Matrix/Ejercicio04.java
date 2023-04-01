package EjerciciosBidimensional;

/*
    Modifica el programa anterior de tal forma que las sumas parciales y la suma total aparezcan en la pantalla con un pequeño retardo, dando la impresión de que el ordenador se queda “pensando” antes de mostrar los números.
 */

import Funciones.OperacionesArray;
import java.util.concurrent.TimeUnit;

public class Ejercicio04 {
    public static void main(String[] args) {
        int[][] array = OperacionesArray.crearArrayAleatorioBidimensional(4,5,100,999);
        // Imprimimos la primera fila con su suma
        int suma = 0;
        for (int i = 0; i < array.length; i++) {
            System.out.print(" | " + array[0][i] + " | ");
            suma+=array[0][i];
        }
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.print("Total: "+suma);
        suma = 0;
        System.out.println(" ");


        // Imprimimos la segunda fila
        for (int i = 0; i < array.length; i++) {
            System.out.print(" | " + array[1][i] + " | ");
            suma+= array[1][i];
        }
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.print("Total: "+suma);
        suma = 0;
        System.out.println(" ");

        // Imprimimos la tercera fila
        for (int i = 0; i < array.length; i++) {
            System.out.print(" | " + array[2][i] + " | ");
            suma+= array[2][i];
        }
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.print("Total: "+suma);
        suma = 0;
        System.out.println(" ");

        // Imprimimos la cuarta fila
        for (int i = 0; i < array.length; i++) {
            System.out.print(" | " + array[3][i] + " | ");
            suma+= array[3][i];
        }
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.print("Total: "+suma);
        suma = 0;
        System.out.println(" ");


        for (int i = 0; i < array[0].length; i++) {
            for (int j = 0; j < array.length; j++) {
                suma+= array[j][i];
            }
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.print(" | " + suma + " | ");
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
