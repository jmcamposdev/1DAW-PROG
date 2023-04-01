package EjerciciosSecuenciales;
import Funciones.*;


public class Ejercicio04VolumenCono {
    public static void main(String[] args) {
        double radio,altura,volumen;

        System.out.println("Bienvenido al programa para calcular el volumen de un cono.");
        System.out.println("-----------------------------------------------------------");
        radio = GetData.getDouble("Ingrese el radio del cono: ",0.1);
        altura = GetData.getDouble("Ingrese la altura del cono: ",0.1);

        volumen = (Math.PI*radio*radio*altura)/3;
        System.out.println("El volumen del cono con radio="+radio+" y altura="+altura+" es: "+volumen);

    }
}
