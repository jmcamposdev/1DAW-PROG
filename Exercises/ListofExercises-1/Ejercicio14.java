package RelacionEjercicios1;

/*
    14. Pedir el día, mes y año de una fecha e indicar si la fecha es correcta. Con meses de 28, 30 y 31 días. Sin
    años bisiestos.
 */


import Funciones.*;

public class Ejercicio14 {
    public static void main(String[] args){
        int dia;
        int mes;
        int año;
        dia = GetData.getInt("Ingrese el dia: ",1,31);
        mes = GetData.getInt("Ingresa el mes: ",1,12);
        año = GetData.getInt("Ingresa el año: ",1);

        if (Operaciones.fechaValida(dia,mes)){
            System.out.println("La fecha es valida");
        } else {
            System.out.println("La fecha no es valida");
        }
    }
}
