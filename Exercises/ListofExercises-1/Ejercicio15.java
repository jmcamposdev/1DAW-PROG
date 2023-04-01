package RelacionEjercicios1;

/*
    15. Realiza un programa que con todos los números comprendidos entre -50 y +50 (ambos incluidos) calcule la
    suma de todos los múltiplos de 5, la cantidad de números pares y el producto de los números negativos.
 */



public class Ejercicio15 {
    public static void main(String[] args){
        int sumaMultiplos = 0;
        int numerosPares = 0;
        double productoNegativos = 1;
        for (int i = -50; i <= 50; i++) {
            if (i % 5 == 0){
                sumaMultiplos = sumaMultiplos + i;
            }
            if (i % 2 == 0){
                numerosPares = numerosPares + 1;
            }
            if (i < 0){
                productoNegativos = productoNegativos * i;
            }
        }
        System.out.println("La suma de los multiplos de 5 es: " + sumaMultiplos);
        System.out.println("La cantidad de numeros pares es: "+ numerosPares);
        System.out.println("El producto de los numeros negativos es: " + productoNegativos);
    }
}
