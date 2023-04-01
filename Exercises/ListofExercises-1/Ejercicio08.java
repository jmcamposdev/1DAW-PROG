package RelacionEjercicios1;

/*
    8. Escribe un algoritmo en diagrama de flujo que lea del teclado un año e indique si es bisiesto o no (Un año es
    bisiesto si es divisible por 4, excepto el último de cada siglo, aquellos divisibles por 100, que para ser bisiestos,
    también deben ser divisibles por 400.)
 */


import Funciones.*;

public class Ejercicio08 {
    public static void main(String[] args){
        int año;
        año = GetData.getInt("Ingrese un año: ",0);

        if (Operaciones.yearBisiesto(año)) {
            System.out.println("Es Bisiesto");
        } else {
            System.out.println("No es Bisiesto");
        }

        /*
        int año;
        año = getData.getInt("Ingrese un año: ",0);
        if ((año % 4 == 0) && (año % 100 != 0 || año % 400 == 0)) {
            System.out.println("Es Bisiesto");
        } else{
            System.out.println("No es Bisiesto");
        }

         */
    }
}