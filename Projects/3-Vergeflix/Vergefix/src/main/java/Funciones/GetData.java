package Funciones;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
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
        "[A-Za-zÁÉÍÓÚáéíóú*ñÑ0-9:/{}?¿¡!,._´\\[\\]\\-]+"
     */


    public static String getString(String mensaje) {
        Scanner sc = new Scanner(System.in);
        String texto;
        do {
            System.out.print(mensaje);
            while (!sc.hasNextLine()){
                System.out.println("Ingrese un string valido.");
                System.out.print(mensaje);
                sc.nextLine();
            }
            texto = sc.nextLine();
        } while (texto.isBlank());
        return texto.trim();
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

    public static LocalDate getFecha(String mensaje) {
        String date = GetData.getString(mensaje); // Pedimos la Fecha
        // Creamos el formato que deberá tener la fecha
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        // Seleccionamos que el analizador sea estricto por lo cual debe de coincidir con el formato que le hemos puesto
        sdf.setLenient(false);
        // Indicamos que el análisis lo realize desde el index 0 en adelante
        ParsePosition pp = new ParsePosition(0);
        // Intentamos convertir el String de la Fecha en un Date si no puede devuelve null
        java.util.Date d = sdf.parse(date, pp);
        while (d == null) { // Si es null volvemos a pedir la fecha y a pasarla hasta que sea válida
            System.out.println("Ingrese una fecha válida (dd/mm/yyyy)");
            date = GetData.getString(mensaje);
            d = sdf.parse(date, pp);
        }
        // Convertimos el String Fecha en un Array separándolo por "/"
        String[] splitFecha = date.split("/");
        // Devolvemos un LocalDate formada gracia al Array (año,mes,día)
        return LocalDate.of(Integer.parseInt(splitFecha[2]),Integer.parseInt(splitFecha[1]),Integer.parseInt(splitFecha[0]));
    }
}
