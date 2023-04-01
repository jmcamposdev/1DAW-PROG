package EjerciciosBidimensional;
/*
    Escribe un programa que, dada una posición en un tablero de ajedrez, nos diga a qué casillas podría saltar un alfil que se encuentra en esa posición. Como se indica en la figura, el alfil se mueve siempre en diagonal. El tablero cuenta con 64 casillas. Las columnas se indican con las letras de la “a” a la “h” y las filas se indican del 1 al 8.
 */

import Funciones.GetData;
import java.util.Scanner;

public class Ejercico08 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese la posición: ");
        String posicion = sc.next();
        char ejeXChar = posicion.charAt(0);
        int ejeY = Integer.parseInt(posicion.substring(1,2))-1;
        int ejeX;
        switch (ejeXChar){
            case 'a' -> ejeX = 0;
            case 'b' -> ejeX = 1;
            case 'c' -> ejeX = 2;
            case 'd' -> ejeX = 3;
            case 'e' -> ejeX = 4;
            case 'f' -> ejeX = 5;
            case 'g' -> ejeX = 6;
            case 'h' -> ejeX = 7;
            default -> throw new IllegalArgumentException("Posicion no valido");
        }
        //int ejeX = GetData.getInt("Ingrese la fila deseada: ",0,7);
        //int ejeY = GetData.getInt("Ingrese la columna deseada: ",0,7);

        int copiaEjeX = ejeX;
        int copiaEjeY = ejeY;
        System.out.println("Arriba Izquierda");
        copiaEjeX--;
        copiaEjeY++;
        while (copiaEjeX>=0 && copiaEjeY<8){
            System.out.print(convertirLetra(copiaEjeX)+(copiaEjeY+1)+" ");
            copiaEjeX--;
            copiaEjeY++;
        }
        copiaEjeX = ejeX;
        copiaEjeY = ejeY;

        System.out.println(" ");
        System.out.println("Arriba Derecha");
        copiaEjeX++;
        copiaEjeY++;
        while (copiaEjeX<8 && copiaEjeY<8){
            System.out.print(convertirLetra(copiaEjeX)+(copiaEjeY+1)+" ");
            copiaEjeX++;
            copiaEjeY++;
        }
        copiaEjeX = ejeX;
        copiaEjeY = ejeY;

        System.out.println(" ");
        System.out.println("Abajo Izquierda");
        copiaEjeX--;
        copiaEjeY--;
        while (copiaEjeX>=0 && copiaEjeY>=0){
            System.out.print(convertirLetra(copiaEjeX)+(copiaEjeY+1)+" ");
            copiaEjeX--;
            copiaEjeY--;
        }
        copiaEjeX = ejeX;
        copiaEjeY = ejeY;

        System.out.println(" ");
        System.out.println("Abajo Derecha");
        copiaEjeX++;
        copiaEjeY--;
        while (copiaEjeX<8 && copiaEjeY>=0){
            System.out.print(convertirLetra(copiaEjeX)+(copiaEjeY+1)+" ");
            copiaEjeX++;
            copiaEjeY--;
        }
        copiaEjeX = ejeX;
        copiaEjeY = ejeY;
    }

    public static String convertirLetra (int numero){
        String letra = "a";
        switch (numero){
            case 0 -> letra = "a";
            case 1 -> letra = "b";
            case 2 -> letra = "c";
            case 3 -> letra = "d";
            case 4 -> letra = "e";
            case 5 -> letra = "f";
            case 6 -> letra = "g";
            case 7 -> letra = "h";
            default -> throw new IllegalArgumentException("Valor Erroneo");
        }
        return letra;
    }
}
