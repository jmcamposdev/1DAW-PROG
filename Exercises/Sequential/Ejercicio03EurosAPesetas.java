package EjerciciosSecuenciales;
import Funciones.*;

public class Ejercicio03EurosAPesetas {
    public static void main(String[] args) {
        double euro;
        double pesetas;
        System.out.println("Bienvenido al conversor de euros a pesetas");
        System.out.println("------------------------------------------");
        euro = GetData.getDouble("Ingrese los euros: ",0.1);
        pesetas = euro * 166.86;
        System.out.println(euro+" Euros son: " + pesetas+ " Pesetas");


    }
}
