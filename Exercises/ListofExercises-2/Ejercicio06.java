package RelacionEjercicios2;
import Funciones.*;


public class Ejercicio06 {
    public static void main(String[] args) {
        double l1,l2,l3;
        l1 = GetData.getDouble("Ingrese el primer lado: ",0.1);
        l2 = GetData.getDouble("Ingrese el segundo lado: ",0.1);
        l3 = GetData.getDouble("Ingrese el tercero lado: ",0.1);

        System.out.println("El area es: "+ Operaciones.areaTriangulo(l1,l2,l3));

    }
}
