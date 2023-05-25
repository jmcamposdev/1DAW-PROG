package Funciones;

import java.util.Scanner;

public class GetData {

     public static String getString(String mensaje) {
        Scanner sc = new Scanner(System.in);
        String texto;
        System.out.print(mensaje);
        while (!sc.hasNext("[A-Za-zÁÉÍÓÚáéíóúñÑ\\d/.-]*")){
            System.out.println("Ingrese un string valido.");
            System.out.print(mensaje);
            sc.nextLine();
        }
        texto = sc.nextLine();
        return texto;
    }
}
