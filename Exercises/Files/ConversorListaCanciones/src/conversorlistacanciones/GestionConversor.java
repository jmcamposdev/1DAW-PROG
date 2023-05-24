package conversorlistacanciones;

import Funciones.GetData;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author josemaria
 */
public class GestionConversor {

    private static final int OPCION_ORDENAR_POR_DURACION = 1;
    private static final int OPCION_ORDENAR_POR_TITULO = 2;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Cancion> listaCanciones = new ArrayList<>(); // Lista de canciones
        File file = getFile(); // Archivo a leer

        if (file.getName().endsWith(".txt")) { // Si el archivo es .txt
            listaCanciones = leerTxt(file); // Se lee el archivo
        } else if (file.getName().endsWith(".dat")) { // Si el archivo es .dat
            listaCanciones = leerDat(file); // Se lee el archivo
        }

        // Mostar la lista de canciones
        mostrarCanciones(listaCanciones);

        // Preguntar si se desea guardar la lista de canciones en un archivo
        boolean guardar = GetData.getBoolean("Deseas guardar la lista de canciones en un archivo? (si|no): ");
        // Solo se guardará en .dat
        if (guardar) { // Si se desea guardar
            File file2 = getFileToSave(); // Se pide el archivo donde se guardará
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file2))) {
                oos.writeObject(listaCanciones);
            } catch (IOException e) {
                System.out.println("No se ha podido guardar el archivo");
            }
        }
    }

    /**
     * Muestra la lista de canciones ordenadas por duración o por título
     * dependiendo de la opción que elija el usuario
     * 1. Ordenadas por duración
     * 2. Ordenadas por título
     * @param listaCanciones Lista de canciones a mostrar
     */
    private static void mostrarCanciones(ArrayList<Cancion> listaCanciones) {
        System.out.println("""
                Como deseas mostrar la lista de canciones?
                1. Ordenadas por duración
                2. Ordenadas por título""");
        int opcion = GetData.getInt("Opción: ", 1, 2);

        switch (opcion) {
            case OPCION_ORDENAR_POR_DURACION -> Collections.sort(listaCanciones);
            case OPCION_ORDENAR_POR_TITULO -> listaCanciones.sort(new ComparCancionesTitulo());
        }

        System.out.println("Lista de canciones:");
        listaCanciones.forEach(System.out::println);
    }

    /**
     * Método para leer un archivo .dat
     * @param file Archivo a leer
     * @return Lista de canciones que se han leído del archivo
     */
    private static ArrayList<Cancion> leerDat(File file) {
        ArrayList<Cancion> listaCanciones;
        
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            listaCanciones = (ArrayList<Cancion>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return listaCanciones;
    }

    /**
     * Método para leer un archivo .txt
     * @param file Archivo a leer
     * @return Lista de canciones que se han leído del archivo
     */
    private static ArrayList<Cancion> leerTxt(File file) {
        ArrayList<Cancion> listaCanciones = new ArrayList<>();
        try (Scanner sc = new Scanner(file)) {
            sc.nextLine();
            while (sc.hasNextLine()) {
                String titulo = sc.nextLine();
                String autor = sc.nextLine();
                int duracion = Integer.parseInt(sc.nextLine());
                Cancion cancion = new Cancion(titulo, autor, duracion);
                listaCanciones.add(cancion);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("No se ha encontrado el archivo");
        }
        return listaCanciones;
    }

    /**
     * Método para pedir un archivo al usuario debe de ser .txt o .dat
     * sino se le pedirá que introduzca otro archivo
     * @return Archivo que ha introducido el usuario
     */
    private static File getFile() {
        File file;
        String path;
        boolean exists;
        boolean validExtension;
        do {
            path = GetData.getString("Introduce la ruta del archivo: ");
            file = new File(path);
            exists = file.exists();
            validExtension = path.endsWith(".txt") || path.endsWith(".dat");
            if (!exists) {
                System.out.println("El archivo no existe");
            } else if (!validExtension) {
                System.out.println("El archivo no tiene una extensión válida");
            }
        } while (!exists || !validExtension);
        return file;
    }

    /**
     * Método para pedir un archivo al usuario debe de ser .dat
     * sino se le pedirá que introduzca otro archivo
     * @return Archivo que ha introducido el usuario
     */
    private static File getFileToSave() {
        File file;
        String path;
        boolean validExtension;
        do {
            path = GetData.getString("Introduce la ruta del archivo: ");
            file = new File(path);
            validExtension = path.endsWith(".dat");
            if (!validExtension) {
                System.out.println("El archivo no tiene una extensión válida");
            }
        } while (!validExtension);
        return file;
    }
}
