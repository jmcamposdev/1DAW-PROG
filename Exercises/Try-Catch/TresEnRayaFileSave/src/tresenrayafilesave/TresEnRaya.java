package tresenrayafilesave;

import java.io.*;

public class TresEnRaya {
    private final int[][] tablero;
    public static final int CASILLA_VACIA = 0;
    public static final int FICHA_EQUIS = 1;
    public static final int FICHA_CIRCULO = 2;

    /*-----------------------
       Constructor
    -----------------------*/
    public TresEnRaya(){
        this.tablero = new int[3][3];
    }

    /*-----------------------
       Métodos
    -----------------------*/
    public boolean colocarFicha(int ficha, int x, int y){
        if (!validarFicha(ficha)){
            throw new IllegalArgumentException("Valor de ficha no válido");
        }
        if (!validarRango(x) || !validarRango(y)){
            throw new IllegalArgumentException("Valor fuera del rango");
        }

        boolean fichaColocada = false;
        if (this.tablero[y][x] == CASILLA_VACIA){
            this.tablero[y][x] = ficha;
            fichaColocada = true;
        }

        return fichaColocada;
    }

    public boolean juegoTerminado(){
        boolean juegoTerminado = true;
        for (int i = 0; i < tablero.length && juegoTerminado; i++) {
            for (int j = 0; j < tablero[0].length && juegoTerminado; j++) {
                juegoTerminado = tablero[i][j] != CASILLA_VACIA;
            }
        }
        return juegoTerminado;
        
    }

    public boolean hayGanador(){
        return comprobarLinea() || comprobarColumna() || comprobarDiagonal();
    }

    private boolean comprobarLinea(){
        boolean enLinea = true;
        boolean salida = false;
        for (int i = 0; i < tablero.length && !salida; i++) {
            int ficha = tablero[i][0];
            if (ficha != CASILLA_VACIA){
                for (int j = 0; j < tablero[0].length; j++) {
                    if (ficha != tablero[i][j]) {
                        enLinea = false;
                    }
                }
                if (enLinea){
                    salida = true;
                }
            } else {
                enLinea = false;
            }
        }
        return enLinea;
    }

    private boolean comprobarColumna(){
        boolean enLinea = true;
        boolean salida = false;
        for (int i = 0; i < tablero.length && !salida; i++) {
            int ficha = tablero[0][i];
            if (ficha != CASILLA_VACIA){
                for (int j = 0; j < tablero[0].length; j++) {
                    if (ficha != tablero[j][i]){
                        enLinea = false;
                    }
                }
                if (enLinea){
                    salida = true;
                }
            } else {
                enLinea = false;
            }
        }
        return enLinea;
    }

    private boolean comprobarDiagonal(){
        boolean esDiagonalPrincipal = true;
        boolean esDiagonalInversa = true;
        // Recorrer de arriba izquierda abajo derecha
        int x , y;
        int ficha = tablero[0][0];
        if (ficha != CASILLA_VACIA){
            for (int i = 1; i < tablero.length; i++) {
                if (ficha != tablero[i][i]){
                    esDiagonalPrincipal = false;
                }
            }
        } else {
            esDiagonalPrincipal = false;
        }

        x = y = 1;
        ficha = tablero[0][2];
        if (ficha != CASILLA_VACIA){
            for (int i = 1; i < tablero.length; i++) {
                if (ficha != tablero[y][x]){
                    esDiagonalInversa = false;
                }
                y++;
                x--;
            }
        } else {
            esDiagonalInversa = false;
        }


        return esDiagonalPrincipal || esDiagonalInversa;
    }

    /*-----------------------
       Lectura Ficheros
    -----------------------*/
    public int getFicha (int x, int y){
        if (!validarRango(x) || !validarRango(y))
            throw new IllegalArgumentException("Valor fuera del rango");
        return this.tablero[x][y];
    }
    /*-----------------------
       Validaciones
    -----------------------*/
    private boolean validarFicha(int ficha){
        return ficha == FICHA_EQUIS || ficha == FICHA_CIRCULO;
    }
    private boolean validarRango(int valor){
        return valor >= 0 && valor < 3;
    }

    /*-----------------------
       Overrides
    -----------------------*/

    @Override
    public String toString() {
        StringBuilder tableroString = new StringBuilder();
        tableroString.append(indiceColumna());
        for (int i = 0; i < this.tablero.length; i++) {
            tableroString.append(indiceFila(i)); // Índice de las filas
            // Imprimir las fichas
            for (int j = 0; j < tablero[0].length; j++) {
                tableroString.append(mostrarFicha(tablero, i, j));
            }
            tableroString.append("\n");
        }
        return tableroString.toString();
    }

    private String indiceColumna (){
        StringBuilder indiceColumna = new StringBuilder("    ");
        int indiceY = 0;
        for (int j = 0; j < tablero[0].length; j++) {
            indiceColumna.append(indiceY).append("   ");
            indiceY++;
        }
        indiceColumna.append("\n");
        return indiceColumna.toString();
    }

    private String indiceFila (int indiceX){
        return " "+indiceX+"|";
    }

    private static String mostrarFicha (int[][] tablero,int fila,int columna){
        String ficha;
        switch (tablero[fila][columna]){
            case CASILLA_VACIA -> ficha=(" "+" "+" |");
            case FICHA_CIRCULO -> ficha=(" "+"\u001B[31m"+"O"+"\u001B[0m"+" |");
            case FICHA_EQUIS -> ficha=(" "+"\u001B[34m"+"X"+"\u001B[0m"+" |");
            default -> throw new IllegalArgumentException("Valor no esperado");
        }
        return ficha;
    }

}
