package RelacionEjercicios1;

/*
    9. Calcular la potencia y=Xn. La base X puede ser cualquier número real y el exponente n será de tipo entero. X
    y n serán introducidos por teclado, debiendo calcular el valor de y. Utilizar un bucle Desde.
 */


import Funciones.*;

public class Ejercicio09 {
    public static void main(String[] args){
        double base;
        int exponente;
        int exponentemodificado;
        double resultado = 0;
        base = GetData.getDouble("Ingrese la Base: ");
        exponente = GetData.getInt("Ingrese el Exponente: ");

        System.out.println("El resultado es: "+ Operaciones.potencia((int)base,exponente));
    }
}
