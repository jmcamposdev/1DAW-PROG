package EjerciciosBucles;
import Funciones.GetData;


public class Ejercicio22 {
    public static void main(String[] args) {
        double numero = 0,suma = 0,media = 0;
        int cantidadNumeros = 0;
        numero = GetData.getDouble("Ingrese un número: ");
        while (numero > 0){
            cantidadNumeros+= 1;
            suma+=numero;
            numero = GetData.getDouble("Ingrese un número: ");
        }
        if (cantidadNumeros != 0){
            media = suma/cantidadNumeros;
        }
        System.out.println("La media es: "+media);


    }
}
