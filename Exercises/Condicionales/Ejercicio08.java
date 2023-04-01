package EjerciciosCondicionales;
import Funciones.GetData;


public class Ejercicio08 {
    public static void main(String[] args) {
        int numero1,numero2;
        numero1 = GetData.getInt("Ingrese el primer numero: ");
        numero2 = GetData.getInt("Ingrese el segundo numero: ");
        if (numero1+numero2 > 0){
            System.out.println("La suma es mayor que cero");
        } else {
            System.out.println("La suma es menor que cero");
        }

    }
}
