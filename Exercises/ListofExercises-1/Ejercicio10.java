package RelacionEjercicios1;

/*
    10. Pedir un número entre 0 y 9.999 y decir cuantas cifras tiene (usando / y % de enteros).
 */


import Funciones.*;

public class Ejercicio10 {
    public static void main(String[] args){
        int numero;
        numero = GetData.getInt("Ingrese un numero: ");

        System.out.println("Tiene " + Operaciones.cifras(numero) + " cifras");
    }
}