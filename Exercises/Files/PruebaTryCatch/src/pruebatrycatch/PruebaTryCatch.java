/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pruebatrycatch;

/**
 *
 * @author josemaria
 */
public class PruebaTryCatch {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            prueba(0, 7);
        } catch (MiExcepcion e) {
            System.out.println(e.getMessage());
        }

    }

    public static void prueba(int a, int b) throws MiExcepcion {
        if (b == 0) {
            throw new MiExcepcion();
        }
        if (a == 0) {
            throw new OtraExcepcion();
        }
    }
    
}
