package RelacionEjercicios2;

/*
    1. Diseña un programa que lea los coeficientes de una ecuación de segundo grado (ax2+bx+c=0) y
    calcule sus soluciones. Se supone que la ecuación tiene soluciones reales.
 */


import Funciones.*;

public class Ejercicio01 {
    public static void main(String[] args) {
        int a, b, c;
            a = GetData.getInt("Ingrese a: ", 1);
            b = GetData.getInt("Ingrese b: ");
            c = GetData.getInt("Ingrese c: ");
        double[] soluciones = Operaciones.ecuacion2Grado(a, b, c);
        if (soluciones == null) {
            System.out.println("No tiene solución");
        } else if (soluciones.length == 1){
            System.out.println("La primera solución: "+soluciones[0]);
        } else {
            System.out.println("La primera solución: "+soluciones[0]);
            System.out.println("La segunda solución: "+soluciones[1]);
        }

        //Realizar los dos resultados pero falta la raiz cuadrada.


    }
}
