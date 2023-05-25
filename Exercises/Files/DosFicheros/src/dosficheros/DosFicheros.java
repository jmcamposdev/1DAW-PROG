package dosficheros;

import java.io.File;
import java.util.Scanner;

import Funciones.GetData;

/*
 * Escribe un programa que guarde en un fichero el contenido de otros dos ficheros, 
 * de tal forma que en el fichero resultante aparezcan las líneas de los primeros dos ficheros mezcladas, es decir, 
 * la primera línea será del primer fichero, la segunda será del segundo fichero, la tercera será la siguiente del primer fichero, etc.
 * Los nombres de los dos ficheros origen y el nombre del fichero destino se deben pasar como argumentos en la línea de comandos.
 * Hay que tener en cuenta que los ficheros de donde se van cogiendo las líneas pueden tener tamaños diferentes.
 */

public class DosFicheros {

    public static void main(String[] args) {
        File file1 = getFichero();
        File file2 = getFichero();
        try (Scanner sc1 = new Scanner(file1); Scanner sc2 = new Scanner(file2)) {
            while (sc1.hasNextLine() || sc2.hasNextLine()) {
                if (sc1.hasNextLine()) {
                    System.out.println(sc1.nextLine());
                }
                if (sc2.hasNextLine()) {
                    System.out.println(sc2.nextLine());
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }


    public static File getFichero() {
        File file = null;
        boolean error = true;
        while (error) {
            String fileName = GetData.getString("Ingrese el nombre del fichero: ");
            file = new File(fileName);
            if (file.exists()) {
                error = false;
            } else {
                System.out.println("El fichero no existe.");
            }
        }
        return file;
    }
    
}
