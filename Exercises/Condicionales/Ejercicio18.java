package EjerciciosCondicionales;
import Funciones.*;


public class Ejercicio18 {
    public static void main(String[] args) {
        String jugador1,jugador2;
        do {
            jugador1 = GetData.getString("Jugador 1: Ingrese piedra,papel o tijera: ");
            jugador2 = GetData.getString("Jugador 2: Ingrese piedra,papel o tijera: ");
        } while (!((jugador1.equals("piedra")||jugador1.equals("papel")||jugador1.equals("tijera"))&&(jugador2.equals("piedra")||jugador2.equals("papel")||jugador2.equals("tijera"))));

        int ganador = Operaciones.piedraPapelTijera(jugador1,jugador2);
        switch (ganador){
            case 0 -> System.out.println("Empate");
            case 1 -> System.out.println("Gana Jugador 1");
            case -1 -> System.out.println("Gana Jugador 2");
        }


    }
}
