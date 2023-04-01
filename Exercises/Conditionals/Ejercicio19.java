package EjerciciosCondicionales;
import Funciones.GetData;


public class Ejercicio19 {
    public static void main(String[] args) {
        float suma = 0f;
        String desayuno,bebida,tipo;
        desayuno = GetData.getString("Que has desayunado: tostadas, churros, donuts");
        switch (desayuno){
            case "churros" -> suma+=1.50;
            case "donuts" -> suma+=1;
            case "tostadas" -> {
                tipo = GetData.getString("Que tipo: básica o especial: ");
                switch (tipo){
                    case "básica" -> suma+=1.20;
                    case "especial" -> suma+=1.60;
                    default -> throw new IllegalStateException("Unexpected value: " + tipo);
                }
            }
            default -> throw new IllegalStateException("Unexpected value: " + desayuno);
        }
       bebida = GetData.getString("Que tipo de bebida: zumo o cafe: ");
        switch (bebida){
            case "zumo" -> suma+=1.80;
            case "cafe" -> suma+=1.20;
            default -> throw new IllegalStateException("Unexpected value: " + bebida);
        }
        System.out.println("El total es: "+suma);

    }
}
