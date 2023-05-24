package Funciones;

import java.util.Scanner;

public class GetData {

    /*
        ------------------------------------------------
        GET INT
        ------------------------------------------------
     */
    //  INT SIN RANGO
    public static int getInt(String mensaje) {
        Scanner sc = new Scanner(System.in);
        int numero;
        System.out.print(mensaje);
        while (!sc.hasNextInt()){
            System.out.println("Ingrese un valor numérico.");
            System.out.print(mensaje);
            sc.nextLine();
        }
        numero = sc.nextInt();
        return numero;
    }

    public static long getLong(String mensaje) {
        Scanner sc = new Scanner(System.in);
        long numero;
        System.out.print(mensaje);
        while (!sc.hasNextInt()){
            System.out.println("Ingrese un valor numérico.");
            System.out.print(mensaje);
            sc.nextLine();
        }
        numero = sc.nextInt();
        return numero;
    }
    //  INT CON MÍNIMO (el mínimo está incluido en valores válidos)
 public static int getInt(String mensaje, int minimo) {
        Scanner sc = new Scanner(System.in);
        int numero;
        do {
            System.out.print(mensaje);
            while (!sc.hasNextInt()){
                System.out.println("Ingrese un valor numérico.");
                System.out.print(mensaje);
                sc.nextLine();
            }
            numero = sc.nextInt();
            if (numero < minimo){
                System.out.println("El rango no es el adecuado");
            }
        } while (numero < minimo);
        return numero;
    }

    //  INT CON MÍNIMO Y MÁXIMO(el mínimo está incluido en valores válidos)
    public static int getInt(String mensaje, int minimo, int maximo) {
        Scanner sc = new Scanner(System.in);
        int numero;
        do {
            System.out.print(mensaje);
            while (!sc.hasNextInt()){
                System.out.println("Ingrese un valor numérico.");
                System.out.print(mensaje);
                sc.nextLine();
            }
            numero = sc.nextInt();
            if (numero < minimo || numero > maximo){
                System.out.println("El rango no es el adecuado");
            }
        } while (numero < minimo || numero > maximo);
        return numero;
    }

    /*
        ------------------------------------------------
        GET DOUBLE
        ------------------------------------------------
     */
    //  DOUBLE SIN RANGO
    public static double getDouble(String mensaje) {
        Scanner sc = new Scanner(System.in);
        double numero;
            System.out.print(mensaje);
            while (!sc.hasNextDouble()){
                System.out.println("Ingrese un valor numérico.");
                System.out.print(mensaje);
                sc.nextLine();
            }
            numero = sc.nextDouble();
        return numero;
    }

    //  DOUBLE CON MÍNIMO (el mínimo está incluido en valores válidos)
    public static double getDouble(String mensaje, double minimo) {
        Scanner sc = new Scanner(System.in);
        double numero;
        do {
            System.out.print(mensaje);
            while (!sc.hasNextDouble()){
                System.out.println("Ingrese un valor numérico.");
                System.out.print(mensaje);
                sc.nextLine();
            }
            numero = sc.nextDouble();
            if (numero < minimo){
                System.out.println("El rango no es el adecuado");
            }
        } while (numero < minimo);
        return numero;
    }

    //  DOUBLE CON MÍNIMO Y MÁXIMO (ambos están incluidos)
    public static double getDouble(String mensaje, double minimo,double maximo) {
        Scanner sc = new Scanner(System.in);
        double numero;
        do {
            System.out.print(mensaje);
            while (!sc.hasNextDouble()){
                System.out.println("Ingrese un valor numérico.");
                System.out.print(mensaje);
                sc.nextLine();
            }
            numero = sc.nextDouble();
            if (numero < minimo || numero > maximo){
                System.out.println("El rango no es el adecuado");
            }
        } while (numero < minimo || numero > maximo);
        return numero;
    }

    public static double getDoubleDistinto(String mensaje, double distinto) {
        Scanner sc = new Scanner(System.in);
        double numero;
        do {
            System.out.print(mensaje);
            while (!sc.hasNextDouble()){
                System.out.println("Ingrese un valor numérico.");
                System.out.print(mensaje);
                sc.nextLine();
            }
            numero = sc.nextDouble();
            if (numero==distinto){
                System.out.println("Ingrese un valor distingo a "+distinto);
            }
        } while (numero==distinto);
        return numero;
    }

     /*
        ------------------------------------------------
        GET STRING
        ------------------------------------------------
     */

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

    public static char getChar(String mensaje) {
        Scanner sc = new Scanner(System.in);
        char texto;
        System.out.print(mensaje);
        while (!sc.hasNext()){
            System.out.println("Ingrese un string valido.");
            System.out.print(mensaje);
            sc.nextLine();
        }
        texto = sc.next().charAt(0);
        return texto;
    }

    /**
     * Método para pedir un booelan por Terminal.
     * El usuario debe de insetar (si|no) para la representación del boolean.
     * Si inseta una opción no válida imprime un error y se le vuevelve a pedir que ingrese (si|no)
     * @param mensaje El mensaje que saldra para pedirle al usuario el boolean
     * @return True si el usuario a escrito "si" y false en caso de que escriba "no".
     */
    public static boolean getBoolean (String mensaje) {
        Scanner sc = new Scanner(System.in);
        boolean option;
        String input;
        do {
            System.out.print(mensaje);
            while (!sc.hasNext()){
                System.out.println("Ingrese si o no.");
                System.out.print(mensaje);
                sc.nextLine();
            }
            input = sc.next();
            input = input.toLowerCase();
            if (!input.matches("si|no")){
                System.out.println("Valor no válido (si o no)");
            }
        } while (!input.matches("si|no"));
        return input.equals("si");
    }


}
