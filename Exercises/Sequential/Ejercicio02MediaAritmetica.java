package EjerciciosSecuenciales;
import Funciones.GetData;


public class Ejercicio02MediaAritmetica {
    public static void main(String[] args) {
        double numero1,numero2,media;
        System.out.println("Bienvenido al programa para realizar la media aritmética de dos numeros");
        System.out.println("-----------------------------------------------------------------------");
        numero1 = GetData.getInt("Ingrese el primer numero (>0): ",1);
        numero2= GetData.getInt("Ingrese el segundo numero (>0): ",1);
        media = (numero1+numero2)/2;
        System.out.println("La media de "+numero1+" y "+numero2+" es: "+media);

    }
}
