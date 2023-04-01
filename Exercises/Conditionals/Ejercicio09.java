package EjerciciosCondicionales;
import Funciones.GetData;

public class Ejercicio09 {
    public static void main(String[] args) {
        String dia;
        dia = GetData.getString("Ingrese un dia de la semana: ");
        switch (dia){
            case "Lunes","lunes" -> System.out.println("Toca Programación");
            case "Martes","martes" -> System.out.println("Toca Programación");
            case "Miercoles","miercoles" -> System.out.println("Toca FOL");
            case "Jueves","jueves" -> System.out.println("Toca Base de Datos");
            case "Viernes","viernes" -> System.out.println("Toca Base de Datos");
            default -> System.out.println("Valor erroneo");
        }
    }
}
