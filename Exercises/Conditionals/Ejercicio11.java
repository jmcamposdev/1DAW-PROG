package EjerciciosCondicionales;
import Funciones.GetData;

public class Ejercicio11 {
    public static void main(String[] args) {
        int horas,salario;
        horas = GetData.getInt("Ingrese el numero de horas: ",1);
        if (horas <= 0){
            System.out.println("Horas introducidas erróneas.");
        } else {
            if (horas > 40){
                salario = 480 + ((horas-40)*10);
            } else {
                salario = horas * 12;
            }
            System.out.println("El salario es: "+salario);
        }


    }
}
