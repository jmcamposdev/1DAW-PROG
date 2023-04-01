package RelacionEjercicios1;

/*
    16. Una llamada telefónica cuesta 15 cent/min los tres primeros minutos, y cada minuto o fracción restantes
    cuesta 7 cent/min. Calcular e imprimir el importe de una llamada introduciendo su duración en segundos.
 */


import Funciones.GetData;import Funciones.Operaciones;


public class Ejercicio16 {
    public static void main(String[] args) {
        int segundos;
        int importe;
        segundos = GetData.getInt("Ingrese la cantidad de segundos: ",1);
        importe = Operaciones.costeLlamadaTelefonica(segundos);
        System.out.println("El importe total es: " + importe);
    }
}

