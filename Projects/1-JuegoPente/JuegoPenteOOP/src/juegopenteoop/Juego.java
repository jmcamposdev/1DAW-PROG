package juegopenteoop;

import Funciones.GetData;

public class Juego {
    public static void main(String[] args) {
        // Creamos todas las variables.
        boolean ganadorPorLinea = false, existenFichasLibres = true, ganadorPorCapturas = false,comprobarFicha;
        int fila,columna,turno=1,ficha,capturaJugador1 = 0,capturaJugador2 = 0,fichasCapturadas;
        String[] nombres = new String[2];

        System.out.println("Bienvenido al Juego Pente");
        System.out.println("-------------------------");
        // Pedimos la dimensión del tablero con un mínimo de 10 y un máximo de 19 ambos incluidos.
        int dimensionTablero = GetData.getInt("Ingrese la dimensión deseada del tablero (10 - 19): ",10,19);
        JuegoPente juegoPente = new JuegoPente(dimensionTablero); // Creamos el objeto con las dimensiones del tablero
        // Pedimos el número de captura para ganar mínimo de 5 y máximo de 10 ambos incluidos
        int maximoDeCaptura = GetData.getInt("Ingrese el máximo de capturas para ganar la partida (5 - 10): ",5,10);
        nombres[0] = GetData.getString("Ingrese el nombre del Primer Jugador: "); // Pedimos el nombre del Jugador 1
        nombres[1] = GetData.getString("Ingrese el nombre del Segundo Jugador: "); // Pedimos el nombre del Jugador 2
        System.out.println(juegoPente.mostrarTablero()); // Mostramos el tablero vacío

        // Iteramos constantemente hasta que exista un ganador por linea, captura o empate.
        while (!ganadorPorLinea && existenFichasLibres && !ganadorPorCapturas){
            // Pedir ficha al usuario y comprobar si se puede insertar
            do {
                ficha = turno%2==0?JuegoPente.FICHA_EQUIS:JuegoPente.FICHA_CIRCULO; // Asignamos la ficha dependiendo del turno PAR=X IMPAR=O
                System.out.println("Te toca "+nombres[turno%2==0?1:0]); // Mostramos a quien le toca el turno
                // Pedimos la fila y columna con un mínimo de 0 y un máximo de la longitud del tablero -1.
                fila = GetData.getInt("Ingrese la fila: ",0,dimensionTablero-1);
                columna = GetData.getInt("Ingrese la columna: ",0,dimensionTablero-1);

                comprobarFicha = juegoPente.colocarFicha(ficha,fila,columna); // Comprobamos si es válida la casilla indicada
                // Si no es válida mostramos erros y volvemos a iterar el do while.
                if (!comprobarFicha){
                    System.out.println("En la posición solicitada ya existe una ficha vuelva a intentarlo.");
                }
            } while (!comprobarFicha);

            ganadorPorLinea = juegoPente.comprobarLinea(fila, columna); // Comprueba si existe 5 en línea
            existenFichasLibres = juegoPente.casillasLibres();  // Comprueba si existe empate
            fichasCapturadas = juegoPente.capturarFichas(fila,columna);  // Guardamos la cantidad de fichas capturadas
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
            System.out.println(juegoPente.mostrarTablero(fila,columna));
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
}
