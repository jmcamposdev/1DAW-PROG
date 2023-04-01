package EjerciciosSecuenciales;
import Funciones.GetData;

public class Ejercicio06SalarioMensual {
    public static void main(String[] args) {
        int horas,salario;
        System.out.println("Bienvenido al programa para calcular el salario en base a las horas trabajadas");
        System.out.println("------------------------------------------------------------------------------");
        horas = GetData.getInt("holas");
        salario = horas * 12;
        System.out.println("Al trabajar "+horas+" horas te pertenecen "+salario+" euros");

    }
}
