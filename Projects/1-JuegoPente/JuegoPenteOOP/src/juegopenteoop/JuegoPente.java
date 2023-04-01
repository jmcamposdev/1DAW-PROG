package juegopenteoop;

public class JuegoPente {
    public static final int CASILLA_VACIA = 0;
    public static final int FICHA_CIRCULO = 1;
    public static final int FICHA_EQUIS = 2;

    private final int[][] tablero;

    /*-----------------------
       Constructor
    -----------------------*/
    public JuegoPente(int dimensiones){
        if (dimensiones < 10 || dimensiones > 19){
            throw new IllegalArgumentException("La dimension del tablero debe ser de 10 a 19");
        }
        this.tablero = new int[dimensiones][dimensiones];
    }

    /*-----------------------
       Colocar Ficha
    -----------------------*/
    public boolean colocarFicha(int ficha, int fila, int columna){
        validarFicha(ficha);
        // Comprobamos si la posicion marcada es válida = CASILLA_VACIA
        boolean posicionValida = tablero[fila][columna] == CASILLA_VACIA;
        if (posicionValida){
            tablero[fila][columna] = ficha;
        }
        return posicionValida;
    }

    /*-----------------------
       Comprobar Empate
    -----------------------*/
    public boolean casillasLibres(){
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

    /*-----------------------
       Comprobar Línea
    -----------------------*/

    public boolean comprobarLinea(int fila, int columna){
        return (comprobarLineaHorizontal(fila,columna) || comprobarLineaVertical(fila,columna) || comprobarLineaDiagonal(fila,columna));
    }
    // Validar si hay 5 fichas en línea horizontales
    public boolean comprobarLineaHorizontal (int fila,int columna){
        int repeticionesHorizontalDerecha = 0;
        int repeticionesHorizontalIzquierda = 0;
        // Recorremos hacia la derecha
        if (columna!=tablero[0].length-1){
            repeticionesHorizontalDerecha = recorrerHorizontalDerecha(tablero[fila][columna],fila,columna);
        }
        // Recorremos hacia la izquierda
        if (columna!=0 && repeticionesHorizontalDerecha<4){
            repeticionesHorizontalIzquierda = recorrerHorizontalIzquierda(tablero[fila][columna],fila,columna);
        }
        // Sumamos al resultado la ficha colocada por el usuario, ya que las funciones no cuenta la ficha recién colocada
        return ((repeticionesHorizontalDerecha+repeticionesHorizontalIzquierda)+1)>=5;
    }
    // Validar si hay 5 fichas en línea Vertical
    public boolean comprobarLineaVertical (int fila,int columna){
        int repeticionesArriba = 0;
        int repeticionesAbajo = 0;
        // Recorremos hacia arriba
        if (fila!=0){
            repeticionesArriba = recorrerVerticalArriba(tablero[fila][columna],fila,columna);
        }
        // Recorremos hacia abajo
        if (fila!=tablero.length-1 && repeticionesArriba<4){
            repeticionesAbajo = recorrerVerticalAbajo(tablero[fila][columna],fila,columna);
        }
        // Sumamos al resultado la ficha colocada por el usuario, ya que las funciones no cuenta la ficha recién colocada
        return ((repeticionesArriba+repeticionesAbajo)+1)>=5;
    }

    // Validar si hay 5 fichas en diagonal
    public boolean comprobarLineaDiagonal (int fila,int columna){
        int repeticionesArribaIzquierda = 0;
        int repeticionesAbajoDerecha = 0;
        int repeticionesArribaDerecha= 0;
        int repeticionesAbajoIzquierda = 0;

        // Comprueba las diagonales de arriba izquierda hacia abajo derecha
        if (fila!=0 && columna!=0){
            repeticionesArribaIzquierda = recorrerDiagonalArribaIzquierda(tablero[fila][columna],fila,columna);
        }
        if (fila!=tablero.length-1 && columna!=tablero[0].length-1 && repeticionesArribaIzquierda<5){
            repeticionesAbajoDerecha = recorrerDiagonalAbajoDerecha(tablero[fila][columna],fila,columna);
        }
        // Comprueba la fila arriba derecha hacia abajo izquierda
        if (fila!=0 && columna!= tablero[0].length-1 && repeticionesArribaIzquierda<5 && repeticionesAbajoDerecha<5){
            repeticionesArribaDerecha = recorrerDiagonalArribaDerecha(tablero[fila][columna],fila,columna);
        }
        if (fila!=tablero[0].length-1 && columna!=0  && repeticionesArribaIzquierda<5 && repeticionesAbajoDerecha<5 && repeticionesArribaDerecha<5){
            repeticionesAbajoIzquierda = recorrerDiagonalAbajoIzquierda(tablero[fila][columna],fila,columna);
        }

        // Sumamos al resultado la ficha colocada por el usuario, ya que las funciones no cuenta la ficha recién colocada
        return ((repeticionesArribaIzquierda+repeticionesAbajoDerecha+1)>=5 || (repeticionesAbajoIzquierda+repeticionesArribaDerecha+1)>=5);
    }

    /*-----------------------
       Comprobar Captura
    -----------------------*/
    public int capturarFichas(int fila, int columna){
        int ficha = tablero[fila][columna];
        // Almacenamos la ficha opuesta a la ficha de la posición que nos pasan
        int fichaACapturar = ficha==FICHA_CIRCULO?FICHA_EQUIS:FICHA_CIRCULO;
        // Comprobamos si existen capturas en todas las direcciones
        int cantidadFichasHorizontales = capturaHorizontal(fichaACapturar,fila,columna);
        int cantidadFichasVerticales = capturaVertical(fichaACapturar,fila,columna);
        int cantidadFichasDiagonales = capturaDiagonal(fichaACapturar,fila,columna);
        return (cantidadFichasHorizontales+cantidadFichasVerticales+cantidadFichasDiagonales);
    }

    // Captura Horizontal Derecha
    public int capturaHorizontal(int ficha,int fila,int columna){
        validarFicha(ficha);
        int capturas = 0,repeticionesHorizontalDerecha,repeticionesHorizontalIzquierda;
        // Recorremos hacia la derecha
        if (columna<tablero[0].length-3){
            repeticionesHorizontalDerecha = recorrerHorizontalDerecha(ficha,fila,columna);
            if (repeticionesHorizontalDerecha==2 && tablero[fila][columna+3]==tablero[fila][columna]){
                capturas+=2;
                for (int i = columna+1; i <= columna+2; i++) {
                    tablero[fila][i] = CASILLA_VACIA;
                }
            }
        }
        //Recorrer hacia la izquierda
        if (columna>2){
            repeticionesHorizontalIzquierda = recorrerHorizontalIzquierda(ficha,fila,columna);
            if (repeticionesHorizontalIzquierda==2 && tablero[fila][columna-3]==tablero[fila][columna]){
                capturas+=2;
                for (int i = columna-1; i >= columna-2; i--) {
                    tablero[fila][i] = CASILLA_VACIA;
                }
            }
        }
        return capturas;
    }

    public int capturaVertical(int ficha,int fila,int columna){
        validarFicha(ficha);
        int capturas = 0,repeticionesArriba,repeticionesAbajo;
        // Recorremos hacia arriba
        if (fila>2){
            repeticionesArriba = recorrerVerticalArriba(ficha,fila,columna);
            if (repeticionesArriba==2 && tablero[fila-3][columna]==tablero[fila][columna]){
                capturas+=2;
                for (int i = fila-1; i >= fila-2; i--) {
                    tablero[i][columna] = CASILLA_VACIA;
                }
            }
        }
        // Recorremos hacia abajo
        if (fila<tablero.length-3){
            repeticionesAbajo = recorrerVerticalAbajo(ficha,fila,columna);
            if (repeticionesAbajo==2 && tablero[fila+3][columna]==tablero[fila][columna]){
                capturas+=2;
                for (int i = fila+1; i <= fila+2; i++) {
                    tablero[i][columna] = CASILLA_VACIA;
                }
            }

        }
        return capturas;
    }

    public int capturaDiagonal(int ficha,int fila,int columna) {
        validarFicha(ficha);
        int capturas = 0,repeticionesAscendentesIzquierda,repeticionesDescendentesDerecha,limpiarFila,limpiarColumna;
        int repeticionesAscendentesDerecha,repeticionesDescendentesIzquierda;
        // Comprueba las diagonales de arriba izquierda hacia abajo derecha
        if (columna>2 && fila>2){
            repeticionesAscendentesIzquierda = recorrerDiagonalArribaIzquierda(ficha,fila,columna);

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
            repeticionesDescendentesDerecha = recorrerDiagonalAbajoDerecha(ficha,fila,columna);

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
            repeticionesAscendentesDerecha = recorrerDiagonalArribaDerecha(ficha,fila,columna);

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
            repeticionesDescendentesIzquierda = recorrerDiagonalAbajoIzquierda(ficha,fila,columna);

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
    /*----------------------
        Recorrer Tablero
    ----------------------*/
    // Horizontal hacia la derecha
    public int recorrerHorizontalDerecha (int ficha,int fila,int columna){
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
    public int recorrerHorizontalIzquierda (int ficha,int fila,int columna) {
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
    public int recorrerVerticalArriba (int ficha,int fila,int columna){
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
    public int recorrerVerticalAbajo (int ficha,int fila,int columna){
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
    public int recorrerDiagonalArribaIzquierda (int ficha,int fila,int columna){
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
    public int recorrerDiagonalAbajoDerecha (int ficha,int fila,int columna){
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
    public int recorrerDiagonalArribaDerecha (int ficha,int fila,int columna){
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
    public int recorrerDiagonalAbajoIzquierda (int ficha,int fila,int columna){
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






    /*-----------------------
       Mostrar Tablero
    -----------------------*/
    public String mostrarTablero(){
        StringBuilder mostrarTablero = new StringBuilder();
        mostrarTablero.append(indiceColumna());
        for (int i = 0; i < tablero.length; i++) {
            mostrarTablero.append(indiceFila(i)); // Índice de las filas
            // Imprimir las fichas
            for (int j = 0; j < tablero[0].length; j++) {
                mostrarTablero.append(mostrarFicha(i,j));
            }
            mostrarTablero.append("\n");
        }
        return mostrarTablero.toString();
    }
    public String mostrarTablero(int fila, int columna){
        StringBuilder mostrarTablero = new StringBuilder();
        mostrarTablero.append(indiceColumna()); // Muestra el índice de las columnas
        for (int i = 0; i < tablero.length; i++) {
            mostrarTablero.append(indiceFila(i)); // Índice de las filas
            // Imprimir las fichas
            for (int j = 0; j < tablero[0].length; j++) {
                if (i==fila && j==columna){
                    mostrarTablero.append(mostrarFichaNegrita(i,j));
                } else {
                    mostrarTablero.append(mostrarFicha(i,j));
                }
            }
            mostrarTablero.append("\n");
        }
        return mostrarTablero.toString();
    }

    private String indiceColumna (){
        StringBuilder indiceColumna = new StringBuilder("    ");
        int indiceY = 0;
        for (int j = 0; j < tablero[0].length; j++) {
            if (j<9){
                indiceColumna.append(indiceY).append("   ");
            } else {
                indiceColumna.append(indiceY).append("  ");
            }
            indiceY++;
        }
       indiceColumna.append("\n");
        return indiceColumna.toString();
    }

    private String indiceFila (int indiceX){
        String indiceFila;
        if (indiceX<10){
            indiceFila = " "+indiceX+"|";
        } else {
            indiceFila = indiceX+"|";
        }
        return indiceFila;
    }

    private String mostrarFicha (int fila,int columna){
        String representacionFicha;
        switch (this.tablero[fila][columna]){
            case CASILLA_VACIA -> representacionFicha = " "+" "+" |";
            case FICHA_CIRCULO -> representacionFicha = " "+"\u001B[31m"+"O"+"\u001B[0m"+" |";
            case FICHA_EQUIS -> representacionFicha = " "+"\u001B[34m"+"X"+"\u001B[0m"+" |";
            default -> throw new IllegalArgumentException("Valor no esperado");
        }
        return representacionFicha;
    }
    private String mostrarFichaNegrita (int fila,int columna){
        String representacionFicha;
        switch (this.tablero[fila][columna]){
            case CASILLA_VACIA -> representacionFicha = " "+" "+" |";
            case FICHA_CIRCULO -> representacionFicha = " "+"\033[1;33m"+"O"+"\u001B[0m"+" |";
            case FICHA_EQUIS -> representacionFicha = " "+"\033[1;33m"+"X"+"\u001B[0m"+" |";
            default -> throw new IllegalArgumentException("Valor no esperado");
        }
        return representacionFicha;
    }

    /*-----------------------
       Validaciones
    -----------------------*/

    public static void validarFicha (int ficha){
        boolean validacion = ficha == CASILLA_VACIA || ficha == FICHA_CIRCULO || ficha == FICHA_EQUIS;
        if (!validacion){
            throw new IllegalArgumentException("El valor de la ficha introducida es erróneo");
        }
    }
}

