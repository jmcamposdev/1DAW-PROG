package EjerciciosBucles;
import Funciones.GetData;


public class Ejercicio25 {
    public static void main(String[] args) {
        double numeroIntroducido,total=0,mayor=0,sumaimpar=0,mediaimpar=0;
        int cantidadimpar=0;
        numeroIntroducido = GetData.getDouble("Ingrese un número: ");
        while (numeroIntroducido > 0){
            total+=1;
            if (numeroIntroducido%2!=0){
                sumaimpar+=numeroIntroducido;
                cantidadimpar+=1;
            } else{
                mayor = numeroIntroducido>mayor ? numeroIntroducido : mayor;
            }
            numeroIntroducido = GetData.getDouble("Ingrese un número: ");
        }
        if (cantidadimpar!=0){
            mediaimpar = sumaimpar/cantidadimpar;
        }

        System.out.println("La media impar es: "+mediaimpar);
        System.out.println("El mayor de los pares es: "+mayor);

    }
}
