package RelacionEjercicios1;

/*
    5. Mostrar los N primeros múltiplos de 3. N será introducido por teclado y deberá ser un entero positivo.
 */

import Funciones.*;

public class
Ejercicio05 {
    public static void main(String[] args){
        int numero;
        numero = GetData.getInt("Ingrese un numero positivo: ",1    );
        int[] numeros = Operaciones.multiplosDe(3,numero);
        for (int valor:numeros) {
            System.out.println(valor);
        }
    }
}