package primosespeciales;

import Funciones.Utilities;

import java.util.ArrayList;

/**
 *
 * @author josemaria
 */
public class PrimosEspeciales {
    public static void main(String[] args) {
        // Se muestra por pantalla la lista de primos especiales hasta 62 que devuelve el último número con 19 cifras
        System.out.println(primosEspeciales(61));
    }

    /**
     * Método que devuelve un ArrayList con todos los números primos especiales
     * @param n El número hasta el que se quieren buscar los números primos especiales
     * @return Un ArrayList con todos los números primos especiales hasta n
     */
    public static ArrayList<Long> primosEspeciales(int n) {
        ArrayList<Long> primos = new ArrayList<>(); // ArrayList donde se guardarán los números primos especiales
        long i = 2; // Variable que se usará para recorrer los números hasta n
        while (i <= n) { // Mientras i sea menor que n
            // Si  2^i - 1 es primo, se añade a la lista de primos especiales
            long numero = (long) Math.pow(2, i) - 1;
            if (Utilities.isPrime(numero)) {
                primos.add(numero);
            }
            i++; // Se incrementa i
        }
        return primos; // Se devuelve la lista de primos especiales
    }
}
