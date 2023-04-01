package EjerciciosSecuenciales;
import Funciones.GetData;

public class Ejercicio05MultiOperaciones {
    public static void main(String[] args) {
        double numero1,numero2,suma,resta,division,multiplicacion;
        System.out.println("Bienvenido al programa que realizara la suma,resta,división,multiplicación de dos valores.");
        System.out.println("------------------------------------------------------------------------------------------");
        numero1 = GetData.getDouble("Ingrese el primer numero: ");
        numero2 = GetData.getDouble("Ingrese el segundo numero: ");
        suma = numero1 + numero2;
        resta = numero1 - numero2;
        if (numero1==0){
            division=0;
        }else {
            division=numero1/numero2;
        }
        multiplicacion = numero1 * numero2;
        System.out.println("La suma de "+numero1+" + "+numero2+" es:"+suma);
        System.out.println("La resta de "+numero1+" - "+numero2+" es:"+resta);
        System.out.println("La multiplicación de "+numero1+" * "+numero2+" es:"+multiplicacion);
        System.out.println("La división de "+numero1+" /"+numero2+" es:"+division);

    }
}
