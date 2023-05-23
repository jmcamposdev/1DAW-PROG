package pruebatrycatch;

import java.io.*;

public class LecturaFicheros {
    public static void main(String[] args) {
        File f = new File("datos/info.txt");
        BufferedReader bf = null;
        try{
            bf = new BufferedReader(new FileReader(f));
            String cad;
            while ((cad=bf.readLine()) != null) {
                System.out.println(cad);
            }
        } catch (IOException e) {
            System.out.println("El fichero no existe");
        } finally {
            if (bf != null) {
                try {
                    bf.close();
                } catch (IOException e) {
                    System.out.println("No se ha podido cerrar");
                }
            }
        }
    }
}
