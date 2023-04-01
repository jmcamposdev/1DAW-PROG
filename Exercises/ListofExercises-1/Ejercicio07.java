package RelacionEjercicios1;

/*
    7. Mostrar el mayor y el menor de una serie de cinco números que vamos introduciendo por teclado (usando
    bucles).
 */


import Funciones.*;

public class Ejercicio07 {
    public static void main(String[] args){
        int[] numero = Operaciones.ordenarNumeros(5);
        System.out.println("El mayor es: "+numero[numero.length-1]);
        System.out.println("El menor es: "+numero[0]);



        /*
        int numero;
        int mayor = 0;
        int menor = 0;
        numero = getData.getInt("Ingrese un numero: ");
        mayor = numero;
        menor = numero;
        for (int i = 0; i < 4; i++) {
            numero = getData.getInt("Ingrese un numero: ");
            if (numero > mayor) {
                mayor = numero;
            } else if (numero < menor){
                menor = numero;
            }
        }
        System.out.println("El mayor es: " + mayor);
        System.out.println("El menor es: " + menor);
         */
    }
}

