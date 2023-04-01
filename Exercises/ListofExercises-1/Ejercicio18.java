package RelacionEjercicios1;

/*
    18. Diseña un diagrama de flujo que calcule el número de años, meses, semanas y días, dado un determinado
    número de días introducido por teclado.
 */


import Funciones.GetData;

public class Ejercicio18 {
    public static void main(String[] args) {
        int dias;
        int meses;
        int años;
        dias = GetData.getInt("Ingrese los dias: ",1);
        años = dias/365;
        dias = dias - (años*365);
        meses = dias/30;
        dias = dias - (meses*30);
        System.out.println("Son "+años+" Años, "+meses+" Meses, "+dias+" Dias");
    }
}
