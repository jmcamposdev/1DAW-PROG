package RelacionEjercicios2;
import Funciones.*;


public class Ejercicio12 {
    public static void main(String[] args) {
        int numeroIntroducido,divisorCifras,numeroDecifras=0,cifra,numeroModificado=0,j,posicion,digitoAInsertar;
        boolean salida = false;
        // Calculamos el numero de cifras que tiene el número
        numeroIntroducido = GetData.getInt("Ingrese un número: ",1);
        numeroIntroducido*=10;
        posicion = GetData.getInt("Introduzca la posición donde quiere insertar: ",1, Operaciones.cifras(numeroIntroducido));
        digitoAInsertar = GetData.getInt("Introduzca el dígito que quiere insertar: ",0,9);
        System.out.println(Operaciones.insertarDigito(numeroIntroducido,digitoAInsertar,posicion));

    }
    /*
    int numeroIntroducido,divisorCifras,numeroDecifras=0,cifra,numeroModificado=0,j,posicion,digitoAInsertar;
        boolean salida = false;
        // Calculamos el numero de cifras que tiene el número
        numeroIntroducido = getData.getInt("Ingrese un número: ",1);
        numeroIntroducido = numeroIntroducido*(int)Math.pow(10,1);
        divisorCifras = numeroIntroducido;
        while (divisorCifras!=0){
            divisorCifras = divisorCifras/10;
            numeroDecifras+=1;
        }
        posicion = getData.getInt("Introduzca la posición donde quiere insertar: ",1,numeroDecifras);
        numeroDecifras--; //Restamos una ya que si no nos sale resto
        digitoAInsertar = getData.getInt("Introduzca el dígito que quiere insertar: ",0,9);
        System.out.println(operaciones.insertarDigito(numeroIntroducido,digitoAInsertar,posicion));
        j = numeroDecifras;
        for (int i = 1; i <= j+1 && !salida; i++) {
            cifra = numeroIntroducido/(int)Math.pow(10,numeroDecifras);
            if (i == posicion){
                numeroModificado = numeroModificado + (digitoAInsertar*(int)Math.pow(10,numeroDecifras))+(numeroIntroducido/10);
                salida = true;
            } else {
                numeroIntroducido = numeroIntroducido - (cifra*(int)Math.pow(10,numeroDecifras));
                numeroModificado = numeroModificado + (cifra*(int)Math.pow(10,numeroDecifras));
                numeroDecifras--;
            }
        }
        System.out.println(numeroModificado);
     */
}

