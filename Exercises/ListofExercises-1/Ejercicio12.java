package RelacionEjercicios1;

/*
    12. Pedir un número entre 0 y 9.999, decir si es capicúa (usando / y % de enteros).
 */


import Funciones.*;

public class Ejercicio12 {
    public static void main(String[] args){
        int numero;
        int reves = 0;
        int div;
        int mod;
        numero = GetData.getInt("Ingrese un número: ");
        if (Operaciones.capicua(numero)){
            System.out.print("Es Capicúa");
        } else {
            System.out.println("No es Capicúa");
        }
    }
}
