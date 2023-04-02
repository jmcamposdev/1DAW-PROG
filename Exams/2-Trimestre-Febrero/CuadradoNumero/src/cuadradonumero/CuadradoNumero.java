package cuadradonumero;

public class CuadradoNumero {

    public static void main(String[] args) {

        int numero;

        do {
            numero = LeerDatosTeclado.leerEntero("Introduce un valor entero (0 para finalizar)");
            System.out.println("El cuadrado de " + numero + " es: " + cuadradoSumando(numero));
        } while (numero != 0);

    }

    public static int cuadradoSumando(int n) {
        int base = Math.abs(n);
        int cuadrado = 0;
        int sumaImpar = 1;

        for (int i = 0; i < base; i++) {
            cuadrado += sumaImpar;
            sumaImpar += 2;
        }

        return cuadrado;
    }

}
