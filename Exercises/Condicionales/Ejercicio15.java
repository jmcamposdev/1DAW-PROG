package EjerciciosCondicionales;
import Funciones.*;


public class Ejercicio15 {
    public static void main(String[] args) {
        int horas,minutos,segundos;
        horas = GetData.getInt("Ingrese las horas: ",0,23);
        minutos = GetData.getInt("Ingrese los minutos: ",0,59);
        if (horas >= 0 && horas <= 23 && minutos >= 0 && minutos <= 59){
            segundos = Operaciones.segundosHastaElAmanecer(horas,minutos);
            System.out.println("Quedan "+segundos+" segundos para media noche");
        } else {
            System.out.println("Datos Erroneos");
        }

    }
}
