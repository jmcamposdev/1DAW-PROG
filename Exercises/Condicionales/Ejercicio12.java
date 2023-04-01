package EjerciciosCondicionales;
import Funciones.*;


public class Ejercicio12 {
    public static void main(String[] args) {
        double a,b,x;

        a = GetData.getDoubleDistinto("Ingrese el valor de a: ",0);
        b = GetData.getDouble("Ingrese el valor de b: ");
        if (a != 0){
            x = Operaciones.ecuacion1Grado(a,b);
            System.out.println("El valor de x es: "+x);
        } else {
            System.out.println("Datos erroneos.");
        }

    }
}
