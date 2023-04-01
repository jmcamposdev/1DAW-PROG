package RelacionEjercicios1;

/*
    13. Realiza un programa que dado un importe en euros nos indique el mínimo número de billetes y la cantidad
    sobrante que se pueden utilizar para obtener dicha cantidad. Por ejemplo, 232€:
    1 billete de 200€
    1 billete de 20€
    1 billete de 10€
    Sobran 2€
 */


import Funciones.GetData;

public class Ejercicio13 {
    public static void main(String[] args){
        int dinero;
        int b500;
        int b200;
        int b100;
        int b50;
        int b20;
        int b10;
        int b5;
        dinero = GetData.getInt("Ingrese los euros: ",1);
        b500 = dinero / 500;
        dinero = dinero - (b500 * 500);
        System.out.println("Son " + b500 + " de 500€");

        b200 = dinero / 200;
        dinero = dinero - (b200 * 200);
        System.out.println("Son " + b200 + " de 200€");

        b100 = dinero / 100;
        dinero = dinero - (b100 * 100);
        System.out.println("Son " + b100 + " de 100€");

        b50 = dinero / 50;
        dinero = dinero - (b50 * 50);
        System.out.println("Son " + b50 + " de 50€");

        b20 = dinero / 20;
        dinero = dinero - (b20 * 20);
        System.out.println("Son " + b20 + " de 20€");

        b10 = dinero / 10;
        dinero = dinero - (b10 * 10);
        System.out.println("Son " + b10 + " de 10€");

        b5 = dinero / 5;
        dinero = dinero - (b5 * 5);
        System.out.println("Son " + b5 + " de 5€");
        System.out.println("Sobran: " + dinero);
    }

}
