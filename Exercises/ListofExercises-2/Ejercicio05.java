package RelacionEjercicios2;
import Funciones.*;


public class Ejercicio05 {
    public static void main(String[] args) {
        double hipoteca,interes,cuotaMensual,r,pagoTotal;
        int años;
        hipoteca = GetData.getDouble("Ingrese la hipoteca: ",1);
        años = GetData.getInt("Ingrese los años: ",1);
        interes = GetData.getDouble("Ingrese el interes: ",0);

        cuotaMensual = Operaciones.cuotaMensual(hipoteca,años,interes);
        pagoTotal = (cuotaMensual*12)*años;
        System.out.println("El importe total a pagar es: "+pagoTotal);


    }
}
