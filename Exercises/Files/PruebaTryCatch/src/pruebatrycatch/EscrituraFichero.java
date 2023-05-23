package pruebatrycatch;

import java.io.*;

public class EscrituraFichero {
    public static void main(String[] args) {
        File f = new File("datos/info.txt");
        BufferedWriter bw;
        if (f.exists()) {
            bw = null;
            try {
                bw = new BufferedWriter(new FileWriter(f, true));
                int number = 0;
                while (number != 100) {
                    bw.newLine();
                    bw.write(String.valueOf(number));
                    number++;
                }
            } catch (IOException e) {
                System.out.println("No se ha podido acceder al fichero");
            } finally {
                if (bw != null) {
                    try {
                        bw.close();
                    } catch (IOException e) {
                        System.out.println("No se ha podido cerrar");
                    }
                }
            }
        }

    }
}
