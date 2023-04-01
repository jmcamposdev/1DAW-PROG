package EjerciciosCondicionales;
import Funciones.GetData;


public class Ejercicio17 {
    public static void main(String[] args) {
        double nota1,nota2,media;
        String apto;
        nota1 = GetData.getDouble("Ingrese la primera nota: ",0,10);
        nota2 = GetData.getDouble("Ingrese la segunda nota: ",0,10);
        if (nota1 < 0 || nota1 > 10 || nota2 < 0 || nota2 > 10){
            System.out.println("Valores erroneos");
        } else{
            media = (nota1+nota2)/2;
            if (media>=5){
                System.out.println("La media es: "+media);
            } else{
                apto = GetData.getString("En la recuperación as obtenido apto o no apto:");
                if (!(apto.equals("apto") || apto.equals("no apto"))){
                    System.out.println("Valores erroneos");
                } else if (apto.equals("apto")){
                    System.out.println("La nota final es : 5");
                } else {
                    System.out.println("La nota final es: "+media);
                }

            }
        }

    }
}
