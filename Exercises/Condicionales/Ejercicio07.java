package EjerciciosCondicionales;
import Funciones.GetData;


public class Ejercicio07 {
    public static void main(String[] args) {
        double base,area,altura;
        base = GetData.getDouble("Ingrese la base: ",0.1);
        altura = GetData.getDouble("Ingrese la altura: ",0.1);
        if (altura > 0 && base > 0) {
            area = (base * altura) / 2;
            System.out.println("El area del triangulo con base " + base + " y altura " + altura + " es: " + area);
        } else {
            System.out.println("Datos erroneos");
        }

    }
}
