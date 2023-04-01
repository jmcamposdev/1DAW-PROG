package EjerciciosSecuenciales;
import Funciones.*;

public class  Ejercicio07MediaPonderada {
    public static void main(String[] args) {
        double nota1,nota2,media;
        System.out.println("Bienvenido al programa que realiza la Media Ponderada.");
        System.out.println("------------------------------------------------------");

        nota1 = GetData.getDouble("Ingrese la nota del primer examen: ",0,10);
        media = GetData.getDouble("Nota deseada para el trimestre",0,10);
        nota2 = (int) Operaciones.mediaPonderada(nota1,media);
        System.out.println("Para sacar un "+media+" deverias sacar un "+nota2);


    }
}
