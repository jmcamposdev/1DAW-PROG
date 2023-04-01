package juegoPente;
import Funciones.GetData;
/**
 *
 * @author josemaria
 */
public class JuegoPente {
    public static final int CASILLA_VACIA=0;
    public static final int FICHA_CIRCULO=1;
    public static final int FICHA_EQUIS=2;
    public static void main(String[] args) {
        // Creamos todas las variables.
        boolean ganadorPorLinea = false, existenFichasLibres = true, ganadorPorCapturas = false,comprobarFicha;
        int[][] tablero;
        int fila,columna,turno=1,ficha,capturaJugador1 = 0,capturaJugador2 = 0,fichasCapturadas;
        String[] nombres = new String[2];

        System.out.println("Bienvenido al Juego Pente");
        System.out.println("-------------------------");
        // Pedimos la dimensión del tablero con un mínimo de 10 y un máximo de 19 ambos incluidos.
        int dimensionTablero = GetData.getInt("Ingrese la dimensión deseada del tablero (10 - 19): ",10,19);
        tablero = new int[dimensionTablero][dimensionTablero]; // Creamos el tablero con las dimensiones indicadas
        // Pedimos el número de captura para ganar mínimo de 5 y máximo de 10 ambos incluidos
        int maximoDeCaptura = GetData.getInt("Ingrese el máximo de capturas para ganar la partida (5 - 10): ",5,10);
        nombres[0] = GetData.getString("Ingrese el nombre del Primer Jugador: "); // Pedimos el nombre del Jugador 1
        nombres[1] = GetData.getString("Ingrese el nombre del Segundo Jugador: "); // Pedimos el nombre del Jugador 2
        mostrarTablero(tablero); // Mostramos el tablero vacío

        // Iteramos constantemente hasta que exista un ganador por linea, captura o empate.
        while (!ganadorPorLinea && existenFichasLibres && !ganadorPorCapturas){
            // Pedir ficha al usuario y comprobar si se puede insertar
            do {
                ficha = turno%2==0?FICHA_EQUIS:FICHA_CIRCULO; // Asignamos la ficha dependiendo del turno PAR=X IMPAR=O
                System.out.println("Te toca "+nombres[turno%2==0?1:0]); // Mostramos a quien le toca el turno
                // Pedimos la fila y columna con un mínimo de 0 y un máximo de la longitud del tablero -1.
                fila = GetData.getInt("Ingrese la fila: ",0,tablero.length-1);
                columna = GetData.getInt("Ingrese la columna: ",0,tablero.length-1);

                comprobarFicha = colocarFicha(tablero,ficha,fila,columna); // Comprobamos si es válida la casilla indicada
                // Si no es válida mostramos erros y volvemos a iterar el do while.
                if (!comprobarFicha){
                    System.out.println("En la posición solicitada ya existe una ficha vuelva a intentarlo.");
                }
            } while (!comprobarFicha);

            ganadorPorLinea = comprobarLinea(tablero,fila,columna); // Comprueba si existe 5 en línea
            existenFichasLibres = casillasLibres(tablero);  // Comprueba si es empate
            fichasCapturadas = capturarFichas(tablero,fila,columna);  // Guardamos la cantidad de fichas capturadas
            // Comprobamos si existen fichas capturadas para signarla al correspondiente jugado dependiendo del turno
            if (fichasCapturadas>0){
                if (turno%2==0){
                    capturaJugador2+=fichasCapturadas;
                } else {
                    capturaJugador1+=fichasCapturadas;
                }
                // Validamos si han ganado por captura.
                if (capturaJugador1 >= maximoDeCaptura || capturaJugador2 >= maximoDeCaptura){
                    ganadorPorCapturas = true;
                }
            }
            // Mostramos tanto el tablero con las fichas capturadas de cada jugador;
            mostrarTablero(tablero,fila,columna);
            if (fichasCapturadas>0){
                System.out.println("Ha realizado captura "+nombres[turno%2==0?1:0]);
            }
            System.out.println("Fichas capturas de "+nombres[0]+" : "+capturaJugador1);
            System.out.println("Fichas capturas de "+nombres[1]+" : "+capturaJugador2);

            // Aumentamos el turno si la partida no ha acabado
            if (!ganadorPorLinea && existenFichasLibres && !ganadorPorCapturas){
                turno++;
            }
        }

        // Una vez finalizada la partida comprobamos si es por línea, captura o empate.
        if (ganadorPorLinea){
            System.out.println("Ha Ganado "+nombres[turno%2==0?1:0]);
        } else {
            final String ganadoCapturas = "Ha Ganado por captura " + nombres[turno % 2 == 0 ? 1 : 0];
            if (capturaJugador1>=maximoDeCaptura || capturaJugador2>=maximoDeCaptura){
                System.out.println(ganadoCapturas);
            } else {
                System.out.println("Empate");
            }
        }
    }
    // Muestra el tablero
    public static void mostrarTablero(int [][] tablero){
        indiceColumna(tablero); // Muestra el índice de las columnas
        for (int i = 0; i < tablero.length; i++) {
            indiceFila(i); // Índice de las filas
            // Imprimir las fichas
            for (int j = 0; j < tablero[0].length; j++) {
                mostrarFicha(tablero,i,j);
            }
            System.out.println(" ");
        }
    }

    // Muestra el tablero con la última ficha resaltada
    public static void mostrarTablero(int [][] tablero, int fila, int columna){
        indiceColumna(tablero); // Muestra el índice de las columnas
        for (int i = 0; i < tablero.length; i++) {
            indiceFila(i); // Índice de las filas
            // Imprimir las fichas
            for (int j = 0; j < tablero[0].length; j++) {
                if (i==fila && j==columna){
                    mostrarFichaNegrita(tablero,i,j);
                } else {
                    mostrarFicha(tablero,i,j);
                }

            }
            System.out.println(" ");

        }
    }

    // Coloca la ficha en la posición deseada
    // Comprueba si está libre y devuelve true si se ha colocado y false si no.
    public static boolean colocarFicha(int [][] tablero, int ficha, int fila, int columna){
        validarFicha(ficha);
        // Comprobamos si la posicion marcada es válida = CASILLA_VACIA
        boolean posicionValida = tablero[fila][columna] == CASILLA_VACIA;
        if (posicionValida){
            tablero[fila][columna] = ficha;
        }
        return posicionValida;
    }

    // Comprueba si hay 5 fichas en línea independientemente de la dirección
    public static boolean comprobarLinea(int [][] tablero, int fila, int columna){
        return (comprobarLineaHorizontal(tablero,fila,columna) || comprobarLineaVertical(tablero,fila,columna) || comprobarLineaDiagonal(tablero,fila,columna));
    }

    // Validar si hay 5 fichas en línea horizontales
    public static boolean comprobarLineaHorizontal (int[][] tablero,int fila,int columna){
        int repeticionesHorizontalDerecha = 0;
        int repeticionesHorizontalIzquierda = 0;
        // Recorremos hacia la derecha
        if (columna!=tablero[0].length-1){
            repeticionesHorizontalDerecha = recorrerHorizontalDerecha(tablero,tablero[fila][columna],fila,columna);
        }
        // Recorremos hacia la izquierda
        if (columna!=0 && repeticionesHorizontalDerecha<4){
            repeticionesHorizontalIzquierda = recorrerHorizontalIzquierda(tablero,tablero[fila][columna],fila,columna);
        }
        // Sumamos al resultado la ficha colocada por el usuario, ya que las funciones no cuenta la ficha recién colocada
        return ((repeticionesHorizontalDerecha+repeticionesHorizontalIzquierda)+1)>=5;
    }

    // Validar si hay 5 fichas en línea Vertical
    public static boolean comprobarLineaVertical (int[][] tablero,int fila,int columna){
        int repeticionesArriba = 0;
        int repeticionesAbajo = 0;
        // Recorremos hacia arriba
        if (fila!=0){
            repeticionesArriba = recorrerVerticalArriba(tablero,tablero[fila][columna],fila,columna);
        }
        // Recorremos hacia abajo
        if (fila!=tablero.length-1 && repeticionesArriba<4){
            repeticionesAbajo = recorrerVerticalAbajo(tablero,tablero[fila][columna],fila,columna);
        }
        // Sumamos al resultado la ficha colocada por el usuario, ya que las funciones no cuenta la ficha recién colocada
        return ((repeticionesArriba+repeticionesAbajo)+1)>=5;
    }

    // Validar si hay 5 fichas en diagonal
    public static boolean comprobarLineaDiagonal (int[][] tablero,int fila,int columna){
        int repeticionesArribaIzquierda = 0;
        int repeticionesAbajoDerecha = 0;
        int repeticionesArribaDerecha= 0;
        int repeticionesAbajoIzquierda = 0;

        // Comprueba las diagonales de arriba izquierda hacia abajo derecha
        if (fila!=0 && columna!=0){
            repeticionesArribaIzquierda = recorrerDiagonalArribaIzquierda(tablero,tablero[fila][columna],fila,columna);
        }
        if (fila!=tablero.length-1 && columna!=tablero[0].length-1 && repeticionesArribaIzquierda<5){
            repeticionesAbajoDerecha = recorrerDiagonalAbajoDerecha(tablero,tablero[fila][columna],fila,columna);
        }
        // Comprueba la fila arriba derecha hacia abajo izquierda
        if (fila!=0 && columna!= tablero[0].length-1 && repeticionesArribaIzquierda<5 && repeticionesAbajoDerecha<5){
            repeticionesArribaDerecha = recorrerDiagonalArribaDerecha(tablero,tablero[fila][columna],fila,columna);
        }
        if (fila!=tablero[0].length-1 && columna!=0  && repeticionesArribaIzquierda<5 && repeticionesAbajoDerecha<5 && repeticionesArribaDerecha<5){
            repeticionesAbajoIzquierda = recorrerDiagonalAbajoIzquierda(tablero,tablero[fila][columna],fila,columna);
        }

        // Sumamos al resultado la ficha colocada por el usuario, ya que las funciones no cuenta la ficha recién colocada
        return ((repeticionesArribaIzquierda+repeticionesAbajoDerecha+1)>=5 || (repeticionesAbajoIzquierda+repeticionesArribaDerecha+1)>=5);
    }

    // Comprueba si existen casillas libres en el tablero
    public static boolean casillasLibres(int [][] tablero){
        boolean tableroNoCompleto = false;
        for (int i = 0; i < tablero.length && !tableroNoCompleto; i++) {
            for (int j = 0; j < tablero[0].length && !tableroNoCompleto; j++) {
                if (tablero[i][j] == CASILLA_VACIA){
                    tableroNoCompleto = true;
                }
            }
        }
        return tableroNoCompleto;
    }

    public static int capturarFichas(int [][] tablero, int fila, int columna){
        int ficha = tablero[fila][columna];
        // Almacenamos la ficha opuesta a la ficha de la posición que nos pasan
        int fichaACapturar = ficha==FICHA_CIRCULO?FICHA_EQUIS:FICHA_CIRCULO;
        // Comprobamos si existen capturas en todas las direcciones
        int cantidadFichasHorizontales = capturaHorizontal(tablero,fichaACapturar,fila,columna);
        int cantidadFichasVerticales = capturaVertical(tablero,fichaACapturar,fila,columna);
        int cantidadFichasDiagonales = capturaDiagonal(tablero,fichaACapturar,fila,columna);
        return (cantidadFichasHorizontales+cantidadFichasVerticales+cantidadFichasDiagonales);
    }

    // Captura Horizontal Derecha
    public static int capturaHorizontal(int[][] tablero,int ficha,int fila,int columna){
        validarFicha(ficha);
        int capturas = 0,repeticionesHorizontalDerecha,repeticionesHorizontalIzquierda;
        // Recorremos hacia la derecha
        if (columna<tablero[0].length-3){
            repeticionesHorizontalDerecha = recorrerHorizontalDerecha(tablero,ficha,fila,columna);
            if (repeticionesHorizontalDerecha==2 && tablero[fila][columna+3]==tablero[fila][columna]){
                capturas+=2;
                for (int i = columna+1; i <= columna+2; i++) {
                    tablero[fila][i] = CASILLA_VACIA;
                }
            }
        }
        //Recorrer hacia la izquierda
        if (columna>2){
            repeticionesHorizontalIzquierda = recorrerHorizontalIzquierda(tablero,ficha,fila,columna);
            if (repeticionesHorizontalIzquierda==2 && tablero[fila][columna-3]==tablero[fila][columna]){
                capturas+=2;
                for (int i = columna-1; i >= columna-2; i--) {
                    tablero[fila][i] = CASILLA_VACIA;
                }
            }
        }
        return capturas;
    }

    public static int capturaVertical(int[][] tablero,int ficha,int fila,int columna){
        validarFicha(ficha);
        int capturas = 0,repeticionesArriba,repeticionesAbajo;
        // Recorremos hacia arriba
        if (fila>2){
            repeticionesArriba = recorrerVerticalArriba(tablero,ficha,fila,columna);
            if (repeticionesArriba==2 && tablero[fila-3][columna]==tablero[fila][columna]){
                capturas+=2;
                for (int i = fila-1; i >= fila-2; i--) {
                    tablero[i][columna] = CASILLA_VACIA;
                }
            }
        }
        // Recorremos hacia abajo
        if (fila<tablero.length-3){
            repeticionesAbajo = recorrerVerticalAbajo(tablero,ficha,fila,columna);
            if (repeticionesAbajo==2 && tablero[fila+3][columna]==tablero[fila][columna]){
                capturas+=2;
                for (int i = fila+1; i <= fila+2; i++) {
                    tablero[i][columna] = CASILLA_VACIA;
                }
            }

        }
        return capturas;
    }

    public static int capturaDiagonal(int[][] tablero,int ficha,int fila,int columna) {
        validarFicha(ficha);
        int capturas = 0,repeticionesAscendentesIzquierda,repeticionesDescendentesDerecha,limpiarFila,limpiarColumna;
        int repeticionesAscendentesDerecha,repeticionesDescendentesIzquierda;
        // Comprueba las diagonales de arriba izquierda hacia abajo derecha
        if (columna>2 && fila>2){
            repeticionesAscendentesIzquierda = recorrerDiagonalArribaIzquierda(tablero,ficha,fila,columna);

            if (repeticionesAscendentesIzquierda==2 && tablero[fila-3][columna-3]==tablero[fila][columna]){
                capturas+=2;
                limpiarFila = fila-1;
                limpiarColumna = columna-1;
                while (limpiarFila >= fila-2 && limpiarColumna>= columna-2){
                    tablero[limpiarFila][limpiarColumna] = CASILLA_VACIA;
                    limpiarFila--;
                    limpiarColumna--;
                }
            }

        }
        if (columna<tablero[0].length-3 && fila<tablero.length-3){
            repeticionesDescendentesDerecha = recorrerDiagonalAbajoDerecha(tablero,ficha,fila,columna);

            if (repeticionesDescendentesDerecha==2 && tablero[fila+3][columna+3]==tablero[fila][columna]){
                capturas+=2;
                limpiarFila = fila+1;
                limpiarColumna = columna+1;
                while (limpiarFila <= fila+2 && limpiarColumna <= columna+2){
                    tablero[limpiarFila][limpiarColumna] = CASILLA_VACIA;
                    limpiarFila++;
                    limpiarColumna++;
                }
            }
        }

        // Comprueba la fila arriba derecha hacia abajo izquierda
        if (fila>2 && columna<tablero[0].length-3){
            repeticionesAscendentesDerecha = recorrerDiagonalArribaDerecha(tablero,ficha,fila,columna);

            if (repeticionesAscendentesDerecha==2 && tablero[fila-3][columna+3]==tablero[fila][columna]){
                capturas+=2;
                limpiarFila = fila-1;
                limpiarColumna = columna+1;
                while (limpiarFila >= fila-2 && limpiarColumna <= columna+2){
                    tablero[limpiarFila][limpiarColumna] = CASILLA_VACIA;
                    limpiarFila--;
                    limpiarColumna++;
                }
            }
        }
        if (columna>2 && fila<tablero.length-3){
            repeticionesDescendentesIzquierda = recorrerDiagonalAbajoIzquierda(tablero,ficha,fila,columna);

            if (repeticionesDescendentesIzquierda==2 && tablero[fila+3][columna-3]==tablero[fila][columna]){
                capturas+=2;
                limpiarFila = fila+1;
                limpiarColumna = columna-1;
                while (limpiarFila <= fila+2 && limpiarColumna >= columna-2){
                    tablero[limpiarFila][limpiarColumna] = CASILLA_VACIA;
                    limpiarFila++;
                    limpiarColumna--;
                }
            }
        }

        return capturas;
    }
    /*
    --------------------------------
        Indice Columna y FILA
    --------------------------------
     */
    public static void indiceColumna (int[][] tablero){
        int indiceY = 0;
        System.out.print("    ");
        for (int j = 0; j < tablero[0].length; j++) {
            if (j<9){
                System.out.print(indiceY+"   ");
            } else {
                System.out.print(indiceY+"  ");
            }
            indiceY++;
        }
        System.out.println(" ");
    }

    public static void indiceFila (int indiceX){
        if (indiceX<10){
            System.out.print(" "+indiceX+"|");
        } else {
            System.out.print(indiceX+"|");
        }
    }
    /*
    --------------------------------
        Mostrar Ficha
    --------------------------------

    Utilizamos el color luego el valor a imprimir y por último reseteamos el color.
     */
    public static void mostrarFicha (int[][] tablero,int fila,int columna){
        switch (tablero[fila][columna]){
            case CASILLA_VACIA -> System.out.print(" "+" "+" |");
            case FICHA_CIRCULO -> System.out.print(" "+"\u001B[31m"+"O"+"\u001B[0m"+" |");
            case FICHA_EQUIS -> System.out.print(" "+"\u001B[34m"+"X"+"\u001B[0m"+" |");
            default -> throw new IllegalArgumentException("Valor no esperado");
        }
    }
    public static void mostrarFichaNegrita (int[][] tablero,int fila,int columna){
        switch (tablero[fila][columna]){
            case CASILLA_VACIA -> System.out.print(" "+" "+" |");
            case FICHA_CIRCULO -> System.out.print(" "+"\033[1;33m"+"O"+"\u001B[0m"+" |");
            case FICHA_EQUIS -> System.out.print(" "+"\033[1;33m"+"X"+"\u001B[0m"+" |");
            default -> throw new IllegalArgumentException("Valor no esperado");
        }
    }
    /*
    --------------------------------
        Recorrer Tablero
    --------------------------------
     */
    // Horizontal hacia la derecha
    public static int recorrerHorizontalDerecha (int[][] tablero,int ficha,int fila,int columna){
        validarFicha(ficha);
        int repeticiones = 0;
        boolean salida = false;
        for (int i = columna+1; i < tablero[0].length && !salida; i++) {
            if (tablero[fila][i] == ficha){
                repeticiones++;
            } else {
                salida = true;
            }
        }
        return repeticiones;
    }
    // Horizontal hacia la izquierda
    public static int recorrerHorizontalIzquierda (int[][] tablero,int ficha,int fila,int columna) {
        validarFicha(ficha);
        int repeticiones = 0;
        boolean salida = false;
        for (int i = columna - 1; i >= 0 && !salida; i--){
            if (tablero[fila][i] == ficha){
                repeticiones++;
            } else {
                salida = true;
            }
        }
        return repeticiones;
    }
    // Vertical hacia arriba
    public static int recorrerVerticalArriba (int[][] tablero,int ficha,int fila,int columna){
        validarFicha(ficha);
        int repeticiones = 0;
        boolean salida = false;
        for (int i = fila-1; i >=0 && !salida; i--){
            if (tablero[i][columna] == ficha){
                repeticiones++;
            } else {
                salida = true;
            }
        }
        return repeticiones;
    }
    // Vertical hacia abajo
    public static int recorrerVerticalAbajo (int[][] tablero,int ficha,int fila,int columna){
        validarFicha(ficha);
        int repeticiones = 0;
        boolean salida = false;
        for (int i = fila+1; i < tablero.length && !salida; i++) {
            if (tablero[i][columna] == ficha){
                repeticiones++;
            } else {
                salida = true;
            }
        }
        return repeticiones;
    }
    // Diagonal Arriba Izquierda
    public static int recorrerDiagonalArribaIzquierda (int[][] tablero,int ficha,int fila,int columna){
        validarFicha(ficha);
        int repeticiones = 0;
        boolean salida = false;
        // Restamos una unidad a ambos para excluir la ficha colocada
        fila--;
        columna--;
        // Buscamos todas las fichas continuas y las sumamos si no salimos

        while (fila!=-1 && columna!=-1 && !salida){
            if (tablero[fila][columna] == ficha){
                repeticiones++;
                fila--;
                columna--;
            } else {
                salida = true;
            }
        }
        return repeticiones;
    }
    // Diagonal Abajo Derecha
    public static int recorrerDiagonalAbajoDerecha (int[][] tablero,int ficha,int fila,int columna){
        validarFicha(ficha);
        int repeticiones = 0;
        boolean salida = false;
        fila++;
        columna++;
        // Buscamos todas las fichas continuas y las sumamos si no salimos
        while (fila!=tablero.length && columna!=tablero[0].length && !salida){
            if (tablero[fila][columna] == ficha){
                repeticiones++;
                fila++;
                columna++;
            } else {
                salida = true;
            }
        }
        return repeticiones;
    }
    // Diagonal Arriba Derecha
    public static int recorrerDiagonalArribaDerecha (int[][] tablero,int ficha,int fila,int columna){
        validarFicha(ficha);
        int repeticiones = 0;
        boolean salida = false;
        // Subimos una diagonal para excluir la ficha colocada
        fila--;
        columna++;
        while (fila!=-1  && columna!=tablero[0].length && !salida){
            if (tablero[fila][columna] == ficha){
                repeticiones++;
                fila--;
                columna++;
            } else {
                salida = true;
            }
        }
        return repeticiones;
    }
    // Diagonal AbajoIzquierda
    public static int recorrerDiagonalAbajoIzquierda (int[][] tablero,int ficha,int fila,int columna){
        validarFicha(ficha);
        int repeticiones = 0;
        boolean salida = false;
        // Bajamos la diagonal para excluir la ficha
        fila++;
        columna--;
        while (fila!=tablero[0].length && columna!=-1 && !salida){
            if (tablero[fila][columna] == ficha){
                repeticiones++;
                fila++;
                columna--;
            } else {
                salida = true;
            }
        }
        return repeticiones;
    }

    // Válida si la ficha introducida coincide con las constantes.
    public static void validarFicha (int ficha){
        boolean validacion = ficha == CASILLA_VACIA || ficha == FICHA_CIRCULO || ficha == FICHA_EQUIS;
        if (!validacion){
            throw new IllegalArgumentException("El valor de la ficha introducida es erróneo");
        }
    }
}