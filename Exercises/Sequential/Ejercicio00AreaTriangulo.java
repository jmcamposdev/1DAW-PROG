package EjerciciosSecuenciales;
import Funciones.*;

public class Ejercicio00AreaTriangulo {
    public static void main(String[] args) {
        double base,altura,area;

        System.out.println("Bienvenido al programa de cálculo del área del triángulo.");
        System.out.println("---------------------------------------------------------");

        base = GetData.getDouble("Ingrese la base del triangulo (>0): ", 1);
        altura = GetData.getDouble("Ingrese la altura del triangulo (>0): ",1);
        area = (base*altura)/2;
        System.out.println("El área del triángulo con b="+base+" y h="+altura+" es: " + area);
    }
}
