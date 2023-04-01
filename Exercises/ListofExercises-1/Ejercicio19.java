package RelacionEjercicios1;

/*
    19. Una compañía de alquiler de automóviles desea un programa que calcule lo que se debe cobrar según los
    kilómetros realizados, teniendo presente los siguientes puntos:
     • Si no supera los 300 Km se deberá cobrar 500€
     • Para recorridos entre 300 Km y 1000 Km se le cobrará 500€ más el kilometraje excedente a los 300, a
    razón de 2€ por kilómetro.
     • Para recorridos mayores a 1000 Km se le cobrará 500€ más el kilometraje excedente a los 300, a razón de
    1€ por kilómetro.
 */


import Funciones.GetData;

public class Ejercicio19 {
    public static void main(String[] args) {
        int kilometros;
        int importe;
        kilometros = GetData.getInt("Ingresa los kilometros: ",1);
        if (kilometros < 300){
            importe = 500;
        } else if (kilometros <= 1000){
            kilometros = kilometros - 300;
            importe = (kilometros*2)+ 500;
        } else{
            kilometros = kilometros - 300;
            importe = kilometros + 500;
        }
        System.out.println("El importe total es: "+importe);


    }
}
