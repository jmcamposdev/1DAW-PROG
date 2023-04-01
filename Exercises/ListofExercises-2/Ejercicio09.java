package RelacionEjercicios2;
import Funciones.GetData;


public class Ejercicio09 {
    public static void main(String[] args) {
        int habitacion,camas;
        String planta;
        System.out.println("Habitaciones Disponibles:");
        System.out.println("1. Azul");
        System.out.println("2. Roja");
        System.out.println("3. Verde");
        System.out.println("4. Rosa");
        System.out.println("5. Gris");
        habitacion = GetData.getInt("Ingrese el numero de la habitación deseada: ",1,5);
        if (habitacion == 1){
            camas = 2;
            planta = "Primera";
        } else if (habitacion == 2) {
            camas = 1;
            planta = "Primera";
        } else if (habitacion == 3){
            camas = 3;
            planta = "Segunda";
        } else if (habitacion == 4){
            camas = 2;
            planta = "Segunda";
        } else {
            camas = 1;
            planta = "Tercera";
        }
        System.out.println("La habitación dispone de "+camas+" camas.");
        System.out.println("Se situa en la "+planta+" planta.");
    }
}
