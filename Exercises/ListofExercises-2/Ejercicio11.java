package RelacionEjercicios2;
import Funciones.*;


public class Ejercicio11 {
    public static void main(String[] args) {
        int numeroIntroducido,numeroDecifras=0,divisorCifras,cifra,contador;
        numeroIntroducido = GetData.getInt("Ingrese un número: ");
        // Calculamos el numero de cifras que tiene el número
        int[] palitosCifras = Operaciones.conversorPalitos(numeroIntroducido);
        for (int palitos:palitosCifras) {
            for (int i = 0; i < palitos; i++) {
                System.out.print("|");
            }
            System.out.print(" - ");
        }
    }
}
