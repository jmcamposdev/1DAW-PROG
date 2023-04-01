package EjerciciosCondicionales;
import Funciones.GetData;


public class Ejercicio10 {
    public static void main(String[] args) {
        int hora;
        hora = GetData.getInt("Ingrese la hora entre 00 - 23: ",0,23);
        switch (hora){
            case 6,7,8,9,10,11,12 -> System.out.println("Buenos Días");
            case 13,14,15,16,17,18,19,20 -> System.out.println("Buenas Tardes");
            case 21,22,23,0,1,2,3,4 -> System.out.println("Buneas Noches");
            default -> throw new IllegalStateException("Unexpected value: " + hora);

        }
    }
}
