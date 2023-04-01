package EjerciciosCondicionales;
import Funciones.*;

public class Ejercicio13 {
    public static void main(String[] args) {
        double tiempo,altura;
        altura = GetData.getDouble("Ingrese la altura: ",0.1);
        if (altura > 0){
            tiempo = Operaciones.tiempoCaida(altura);
            System.out.println("El tiempo de caída es: "+tiempo);
        } else {
            System.out.println("La altura debe ser superior a 0;");
        }

    }
}
