package EjerciciosCondicionales;
import Funciones.*;


public class Ejercicio14 {
    public static void main(String[] args) {
        int dia,mes;

        boolean validado;
        do {
            dia = GetData.getInt("Ingrese el dia de nacimiento: ",1,31);
            mes = GetData.getInt("Ingrese el mes de nacimiento: ",1,12);
            validado = Operaciones.fechaValida(dia,mes);
            if (!validado){
                System.out.println("Fecha no valida.");
            }
        } while (!validado);
        System.out.println(Operaciones.horoscopo(dia,mes));

    }
}
