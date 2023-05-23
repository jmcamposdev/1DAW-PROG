package bingo;

import Funciones.OperacionesArrayBidimensional;

import java.util.Arrays;

public class Carton {
    private int[][] datos;

    public Carton() {
        this.datos = OperacionesArrayBidimensional.crearArrayAleatorioBidimensionalSinRepetir(3,5,1,50);
    }

    public Carton(Carton carton) {
        this.datos = new int[3][5];
        for (int i = 0; i < carton.datos.length; i++) {
            System.arraycopy(carton.datos[i], 0, this.datos[i], 0, carton.datos[0].length);
        }
    }

    public int getValor (int fila, int columna) {
        if (fila < 0 || fila > datos.length || columna < 0 || columna > datos[0].length) {
            throw new IllegalArgumentException("Valore de los parámetros no válido");
        }
        return this.datos[fila][columna];
    }

    public boolean marcarCasilla (int bola) {
        if (bola < 1 || bola > 50) {
            throw new IllegalArgumentException("Valor de la bola inválido debe estar entre 1 - 50 ambos incluidos");
        }
        boolean casillaMarcada = false;
        for (int i = 0; i < datos.length && !casillaMarcada; i++) {
            for (int j = 0; j < datos[0].length && !casillaMarcada; j++) {
                if (datos[i][j] == bola) {
                    datos[i][j] = -1;
                    casillaMarcada = true;
                }
            }
        }
        return casillaMarcada;
    }

    public boolean cantarFila() {
        boolean filaCantada = false;
        boolean filaNoValida = false;
        int numeroDeCasillas = 0;
        for (int i = 0; i < datos.length && !filaCantada; i++) {
            int primeraCasilla = datos[i][0];
            for (int j = 0; j < datos[0].length && primeraCasilla == -1 && !filaNoValida; j++) {
                if (datos[i][j] != primeraCasilla){
                    filaNoValida = true;
                } else {
                    numeroDeCasillas++;
                }
            }
            if (numeroDeCasillas == datos[i].length) {
                filaCantada = true;
            }
            filaNoValida = false;
        }
        return filaCantada;
    }

    public boolean cantarBingo() {
        boolean bingoCantado = true;
        for (int i = 0; i < datos.length && bingoCantado; i++) {
            for (int j = 0; j < datos[i].length & bingoCantado; j++) {
                if (datos[i][j] != -1) bingoCantado = false;
            }
        }
        return bingoCantado;
    }

    @Override
    public String toString() {
        return OperacionesArrayBidimensional.mostrarArrayBidimensional(datos);
    }
}
