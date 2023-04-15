/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package serializarnumeros;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author josemaria
 */
public class SerializarNumeros {

    private static final File file1 = new File("./src/serializarnumeros/numeros1.dat");
    private static final File file2 = new File("./src/serializarnumeros/numeros2.dat");
    private static final int[] numeros = {0,1,2,3,4,5,6,7,8,9};
        
    public static void main(String[] args) {
        boolean escrituraIdividual = true;        
        boolean escrituraArray = true;

        if (escribirNumeros()) {
            System.out.println("Se han escrito los números indicidualmente.");
        } else {
            System.out.println("No se ha podido escribir en el fichero");
            escrituraIdividual = false;
        }
        
        if (escribirArray()) {
            System.out.println("Se ha escrito el Array de ints correctamente");
        } else {
            System.out.println("No se ha podido escribir el Fichero");
            escrituraArray = false;
        }
        
        if (escrituraIdividual) {
            System.out.println("El contendio del fichero numero1.dat (Numeros individuales)");
            leerNumeros();
        }
        if (escrituraArray) {
            System.out.println("\nEl contenido del fichero numero2.dat (Array)");
            leerArray();
        }
        
        
    }
    
    private static boolean escribirNumeros () {
        boolean ficheroEscrito = true;
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file1))){
            oos.writeInt(numeros.length);
            for (int i = 0; i < numeros.length; i++) {
                oos.writeInt(numeros[i]);
            }
            oos.flush();
        } catch (IOException e) {
            ficheroEscrito = false;
        }
        return ficheroEscrito;
    }
    
    private static boolean escribirArray() {
        boolean ficheroEscrito = true;
        
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file2))) {
            oos.writeObject(numeros);
        } catch (IOException ex) {
            ficheroEscrito = false;
        } 
        return ficheroEscrito;
    }
    
    private static void leerNumeros() {
        try (ObjectInputStream ois = new ObjectInputStream( new FileInputStream(file1))){
            int cantidadDeNumeros = ois.readInt();
            int numero;
            for (int i = 0; i < cantidadDeNumeros; i++) {
                numero = ois.readInt();
                System.out.print(numero+" ");
            }
        } catch (IOException ex) {
            Logger.getLogger(SerializarNumeros.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private static void leerArray() {
        try (ObjectInputStream ois = new ObjectInputStream( new FileInputStream(file2))){
            int[] numerosFichero = (int[]) ois.readObject();
            for (int i = 0; i < numerosFichero.length; i++) {
                System.out.print(numerosFichero[i]+ " ");
            }
        } catch (IOException ex) {
            Logger.getLogger(SerializarNumeros.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SerializarNumeros.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
