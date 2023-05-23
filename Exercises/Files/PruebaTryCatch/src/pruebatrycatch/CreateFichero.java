package pruebatrycatch;
import java.io.File;
import java.io.IOException;

public class CreateFichero {
    public static void main(String[] args) {
        File f = new File("datos");
        f.mkdir();
        File fichero = new File(f, "info.txt");
        try{
            fichero.createNewFile();
            System.out.println("Se ha creado el fichero");
        } catch(IOException e) {
            System.out.println("No se ha podido crear el fichero"); 
        }
    }
}
