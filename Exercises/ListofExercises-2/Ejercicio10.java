package RelacionEjercicios2;
import Funciones.GetData;


public class Ejercicio10 {
    public static void main(String[] args) {
        int numero,suma=0,contador=0;
        int media;
        do {
            numero = GetData.getInt("Ingrese un número: ");
            suma+=numero;
            contador+=1;
        } while (suma<10000);
        media= suma/contador;
        System.out.println("La suma total es: "+suma);
        System.out.println("La cantidad de numeros introducidos es: "+contador);
        System.out.println("La media es: "+media);
    }
}
