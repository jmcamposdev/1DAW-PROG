package tresenrayafilesave;

import Funciones.GetData;

import java.io.*;

import static Funciones.GetData.*;


public class Juego {
    public static void main(String[] args) {
        boolean salidaGuardarPartida = false;
        String[] jugadores = new String[2];
        int turno = 0;
        TresEnRaya tresEnRaya = new TresEnRaya();
        File partida = new File("partidas/partida1.txt");
        boolean cargarPartidaGuardada = false;
        if (partida.exists()) {
            cargarPartidaGuardada = GetData.getBoolean("Deseas cargar la partida guardada (si|no): ");
            if (cargarPartidaGuardada) {
                try (BufferedReader br = new BufferedReader(new FileReader(partida))){
                    int ficha;
                    jugadores[0] = br.readLine();
                    jugadores[1] = br.readLine();
                    turno = Integer.parseInt(br.readLine());
                    for (int i = 0; i < 3; i++) {
                        String[] fichas = br.readLine().split("");
                        for (int j = 0; j < 3; j++) {
                            ficha = Integer.parseInt(fichas[j]);
                            if (ficha != 0) {
                                tresEnRaya.colocarFicha(ficha,j,i);
                            }
                        }
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        } else {
            try {
                partida.createNewFile();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }



        int x,y,ficha;
        System.out.println("Bienvenido al Tres En Raya");
        System.out.println("--------------------------");
        if (!cargarPartidaGuardada){
            jugadores[0] = getString("Nombre del Jugador 1: ");
            jugadores[1] = getString("Nombre del Jugador 2: ");
        }

        while (!tresEnRaya.juegoTerminado() && !tresEnRaya.hayGanador() && !salidaGuardarPartida){
            boolean fichaColocada = false;
            System.out.println(tresEnRaya);
            ficha = turno%2 == 0 ? TresEnRaya.FICHA_CIRCULO : TresEnRaya.FICHA_EQUIS;
            System.out.println("Le toca a "+jugadores[turno%2]);
            while (!fichaColocada){
                y = getInt("Ingrese la fila: ",0,2);
                x = getInt("Ingrese la columna: ",0,2);
                if (tresEnRaya.colocarFicha(ficha,x,y)){
                    fichaColocada = true;
                } else {
                    System.out.println("Posición Ocupada");
                }
            }
            if (tresEnRaya.hayGanador()){
                System.out.println("Gana el Jugador: "+jugadores[turno%2]);
            } else if (tresEnRaya.juegoTerminado()){
                System.out.print("Empate");
            } else {
                salidaGuardarPartida = GetData.getBoolean("Deseas salir de la Partida (si|no)");
            }
            if (cargarPartidaGuardada) {
                partida.delete();
            }

            turno++;
        }

        if (salidaGuardarPartida) {
            guardarPartida(tresEnRaya,jugadores,turno,partida);
        }

    }
    public static void guardarPartida(TresEnRaya tresEnRaya, String[] jugadores, int turno, File partida){
        try (PrintWriter pw = new PrintWriter(partida)){
            pw.println(jugadores[0]);
            pw.println(jugadores[1]);
            pw.println(turno);
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    pw.print(tresEnRaya.getFicha(i,j));
                }
                pw.println();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}