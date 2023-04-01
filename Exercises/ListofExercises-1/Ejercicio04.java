package RelacionEjercicios1;

/*
    4. Mostrar la suma de los N primeros números. N se introducirá por teclado y deberá ser un entero positivo
 */


import Funciones.*;

public class Ejercicio04 {
    public static void main(String[] args){
        int numero;
        numero = GetData.getInt("Ingrese un numero positivo: ",1);
        int suma = Operaciones.sumaNNumeros(numero);
        System.out.println("La suma de los " + numero + " primeros numeros es: " + suma);
    }
}
