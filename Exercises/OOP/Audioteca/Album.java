package poo.EjerciciosSencillos_2.Audioteca;

import java.util.Arrays;

public class Album {
    private int contador;
    private Cancion[] canciones;


    /*-----------------------
       Constructores
    -----------------------*/
    public Album(){
        this.canciones = new Cancion[0];
        contador = 0;
    }

    /*-----------------------
       Métodos
    -----------------------*/
    public int numeroCanciones(){
        return contador;
    }

    public Cancion dameCancion(int numeroCancion){
        if (!validarIndice(numeroCancion)){
            throw new IllegalArgumentException("El indice esta fuera del rango");
        }
        return canciones[numeroCancion];
    }

    public void agregarCancion(Cancion cancion){
        canciones = Arrays.copyOf(canciones, canciones.length+1);
        canciones[canciones.length-1] = cancion;
        contador++;
    }

    public void elimina(int numeroCancion){
        if (!validarIndice(numeroCancion)){
            throw new IllegalArgumentException("El indice esta fuera del rango");
        }
        Cancion cancionResguardo = canciones[canciones.length-1];
        canciones[canciones.length-1] = canciones[numeroCancion];
        canciones[numeroCancion] = cancionResguardo;
        canciones = Arrays.copyOf(canciones, canciones.length-1);
        contador--;
    }

    public void grabaCancion(int numeroCancion, Cancion cancion){
        if (!validarIndice(numeroCancion)){
            throw new IllegalArgumentException("El indice esta fuera del rango");
        }
        this.canciones[numeroCancion] = cancion;
    }




    /*-----------------------
       Validaciones
    -----------------------*/
    private boolean validarIndice(int indice){
        return indice >= 0 && indice <= canciones.length;
    }
}
