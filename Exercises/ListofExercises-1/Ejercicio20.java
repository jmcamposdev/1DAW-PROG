package RelacionEjercicios1;

/*
    20. Dado un número N, comprobar si es primo.
 */


import Funciones.*;

public class Ejercicio20 {
    public static void main(String[] args) {
        int numero;
        numero = GetData.getInt("Ingrese el numero: ");
        if (Operaciones.esPrimo(numero)){
            System.out.println("Es primo");
        } else {
            System.out.println("No es primo");
        }


    }
}
