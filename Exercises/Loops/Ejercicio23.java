package EjerciciosBucles;
import Funciones.*;


public class Ejercicio23 {
    public static void main(String[] args) {
        int numeroIntroducido;
       numeroIntroducido = GetData.getInt("Introduce un número: ",0);
        int[] numeros = Operaciones.serieFibonacci(numeroIntroducido);
        for (int valor: numeros) {
            System.out.print(valor+",");
        }


        /*
        int aux=0,num1=0,num2=1;
        if (numeroIntroducido<0){
            System.out.println("Datos Erroneos");
        } else if (numeroIntroducido == 0){
            System.out.println("0");
        } else if (numeroIntroducido == 1){
            System.out.println("0,1");
        } else{
            System.out.print("0,1");
            while (numeroIntroducido >= 2){
                aux = num1;
                num1 = num2;
                num2 = aux + num2;
                numeroIntroducido=numeroIntroducido-1;
                System.out.print(","+num2);
            }
        }
         */


    }
}
