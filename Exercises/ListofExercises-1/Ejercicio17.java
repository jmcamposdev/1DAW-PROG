package RelacionEjercicios1;

/*
    17. Queremos conocer los datos estadísticos de una asignatura, por lo tanto, necesitamos un algoritmo que lea
    el número de suspensos, aprobados, notables y sobresalientes de una asignatura, y nos devuelva:
        ● El tanto por ciento de alumnos que han superado la asignatura.
        ● El tanto por ciento de suspensos, aprobados, notables y sobresalientes de la asignatura
 */


import Funciones.GetData;

public class Ejercicio17 {
    public static void main(String[] args) {
        int numeroSuspensos;
        int numeroAprovados;
        int numeroNotables;
        int numeroSobresalientes;
        int notasTotales;
        int porcentajeSuperado;
        int porcentajeSuspensos;
        int porcentajeAprobados;
        int porcentajeNotables;
        int porcentajeSobresalientes;

        numeroSuspensos = GetData.getInt("Ingrese los suspensos: ",0);
        numeroAprovados = GetData.getInt("Ingrese los aprovados: ",0);
        numeroNotables = GetData.getInt("Ingrese los notables: ",0);
        numeroSobresalientes = GetData.getInt("Ingrese los sobresalientes: ",0);

        notasTotales = numeroSuspensos + numeroAprovados + numeroNotables + numeroSobresalientes;
        porcentajeSuperado = ((numeroAprovados +  numeroNotables + numeroSobresalientes)) * 100 / notasTotales;
        porcentajeSuspensos = numeroSuspensos * 100 / notasTotales;
        porcentajeAprobados = numeroAprovados * 100 / notasTotales;
        porcentajeNotables = numeroNotables * 100 / notasTotales;
        porcentajeSobresalientes = numeroSobresalientes * 100 / notasTotales;

        System.out.println("El total de alumnos superados es: " + porcentajeSuperado+"%");
        System.out.println("El total de alumnos suspensos es: " + porcentajeSuspensos+"%");
        System.out.println("El total de alumnos aprovados es: " + porcentajeAprobados+"%");
        System.out.println("El total de alumnos con notables es: " + porcentajeNotables+"%");
        System.out.println("El total de alumnos sobresalientes es: " + porcentajeSobresalientes+"%");
    }
}