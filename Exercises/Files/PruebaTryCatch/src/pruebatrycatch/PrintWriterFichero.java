package pruebatrycatch;

import java.io.*;
import java.util.Scanner;

public class PrintWriterFichero {
    public static void main(String[] args) {
        File f = new File("datos/info.txt"); // Obtenemos el Fichero
        PrintWriter salida;
        if (f.exists()) { // Comprobamos que exista el Fichero
            salida = null; // Inicializamos a null
            try {
                salida = new PrintWriter(new BufferedWriter(new FileWriter(f, true)));
                Scanner sc = new Scanner(System.in);
                String userInput = "";
                System.out.println("Escribe todo el contenido que desees se guardara en un fichero.");
                System.out.println("Para salir del programa escriba \"salir\".");
                while (!userInput.equalsIgnoreCase("salir")) {
                    System.out.print("Ingrese su texto: ");
                    userInput = sc.nextLine();
                    salida.println(userInput);
                }
                salida.flush();
                System.out.println("Adios");
            } catch (IOException e) {
                System.out.println("No se ha encontrado el fichero");
            } finally {
                if (salida != null) {
                    salida.close();
                }
            }
        } else {
            System.out.println("El fichero no existe");
        }

    }
}
