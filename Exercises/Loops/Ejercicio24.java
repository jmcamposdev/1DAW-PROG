package EjerciciosBucles;
import Funciones.GetData;


public class Ejercicio24 {
    public static void main(String[] args) {
        int numeroIntroducido,positivos=0,negativos=0;
        for (int i = 0; i < 10; i++) {
            numeroIntroducido = GetData.getInt("Introduce un número: ");
            if (numeroIntroducido < 0){
                negativos+=1;
            } else if (numeroIntroducido > 0) {
                positivos+=1;
            }
        }
        System.out.println("El numero de positivos es: "+positivos);
        System.out.println("El numero de negativos es: "+negativos);
    }
}
