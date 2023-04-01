package EjerciciosBidimensional;

import Funciones.GetData;

import java.sql.SQLOutput;
import java.util.EventListener;

public class TresEnRaya {
    public static void main(String[] args) {
        char[][] tablero = new char[3][3];
        int fila,columna,turnos;
        boolean ganador = false,ocupado = false;
        rellenarTablero(tablero);
        System.out.println("Bienvenidos al Tres en Raya");
        System.out.println("---------------------------");
        System.out.println(" ");
        mostrarTablero(tablero);

        turnos = 1;
        System.out.println("Empieza las X");
        while (!ganador){
            do{
                fila = GetData.getInt("Ingrese la fila: ",0,2);
                columna = GetData.getInt("Ingrese la columna: ",0,2);
                ocupado = comprobarTablero(tablero,fila,columna);
                if (!ocupado){
                    System.out.println("La casilla deseada esta ocupada");
                }
            } while (!ocupado);
            if (turnos%2==0){
                tablero[fila][columna] = 'O';
                ganador = ganador(tablero,'O');
            } else {
                tablero[fila][columna] = 'X';
                ganador = ganador(tablero,'X');
            }
            if (!ganador){
                turnos++;
            }
            mostrarTablero(tablero);

        }
        if (turnos%2==0){
            System.out.println("El ganador es 0");
        } else {
            System.out.println("El ganador es X");
        }
    }

    // Rellena el tablero con espacios en blanco
    public static void rellenarTablero (char[][] tablero){
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[0].length; j++) {
                tablero[i][j] = ' ';
            }
        }
    }

    // Mostrar el tablero
    public static void mostrarTablero (char[][] tablero){
        int indice = 0;
        System.out.println("  0   1   2");
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[0].length; j++) {
                if (i==0){
                    if (j==0){
                        System.out.print(indice+" ");
                        indice++;
                    }
                    if (j==tablero[0].length-1){
                        System.out.print(tablero[i][j]);
                    } else {
                        System.out.print(tablero[i][j]+" | ");
                    }
                }
                if (i==1){
                    if (j==0){
                        System.out.println(" ");
                        System.out.println("------------");
                        System.out.print(indice+" ");
                        indice++;
                    }
                    if (j==tablero[0].length-1){
                        System.out.print(tablero[i][j]);
                    } else {
                        System.out.print(tablero[i][j]+" | ");
                    }
                }
                if (i==2){
                    if (j==0){
                        System.out.println(" ");
                        System.out.println("------------");
                        System.out.print(indice+" ");
                    }
                    if (j==tablero[0].length-1){
                        System.out.print(tablero[i][j]);
                    } else {
                        System.out.print(tablero[i][j]+" | ");
                    }
                }

            }
        }
        System.out.println(" ");
    }
    // Comprobar si esta vacía
    public static boolean comprobarTablero (char[][] tablero,int fila,int columna){
        return  tablero[fila][columna] == ' ';
    }
    public static boolean ganador (char[][] tablero, char signo){
        boolean ganador = false;
        int repeticiones = 0;
        for (int i = 0; i < tablero.length && !ganador; i++) {
            repeticiones = 0;
            // Comprueba las Filas
            for (int j = 0; j < tablero[0].length && !ganador; j++) {
                if (tablero[i][j] == signo){
                    repeticiones++;
                }
                if (repeticiones == 3){
                    ganador = true;
                }
            }

            repeticiones = 0;
            // Comprueba las columnas
            for (int j = 0; j < tablero[0].length && !ganador; j++) {
                if (tablero[j][i] == signo){
                    repeticiones++;
                }
                if (repeticiones == 3){
                    ganador = true;
                }
            }

            if (tablero[1][1] == signo && ((tablero[0][0] == signo && tablero[2][2] == signo) || (tablero[2][0] == signo && tablero[0][2] == signo))){
                ganador = true;
            }

        }
        return ganador;
    }
}
