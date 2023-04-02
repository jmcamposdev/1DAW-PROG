/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ofuscadorcadenas;

import Funciones.Utilities;

/**
 *
 * @author josemaria
 */
public class OfuscadorCadenas {
    // Array para almacenar los caracteres alfabéticos
    public static final char[] caracteres = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','ñ','o','p','q','s','s','t','u','v','w','x','y','z','[',']','?','¿','-','|','/'};

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Probamos el funcionamiento del Ofuscador y el DesOfuscador
        String cadenaDeTextoNorma1 = "Esto es una simple Prueba";
        String cadenaDeTextoNorma2 = "Segunda Prueba de OfuscadorDeCadenas";
        String cadenaOfuscada1 = ofuscar(cadenaDeTextoNorma1,5);
        String cadenaDesOfuscada1 = desofuscar(cadenaOfuscada1, 5);
        String cadenaOfuscada2 = ofuscar(cadenaDeTextoNorma2,2);
        String cadenaDesOfuscada2 = desofuscar(cadenaOfuscada2,2);
        System.out.println("Primera Cadena: ");
        System.out.println(cadenaOfuscada1);
        System.out.println(cadenaDesOfuscada1);
        System.out.println("Segunda Cadena: ");
        System.out.println(cadenaOfuscada2);
        System.out.println(cadenaDesOfuscada2);

    }

    public static String ofuscar (String mensaje, int n) {
        if (n < 0) { // Validamos que n no sea negativo
            throw new IllegalArgumentException("El valor de n no puede ser negativo");
        }
        StringBuilder cadenaOfuscada = new StringBuilder(); // Inicializamos la CadenaOfuscada
        StringBuilder cadenaAleatoria; // Declaramos la CadenaAleatoria
        for (int i = 0; i < mensaje.length(); i++) {
            cadenaAleatoria = new StringBuilder(); // Inicializamos la Cadena Aleatoria en cada iteración
            for (int j = 0; j < n; j++) { // Creamos la cadena Aleatoria de la longitud pasada por n
                cadenaAleatoria.append(caracteres[Utilities.randomNumber(0, 32)]);
            }
            // Añadimos a la CadenaOfuscada el caracter real y los n caracteres aleatorios
            cadenaOfuscada.append(mensaje.charAt(i)).append(cadenaAleatoria.toString());
        }
        return cadenaOfuscada.toString();
    }

    public static String desofuscar (String mensajeOfuscado, int n) {
        if (n < 0) { // Validamos que n no sea negativo
            throw new IllegalArgumentException("El valor de n no puede ser negativo");
        }
        StringBuilder cadenaDesOfuscada = new StringBuilder(); // Inicializamos la cadenaDesOfuscada
        for (int i = 0; i < mensajeOfuscado.length(); i+=n+1) { // Iteramos cada n+1 para obtener el caracter real
            cadenaDesOfuscada.append(String.valueOf(mensajeOfuscado.charAt(i))); // Añadimos el caracter real a la cadenaDesOfuscada.
        }
        return cadenaDesOfuscada.toString();
    }
    
}
