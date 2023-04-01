package RelacionEjercicios1;

/*
    11. Pedir una hora de la forma hora, minutos y segundos, y mostrar la hora en el segundo siguiente.
*/


import Funciones.GetData;

public class Ejercicio11 {
    public static void main(String[] args){
        int hora;
        int minutos;
        int segundos;

        hora = GetData.getInt("Ingrese la hora: ",0,23);
        minutos = GetData.getInt("Ingrese los minutos: ",0,59);
        segundos = GetData.getInt("Ingrese los segundos: ",0,59);
        if (minutos == 59 && segundos == 59){
            hora = hora + 1;
            minutos = 0;
            segundos = 0;
            if (hora == 24){
                hora = 0;
            }
        } else if (segundos == 59){
            segundos = 0;
            minutos = minutos + 1;
        } else{
            segundos = segundos +1;
        }
        System.out.println(hora + ":" + minutos + ":" + segundos);

    }
}
