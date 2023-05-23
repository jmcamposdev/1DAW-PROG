package bingo;

import Funciones.GetData;

import java.util.ArrayList;
import java.util.Random;

public class GestionBingo {
    public static void main(String[] args) {
        Random random = new Random();
        boolean catadoBingo = false;
        boolean filaCantada = false;
        int bola;
        ArrayList<Carton> cartones = new ArrayList<>();
        int numeroJugadores = GetData.getInt("Cuantos jugadores habrá (2 - 6): ",2,6);
        // Añadimos los cartones
        for (int i = 0; i < numeroJugadores; i++) {
            cartones.add(new Carton());
        }

        // Mostramos los cartones
        for (int i = 0; i < cartones.size(); i++) {
            System.out.println("Carton Nº"+(i+1));
            System.out.println(cartones.get(i));
        }

        while (!catadoBingo) {
            bola = random.nextInt(50 - 1 + 1) + 1;
            System.out.println("La Bola es: "+bola);
            for (Carton carton : cartones) {
                boolean casillaMarcada = carton.marcarCasilla(bola);
                boolean cartarFila = carton.cantarFila();
                boolean cantarBingo = carton.cantarBingo();

                if (!catadoBingo && cantarBingo) {
                    System.out.println("El Bingo: ");
                    System.out.println(carton);
                    catadoBingo = true;
                } else if (!filaCantada && cartarFila) {
                    System.out.println("Fila Cantada:");
                    System.out.println(carton);
                    filaCantada = true;
                } else if (casillaMarcada) {
                    System.out.println(carton);
                }
            }
        }
        System.out.println("Fin del Bingo");
    }
}
