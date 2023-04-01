package RelacionEjercicios2;
import Funciones.GetData;

/*
    4. Realizar un juego para adivinar un número N. Para ello supondremos que tenemos disponible la función Aleatorio(x,y) que devuelve un número entero en el intervalo [x,y]. Una vez generado el número a adivinar, el programa irá pidiendo números indicando “mayor” o “menor” según sea mayor o menor con respecto a N. El proceso termina cuando el usuario acierta.
 */


public class Ejercicio04 {
    public static void main(String[] args) {
        int aleatorio = (int) (Math.random()*100);
        int numeroIntroducido;
        do {
            numeroIntroducido = GetData.getInt("Ingrese un numero: ");
            if (numeroIntroducido > aleatorio){
                System.out.println("El numero es menor");
            } else if (numeroIntroducido < aleatorio){
                System.out.println("El numero es mayor");
            }
        } while (numeroIntroducido != aleatorio);
        System.out.println("Ha adivinado el numero!!!");

    }
}
