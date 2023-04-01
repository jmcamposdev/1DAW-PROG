package Funciones;

import java.util.Arrays;

public class OperacionesArray {

    // Crear un array con numeros aleatorios con prendidos con el máximo sin incluirlo
    public static int[] crearArrayAleatorio(int longitudArray,int maximo){
        if (longitudArray<=0){
            throw new IllegalArgumentException("La longitud del array debe ser positiva mayor que 0");
        }

        int[] array = new int[longitudArray];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random()*maximo);
        }
        return array;
    }

    // Crea un array con números aleatorios entre un rando ambos incluidos
    public static int[] crearArrayAleatorio(int longitudArray,int minimo,int maximo){
        if (longitudArray<=0){
            throw new IllegalArgumentException("La longitud del array debe ser positiva mayor que 0");
        }

        int[] array = new int[longitudArray];
        for (int i = 0; i < array.length; i++) {
                array[i] = (int) ((Math.random()*((maximo-minimo)+1))+minimo);
        }
        return array;
    }

    // Crea un array bidimensional aleatorio con n filas y n columnas
    public static int[][] crearArrayAleatorioBidimensional (int filas,int columnas,int maximo){
        if (filas<=0 || columnas<= 0){
            throw new IllegalArgumentException("El array no puede tener 0 filas o columnas");
        }
        int[][] array = new int[filas][columnas];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                array[i][j] = (int) (Math.random()*maximo);
            }
        }
        return array;
    }

    // Crea un array bidimensional aleatorio con n filas y n columnas
    public static int[][] crearArrayAleatorioBidimensional (int filas,int columnas,int minimo,int maximo){
        if (filas<=0 || columnas<= 0){
            throw new IllegalArgumentException("El array no puede tener 0 filas o columnas");
        }
        int[][] array = new int[filas][columnas];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                array[i][j] = (int) ((Math.random()*((maximo-minimo)+1))+minimo);
            }
        }
        return array;
    }

    public static int[][] crearArrayAleatorioBidimensionalSinRepetir (int filas,int columnas,int minimo,int maximo){
        boolean repetido = true;
        int numero;
        if (filas<=0 || columnas<= 0){
            throw new IllegalArgumentException("El array no puede tener 0 filas o columnas");
        }
        int[][] array = new int[filas][columnas];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                while (repetido){
                    numero =(int) ((Math.random()*((maximo-minimo)+1))+minimo);
                    for (int k = 0; k < array.length && repetido; k++) {
                        for (int l = 0; l < array[0].length && repetido; l++) {
                            repetido = numero == array[k][l];
                        }
                    }
                    array[i][j] = numero;
                }
                repetido = true;
            }
        }
        return array;
    }




    // Crea un array pidiendo los números por teclado sin restricciones
    public static int[] cargarArrayTeclado (int longitudArray){
        if (longitudArray<=0){
            throw new IllegalArgumentException("La longitud del array debe ser positiva mayor que 0");
        }

        int[] array = new int[longitudArray];
        int numeroIntroducido;
        for (int i = 0; i < array.length; i++) {
            numeroIntroducido = GetData.getInt("Ingrese un número: ");
            array[i] = numeroIntroducido;
        }
        return array;
    }

    // Crea un array pidiendo los datos con un mínimo
    public static int[] cargarArrayTeclado (int longitudArray,int minimo){
        if (longitudArray<=0){
            throw new IllegalArgumentException("La longitud del array debe ser positiva mayor que 0");
        }

        int[] array = new int[longitudArray];
        int numeroIntroducido;
        for (int i = 0; i < array.length; i++) {
            numeroIntroducido = GetData.getInt("Ingrese un número: ",minimo);
            array[i] = numeroIntroducido;
        }
        return array;
    }

    public static int[] cargarArrayTeclado (int longitudArray,int minimo,int maximo){
        if (longitudArray<=0){
            throw new IllegalArgumentException("La longitud del array debe ser positiva mayor que 0");
        }

        int[] array = new int[longitudArray];
        int numeroIntroducido;
        for (int i = 0; i < array.length; i++) {
            numeroIntroducido = GetData.getInt("Ingrese un número: ",minimo,maximo);
            array[i] = numeroIntroducido;
        }
        return array;
    }

    // Muestra el array por pantalla de forma visual
    public static void mostrarArrayPantalla (int[] array){
        for (int i = 0; i < array.length; i++) {
            System.out.println("Indice: "+i+" = "+array[i]);
        }

    }

    // Retorna la suma del array
    public static double suma (double[] array){
        if (array.length == 0){
            throw new IllegalArgumentException("La longitud del array debe ser positiva mayor que 0");
        }

        double suma = 0;
        for (int i = 0; i < array.length; i++) {
            suma+=array[i];
        }
        return suma;
    }

    // Retorna la suma del array bidimensional
    public static int suma (int[][] array){
        if (array.length == 0){
            throw new IllegalArgumentException("La longitud del array debe ser positiva mayor que 0");
        }

        int suma = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                suma+=array[i][j];
            }
        }
        return suma;
    }

    // Convertir array de ints a array de double
    public static double[] convertirDouble (int[] array){
        if (array.length == 0){
            throw new IllegalArgumentException("La longitud del array debe ser positiva mayor que 0");
        }

        double[] arrayDouble = new double[array.length];
        for (int i = 0; i < array.length; i++) {
            arrayDouble[i] = array[i];
        }
        return arrayDouble;
    }

    // Devuelve el valor maximo del array
    public static double maximo (double[] array){
        if (array.length == 0){
            throw new IllegalArgumentException("La longitud del array debe ser positiva mayor que 0");
        }

        Arrays.sort(array);
        return array[array.length-1];
    }

    // Devuelve el valor maximo del array bidimensional
    public static int maximo (int[][] array){
        if (array.length == 0){
            throw new IllegalArgumentException("La longitud del array debe ser positiva mayor que 0");
        }
        int maximo = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                if (array[i][j]> maximo){
                    maximo = array[i][j];
                }
            }
        }
        return maximo;
    }

    // Devuelve el valor mínimo del array
    public static double minimo (double[] array){
        if (array.length == 0){
            throw new IllegalArgumentException("La longitud del array debe ser positiva mayor que 0");
        }

        Arrays.sort(array);
        return array[0];
    }

    // Devuelve el valor mínimo del array bidimensional
    public static int minimo (int[][] array){
        if (array.length == 0){
            throw new IllegalArgumentException("La longitud del array debe ser positiva mayor que 0");
        }
        int minimo = array[0][0];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                if (array[i][j]<minimo){
                    minimo = array[i][j];
                }
            }
        }
        return minimo;
    }

    // Devuelve la media del array
    public static int media (int[][] array){
        if (array.length == 0){
            throw new IllegalArgumentException("La longitud del array debe ser positiva mayor que 0");
        }

        int suma = suma(array);
        return suma/(array.length*array[0].length);
    }

    // Devuelve la media del array
    public static double media (double[] array){
        if (array.length == 0){
            throw new IllegalArgumentException("La longitud del array debe ser positiva mayor que 0");
        }

        double suma = suma(array);
        return suma/array.length;
    }

    // Devuelve la moda tanto unimodal como multimodal;
    public static double[][] moda (double[] array){
        if (array.length == 0){
            throw new IllegalArgumentException("La longitud del array debe ser positiva mayor que 0");
        }

        Arrays.sort(array);
        int numerosUnicos = OperacionesArray.numeroUnicos(array).length;
        double[][] vecesRepetidos = new double[numerosUnicos][2];
        double[] moda = new double[0];
        int indice = 0;
        int contador=0;
        double aux=array[0];
        for (double numero : array) {
            if (aux == numero) {
                contador++;
            } else {
                vecesRepetidos[indice][0] = aux;
                vecesRepetidos[indice][1] = contador;
                indice++;
                contador = 1;
                aux = numero;
            }
        }
        vecesRepetidos[indice][0] = array[array.length-1];
        vecesRepetidos[indice][1] = contador;

        int masRepetido = 0;
        for (int i = 0; i < vecesRepetidos.length; i++) {
                if (vecesRepetidos[i][1]>masRepetido){
                    masRepetido = (int) vecesRepetidos[i][1];
                }
        }

        int modaindice = 0;
        for (int i = 0; i < vecesRepetidos.length; i++) {
                if (vecesRepetidos[i][1] == masRepetido){
                    moda = Arrays.copyOf(moda,moda.length+1);
                    moda[modaindice] = vecesRepetidos[i][0];
                    modaindice++;
                }
        }
        System.out.println(Arrays.toString(moda));
        return vecesRepetidos;
    }

    public static int[] moda (int[] array){
        Arrays.sort(array);
        int[] moda = new int[1];
        int indicemoda = 0;
        int repetidos = 0;
        int maximasRepeticiones = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (array[i] == array[j]){
                    repetidos++;
                }
            }
             if (repetidos == maximasRepeticiones && Arrays.binarySearch(moda,array[i])<0){
                     moda = Arrays.copyOf(moda,moda.length+1);
                     moda[indicemoda] = array[i];
                     indicemoda++;
            } else if (repetidos > maximasRepeticiones){
                 maximasRepeticiones = repetidos;
                 moda = Arrays.copyOf(moda,1);
                 moda[0] = array[i];
                 indicemoda = 1;
                 System.out.println(Arrays.toString(moda));
             }
            repetidos=0;
        }
        return moda;
    }
    public static double[] numeroUnicos (double[] array){
        if (array.length == 0){
            throw new IllegalArgumentException("La longitud del array debe ser positiva mayor que 0");
        }

        double[] numerosRepetidos = new double[1];
        int indice = 0;
        for (double v : array) {
            if (Arrays.binarySearch(numerosRepetidos, v) < 0) {
                numerosRepetidos[indice] = v;
                numerosRepetidos = Arrays.copyOf(numerosRepetidos, numerosRepetidos.length + 1);
                indice++;
            }
        }
        numerosRepetidos = Arrays.copyOf(numerosRepetidos,numerosRepetidos.length-1);
        return numerosRepetidos;
    }

    // Mostrar un arrayBidimensional por pantalla DOUBLE
    public static void mostrarArrayBidimensional (double[][] array){
        if (array.length == 0){
            throw new IllegalArgumentException("La longitud del array debe ser positiva mayor que 0");
        }
        for (double[] doubles : array) {
            for (int y = 0; y < doubles.length; y++)
                System.out.print(" | " + doubles[y] + " | ");
            System.out.println("\n----------------------------------------");

        }
    }

    public static void mostrarArrayBidimensional (int[][] array){
        if (array.length == 0){
            throw new IllegalArgumentException("La longitud del array debe ser positiva mayor que 0");
        }
        for (int[] ints : array) {
            for (int y = 0; y < ints.length; y++)
                System.out.print(" | " + ints[y] + " | ");
            System.out.println("\n----------------------------------------");

        }
    }

    // Devuelve el índice donde se encuentra el número si no retorna un valor negativo;
    // el cual realizando -indiceDevuelto -1 es el índice donde se debería colocar.
    public static int buscar (double[] array,int numero){
        if (array.length == 0){
            throw new IllegalArgumentException("La longitud del array debe ser positiva mayor que 0");
        }

        Arrays.sort(array);
        return Arrays.binarySearch(array,numero);
    }

    // Devuelve el array rotado.
    public static double[] voltear (double[] array){
        if (array.length == 0){
            throw new IllegalArgumentException("La longitud del array debe ser positiva mayor que 0");
        }

        double[] arrayVolteado = new double[array.length] ;
        int indice = array.length-1;
        for (int i = 0; i < array.length; i++) {
            arrayVolteado[i] = array[indice];
            indice--;
        }
        return arrayVolteado;
    }
}
