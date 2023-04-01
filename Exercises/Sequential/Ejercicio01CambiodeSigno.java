package EjerciciosSecuenciales;
import Funciones.*;


public class Ejercicio01CambiodeSigno {
    public static void main(String[] args) {
        int numero,cambioDeSigno;
        System.out.println("Bienvenido al programa para cambiar de signo.");
        System.out.println("---------------------------------------------");
        numero = GetData.getInt("Ingrese el numero para cambiarlo de signo: ");

        cambioDeSigno = numero * -1;
        System.out.println("El numero "+numero+" cambiado de signo es: "+numero*-1);
    }
    
}
