package RelacionEjercicios1;

/*
    6. Calcular la suma de todos los números pares, por un lado, y por otro, la de todos los impares; desde 1 hasta
    N, siendo N un número entero positivo introducido por teclado.
 */


import Funciones.GetData;

public class Ejercicio06 {
    public static void main(String[] args){
        int numero;
        int sumapar = 0;
        int sumaimp = 0;
        numero = GetData.getInt("Ingrese un numero positivo: ",1);

        for (int i = 1; i <= numero; i++) {
            if (i % 2 == 0){
                sumapar = sumapar + i;
            } else {
                sumaimp = sumaimp + i;
            }
        }
        System.out.println("La suma de los pares es: " + sumapar);
        System.out.println("La suma de los impares es: " + sumaimp);
    }
}
