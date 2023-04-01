package RelacionEjercicios2;
import Funciones.*;

/*
    3. Hacer un programa que calcule e imprima los números perfectos menores de 1000. Un número es
    perfecto si la suma de sus divisores, excepto él mismo, es igual al propio número. Ejemplo: Los
    divisores de 6 son 6, 3, 2, 1 y la suma de todos sus divisores excepto él mismo es 3+2+1 = 6. Luego 6 es
    un número perfecto.
 */

public class Ejercicio03 {
    public static void main(String[] args) {
        int perfecto = 0; // Creamos la variable que almacenara la suma de los divisores del número
        for (int i = 1; i < 1000; i++) { // Se encargará de ir probando todos los numeros hasta el 1000
            if (Operaciones.numeroPerfecto(i)){
                System.out.print(i+",");
            }
        }
    }
}
