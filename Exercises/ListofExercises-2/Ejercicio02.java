package RelacionEjercicios2;

/*
    2. Realizar una aplicación que escriba en pantalla los valores de una progresión geométrica utilizando
    un bucle mientras (while). Se introducirá por teclado el número de elementos de la progresión (N), la
    razón (r) o factor de la progresión y el término inicial (ti).

        Por ejemplo: ti = 3, r = 2 y N = 5 la progresión sería: 3 6 12 24 48...
 */


import Funciones.*;

public class Ejercicio02 {
    public static void main(String[] args) {
        int n,r,ti,contador=1; //Creamos las variables necesarias para el algoritmo
        ti = GetData.getInt("Ingrese el termino inicial: ",1); // Validamos los datos de ti
        r = GetData.getInt("Ingrese la razon (incremento): ",1);// Validamos los datos de r
        n = GetData.getInt("Ingrese la progresión: ",1); // Validamos los datos de n

        int[] numeros = Operaciones.progresionGeometrica(ti,r,n);
        for (int valor:numeros) {
            System.out.print(","+valor);
        }


    }
}