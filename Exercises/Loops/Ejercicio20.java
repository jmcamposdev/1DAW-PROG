package EjerciciosBucles;
import Funciones.*;


public class Ejercicio20 {
    public static void main(String[] args) {
        int numero;
        numero = GetData.getInt("Ingrese el numero deseado: ");
        int[] array = Operaciones.multiplosDe(numero, 10);
        for (int i = 0; i <= array.length-1; i++) {
            System.out.println(numero+" * "+(i+1)+" = "+array[i]);
        }
    }
}
